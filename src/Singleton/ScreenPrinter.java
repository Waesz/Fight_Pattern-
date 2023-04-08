package Singleton;

public class ScreenPrinter {
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";

    public static final String RESET = "\u001B[0m";

    private static ScreenPrinter unique_printer;
    private static String current_color;

    private ScreenPrinter(){}

    public static ScreenPrinter getInstance() {
        if(unique_printer == null) {
            unique_printer = new ScreenPrinter();
            current_color = RESET;
        }
        return unique_printer;
    }

    public void setColor(String color) {
        current_color = color;
        System.out.print(current_color);
    }
    
}
