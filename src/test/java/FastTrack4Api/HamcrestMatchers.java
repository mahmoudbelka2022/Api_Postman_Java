package FastTrack4Api;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;


public class HamcrestMatchers extends TestBase {

    @Test
    public void test1() {
        given().accept(ContentType.JSON)
                .when().get("/api/spartans")
                .then().statusCode(200);
    }

    @Test
    public void test2() {
        given().accept(ContentType.JSON)
                .and().pathParam("id", 20)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200)
                .and().assertThat().contentType(ContentType.JSON)
                .and().body("name", is("Lothario"),
                        "gender", equalTo("Male"),
                        "id", is(greaterThan(10))
                );
    }


    // hamcrest matchers validating list
    @Test
    public void test3() {

        // extract method helps us extract response to other objects afte validation
        List<String> names = given().accept(ContentType.JSON)
                .when().get("/api/spartans")
                .then().statusCode(200)
                .extract().jsonPath().getList("name");

        System.out.println(names);

        assertThat(names, hasSize(greaterThan(20)));
        assertThat(names,hasItem("Paige"));
        assertThat(names, everyItem(not(nullValue())));
    }


}
