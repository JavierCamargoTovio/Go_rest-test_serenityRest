package utils;

import com.github.javafaker.Faker;
import org.json.JSONObject;

import java.util.List;

public class PreparateBodyPost {
    public static final Faker faker = new Faker();

        public static String bodyUser(List<String> data) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", data.get(0));
            jsonObject.put("gender", data.get(2));
            jsonObject.put("email", faker.internet().emailAddress());
            jsonObject.put("status", data.get(3));
            return jsonObject.toString();


        }

}
