import java.util.Scanner;

public class SmartBankingApp{
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String COLOR_GREEN_BOLD = "\033[33;1m";
        final String RESET = "\033[0m";

        final String DASHBOARD = "\u1F4B0 Welcome to Smart Banking App";
        final String OPEN_ACCOUNT = "\u1F195 Open New Account";
        final String DEPOSIT_MONEY = "\u1F4B8 Withdraw Money";
        final String TRANFER_MONEY = "\u1F911 Transfer Money";
        final String CHECK_BALANCE = "\u2705 Check Account Balance";
        final String DROP_ACCOUNT = "\u1F6AE Drop Existing Account";

        final String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
        final String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);


        


    }
}