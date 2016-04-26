package ua.epam.spring.hometask.yeremenko.utils;

import org.springframework.stereotype.Component;

/**
 * Created by Olha_Yeremenko on 4/20/2016.
 */
@Component
public class ConsoleDialogUtils {


    public static void displayGreetings() {
        System.out.print("Hello! Enter your role [admin/user] to start work. \n" +
                " - admin \n" +
                " - user \n" +
                "Selected role: ");
    }

    public static void displayUserCommands() {
        System.out.print("Available commands for you [user]: \n" +
                "  - register user [1] \n" +
                "  - change user [2]\n" +
                "  - book ticket [3]\n" +
                "  - get event by name [4]\n" +
                "  - get all events [5]\n" +
                "  - get ticket price [6]\n" +
                "  - exit [0]\n" +
                "Selected command: ");
    }

    public static void displayAdminCommands() {
        System.out.print("Available commands for you [admin]: \n" +
                "  - change user [1]\n" +
                "  - remove user [2]\n" +
                "  - register user [3]\n" +
                "  - get all users [4]\n" +
                "  - get user by email [5]\n" +
                "  - create event [6]\n" +
                "  - remove event [7]\n" +
                "  - get event by name [8]\n" +
                "  - get all events [9]\n" +
                "  - get auditoriums [10]\n" +
                "  - get purchased ticket for event [11]\n" +
                "  - exit [0]\n" +
                "Selected command: ");
    }
}
