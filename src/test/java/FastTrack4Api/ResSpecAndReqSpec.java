package FastTrack4Api;

import io.restassured.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

public class ResSpecAndReqSpec extends SpartanSpecTestBase{

    @Test
    public void test1() {

        Response response = RestAssured.given()
                .spec(reqSpec)
                .when().get("http://3.87.65.105:8000/api/spartans/{id}")
                .then().spec(resSpec).extract().response();

        response.prettyPrint();
    }
}
