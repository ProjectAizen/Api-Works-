package get_requests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get02 {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/1001
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

    @Test
    public void get01() {

        // 1- Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/1005";

        // 2- Set the expected Data(Post - Put - Patch)

        // 3-  Type code to send request
        Response response = given().when().get(url);
        response.prettyPrint();

        // 4- Do assertion
        response
                .then()
                .assertThat()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found");

        // Response body'de bulunan spesifik bir veri nasil assert edilir
        // assertTrue() methodu parantezin icindeki deger true ise testi gecirir
        assertTrue(response.asPrettyString().contains("Not Found"));

        // Response body'de spesifik bir verinin bulunmadigi assert edilir
        // assertFalse() methodu parantezin icindeki deger false ise testi gecirir
        assertFalse(response.asString().contains("TechProEd"));

        // assertEquals() methodu parantez icindeki iki deger esit isetesti gecirir
        assertEquals("Cowboy",response.header("Server"));
    }
}
