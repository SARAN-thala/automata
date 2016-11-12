import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws IOException, ParseException {
        JSONArray data = ReadFile.read("data/data.json");

        for (Object eachData : data) {
            HashMap tuple = (HashMap) eachData;
            System.out.println(tuple.get("tuple"));
//            System.out.println(((HashMap)eachData).get("tuple"));
        }

//        JSONObject jsonObject = (JSONObject) data.get(0);
//        System.out.println(jsonObject.get("tuple"));
    }
}

