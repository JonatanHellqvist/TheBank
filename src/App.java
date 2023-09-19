import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        //Double saldo = 0.0;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Bank");
        double balance = 0;
        double money = 0;
        boolean run = true;
        int menuOption = 0;
        //int menuOption

            while (run) {
                System.out.println("\nPlease select one of the alternatives:\n\n" +  
                    "1 - Saldo \n" + 
                    "2 - Deposit\n" + 
                    "3 - Withdraw\n" + 
                    "4 - Exit");
                
                if (input.hasNextInt()) {
                        menuOption = input.nextInt();
                } else {
                    System.out.println(wrongInput());
                    input.next();
                }
                    switch (menuOption){
                        case 1:
                        System.out.println("\nYour current balance is: " + balance);
                            break;
                        case 2:
                            System.out.println("Enter the ammount you wish to deposit: ");
                            if (input.hasNextDouble()) {
                                money = input.nextDouble();
                                balance = deposit(money, balance);
                                break;
                            } else {
                                System.out.println(wrongInput());
                                input.next();
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
                                System.out.println(wrongInput());
                                input.next();
                                break;
                            }
                               
                        case 4:
                            System.out.println("Exit. Welcome back!");
                            run = exit(run);
                            
                            

                        /*default: {
                            System.out.println("Wrong input!");
                            input.nextLine();
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

    public static double Saldo(double bankBalance) {
        return(bankBalance);
    }
    public static double deposit(double bankMoney,double bankBalance) {
        bankBalance = bankMoney+bankBalance;
        return(bankBalance);
    }
    public static double withdraw(double bankMoney,double bankBalance) {
        bankBalance = bankBalance - bankMoney;
        return(bankBalance);
    }
    public static boolean exit(boolean run) {
        return(false); 
    }
    public static String wrongInput(){
        String s = ("Wrong input! Try again.");
        return (s);

    }



}