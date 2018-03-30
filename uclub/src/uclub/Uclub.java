
package uclub;

//import java.io.BufferedReader;
//import java.io.FileReader;

import java.util.Scanner;

import java.util.*;
import java.io.*;

public class Uclub
{
    public static void main(String[] args) throws Exception
    {
        itemManage myItem = new itemManage();
        
        myItem.readFile();
        myItem.sendToDatabase();
        
        Scanner reader = new Scanner(System.in);
        int userSelect = 0;
        
        displayMenu();
        
        do
        {
            userSelect = reader.nextInt();
            userChoice(userSelect, myItem);
            
        }while (userSelect != 0);
        
        
    }
    
    public static void displayMenu()
    {
        System.out.println("--------------------------------");
        System.out.println("Welcome to the shopping menu.\n");
        System.out.println("Press 1: Browse full inventory.");
        System.out.println("Press 2: Browse by category.");
        System.out.println("Press 3: View your shopping cart");
        System.out.println("Press 0 to exit.");
        System.out.println("--------------------------------");
        System.out.print("Your Selection: ");
    }
    
    public static void userChoice(int select, itemManage myItem) throws Exception
    {
        switch(select)
        {
            case 1: myItem.displayAll();
            break;
            case 2: myItem.displayCategory();
            break;
            case 0: System.out.println("\nHave a nice day!");
            break;
        }
    }
}
  
