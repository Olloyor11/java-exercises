package com.amigoscode._6_functionalinterfaces.exercise_from_website;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        // sendEmail("hello@amigoscode.com");
        sendEmailConsumer.accept("jamila@amigoscode.com");


        List<String> emails = List.of(
                "hello@amigoscode.com",
                "foo@amigoscode.com",
                "bar@amigoscode.com"
        );
        emails.forEach(Main::sendEmail);
        // emails.forEach(email -> sendEmail(email));
        emails.forEach(to -> sendEmailFunc.accept("jamila@amigoscode.com", to));


    }

    static Consumer<String> sendEmailConsumer =
            email -> System.out.println("sending email to " + email);

    static void sendEmail(String email) {
        System.out.println("sending email to " + email);
    }

    static BiConsumer<String, String> sendEmailFunc = (from, to) -> {
        sendEmailConsumer.accept(from);
        sendEmail(to);
        System.out.println("sending email from: %s to %s" .formatted(from,to));

    };




}
