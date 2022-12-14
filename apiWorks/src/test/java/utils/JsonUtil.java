package utils;


import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    private static ObjectMapper mapper;

    static{
        mapper = new ObjectMapper();
    }

    // 1. method: Json Datasini Java objesine cevirir.(De-Serilization)
    public static <T> T convertJsonToJavaObject(String json, Class<T> cls ){
        T javaResult = null;
        try {
           javaResult = mapper.readValue(json,cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return javaResult;
    }



    // 2. method: Java objesini Json Datasina cevirir. (Serilization)
    public static String convertJavaObjectToJson(Object obj){
        String jsonResult= null;

        try {
            jsonResult = mapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonResult;
    }
}
