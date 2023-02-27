package FastTrack4Api;

import io.restassured.http.*;
import io.restassured.module.jsv.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

public class SchemaValidation extends TestBase{


    // single spartan schema test
    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/10")
                .then().statusCode(200)
                .and().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("singleSpartanSchema.json"))
                .extract().response();
    }
}
