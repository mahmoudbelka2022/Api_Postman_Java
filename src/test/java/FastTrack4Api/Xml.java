package FastTrack4Api;

import groovy.xml.*;
import io.restassured.http.*;
import io.restassured.path.xml.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class Xml extends TestBase{


    // getting xml format
    @Test
    public void test1(){
        Response response = given().accept(ContentType.XML)
                .when().get("/api/spartans");

//        response.prettyPrint();
        System.out.println(response.path("List.item[0].id").toString());
        Assertions.assertEquals("Jerry",response.path("List.item[1].name"));

        XmlPath xmlPath = response.xmlPath();
        System.out.println(xmlPath.get("List.item[4].name").toString());
    }
}
