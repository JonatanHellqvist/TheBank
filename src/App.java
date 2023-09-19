import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Bank");
        double balance = 0;
        double money = 0;
        boolean run = true;
        int menuOption = 0;
        

            while (run) {
                System.out.println("\nPlease select one of the alternatives:\n\n" +  
                    "1 - Saldo \n" + 
                    "2 - Deposit\n" + 
                    "3 - Withdraw\n" + 
                    "4 - Exit");
                if (input.hasNextInt()) {
                        menuOption = input.nextInt();
                } else {
                    WrongInput.menu(input);
                    continue;
                    
                }
                    switch (menuOption){
                        case 1:
                            accountBalance(balance);
                            break;
                        case 2:
                            System.out.println("Enter the ammount you wish to deposit: ");
                            if (input.hasNextDouble()) {
                                money = input.nextDouble();
                                balance = deposit(money, balance);
                                break;
                            }  else {
                                WrongInput.deposit(input);
                                break;
                            }
                        case 3:
                            System.out.println("Enter the ammount you wish to withdraw: ");
                            if (input.hasNextDouble()) {
                                money = input.nextDouble();
                                 if (money > balance) {
                                    System.out.println("\nInnsufficient funds to do that transfer, please try again.");
                                    break;
                                } else {
                                    balance = withdraw(money, balance);
                                    break;
                                }
                            } else {
                                WrongInput.withdraw(input);
                                break;
                            }
                               
                        case 4:
                            run = exit(run);
                            
                            

                        /*default: {
                            System.out.println("Wrong input!");
                            input.next();
                            break;
                        }*/
                    
                    }         

            }input.close();  
        /* Skapa en meny med 4 val

        1 - Se saldo
        * Se hur mycket pengar som finns på kontot

        2 - Sätt in pengar
        * Fråga hur mycket pengar som ska sättas in

        3 - Ta ut pengar
        * Fråga hur mycket pengar som ska tas ut.
        
        - inte låta saldot bli mindre än 0, isf skriv ut att det inte finns tillräckligt med pengar.

        4 - Avsluta
        *Avsluta programmet
        */ 


        //Hantera felaktiga val i menyn med en varning och visa menyn igen.

        //Egna klasser för alla val i menyn

        //DRY (Don't repeat yourself) ska användas i koden på ett bra sätt.





    }
    //fixa class för account grejor
    
    public static void accountBalance(double bankBalance) {
        System.out.println("\nYour current balance is: " + bankBalance);
        
    }
    //fixa in hela deposit i en metod om det går
    public static double deposit(double bankMoney,double bankBalance) {
        bankBalance = bankMoney+bankBalance;
        return(bankBalance);
    }
    //fixa in hela withdraw i en metod om det går
    public static double withdraw(double bankMoney,double bankBalance) {
        bankBalance = bankBalance - bankMoney;
        return(bankBalance);
    }
    public static boolean exit(boolean run) {
        System.out.println("Exiting the bank. Welcome back!");
        return (false); 
    }

    public class WrongInput {
    
        public static void menu(Scanner input){
            System.out.println("Wrong input! Please enter a number 1-4");
            input.next();
        }
        public static void deposit(Scanner input){
            System.out.println("Wrong input! Please enter the ammount of money you would like to deposit");
            input.next();
        }
        public static void withdraw(Scanner input){
            System.out.println("Wrong input! Please enter the ammount of money you would like to withdraw");
            input.next();
        }
    }
    

}
