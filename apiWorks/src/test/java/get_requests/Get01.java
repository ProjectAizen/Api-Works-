package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
    /*
        1- Postman manuel API testi icin kullanilir.
        2- API otomasyon testi icin Rest-Assured Library kullaniyoruz.
        3- Otomasyon kodlarinin yazimi icin su adimlari izliyoruz:
            a- Gereksinimleri anlamak
            b- Test case'i yazmak
               Test case yazimi icin 'Gherkin Language' kullaniyoruz.
                    'Gherkin' bazi keywordlere sahiptir:
                    - Given: On kosullar
                    - When:  Aksiyonlar -> Get, Put, ...
                    - Then:  Output -> Dogrulama, Response, ...
                    - And:   Coklu islemler icin kullanilir

            c- Test kodunun yazimi
                    i-   Set the URL
                    ii-  Set the expected data(Post-Put-Patch)
                    iii- Type code to send request
                    iv-  Do Assertion
     */

    /*
        Given
            https://restful-booker.herokuapp.com/booking/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */


    @Test
    public void get01(){

        // i-   Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/5555";

        // ii-  Set the expected data(Post-Put-Patch)


        // iii- Type code to send request
        Response response = given().when().get(url);
        //System.out.println(response.prettyPrint());
        //System.out.println(response.asPrettyString());
        //System.out.println(response.contentType());
        //System.out.println(response.getHeader("id"));
        //System.out.println(response.print());

        // iv-  Do Assertion
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");
        System.out.println(response.getTime());



    }
}
