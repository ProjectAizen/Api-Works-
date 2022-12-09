package get_requests;

import base_urls.GoRestBaseUrl;
import org.junit.Test;

public class Get13Pojo extends GoRestBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users/2508
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
            {
                "meta": null,
                "data": {
                    "id": 13,
                    "name": "Sanya Pandey",
                    "email": "sanya_pandey@collier.io",
                    "gender": "female",
                    "status": "inactive"
                }
            }
     */

    @Test
    public void get01() {

    }
}
