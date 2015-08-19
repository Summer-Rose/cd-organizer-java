import org.junit.*;
import static org.junit.Assert.*;

public class UnitTest {

  @Test
  public void CD_instantiatesCorrectly() {
    CD testCD = new CD("The White Album", "The Beatles", "British Rock");
    assertEquals(true, testCD instanceof CD);
  }

  @Test
  public void CD_getsCorrectTitle() {
    CD testCD = new CD("The White Album", "The Beatles", "British Rock");
    assertEquals("The White Album", testCD.getTitle());
  }

  @Test
  public void CD_getsCorrectArtist() {
    CD testCD = new CD("The White Album", "The Beatles", "British Rock");
    assertEquals("The Beatles", testCD.getArtist());
  }

  @Test
  public void CD_getsCorrectGenre() {
    CD testCD = new CD("The White Album", "The Beatles", "British Rock");
    assertEquals("British Rock", testCD.getGenre());
  }
}
