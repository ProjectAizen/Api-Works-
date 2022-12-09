package put_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyApiDataPojo;
import pojos.DummyApiResponseBodyPojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put02 extends DummyRestApiBaseUrl {
    /*
   URL: https://dummy.restapiexample.com/api/v1/update/21
  HTTP Request Method: PUT Request
  Request body: {
                   "employee_name": "Tom Hanks",
                   "employee_salary": 111111,
                   "employee_age": 23,
                   "profile_image": "Perfect image"
                }
  Test Case: Type by using Gherkin Language
  Assert:
           i) Status code is 200
           ii) Response body should be like the following
               {
                   "status": "success",
                   "data": {
                       "employee_name": "Tom Hanks",
                       "employee_salary": 111111,
                       "employee_age": 23,
                       "profile_image": "Perfect image"
                   },
                   "message": "Successfully! Record has been updated."
               }
*/
    /*
            Given
https://dummy.restapiexample.com/api/v1/update/21
 {
                 "employee_name": "Tom Hanks",
                 "employee_salary": 111111,
                 "employee_age": 23,
                 "profile_image": "Perfect image"
              }
When
HTTP Request Method: PUT Request
Then
Status code is 200
And
Response body should be like the following
             {
                 "status": "success",
                 "data": {
                     "employee_name": "Tom Hanks",
                     "employee_salary": 111111,
                     "employee_age": 23,
                     "profile_image": "Perfect image"
                 },
                 "message": "Successfully! Record has been updated."
             }
     */

    @Test
    public void put01() {
        spec.pathParams("first","update","second",21);

        DummyApiDataPojo dummyDataPojo=new DummyApiDataPojo("Ali Can",111221,25,"Perfect image");
        DummyApiResponseBodyPojo expectedData=new DummyApiResponseBodyPojo("success",dummyDataPojo,"Successfully! Record has been updated.");

        Response response=given().spec(spec).contentType(ContentType.JSON).body(dummyDataPojo).when().put("/{first}/{second}");

        DummyApiResponseBodyPojo actualData= JsonUtil.convertJsonToJavaObject(response.asString(),DummyApiResponseBodyPojo.class);

        assertEquals(200,response.getStatusCode());
        assertEquals(dummyDataPojo.getEmployee_name(),actualData.getData().getEmployee_name());
        assertEquals(dummyDataPojo.getEmployee_salary(),actualData.getData().getEmployee_salary());
        assertEquals(dummyDataPojo.getEmployee_age(),actualData.getData().getEmployee_age());
        assertEquals(dummyDataPojo.getProfile_image(),actualData.getData().getProfile_image());
        assertEquals(expectedData.getStatus(),actualData.getStatus());
        assertEquals(expectedData.getMessage(),actualData.getMessage());
    }
}
