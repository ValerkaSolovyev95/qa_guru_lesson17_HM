import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    private Faker faker = new Faker(new Locale("RU"));
    public String email = faker.internet().emailAddress();
    public String fio = faker.name().nameWithMiddle();
    public String birthdate = "10.01.1956";
    public final String DEFAULT_INN = "7707329152";
    public String companyName = String.format("OOO %s", faker.company().name());
    public String phoneNumber = String.format("910%s", faker.phoneNumber().subscriberNumber(7));
}
