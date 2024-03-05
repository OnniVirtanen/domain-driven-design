package com.paymentservice.demo.application.testdata;

import com.paymentservice.demo.domain.Account;
import com.paymentservice.demo.domain.Person;
import com.paymentservice.demo.domain.valueobject.Age;
import com.paymentservice.demo.domain.valueobject.FullName;
import com.paymentservice.demo.domain.valueobject.Money;
import com.paymentservice.demo.domain.valueobject.ReadableDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class TestDataGenerator {

    public static Account createRandomAccount() {
        Person person = new Person();

        person.setName(new FullName(generateRandomName(), generateRandomName()));
        person.setAge(new Age((short) (new Random().nextInt(100) + 1)));

        // Define the date range
        LocalDate startDate = LocalDate.of(2000, 1, 1); // Start date
        LocalDate endDate = LocalDate.of(2020, 12, 31); // End date

        // Generate a random date within the range
        String randomDate = generateRandomDate(startDate, endDate);

        person.setDateOfBirth(new ReadableDate(randomDate));

        Random random = new Random();
        Account account = new Account();
        account.setFrozen(random.nextDouble() > 0.98);
        account.setBalance(generateRandomMoney());
        account.setAccountHolder(person);

        return account;
    }

    private static Money generateRandomMoney() {
        Random rand = new Random();
        long randomAmount = 0;

        // Probability distribution: higher probability for values in the range of a couple of thousand
        int probabilityThreshold = rand.nextInt(100); // Adjust this threshold as needed
        if (probabilityThreshold < 60) { // 60% probability for values in the couple thousand range
            randomAmount = (long) (rand.nextInt(2000) + 1000); // Range: 1000 - 2999
        } else if (probabilityThreshold < 90) { // 30% probability for values in the range of a couple hundred
            randomAmount = (long) (rand.nextInt(200) + 100); // Range: 100 - 299
        } else { // 10% probability for other values within the range 0 - 5 million
            randomAmount = (long) (rand.nextDouble() * 5000000); // Range: 0 - 5 million
        }
        return new Money(BigDecimal.valueOf(randomAmount));
    }

    private static String generateRandomDate(LocalDate start, LocalDate end) {
        Random random = new Random();
        long startEpochDay = start.toEpochDay();
        long endEpochDay = end.toEpochDay();
        long randomDay = startEpochDay + random.nextLong(endEpochDay - startEpochDay + 1); // +1 to include end date

        // Create a random date and format it
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        return randomDate.format(formatter);
    }

    private static String generateRandomName() {
        Random random = new Random();
        int length = random.nextInt(10) + 5; // 5 to 15 characters
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            if (i == 5) {
                sb.append(' '); // Insert a space between the 5th and 6th characters
            }
            sb.append(c);
        }
        return sb.toString(); // Return the random name as a string
    }

}
