package ua.epam.spring.hometask.yeremenko.utils;


import java.util.*;

public class ConsoleUtils {

    public static String readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        if (scanner.hasNextLine()){
            input = scanner.nextLine();
        }
        return input;
    }

    public static int readIntFromConsole() {
        Scanner scanner = new Scanner(System.in);
        int input=0;
        if (scanner.hasNextLine()){
            try {
            input = scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Oops!! Please enter only integral numbers");
            }
        }
        return input;
    }

    public static Set<Long> parseStringToSetLong(String string) {
        List<String> stringList =new ArrayList<>(Arrays.asList(string.split(",")));
        Set<Long>  intSet= new TreeSet<>();
            for (String str : stringList) {
                intSet.add(Long.parseLong(str));
            }
            return intSet;
    }
}
