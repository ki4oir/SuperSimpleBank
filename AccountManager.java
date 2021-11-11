
package account;

import java.util.Scanner;

/*
 * The purpose of this program is to replicate an Online Banking Application
 * The code below shows how the interal operation works.
 * The main menu is displayed to the customer,
 * the customer is asked if they would like to view balances,
 * transfer money between accounts, and lastly to view the available 
 * transaction history.  If there is no history, the output should all be 'null'.
 */
public class AccountManager { //main class start
    public static void main(String[] args) { //main method start
        
       //declare and initialize two Account objects 
       //Normally would use an account database in an enterprise -
       //but for this purpose the objects are hard coded here.
       Account account1 = new Account("Savings", 50.00);
       Account account2 = new Account("Checking", 50.00);
       
       //declare and initialize counter for transaction history - 
       //variable for numbering the location of the next object in transaction history 
       int counter = 0;
	   
       //declare and initialize a string array for transaction history
       //Normally this would be another database object -
       //but for this purpose a String array object is used here
       String[] transactHistory = new String[10];
       
       //new Scanner input object for managing user input
        Scanner input = new Scanner(System.in);
        
        //user greeting
        System.out.println("Welcome to Super Simple Bank App Online!");
        
        // variable for storing the user selection in the menu
        int choice;
        
        do //run the continuous user menu
        {
            System.out.println("Main Menu");
            System.out.println("Please make a selection from the following choices:");
            System.out.println("\n 1. Check Balances\n 2. Transfer Money\n 3. View Transactions\n");
            System.out.println("Press 5 to exit the system");
            System.out.println("For Customer Service please call: \n1-800-125-7535");
            
            //function for user menu selection
            choice = input.nextInt();
            
            //user menu options
            switch (choice) {
                //display balance option
                case 1:
                    // display initial balance of each object
                    System.out.printf("%s balance: $%.2f%n",
                           account1.getName(), account1.getBalance()); 
                    System.out.printf("%s balance: $%.2f%n%n",
                           account2.getName(), account2.getBalance()); 
                    break; // exit this case
            
                //transfer money options
                case 2:
                    //make account selection to take money from
                    System.out.println("Enter transfer source:");
                    System.out.println("Enter 1 for Savings");
                    System.out.println("Enter 2 for Checking");
                    //make selection
                    int accntChoice = input.nextInt();

                    //Transfer to Checking
                    if (accntChoice == 1) {
                        System.out.println("Enter amount to transfer:");
                        // obtain user input
                        double depositAmount = input.nextDouble();
                        //notification
                        System.out.printf("%nTransferring %.2f to Checking balance%n%n", 
                            depositAmount);
                        account2.deposit(depositAmount); // add to account2 balance
                        account1.transfer(depositAmount);// subtract from account1 balance
                        //store this transaction
                        String transactHist01 = String.format("%nTransferred %.2f to Checking balance", 
                                depositAmount);
                        transactHistory[counter] = transactHist01; // store transaction into array
                        counter++; //increment transactHistory array counter 
                        
                    
                    }
                    else {//Transfer to Savings
                        System.out.println("Enter amount to transfer:");
                        // obtain user input
                        double depositAmount = input.nextDouble();
                        //notification
                        System.out.printf("%nTransferring %.2f to Savings balance%n%n", 
                            depositAmount);
                        account1.deposit(depositAmount); // add to account2 balance
                        account2.transfer(depositAmount);// subtract from account1 balance
                        //store this transaction
                        String transactHist02 = String.format("%nTransferred %.2f to Savings balance", 
                                depositAmount);
                        transactHistory[counter] = transactHist02; // store transaction into array
                        counter++; //increment transactHistory array counter
                        
                    }
                    
                          // display balances
                    System.out.printf("%s balance: $%.2f%n", 
                        account1.getName(), account1.getBalance()); 
                    System.out.printf("%s balance: $%.2f%n%n",
                        account2.getName(), account2.getBalance());
                    break; // exit this case
                    
                case 3:
                    //display transaction history
                    System.out.println("\nDisplay Transaction History:");
                                        
                    //for loop to iterate over the transaction history array
                    //enhanced for loop can be used here - not used on purpose.
                    for(int i=0; i<transactHistory.length; i++)
                        System.out.println(transactHistory[i] + " ");
                  
                    break; // exit this case
                        

                default:
                    System.exit(0); // exit the program cleanly
            }
        }
        while (choice != 5); //stop the user menu
            
            
    }// end main method
}// end main class
