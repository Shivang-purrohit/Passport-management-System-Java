package Passport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Passport Application System!");

        // Get applicant details
        System.out.println("Please enter your details:");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Date of Birth (dd/MM/yyyy): ");
        String dobStr = scanner.nextLine();
        System.out.print("Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        // Create the Application object
        Application application = new Application();
        application.setFirst_name(firstName);
        application.setLast_name(lastName);
        application.setGender(gender);
        application.setEmail(email);
        application.setPhone_number(phoneNumber);

        try {
            Date dob = parseDateOfBirth(dobStr);
            application.setDob(dob);
        } catch (ParseException e) {
            System.out.println("Invalid Date of Birth format! Please enter the date in dd/MM/yyyy format.");
            return;
        }

        System.out.println("\nThank you for providing your details. Your application is in progress.");
        System.out.println("Please wait while we process your application...");

        // Simulating processing time
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Generate application ID
        String applicationId = generateApplicationId();
        application.setApplication_id(applicationId);

        System.out.println("\nCongratulations, your application has been successfully processed!");
        System.out.println("Your application ID is: " + applicationId);

        // Display application summary
        System.out.println("\nApplication Summary:");
        System.out.println("Full Name: " + application.getFirst_name() + " " + application.getLast_name());
        System.out.println("Date of Birth: " + new SimpleDateFormat("dd/MM/yyyy").format(application.getDob()));
        System.out.println("Gender: " + application.getGender());
        System.out.println("Email: " + application.getEmail());
        System.out.println("Phone Number: " + application.getPhone_number());

        scanner.close();
    }

    private static Date parseDateOfBirth(String dobStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        return dateFormat.parse(dobStr);
    }

    private static String generateApplicationId() {
        // Generate a random 6-digit application ID
        int min = 100000;
        int max = 999999;
        int randomNum = min + (int) (Math.random() * ((max - min) + 1));
        return String.valueOf(randomNum);
    }
}
