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
                    Account.accountBalance(balance);
                    break;
                case 2:
                    balance = Account.deposit(input, balance);
                    break;
                case 3:
                    balance = Account.withdraw(input, balance);
                    break;
                case 4:
                    run = exit(run);
            }         
        }input.close();  
    }

    public class Menu {

        public static int menuOption(Scanner input) {
           System.out.println("\nPlease select one of the alternatives:\n\n" +  
                "1 - Saldo \n" + 
                "2 - Deposit\n" + 
                "3 - Withdraw\n" + 
                "4 - Exit");
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
    }
    public class Account {
        
        public static void accountBalance(double bankBalance) {
            System.out.println("\nYour current balance is: " + bankBalance);
        }
        public static double deposit(Scanner input, double balance) {
            System.out.println("Enter the ammount you wish to deposit: ");
            if (input.hasNextDouble()) {
                double money = input.nextDouble();
                if (money > 0){
                    balance = depositTransfer(money, balance);
                }else {
                    WrongInput.depositMinus(input);
                }
            } else {
                WrongInput.deposit(input);
            }
            return balance;
        }
        public static double withdraw(Scanner input, double balance) {
            System.out.println("Enter the ammount you wish to withdraw: ");
            if (input.hasNextDouble()) {
                double bankMoney = input.nextDouble();
                if (bankMoney > balance) {
                    System.out.println("\nInnsufficient funds to do that transfer, please try again.");
                } else if (bankMoney > 0){
                    balance = withdrawTransfer(bankMoney, balance);
                } else {
                    WrongInput.withdrawMinus(input);
                }
            } else {
                WrongInput.withdraw(input);
            }
            return balance;
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
            System.out.println("Wrong input! Please enter a number 1-4");
            input.nextLine();
        }

        public static void deposit(Scanner input){
            System.out.println("Wrong input! Please enter the ammount of money you would like to deposit");
            input.next();
        }

        public static void withdraw(Scanner input){
            System.out.println("Wrong input! Please enter the ammount of money you would like to withdraw");
            input.next();
        }
        public static void depositMinus (Scanner input) {
            System.out.println("Wrong input! Please enter a positive number to deposit");
            input.nextLine();
        }
        public static void withdrawMinus (Scanner input) {
            System.out.println("Wrong input! Please enter a positive number to withdraw");
            input.nextLine();
        }
    }

    public static boolean exit(boolean run) {
        System.out.println("Exiting the bank. Welcome back!");
        return (false); 
    }
    

}
