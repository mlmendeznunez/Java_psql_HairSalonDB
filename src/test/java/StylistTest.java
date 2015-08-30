import java.util.Arrays;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;

public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Stylist.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfNamesAreTheSame() {
    Stylist firstStylist = new Stylist("Molly");
    Stylist secondStylist = new Stylist("Molly");
    assertTrue(firstStylist.equals(secondStylist));
  }

  @Test 
  public void save_savesIntoDatabase_true() {
    Stylist newStylist = new Stylist("Harrieta");
    newStylist.save();
    assertTrue(Stylist.all().get(0).equals(newStylist));
  }

  @Test
  public void find_findsStylistInDatabase_true() {
    Stylist myStylist = new Stylist("Lolita");
    myStylist.save();
    Stylist savedStylist = Stylist.find(myStylist.getId());
    assertTrue(myStylist.equals(savedStylist));
  }

  @Test
  public void getClients_retrievesAllClientsFromDatabase_clientsList() {
    Stylist myStylist = new Stylist ("Lolita");
    myStylist.save();
    Clients firstClient = new Clients("Alisa", "55555", "email@yahoo.com", "address", myStylist.getId());
    firstClient.save();
    Clients secondClient = new Clients("Saba", "44444", "email@gmail.com", "address", myStylist.getId());
    secondClient.save();
    Clients[] clients = new Clients[] { firstClient, secondClient };
    assertTrue(myStylist.getClients().containsAll(Arrays.asList(clients)));
  }

  @Test
  public void delete_deletesStylistFromDatabase_true() {
    Stylist myStylist = new Stylist("Harrieta");
    myStylist.save();
    myStylist.delete();
    assertEquals(Stylist.all().size(), 0);
  }

  @Test
  public void update_changesStylistNameInDatabase_true() {
    Stylist myStylist = new Stylist("Moop");
    myStylist.save();
    String betterStylist = "Better";
    myStylist.update(betterStylist);
    assertTrue(Stylist.all().get(0).getStylistName().equals(betterStylist));
  }
}//end StylistTest
