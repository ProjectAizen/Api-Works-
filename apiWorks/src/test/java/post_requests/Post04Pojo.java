package post_requests;

import base_urls.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponseBodyPojo;

import static io.restassured.RestAssured.given;

public class Post04Pojo extends HerokuAppBaseUrl {
/*
         Given
            https://restful-booker.herokuapp.com/booking
            {
                "firstname": "Ali",
                "lastname": "Can",
                "totalprice": 999,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-21",
                    "checkout": "2021-12-21"
                 }
                 "additionalneeds": "Breakfast with white tea, Dragon juice"
             }
        When
 		    I send POST Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {
 		                            "bookingid": 16,
 		                            "booking" :{
                                        "firstname": "Ali",
                                        "lastname": "Can",
                                        "totalprice": 999,
                                        "depositpaid": true,
                                        "bookingdates": {
                                            "checkin": "2021-09-21",
                                            "checkout": "2021-12-21"
                                        }
                                        "additionalneeds": "Breakfast with white tea, Dragon juice"
                                     }
                                  }
     */

    @Test
    public void post01() {

        spec.pathParam("first","booking");

        BookingDatesPojo bookingDates=new BookingDatesPojo("2021-09-21","2021-12-21");
        BookingPojo bookingPojo=new BookingPojo("Ali","Can",999,true,bookingDates,"Breakfast with white tea, Dragon juice");

        Response response = given().spec(spec).contentType(ContentType.JSON).body(bookingPojo).post("/{first}");

        BookingResponseBodyPojo actualBody = response.as(BookingResponseBodyPojo.class);

        Assert.assertEquals(bookingPojo.toString(),actualBody.getBooking().toString());

    }
}
