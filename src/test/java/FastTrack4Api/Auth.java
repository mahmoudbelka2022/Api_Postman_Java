package FastTrack4Api;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

public class Auth {


    // basic auth
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .and().auth().basic("user","user")
                .when().get("http://3.87.65.105:7000/api/spartans");

        response.prettyPrint();
    }


    // bearer token

    @Test
    public void test2(){
        String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTUxNiIsImF1ZCI6InRlYWNoZXIifQ.saFcTsRyMJQj1e8jhya1zpxngBggh5fC3lGsGyBCrQs";

        given().header("Authorization",token)
                .and().accept(ContentType.JSON)
                .when().get("http://api.qa.bookit.cydeo.com/api/campuses")
                .then().statusCode(200);
    }
}
