package Tests;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UniqueEmailGenerator {
    public static String generateUniqueEmail() {
        // Use the current timestamp to generate a unique email
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        
        // Combine a base email with the timestamp
        return "user" + timestamp + "@example.com";
    }

    public static void main(String[] args) {
        // Example usage
        String uniqueEmail = generateUniqueEmail();
        System.out.println("Generated Email: " + uniqueEmail);

        // Use this in your Selenium test
        // email.sendKeys(uniqueEmail);
    }
}

