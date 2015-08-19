public class CD {
  private String mTitle;
  private String mArtist;
  private String mGenre;

  public CD (String title, String artist, String genre){
    mTitle = title;
    mArtist = artist;
    mGenre = genre;
  }

  public String getTitle(){
    return mTitle;
  }

  public String getArtist(){
    return mArtist;
  }

  public String getGenre(){
    return mGenre;
  }
}
