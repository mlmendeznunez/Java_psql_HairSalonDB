import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.List;


public class App {
  public static void main(String [] args) {
    staticFileLocation("/public"); //What does this mean?
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("clients", Clients.all());
      model.put("stylists", Stylist.all());
      model.put("template", "templates/homepage.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    //add a stylist to bella stylists
    get("/stylists", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("clients", Clients.all());
      model.put("stylists", Stylist.all());
      model.put("template", "templates/homepage.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      Stylist newStylist = new Stylist(name);
      newStylist.save();

      model.put("stylists", Stylist.all());
      model.put("template", "templates/homepage.vtl");
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());

    //add a client to a stylists list
    get("/clients", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("clients", Clients.all());
      model.put("stylists", Stylist.all());
      model.put("template", "templates/homepage.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/clients", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("clients", Clients.all());
      model.put("stylists", Stylist.all());
      model.put("template", "templates/homepage.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // //lookup a stylists client list
    // get("/search", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   model.put("clients", Clients.all());
    //   model.put("stylists", Stylist.all());
    //   model.put("template", "templates/search.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

    // post("/search", (request, resposne)->{
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   int stylist = Integer.parseInt(request.queryParams("stylist_id"));

    //   List<Clients> searchClients = Clients.search(name, phone, email, address);
    //   model.put("searchClients", searchClients);
    //   model.put("stylist", stylist);
    //   model.put("clients", Clients.all());
    //   model.put("stylists", Stylist.all());
    //   model.put("template", "templates/search.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

    // get("/searchall", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   model.put("clients", Clients.all());
    //   model.put("stylists", Stylist.all());
    //   model.put("template", "templates/searchall.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

    // //displays all of bella stylist clients
    // post("/searchall", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   model.put("clients", Clients.all());
    //   model.put("stylists", Stylist.all());
    //   model.put("template", "templates/search.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

  }//end main
}//end of app
