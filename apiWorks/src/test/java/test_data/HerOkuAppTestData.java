package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {

    public Map<String,String> bookingdatesSetup(String checkin, String checkout){
        Map<String,String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin",checkin);
        bookingdatesMap.put("checkout",checkout);
        return bookingdatesMap;

    }

    public Map<String,Object> expectedDataSetup(String firstname, String lastname, int totalprice, boolean depositpaid, Map<String,String> bookingdates){
        Map<String,Object> expedtedData = new HashMap<>();
        expedtedData.put("firstname",firstname);
        expedtedData.put("lastname",lastname);
        expedtedData.put("totalprice",totalprice);
        expedtedData.put("depositpaid",depositpaid);
        expedtedData.put("bookingdates",bookingdates);

        return expedtedData;

    }
}
