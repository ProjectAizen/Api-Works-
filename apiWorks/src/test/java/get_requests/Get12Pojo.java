package get_requests;

import base_urls.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;

public class Get12Pojo extends HerokuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/2
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {
                                    "firstname": "Mary",
                                    "lastname": "Brown",
                                    "totalprice": 227,
                                    "depositpaid": true,
                                    "bookingdates": {
                                        "checkin": "2015-10-21",
                                        "checkout": "2021-08-28"
                                    },
                                    "additionalneeds": "Breakfast"
                                 }
     */

    @Test
    public void get01() {
        spec.pathParams("first","booking","second","18");

        // 2. step set the expected data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo bookingPojo = new BookingPojo("omto","nena",112,true,bookingDatesPojo,"Breakfast");

        // 3. set the get request and get the respond
        Response response = given().spec(spec).when().get("/{first}/{second}");

        // 4. step do assertion
        BookingPojo actualPojo = response.as(BookingPojo.class);

        Assert.assertEquals(bookingPojo.getFirstname(),actualPojo.getFirstname());
        Assert.assertEquals(bookingPojo.getLastname(),actualPojo.getLastname());
        Assert.assertEquals(bookingPojo.getTotalprice(),actualPojo.getTotalprice());
        Assert.assertEquals(bookingPojo.getDepositpaid(),actualPojo.getDepositpaid());
        Assert.assertEquals(bookingPojo.getBookingdates().getCheckin(),actualPojo.getBookingdates().getCheckin());
        Assert.assertEquals(bookingPojo.getBookingdates().getCheckout(),actualPojo.getBookingdates().getCheckout());
        Assert.assertEquals(bookingPojo.getAdditionalneeds(),actualPojo.getAdditionalneeds());
    }
}
