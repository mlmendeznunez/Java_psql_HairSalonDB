import java.util.Arrays;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;

public class ClientsTest {
	@Rule
	public DatabaseRule database = new DatabaseRule();
	
	@Test
	public void all_emptyAtFirst(){
	  assertEquals(Clients.all().size(), 0);
	}
	
	//When two distinct constructor Clients in class Clients with the same object are found, they are equal 
	@Test
	public void equals_returnsTrueIfDescriptionsAreTheSameForClients() {
	  Clients firstClient = new Clients( 2, "PunkHair", "1111", "punk@yahoo", "Punk addy", 1);
	  Clients secondClient = new Clients( 2, "PunkHair", "1111", "punk@yahoo", "Punk addy", 1);
	  assertTrue(firstClient.equals(secondClient));
	}
	
	@Test
	public void equals_returnsFalseIfDescriptionsAreTheSame() {
	  Clients firstClient = new Clients( 2, "PunkHair", "1111", "punk@yahoo", "Punk addy", 1);
	  Clients secondClient = new Clients( 1, "PunkHair", "1111", "punk@yahoo", "Punk addy", 1);
	  assertTrue(!firstClient.equals(secondClient));
	}
	
	@Test
	public void save_returnsTrueIfDescriptionsAreSame () {
	  Clients myClient = new Clients(1, "Dreadlocks", "22222", "dread@yahoo", "Locks addy", 1);
	  myClient.save();
	  assertTrue(Clients.all().get(0).equals(myClient));
	}
	
	@Test
	public void save_assignsIdToObject() {
		Clients myClient = new Clients(0, "Dreadlocks", "22222", "dread@yahoo", "Locks addy", 1);
		myClient.save();
		Clients savedClient = Clients.all().get(0); //verifying that saved object myClient was given an Id by RECOVERING the object
		assertEquals(myClient.getId(), savedClient.getId()); //compare original object to recovered object
	  }
	
	@Test
	public void find_findsClientInDatabase_true() {
		Clients myClient = new Clients(0, "Dreadlocks", "22222", "dread@yahoo", "Locks addy", 1);
		myClient.save();
		Clients savedClient = Clients.find(myClient.getId());
		assertTrue(myClient.equals(savedClient));
	}
	
	@Test
	public void delete_deletesClientFromDatabase_true() {
		Stylist myStylist = new Stylist("Meme");
		myStylist.save();
		Clients myClient = new Clients(0, "Dreadlocks", "22222", "dread@yahoo", "Locks addy", 1);
		myClient.save();
		myClient.delete();
		assertEquals(Clients.all().size(), 0);
	}
	
	@Test
	public void update_changesClientInDatabase_True() {
		Stylist myStylist = new Stylist("Meme");
		myStylist.save();
		Clients myClient = new Clients(0, "Dreadlocks", "22222", "dread@yahoo", "Locks addy", 1);
		myClient.save();
		String name="SassySis", phone="33333", email="sassy@yahoo", address="sassy addy";
		int stylist_id=1;
		myClient.update(name, phone, email, address, stylist_id);
		assertTrue(Clients.all().get(0).getClientName().equals(name));
	}
	
}//end ClientsTest

