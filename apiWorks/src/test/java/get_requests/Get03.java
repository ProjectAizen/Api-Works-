package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class Get03 extends JsonPlaceHolderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
		And
		    Response format should be “application/json”
		And
		    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
		And
		    “completed” is false
		And
		    “userId” is 2
     */

    @Test
    public void get01() {

        // 1- Set the URL
        // https://jsonplaceholder.typicode.com/todos/23

        spec.pathParams("first","todos","second",23);

        // 2- Set the expected Data(Post - Put - Patch)

        // 3-  Send the request adn get the respond
        Response response = given().spec(spec).when().get("/{first}/{second}");

        // 4- Do assertion

        // 1. yol
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("title", equalToIgnoringCase("et itaque necessitatibus maxime molestiae qui quas velit"))
                .body("completed",equalTo(false))
                .body("userId",equalTo(2));

        // 2. yol
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("title", equalToIgnoringCase("et itaque necessitatibus maxime molestiae qui quas velit")
                        ,"completed",equalTo(false)
                        ,"userId",equalTo(2));


/*  not 1:  Assertion yaparken Java calismayi durdurdugunda hata sonrasi kodlar calismaz.
            boylece hata sonrasi assertion lar hakkinda bilgi sahibi olamayiz
            fakat hata oncesi assertion lar gecmistir

     not 2: Eger kodumuzu hata noktasinda duracak sekilde yazarsak "hard assertion" yapmis oluruz
     not 3: Eger kodumuzu hata noktasinda durmayacak sekilde yazarsak 'soft assertion' yapmis oluruz

     not 4: Eger coklu body() methodu icinde assert yaparsak 'hard assert' yapmis oluruz
     not 5: Eger tek body() methodu icinde assert yaparsak 'hard assert' yapmis oluruz

*/

    }
}
