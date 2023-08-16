import java.util.Random;
import java.util.Scanner;
import java.lang.String;
import java.lang.*;

public class SmartBankingApp{
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {

        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String COLOR_GREEN_BOLD = "\033[33;1m";
        final String RESET = "\033[0m";

        final String DASHBOARD = "🏦 Welcome to Smart Banking App";
        final String OPEN_ACCOUNT = "📂 Open New Account";
        final String DEPOSIT_MONEY = "💰 Deposit Money";
        final String WITHDRAW_MONEY = "🤑 Withdraw Money";
        final String TRANFER_MONEY = "💸 Transfer Money";
        final String CHECK_BALANCE = "💵 Check Account Balance";
        final String DROP_ACCOUNT = "🚮 Drop Existing Account";

        final String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
        final String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);


        String screen = DASHBOARD;

        String[] customerIds = new String[0];
        String[] customerNames = new String[0];
        int[] accBalance = new int[0];


        do{
            final String APP_TITLE = String.format("%s%s%s",COLOR_BLUE_BOLD, screen, RESET);

            System.out.println(CLEAR);
            System.out.printf("%s%s\n",COLOR_BLUE_BOLD,"-".repeat(50));
            System.out.println(" ".repeat((50-APP_TITLE.length()+7)/2).concat(APP_TITLE));
            System.out.printf("%s%s%s\n",COLOR_BLUE_BOLD,"-".repeat(50),RESET);

            switch(screen){
                case DASHBOARD:
                    System.out.println("\t[1]. Open New Account");
                    System.out.println("\t[2]. Deposit Money");
                    System.out.println("\t[3]. Withdraw Money");
                    System.out.println("\t[4]. Transfer Money");
                    System.out.println("\t[5]. Check Account Balance");
                    System.out.println("\t[6]. Drop Existing Account");
                    System.out.println("\t[7]. Exit\n");
                    System.out.print("\tEnter an option to continue: ");
                    int option = SCANNER.nextInt();
                    SCANNER.nextLine();

                    switch(option){
                        case 1: screen = OPEN_ACCOUNT; break;
                        case 2: screen = DEPOSIT_MONEY; break;
                        case 3: screen = WITHDRAW_MONEY; break;
                        case 4: screen = TRANFER_MONEY; break;
                        case 5: screen = CHECK_BALANCE; break;
                        case 6: screen = DROP_ACCOUNT; break;
                        case 7: 
                        System.out.println(CLEAR);
                        System.out.printf("\n\n\t%sHave a Nice Day!👋%s\n\n\n",COLOR_BLUE_BOLD,RESET);
                        System.exit(0);

                        default: continue;

                    }
                    break;
                case OPEN_ACCOUNT:
                    String id;
                    String name;
                    boolean valid;
                    int depo;

                
                
                    valid = true;
                    Random rand = new Random();
                    int randomId = rand.nextInt(99999);
                    id = String.format("SDB-%05d", randomId);
                    System.out.printf("\tID: %s\n",id);
                    
                // Name Validation
                do{
                    valid = true;
                    System.out.print("\tEnter Customer Name: ");
                    name = SCANNER.nextLine().strip();
                    if (name.isBlank()){
                        System.out.printf(ERROR_MSG, "Customer name can't be empty");
                        valid = false;
                        continue;
                    }
                    for (int i = 0; i < name.length(); i++) {
                        if (!(Character.isLetter(name.charAt(i)) || 
                            Character.isSpaceChar(name.charAt(i))) ) {
                            System.out.printf(ERROR_MSG, "Invalid name");
                            valid = false;
                            break;
                        }
                    }
                }while(!valid);

                do{
                    valid = true;
                    System.out.println("Initial Deposit: ");
                    depo = SCANNER.nextInt();
                    SCANNER.nextLine();
                    if (depo < 5000){
                        System.out.printf(ERROR_MSG, "Initial Deposit Should be grater than 5000");
                        valid = false;
                        continue;
                    }
                }while(!valid);

                String[] newCustomerIds = new String[customerIds.length + 1];
                String[] newCustomerNames = new String[customerNames.length + 1];
                int[] newAccBalance = new int[accBalance.length+1];
                for (int i = 0; i < customerIds.length; i++) {
                    newCustomerIds[i] = customerIds[i];
                    newCustomerNames[i] = customerNames[i];
                    newAccBalance[i] = accBalance[i];
                }
                newCustomerIds[newCustomerIds.length - 1] = id;
                newCustomerNames[newCustomerIds.length - 1] = name;
                newAccBalance[newAccBalance.length-1] = depo;
                customerIds = newCustomerIds;
                customerNames = newCustomerNames;
                accBalance = newAccBalance;

                System.out.println();
                System.out.printf(SUCCESS_MSG, 
                String.format("%s:%s account has been created successfully", id, name));
                System.out.print("\tDo you want to continue adding (Y/n)? ");
                if (SCANNER.nextLine().strip().toUpperCase().equals("Y")) continue;
                screen = DASHBOARD;
                break;
                case DEPOSIT_MONEY:
                case WITHDRAW_MONEY:
                case TRANFER_MONEY:
                case CHECK_BALANCE:
                case DROP_ACCOUNT:
                default:
                    System.exit(0);

            }


        }while(true);



    }
}