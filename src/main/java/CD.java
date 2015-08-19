public class CD {
  private String mArtist;
  private String mTitle;
  private String mGenre;

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
}
