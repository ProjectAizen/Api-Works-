package delete_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Delete01 extends JsonPlaceHolderBaseUrl {
/*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
 */

    @Test
    public void delete01() {

        // 1. step: Set the URL
        spec.pathParams("first","todos","second","198");

        // 2. step: Set the expected data
        Map<String,Object> expectedDataMap = new HashMap<>();

        // 3. step: Send DELETE Request and get the response
        Response response = given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        // 4. step: Do assertion
        // 1. yol
        assertEquals(200,response.getStatusCode());
        assertEquals(expectedDataMap, response.as(HashMap.class));

        // 2. yol
        Map<String,Object> actualDataMap = response.as(HashMap.class);
        response.then().assertThat().statusCode(200);
        assertEquals(expectedDataMap, actualDataMap);

        // 3.yol
        assertTrue(actualDataMap.size()==0);
        assertTrue(actualDataMap.isEmpty());

        // Delete request yapmadan once "Post Request" yapip o datayi silmeliyiz

    }
}
