import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    private static final Faker FAKER = new Faker(new Locale("RU"));
    public static String email = FAKER.internet().emailAddress();
    public static String fio = FAKER.name().nameWithMiddle();
    public static String birthdate = "10.01.1956";
    public static final String DEFAULT_INN = "7707329152";
    public static String companyName = String.format("OOO %s", FAKER.company().name());
    public static String phoneNumber = String.format("910%s", FAKER.phoneNumber().subscriberNumber(7));
}
