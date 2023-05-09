
package bankingapplication3;

import java.util.Random;
import java.util.Scanner;

public class BankingApplication3 {

  
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int option = 0, number;
        String name;
        double balance,amount;
        Account account;
        Bank bank = new Bank("SCB");
        
        while(option != 6){
            System.out.println("Main menu");
            System.out.println("1. Display All Accounts");
            System.out.println("2. Open New Account");
            System.out.println("3. Close Existing Account");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.println();
            
            System.out.print("Enter your choice: ");
            option = scan.nextInt();   
            scan.nextLine();
            System.out.println();
            
            switch(option){
                case 1:
                    bank.listAccounts();
                    break;
                case 2: 
                    number = generateAccountNumber();
                    System.out.print("Enter Account Name: ");
                    name = scan.nextLine();
                    scan.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    balance = scan.nextDouble();
                    scan.nextLine();
                    account = new Account(number,name,balance);
                    bank.openAccount(account);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    number = scan.nextInt();
                    bank.closeAccount(number);
                    System.out.println("Account is deleted !");
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    number = scan.nextInt();
                    account = bank.getAccount(number);
                    scan.nextLine();
                    System.out.print("Enter amount of deposit: ");
                    amount = scan.nextDouble();
                    bank.depositMoney(account, amount);
                    break;
                case 5: 
                    System.out.println("Enter Account Number: ");
                    number = scan.nextInt();
                    account = bank.getAccount(number);
                    System.out.println("Enter Amount: ");
                    amount = scan.nextDouble();
                    bank.depositMoney(account, amount);
                    break;
            }       
        }
    }
    
    public static int generateAccountNumber(){
        Random random = new Random();
        int accNumber = 100000 + random.nextInt(900000);
        return accNumber;
    }
    
}
