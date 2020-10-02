package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CountryDTO;
import facades.FacadeCountry;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

//Todo Remove or change relevant parts before ACTUAL use
@Path("country")
public class CountryResource {
    private static final FacadeCountry FACADE =  FacadeCountry.getFacadeCountry();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Path("{countryID}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRenameMeCount(@PathParam("countryID") String countryID) throws IOException {
        //System.out.println("--------------->"+count);
        URL url = new URL("http://restcountries.eu/rest/v1/alpha?codes=" + countryID);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr=null;
        if (scan.hasNext()) {
            jsonStr = scan.nextLine();
        }
        scan.close();
        CountryDTO country = GSON.fromJson(jsonStr.substring(1, jsonStr.length() - 1), CountryDTO.class);
        System.out.println(jsonStr);

        return Response.ok(GSON.toJson(country)).build();
    }
}
