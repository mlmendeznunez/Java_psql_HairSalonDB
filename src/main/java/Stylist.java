import java.util.List;
import org.sql2o.*;
import java.util.List;

public class Stylist {
  private int id;
  private String name;

  public int getId(){
    return id;
  }

  public String getStylistName(){
    return name;
  }
  
  public Stylist(String name) {
    this.name = name;
  }

  //override .equals imbeded functionality to ensure that 2 diff. instances of
  //an object Stylist with the same string will be equal.
  @Override
  public boolean equals(Object otherStylist) {
    if(!(otherStylist instanceof Stylist)){
      return false;
    }
    else {
      Stylist newStylist = (Stylist) otherStylist;
      return this.getStylistName().equals(newStylist.getStylistName());
    }
  }//end override

  //access a list of all Stylist
  public static List<Stylist> all() {
    String sql = "SELECT id, name, city FROM stylists";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }

  public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO stylists (name) VALUES (:name)";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .executeUpdate()
      .getKey();
    }
  }

  public static Stylist find(int id ) {
    try(Connection con = DB.sql2o.open()) {
      String sql ="select * from stylists where id=:id";
      Stylist stylist = con.createQuery(sql)
      .addParameter("id",id)
      .executeAndFetchFirst(Stylist.class);
      return stylist;
    }
  }
  public List<Clients> getClients() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE stylist_id= :id";
      return con.createQuery(sql)
       .addParameter("id", this.id)
       .executeAndFetch(Clients.class);
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
    String sql = "DELETE FROM stylists WHERE id = :id;";
      con.createQuery(sql)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public void update(String name) {
      try(Connection con = DB.sql2o.open()) {
        String sql = "UPDATE stylists SET name= :name WHERE id= :id";
        con.createQuery(sql)
          .addParameter("name", name)
          .addParameter("id", id)
          .executeUpdate();
      }
  }
}//end stylist class 
