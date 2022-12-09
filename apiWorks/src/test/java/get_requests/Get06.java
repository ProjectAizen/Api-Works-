package get_requests;

import base_urls.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get06 extends HerokuAppBaseUrl {
     /*
        Given
            https://restful-booker.herokuapp.com/booking/101
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
          {
            "firstname": "Emily",
            "lastname": "Thompson",
            "totalprice": 173,
            "depositpaid": false,
            "bookingdates": {
                "checkin": "2022-07-31",
                "checkout": "2022-08-08"
            },
            "additionalneeds": "breakfast"
}
        }
     */

    @Test
    public void get06() {
        spec.pathParams("first","booking","second",101);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        //response.prettyPrint();

        // 1. yol
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Emily"),
                        "lastname",equalTo("Thompson"),
                        "totalprice",equalTo(173),
                        "depositpaid",equalTo(false),
                        "bookingdates.checkin",equalTo("2022-07-31"),
                        "bookingdates.checkout",equalTo("2022-08-08"),
                        "additionalneeds",equalTo("breakfast")
                );

        // 2. yol: JsonPath Class kullanilir
        JsonPath actualBody = response.jsonPath();
        assertEquals("Emily",actualBody.getString("firstname"));
        assertEquals("Thompson",actualBody.getString("lastname"));
        assertEquals(173,actualBody.getInt("totalprice"));
        assertEquals(false,actualBody.getBoolean("depositpaid"));
        assertEquals("2022-07-31",actualBody.getString("bookingdates.checkin"));
        assertEquals("2022-08-08",actualBody.getString("bookingdates.checkin"),actualBody.getString("bookingdates.checkout"));

        // 3. yol soft assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualBody.getString("firstname"),"Emily");
        softAssert.assertEquals(actualBody.getString("lastname"),"Thompson");
        softAssert.assertEquals(actualBody.getInt("totalprice"),173);
        softAssert.assertEquals(actualBody.getBoolean("depositpaid"),false);
        softAssert.assertEquals(actualBody.getString("bookingdates.checkin"),"2022-07-31");
        softAssert.assertEquals(actualBody.getBoolean("depositpaid"),false);

        softAssert.assertAll();
    }
}
