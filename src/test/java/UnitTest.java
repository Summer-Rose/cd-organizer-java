import org.junit.*;
import static org.junit.Assert.*;

public class UnitTest {

  @Test
  public void CD_instantiatesCorrectly() {
    CD testCD = new CD("The Beatles", "The White Album", "British Rock");
    assertEquals(true, testCD instanceof CD);
  }

  @Test
  public void CD_getsCorrectTitle() {
    CD testCD = new CD("The Beatles", "The White Album", "British Rock");
    assertEquals("The White Album", testCD.getTitle());
  }

  @Test
  public void CD_getsCorrectArtist() {
    CD testCD = new CD("The Beatles", "The White Album", "British Rock");
    assertEquals("The Beatles", testCD.getArtist());
  }

  @Test
  public void CD_getsCorrectGenre() {
    CD testCD = new CD("The Beatles", "The White Album", "British Rock");
    assertEquals("British Rock", testCD.getGenre());
  }

  // @Test
  // public void newId_cdInstantiatesWithAnID_true() {
  //   CD testCD = new CD("The Beatles", "The White Album", "British Rock");
  //   assertEquals(CD.all().size(), testCD.getId());
  // }
  //
  // @Test
  // public void newId_returnsCDWithRightId_secondCD() {
  //   CD firstCD = new CD("The Beatles", "The White Album", "British Rock");
  //   CD secondCD = new CD("Summmer & Ju", "Infinite Loop", "Electronic");
  //   assertEquals(CD.find(secondCD.getId()), secondCD);
  // }

  @Test
  public void newId_deletesCDById_secondCD() {
    CD.instances.clear();
    CD firstCD = new CD("The Beatles", "The White Album", "British Rock");
    CD secondCD = new CD("Summer & Ju", "Infinite Loop", "Electronic");
    CD thirdCD = new CD("Summer & Ju", "Epicodus Blues", "Folk");
    CD.delete(2);
    assertEquals(CD.all().size(), 1);
  }
}
