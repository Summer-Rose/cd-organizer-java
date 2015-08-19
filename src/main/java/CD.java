import java.util.ArrayList;

public class CD {
  public static ArrayList<CD> instances = new ArrayList<CD>();

  private String mArtist;
  private String mTitle;
  private String mGenre;
  public static int mId;

  public CD (String artist, String title, String genre){
    mArtist = artist;
    mTitle = title;
    mGenre = genre;
    instances.add(this);
    mId = instances.size();
  }
  public String getArtist(){
    return mArtist;
  }

  public String getTitle(){
    return mTitle;
  }

  public String getGenre(){
    return mGenre;
  }

  public static int getId() {
    return mId;
  }

  public static ArrayList<CD> all() {
    return instances;
  }

  public static CD find(int id) {
    try {
     return instances.get(id - 1);
   } catch (IndexOutOfBoundsException e) {
     return null;
   }
  }

  public static void deleteById(int id){
    System.out.println(instances.get(0).getArtist());
    instances.remove(id - 1);
    System.out.println(instances.get(0).getArtist());
  }


}
