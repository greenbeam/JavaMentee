package generator;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.random.RandomDataGenerator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Reader {

    public static void main(String[] args) throws Exception {
        Set<User> userSet = readData("100k_users");
        System.out.println("");
    }

    private static Set<User> readData(String filepath) throws Exception {
        Type REVIEW_TYPE = new TypeToken<Set<User>>() {
        }.getType();
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(filepath));
        Set<User> data = gson.fromJson(reader, REVIEW_TYPE); // contains the whole reviews list
        return data;
    }

    @Data
    @Builder
    @AllArgsConstructor
    static class User {
        private long id;
        private String firstName;
        private String lastName;
        private LocalDateTime birthDate;
        private String city;
        private String street;
        private String firstLineAddress;
        private String country;
        private String telephoneNumber;
        private double salary;
        private boolean isMale;
    }


}
