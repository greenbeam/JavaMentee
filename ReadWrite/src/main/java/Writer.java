package generator;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.random.RandomDataGenerator;

import java.io.File;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Writer {
    public static void main(String[] args) throws Exception {
        Set<User> userSet = new HashSet<>();
        for (int i = 0; i < 100_000; i++) {
            if (i % 1000 == 0) {
                System.out.println(i);
            }
            Fairy fairy = Fairy.create();
            Person person = fairy.person();
            User user = User.builder()
                    .id(new RandomDataGenerator().nextLong(0, Long.MAX_VALUE))
                    .firstName(person.getFirstName())
                    .lastName(person.getLastName())
                    .birthDate(person.getDateOfBirth().atStartOfDay())
                    .city(person.getAddress().getCity())
                    .street(person.getAddress().getStreet())
                    .firstLineAddress(person.getAddress().getAddressLine1())
                    .telephoneNumber(person.getTelephoneNumber())
                    .salary((Math.random() * (1000000 - 10000)) + 10000)
                    .isMale(person.isMale())
                    .build();
            userSet.add(user);
        }

        String data100 = new Gson().toJson(userSet);
        FileUtils.writeStringToFile(new File("100k_users"), data100);
        System.out.println("job is done, reader is ready");
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
