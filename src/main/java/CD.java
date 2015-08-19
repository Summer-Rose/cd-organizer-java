import java.util.ArrayList;

public class CD {
  public static ArrayList<CD> instances = new ArrayList<CD>();

  private String mArtist;
  private String mTitle;
  private String mGenre;
  private int mId;

  public CD (String artist, String title, String genre){
    mArtist = artist;
    mTitle = title;
    mGenre = genre;
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

  public int getId() {
    return mId;
  }

  public static ArrayList<CD> all() {
    return instances;
  }

  public void save() {
    instances.add(this);
    mId = instances.size();
  }

  public static CD find(int id) {
    try {
     return instances.get(id - 1);
   } catch (IndexOutOfBoundsException e) {
     return null;
   }
  }

  public void delete() {
    instances.remove(mId - 1);
  }


}
