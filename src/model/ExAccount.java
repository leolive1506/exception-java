package model;

import java.util.Scanner;

import model.entities.Account;

public class ExAccount {
  public static void main() {
    try {
      Scanner sc = new Scanner(System.in);
      System.out.print("Number: ");
      int number = sc.nextInt();
      System.out.print("Holder: ");    
      sc.nextLine();
      String holder = sc.nextLine();
      System.out.print("Initial balance: ");    
      double balance = sc.nextDouble();
      System.out.print("Withdraw limit: ");    
      double withdrawLimit = sc.nextDouble();
  
      Account account = new Account(number, holder, balance, withdrawLimit);
  
      System.out.println();
      System.out.print("Enter amount for withdraw: ");
      double withdraw = sc.nextDouble();
      account.withdraw(withdraw);
      System.out.print("New balance: " + String.format("%.2f", account.getBalance()));
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }
  }
}
