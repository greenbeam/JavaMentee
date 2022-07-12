import java.time.LocalDateTime;
import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.io.FileUtils;

public class MyCollection {
    public static void main(String[] args) {
        System.out.println("Get users");

    }

    @Data
    @Builder
    @AllArgsConstructor
    static class User {
        private long id;
        //    private String firstName;
        //     private String lastName;
        private LocalDateTime birthDate;
        //    private String city;
        //    private String street;
        //   private String firstLineAddress;
        //  private String country;
        //  private String telephoneNumber;
        //  private double salary;
        //  private boolean isMale;
    }

    public Collection<User> getUserWithBirthDays(LocalDateTime birthDayFrom, LocalDateTime birthDayTo) {
        Map<LocalDateTime, User> usersByBirthday = new HashMap<>();
        //   User userFrom = new User(0, birthDayFrom);
        //   User userTo = new User(Long.MAX_VALUE, birthDayTo);

        for (LocalDateTime localDateTime : usersByBirthday.keySet()) {
            User user = usersByBirthday.get(localDateTime);
            usersByBirthday.put(localDateTime, user);
        }
         return (Collection<User>) usersByBirthday;
    }
}