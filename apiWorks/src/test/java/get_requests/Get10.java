package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get10 extends GoRestBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users/2986
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
  {
    "meta": null,
    "data": {
        "id": 2986,
        "name": "Mrs. Agastya Nambeesan",
        "email": "nambeesan_agastya_mrs@littel-schultz.com",
        "gender": "female",
        "status": "inactive"
            }
   }
     */

    @Test
    public void get01() {

        // set the url
        spec.pathParams("first", "users", "second", 2986);

        // set the expected data
        GoRestTestData dataKey = new GoRestTestData();

        Map<String,String> dataMap = dataKey.dataKeyMap("Mrs. Agastya Nambeesan","nambeesan_agastya_mrs@littel-schultz.com","female","inactive");

        Map<String,Object> expectedData = dataKey.expectedDataMap(null,dataMap);


        // 3. send the request and get the data
        Response response = given().spec(spec).when().get("/{first}/{second}");
        Map<String,Object> actualData = response.as(HashMap.class);

        // do assertion
        assertEquals(expectedData.get("meta"),actualData.get("meta"));
        assertEquals(expectedData.get(dataMap.get("name")),actualData.get(dataMap.get("name")));
        assertEquals(dataMap.get("name"),((Map)actualData.get("data")).get("name"));
        assertEquals(dataMap.get("email"),((Map)actualData.get("data")).get("email"));
        assertEquals(dataMap.get("gender"),((Map)actualData.get("data")).get("gender"));
        assertEquals(dataMap.get("status"),((Map)actualData.get("data")).get("status"));
        //Actual data kismi Object, Map<String,Object>, goruldugu uzere 2. kisim hep object. o yuzden bu map olmadigi
        // icin casting yapiyoruz.

    }
}
