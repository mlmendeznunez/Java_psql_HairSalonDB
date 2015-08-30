import java.util.List;
import org.sql2o.*;
import java.util.List;

public class Clients {
  private int id;
  private String cname;
  private String phone;
  private String email;
  private String address;
  private int stylistId; //Would intel hardcode these variable?

  public int getId() {
    return id;
  }

  public String getClientName() {
    return cname;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }

  public String getAddress() {
    return address;
  }

  public int getStylistId() {
    return stylistId;
  }

  public Clients(String name, String phone, String email, String address, int stylistId) {
    this.cname = name; //What does .this mean? Why use it?
    this.phone = phone;
    this.email = email;
    this.address = address;
    this.stylistId = stylistId;
  }//end Clients()

  @Override
  public boolean equals(Object otherClients) {
    if (!(otherClients instanceof Clients)) {
      return false;
    } else {
      Clients newClients = (Clients) otherClients;
      return this.getId() == newClients.getId() && 
            this.getClientName().equals(newClients.getClientName()) && 
            this.getPhone().equals(newClients.getPhone()) &&
            this.getEmail().equals(newClients.getEmail()) &&
            this.getAddress().equals(newClients.getAddress()) &&
            this.getStylistId() == newClients.getStylistId();
     }
  }//end override

  public static List<Clients> all() {
    String sql="SELECT id, name, phone, email, address, stylist_id FROM clients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Clients.class);
    }
  }//end List Clients

  public void save() {
//    try(Connection con = DB.static sql2o.open()) { // change #1
    try(Connection con = DB.sql2o.open()) { // change #1
      String sql = "INSERT INTO clients (name, phone, email, address, stylist_id) VALUES (:name, :phone, :email, :address, :stylist_id)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.cname)
      .addParameter("phone", this.phone)
      .addParameter("email", this.email) // change #2
//      .addParameter("email", this.lemail) // change #2
      .addParameter("address", this.address)
      .executeUpdate()
      .getKey();
    }
  }

  public static Clients find(int id) {
   try(Connection con = DB.sql2o.open()) {
     String sql = "SELECT * FROM clients where id=:id";
     Clients client = con.createQuery(sql)
       .addParameter("id", id)
       .executeAndFetchFirst(Clients.class);
     return client;
   }
 }

 public void delete() {
   try(Connection con = DB.sql2o.open()) {
    String sql = "DELETE FROM clients WHERE id = :id;";
     con.createQuery(sql)
       .addParameter("id", id)
       .executeUpdate();
   }
 }

 public void update(String name, String phone, String email, String address) {
     try(Connection con = DB.sql2o.open()) {
       String sql = "UPDATE clients SET name = :name, phone=:phone, email=:email, address=:address  WHERE id = :id";
       con.createQuery(sql)
         .addParameter("name", name)
         .addParameter("phone", phone)
         .addParameter("email", email)
         .addParameter("address", address)
         .executeUpdate();
     }
   }
}//end object Class
