package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {
    public static <T> T convertJsonToJava(String json, Class<T> cls) {
        try {
            return new ObjectMapper().readValue(json, cls);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String expectedDataInString(int userId, String title, boolean completed) {

        return " { userId=" + userId + ", title=" + title + ", completed=" + completed + "}";
    }
}