package FastTrack4Api;

import FastTrack4Api.POJO.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class PostMethod extends TestBase{

    //creating a new spartan
    // json --> java object(map, list, custom class)   deserilization
    // java object --> json   serilization
    @Test
    public void test1(){

        String bodyString = "{\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"name\": \"John\",\n" +
                "  \"phone\": 1236547895\n" +
                "}";

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("name","Jack");
        bodyMap.put("gender","Male");
        bodyMap.put("phone",6541239857l);

        Spartan bodySpartan = new Spartan();
        bodySpartan.setName("Harry");
        bodySpartan.setGender("Male");
        bodySpartan.setPhone(5287412369l);

        Response responseString = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(bodyString)
                .when().post("/api/spartans");

        responseString.prettyPrint();

        Response responseMap = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(bodyMap)
                .when().post("/api/spartans");

        responseMap.prettyPrint();

        Response responseClass = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(bodySpartan)
                .when().post("/api/spartans");

        responseClass.prettyPrint();


    }
}
