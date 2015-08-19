import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
    	staticFileLocation("/public");
    	String layout = "templates/layout.vtl";

        get("/", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();

            model.put("cdList", request.session().attribute("cdList"));
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/cd-list", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();

            ArrayList<CD> cdList = request.session().attribute("cdList");

            if (cdList == null){
              cdList = new ArrayList<CD>();
              request.session().attribute("cdList", cdList);
            }

            String artist = request.queryParams("artist");
            String title = request.queryParams("title");
            String genre = request.queryParams("genre");
            CD newCD = new CD(artist, title, genre);

            cdList.add(newCD);

            boolean deleteClicked = Boolean.parseBoolean(request.queryParams("deleteClicked"));

            //this doesn't work yet
            if(deleteClicked){
              cdList.remove(CD.getId());
            }


            model.put("cdList", request.session().attribute("cdList"));
            model.put("template", "templates/index.vtl");
              return new ModelAndView(model, layout);
            }, new VelocityTemplateEngine());

    }



}
