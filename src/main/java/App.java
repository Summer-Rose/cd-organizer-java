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

            //model.put("cdList", request.session().attribute("cdList"));
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        post("/cd-list", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();

            ArrayList<CD> cdList = CD.all();

            String artist = request.queryParams("artist");
            String title = request.queryParams("title");
            String genre = request.queryParams("genre");

            CD newCD = new CD(artist, title, genre);
            newCD.save();
            System.out.println(CD.all().get(0));



            //boolean deleteClicked = Boolean.parseBoolean(request.queryParams("deleteClicked"));

            // if (deleteClicked) {
            //   CD.delete();
            // }


            model.put("cdList",  cdList);
            model.put("template", "templates/index.vtl");
              return new ModelAndView(model, layout);
            }, new VelocityTemplateEngine());

            post("/cd-list/:id", (request, response) -> {
                HashMap<String, Object> model = new HashMap<String, Object>();
                int id = Integer.parseInt(request.params("id"));
                CD foundCD = CD.find(id);
                foundCD.delete();



                model.put("cdList",  CD.all());
                model.put("template", "templates/index.vtl");
                  return new ModelAndView(model, layout);
                }, new VelocityTemplateEngine());


    }



}
