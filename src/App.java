import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Bank");
        double balance = 0;
        boolean run = true;
        int menuChoice = 0;
        
        while (run) {
                
            menuChoice = Menu.menuOption(input);
            
            switch (menuChoice){
                case 1:
                    Bank.currentBalance(input,balance);
                    break;
                case 2:
                    balance = Bank.deposit(input, balance);
                    break;
                case 3:
                    balance = Bank.withdraw(input, balance);
                    break;
                case 4:
                    run = Menu.exit(run);
            }         
        }input.close();  
    }

    public class Menu {

        public static int menuOption(Scanner input) {
           System.out.println("\nPlease select one of the alternatives:\n\n" +  
                "1 - Saldo \n" + 
                "2 - Deposit \n" + 
                "3 - Withdraw \n" + 
                "4 - Exit ");
            int menuChoice = 0;
            if (input.hasNextInt()) {
                menuChoice = input.nextInt();
                if (menuChoice <= 0 || menuChoice > 4) {
                    WrongInput.menu(input);
                } 
            } else {
                WrongInput.menu(input);
            }
            return menuChoice;
        }

        public static boolean exit(boolean run) {
            System.out.println("Exiting the bank. Welcome back!");
            return (false);
        }
    }

    public class Bank {
    
        public static void currentBalance(Scanner input,double bankBalance) {
            System.out.println("\nYour current balance is: " + bankBalance);
            input.nextLine();
        }

        public static double deposit(Scanner input, double bankBalance) {
            System.out.println("Enter the ammount you wish to deposit: ");
            if (input.hasNextDouble()) {
                double bankMoney = input.nextDouble();
                if (bankMoney > 0) {
                    bankBalance = depositTransfer(bankMoney, bankBalance);
                }else {
                    WrongInput.depositMinus(input);
                }
            } else {
                WrongInput.deposit(input);
            }
            return bankBalance;
        }

        public static double withdraw(Scanner input, double bankBalance) {
            System.out.println("Enter the ammount you wish to withdraw: ");
            if (input.hasNextDouble()) {
                double bankMoney = input.nextDouble();
                if (bankMoney > bankBalance) {
                    System.out.println("\nInnsufficient funds to do that transfer, please try again.");
                } else if (bankMoney > 0) {
                    bankBalance = withdrawTransfer(bankMoney, bankBalance);
                } else {
                    WrongInput.withdrawMinus(input);
                }
            } else {
                WrongInput.withdraw(input);
            }
            return bankBalance;
        }

        public static double depositTransfer(double bankMoney,double bankBalance) {
            bankBalance = bankMoney+bankBalance;
            return(bankBalance);
        }

        public static double withdrawTransfer(double bankMoney,double bankBalance) {
            bankBalance = bankBalance - bankMoney;
            return(bankBalance);
        }
    }

    public class WrongInput {

        public static void menu(Scanner input){
            System.out.println("Invalid characters! Please enter a number 1-4");
            input.nextLine();
        }
        public static void deposit(Scanner input){
            System.out.println("Invalid characters! Please enter the ammount you would like to deposit");
            input.next();
        }
        public static void withdraw(Scanner input){
            System.out.println("Invalid characters! Please enter the ammount you would like to withdraw");
            input.next();
        }
        public static void depositMinus (Scanner input) {
            System.out.println("Error! Please enter a positive number to deposit");
            input.nextLine();
        }
        public static void withdrawMinus (Scanner input) {
            System.out.println("Error! Please enter a positive number to withdraw");
            input.nextLine();
        }
    }
}
