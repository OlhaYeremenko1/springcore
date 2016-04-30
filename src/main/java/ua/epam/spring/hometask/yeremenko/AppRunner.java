package ua.epam.spring.hometask.yeremenko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.yeremenko.aspects.CounterAspect;
import ua.epam.spring.hometask.yeremenko.aspects.DiscountAspect;
import ua.epam.spring.hometask.yeremenko.aspects.LuckyWinnerAspect;
import ua.epam.spring.hometask.yeremenko.domain.*;
import ua.epam.spring.hometask.yeremenko.jdbc.DBManager;
import ua.epam.spring.hometask.yeremenko.service.implementation.AuditoriumService;
import ua.epam.spring.hometask.yeremenko.service.implementation.BookingService;
import ua.epam.spring.hometask.yeremenko.service.implementation.EventService;
import ua.epam.spring.hometask.yeremenko.service.implementation.UserService;
import ua.epam.spring.hometask.yeremenko.utils.ConsoleUtils;
import ua.epam.spring.hometask.yeremenko.utils.CustomLocalDateTimeEditor;

import java.time.LocalDateTime;
import java.util.*;

import static ua.epam.spring.hometask.yeremenko.utils.ConsoleDialogUtils.*;
import static ua.epam.spring.hometask.yeremenko.utils.ConsoleUtils.*;

/**
 * Created by Olha_Yeremenko on 4/19/2016.
 */
@Component
public class AppRunner {
    /**
     * Instantiates a new App runner.
     */
    public AppRunner() {
    }

    @Autowired
    private DBManager dbManager;

    @Autowired
    private AuditoriumService auditoriumService;

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private CustomLocalDateTimeEditor dateTimeEditor;

    @Autowired
    private LuckyWinnerAspect luckyWinnerAspect;

    @Autowired
    private CounterAspect counterAspect;

    @Autowired
    private DiscountAspect discountAspect;


    private void addTestData(){
        auditoriumService.addAuditorium("red", 30, "10,11,12");
        auditoriumService.addAuditorium("green", 60, "50,51,52,53,54,55");
        eventService.addEvent("event1", 120, EventRating.HIGH, "2010-01-01,2010-01-02", "2010-01-01/red,2010-01-02/green");
        userService.addUser("fname1", "lname1", "1995-01-02", "email1");
        bookingService.addTicket("email1", "event1", "2010-01-01", 10);

    }
    public void run() {
        dbManager.init();
        addTestData();
        chooseUser();

    }

    private void chooseUser() {
        displayGreetings();
        String userRole = readFromConsole();
        int selectedCommand;
        if (userRole.equals("admin")) {
            displayAdminCommands();
            selectedCommand = readIntFromConsole();
            processAdminActionds(selectedCommand);
        }
        if (userRole.equals("user")) {
            displayUserCommands();
            selectedCommand = readIntFromConsole();
            processUserActions(selectedCommand);
        }
    }

    ///ADMIN ACTIONS
    private void processAdminActionds(int commandId) {
        switch (commandId) {
            case 0:
                System.out.println("Exiting...");
                break;
            case 1:
                System.out.println("change user...");
                chooseUser();
                break;
            case 2:
                System.out.println("remove user..");
                removeUser();
                chooseUser();
                break;
            case 3:
                System.out.println("register user..");
                registerUser();
                chooseUser();
                break;
            case 4:
                System.out.println("get all users..");
                getAllUsers();
                chooseUser();
                break;
            case 5:
                System.out.println("get user by Email..");
                getUserByEmail();
                chooseUser();
                break;
            case 6:
                System.out.println("create event..");
                createEvent();
                chooseUser();
                break;
            case 7:
                System.out.println("remove event..");
                removeEvent();
                chooseUser();
                break;
            case 8:
                System.out.println("get event by name..");
                getEventByName();
                chooseUser();
                break;
            case 9:
                System.out.println("get all events..");
                getAllEvents();
                chooseUser();
                break;
            case 10:
                System.out.println("get all auditoriums..");
                getAllAuditoriums();
                chooseUser();
                break;
            case 11:
                System.out.println("get purchased ticket for event..");
                getPurchasedTicketsForEvent();
                chooseUser();
        }
    }

    private void getEventByNameStatistics() {
        Set<String> nameKeys = counterAspect.getNameCounter().keySet();
        System.out.println("Event statistics");
        for (String name : nameKeys) {
            System.out.println("Event '" + name + "' got " + counterAspect.getNameCounter().get(name) + " times");
        }
    }

    private void getDiscountStatistics() {
        Set<Double> discountKeys = discountAspect.getTotalDiscountCounter().keySet();
        System.out.println("Statistics for all discounts");
        for (Double discount : discountKeys) {
            System.out.println("Discount '" + discount + "' count is " + discountAspect.getTotalDiscountCounter().get(discount));
        }
    }

    private void processUserActions(int commandId) {
        switch (commandId) {
            case 0:
                System.out.println("Exiting...");
                break;
            case 1:
                System.out.println("register user...");
                registerUser();
                chooseUser();
                break;
            case 2:
                System.out.println("change user...");
                chooseUser();
                break;
            case 3:
                System.out.println("book ticket...");
                bookTicket();
                chooseUser();
                break;
            case 4:
                System.out.println("get event by name ...");
                getEventByName();
                chooseUser();
                break;
            case 5:
                System.out.println(" get all events...");
                getAllEvents();
                chooseUser();
                break;
            case 6:
                System.out.println(" get ticket price...");
                getTicketPrice();
                chooseUser();
                break;
        }
    }

    private void getPurchasedTicketsForEvent() {
        System.out.println("Enter event name: ");
        Event event = eventService.getByName(readFromConsole());
        System.out.println("Enter event day (dd-MM-yyyy): ");
        LocalDateTime date = dateTimeEditor.parseText(readFromConsole());
        try {
            Set<Ticket> booked = bookingService.getPurchasedTicketsForEvent(event, date);
            if (booked.isEmpty()) {
                System.out.println("There are no tickets");
            } else {
                booked.forEach(ticket -> System.out.println(ticket.toString()));
            }
        } catch (NullPointerException e) {
            System.out.println("There are no tickets");
        }
    }

    private void removeUser() {
        User user = getUserByEmail();
        userService.remove(user);
    }

    private void registerUser() {
        System.out.println("Enter user first name:");
        String fname = ConsoleUtils.readFromConsole();
        System.out.println("Enter user lirst name:");
        String lname = ConsoleUtils.readFromConsole();
        System.out.println("Enter user email:");
        String userEmail = ConsoleUtils.readFromConsole();
        System.out.println("Enter user birth date (yyyy-MM-dd):");
        String birthDate = ConsoleUtils.readFromConsole();

        try {
            User newUser = new User();
            newUser.setFirstName(fname);
            newUser.setLastName(lname);
            newUser.setEmail(userEmail);
            newUser.setBirthday(dateTimeEditor.parseText(birthDate));
            userService.save(new User());
        } catch (IllegalArgumentException e) {
            System.out.println("Something went wrong with data you entered. Please enter it again.");
            registerUser();
        }
    }

    private void getAllUsers() {
        userService.getAll().forEach(e -> System.out.println(e.toString()));
    }

    private User getUserByEmail() {
        System.out.println("Enter user email: ");
        String userEmail = ConsoleUtils.readFromConsole();
        User user = null;
        try {
            user = userService.getUserByEmail(userEmail);
            System.out.println(user.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\nPlease enter user valid email.");
            getUserByEmail();
        }
        return user;
    }

    private void createEvent() {
        try {
            System.out.println("Enter event name:");
            String eventName= readFromConsole();
            System.out.println("Enter event base ticket price");
            double basePrice = readIntFromConsole();
            System.out.println("Enter rating of event (HIGH, MID, LOW");
            EventRating rating=EventRating.valueOf(readFromConsole());
            System.out.println("Enter air dates (yyyy-MM-dd) with separator ',': ");
            String dates =  readFromConsole();

            System.out.println("Create schedule. Enter date/auditorium name yyyy-MM-dd/auditorium name");
            String auditoriums =  readFromConsole();
            TreeMap<LocalDateTime, Auditorium> scheduleMap = new TreeMap<>();
            eventService.addEvent(eventName,basePrice,rating,dates,auditoriums);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\nPlease enter event info again.");
            createEvent();
        }
    }

    private void addToSchedule(TreeMap<LocalDateTime, Auditorium> scheduleMap) {
        System.out.println("Add day to schedule: ");
        System.out.println("Enter date (yyyy-MM-dd) :");
        LocalDateTime date = dateTimeEditor.parseText(readFromConsole());
        System.out.println("Enter auditorium name:");
        Auditorium auditorium = auditoriumService.getByName(readFromConsole());
        scheduleMap.put(date, auditorium);
        System.out.println(scheduleMap.get(date).toString());
    }

    private void removeEvent() {
        System.out.println("Enter event name:");
        String eventName = readFromConsole();
        try {
            eventService.removeEvent(eventService.getByName(eventName));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\nPlease enter event name again.");
            removeEvent();
        }
    }

    private void getAllEvents() {
        eventService.getAll().forEach(event -> System.out.println(event.toString()));
    }

    private void getAllAuditoriums() {
        auditoriumService.getAll().forEach(auditorium -> System.out.println(auditorium.toString()));
    }

    private Event getEventByName() {
        System.out.println("Enter event name:");
        String eventName = readFromConsole();
        Event event = null;
        try {
            event = eventService.getByName(eventName);
            if (event != null) {
                System.out.println(event.toString());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Please enter event name again.");
            getEventByName();
        }
        return event;
    }

    private void bookTicket() {
        try {
            Event event = getEventByName();
            User user = getUserByEmail();
            System.out.println("Enter date for event (yyyy-MM-dd)");
            LocalDateTime date = dateTimeEditor.parseText(readFromConsole());
            System.out.println("Enter number of seat (ex: 23,24,25): ");
            Set<Long> seatSet = parseStringToSetLong(readFromConsole());
            Set<Ticket> tickets = new TreeSet<>();
            seatSet.forEach(
                    seat -> {
                        Ticket ticket = new Ticket(user, event, date, seat);
                        tickets.add(ticket);
                        System.out.println(String.format("Ticket %s created", ticket.toString()));
                    }
            );
            bookingService.bookTickets(tickets);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\nPlease enter user valid data.");
            bookTicket();
        }
    }

    public void getTicketPrice() {
        Event event = getEventByName();
        User user = getUserByEmail();
        System.out.println("Enter date for event (yyyy-MM-dd)");
        LocalDateTime date = dateTimeEditor.parseText(readFromConsole());
        System.out.println("Enter number of seat (ex: 23,24,25): ");
        Set<Long> seatSet = parseStringToSetLong(readFromConsole());
        double finalPrice = bookingService.getTicketsPrice(event, date, user, seatSet);
        System.out.println(String.format("You buy tickets for %s \\$", finalPrice));
    }

    private void checkIsUserLucky() {
        System.out.println("Please enter user email");
        User user = getUserByEmail();
        if (userService.isLuckyCheck(user))
            System.out.println("User is lucky");
        System.out.println("User no lucky");
    }


}
