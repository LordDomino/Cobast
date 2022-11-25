package cobast;

import cobast.Version;
import java.util.Scanner;

public class Main {

    public static boolean console_is_mainloop = true;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BOLD = "\u001b[1m";

    public static void main(String[] args) {
        
        Scanner console_in = new Scanner(System.in);
        
        int userin_int;
        String userin_string;

        boolean is_submenu;

        // Menu variables
        String cprint_mainHeader = "===== CLINIC RECORDS TRACKER ===============================\n";
        String cprint_menu_MAIN = cprint_mainHeader
                                + "  Service program provided through Cobast Pre-alpha 0.1\n\n"
                                + "  MENU\n"
                                + "     1  About Cobast\n"
                                + "     2  Edit scan directory\n"
                                + "     3  Begin scan query\n"
                                + "     4  Report bugs\n\n"
                                + "     5  Exit application";
        
        int cprint_menu_MAIN_start = 1;
        int cprint_menu_MAIN_stop = 5;
    
        String cprint_submenu_about = cprint_mainHeader + "\n"
                                + "  ABOUT " + Version._name + " " + Version._version + "\n"
                                + "    The Cobast (Console-Based Records Tracker) service is\n"
                                + "    a java application authored by Loui Naquita, Lance\n"
                                + "    Resurreccion, Ryl Pangilinan, and Zeamon Cruz.\n\n"
                                + "    Version name:    " + Version._name + "\n"
                                + "    Version:         " + Version._version;

        String cprint_submenu_dir = cprint_mainHeader + "\n"
                                + "  DIRECTORY\n"
                                + "    This application uses a so-called \"scan directory\"\n"
                                + "    where files are detected for data operations.\n\n"
                                + "    Choose an action from below.\n";

        String cprint_integerprompt = ">> Type the digit of your choice from the menu: ";

        // Begin initial printing for menu
        while (console_is_mainloop == true) {
            clear_console();

            System.out.println(cprint_menu_MAIN);
            userin_int = promptInputInteger(cprint_integerprompt, console_in);
            
            
            if (userin_int >= cprint_menu_MAIN_start && userin_int <= cprint_menu_MAIN_stop) {
                is_submenu = true;
                switch (userin_int) {
                    case 1:
                        while (is_submenu == true) {
                            clear_console();
                            System.out.println(cprint_submenu_about);
                            userin_string = promptInputString(">> Type \"R\" to go back to main menu: ", console_in);
                            
                            if (userin_string.equals("R")) {
                                is_submenu = false;
                            }
                        }
                        break;
                    case 2:
                        clear_console();
                        System.out.println(cprint_submenu_dir);
                        userin_int = promptInputInteger(cprint_integerprompt, console_in);
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        exit(); // do exit() first as program leaves "watermarks" of console
                        clear_console(); // do clear_console() to clear the leftover watermarks
                        break;
                }
            }
        }
    }

    public static void exit() {
        Main.console_is_mainloop = false;
    }

    public static void clear_console() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int promptInputInteger(String prompt_text, Scanner scanner) {
        System.out.print("\n" + ANSI_YELLOW + prompt_text + ANSI_RESET + ANSI_BOLD);
        if (scanner.hasNextInt()) {
            int _userin_int = scanner.nextInt();
            System.out.println(ANSI_RESET);
            return _userin_int;
        } else {
            scanner.nextLine();
            System.out.println(ANSI_RESET);
            return -1;
        }
    }

    public static String promptInputString(String prompt_text, Scanner scanner) {
        System.out.print("\n" + ANSI_YELLOW + prompt_text + ANSI_RESET + ANSI_BOLD);
        String _userin_str = scanner.nextLine();
        System.out.print(ANSI_RESET);
        return _userin_str;
    }
}