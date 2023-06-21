package upc.service2;
import com.google.gson.Gson;
import spark.ResponseTransformer;


public class JsonUtil {

    public static <T> String toJson(T e) {
        return new Gson().toJson(e);
    }

    public static ResponseTransformer json() {
        return JsonUtil::toJson;
    }
}