package com.paymentservice.demo.testdata;

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
        account.setBalance(new Money(new BigDecimal(random.nextLong())));
        account.setAccountHolder(person);

        return account;
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
