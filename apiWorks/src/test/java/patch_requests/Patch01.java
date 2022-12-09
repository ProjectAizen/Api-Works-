package patch_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class Patch01 extends JsonPlaceHolderBaseUrl {

    /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "title": "Wash the dishes"
               }
        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 10,
									    "title": "Wash the dishes",
									    "completed": true,
									    "id": 198
									   }
     */

    @Test
    public void patch01() {

        // 1. step: set the url
        spec.pathParams("first","todos","second","198");

        // 2. step: set the request body
        JsonPlaceHolderTestData requestBody = new JsonPlaceHolderTestData();
        //Map<String,Object> requestBodyMap  = requestBody.expectedDataWithMissingKeys(new JPHBodyKeys[]{JPHBodyKeys.title, JPHBodyKeys.completed},new Object[]{"Wash the dishes",false});
        Map<String, Object> requestBodyMap = requestBody.expectedDataWithMissingKeys(null,"Wash the dishes", null);

        // 3. step: sen the patch request
        Response response = given().spec(spec).contentType(ContentType.JSON).body(requestBodyMap).when().patch("/{first}/{second}");
        response.prettyPrint();


    }
}
