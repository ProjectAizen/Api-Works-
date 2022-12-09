package get_requests;

import base_urls.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends HerokuAppBaseUrl {
    //Given
    //            https://restful-booker.herokuapp.com/booking/91
    //        When
    //            I send GET Request to the url
    //        Then
    //            Response body should be like that;
    //            {
    //        "firstname": "James",
    //        "lastname": "Brown",
    //        "totalprice": 111,
    //        "depositpaid": true,
    //        "bookingdates": {
    //            "checkin": "2018-01-01",
    //            "checkout": "2019-01-01"
    //        },
    //        "additionalneeds": "Breakfast"
    //         }


    @Test
    public void get01() {

        // 1. step: Set the URL
        spec.pathParams("first","booking","second",91);

        // 2. step: Set the expected data
        Map<String,String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin","2018-01-01");
        bookingdatesMap.put("checkout","2019-01-01");

        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put( "firstname","James");
        expectedData.put("lastname","Brown");
        expectedData.put("totalprice",111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", bookingdatesMap);
        expectedData.put("additionalneeds", "Breakfast");

        // 3. step: Send the request and get the Respond
        Response response = given().spec(spec).when().get("/{first}/{second}");
        Map<String,Object> actualData =  response.as(HashMap.class);

        // 4. step: Do Assertion
        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
        assertEquals(bookingdatesMap.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesMap.get("checkout"),((Map)actualData.get("bookingdates")).get("checkout"));
        assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));

    }
}
