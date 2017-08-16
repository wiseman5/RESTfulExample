package platform;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by alisewiseman on 5/31/17.
 */
@Path("/hello")
public class HelloWorldService {
  private WorldGeography worldGeography;

  @GET
  @Path("/{param}")
  public Response getMsg(@PathParam("param") String msg) {

    String output = "Hello : " + msg;

    return Response.status(200).entity(output).build();

  }

  @GET
  @Path("/{country}/capital")
  public Response getCapital(@PathParam("country") String country){
    country = country.toLowerCase();
    String capital = getWorldGeography().getCapital(country);
    if (capital == null) {
      return Response.status(404).build();
    }
    else {
      return Response.status(200).entity(capital).build();
    }
  }

  @GET
  @Path("/{country}/continent")
  public Response getContinent(@PathParam("country") String country){
    country = country.toLowerCase();
    String continent = getWorldGeography().getContinent(country);
    String continentHTML;
    continentHTML = "<a href=\"http://localhost:8080/RESTfulExample/rest/hello/" + continent + "/countries\">" + continent + "</a>";
    if (continent == null) {
      return Response.status(404).build();
    }
    else {
      return Response.status(200).entity(continentHTML).build();
    }
  }

  @GET
  @Path("/{continent}/countries")
  public Response getCountries(@PathParam("continent") String continent){
    continent = continent.toLowerCase();
    String countries = getWorldGeography().getCountries(continent);
    if (countries == null) {
      return Response.status(404).build();
    }
    else {
      return Response.status(200).entity(countries).build();
    }
  }

  private WorldGeography getWorldGeography() {
    if (worldGeography == null) {
      try {
        FileInputStream fileInputStream = new FileInputStream("worldGeography.json");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
        Scanner scanner = new Scanner(inputStreamReader);
        String geography = "";
        while (scanner.hasNextLine()) {
          geography += scanner.nextLine();
        }
        scanner.close();

        ObjectMapper objectMapper = new ObjectMapper();
        worldGeography = objectMapper.readValue(geography, WorldGeography.class);
      }
      catch (FileNotFoundException e) {
        e.printStackTrace();
      }
      catch (JsonParseException e) {
        e.printStackTrace();
      }
      catch (JsonMappingException e) {
        e.printStackTrace();
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
    worldGeography.capitalize();
    return worldGeography;
  }
}
