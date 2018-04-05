// Team Members: Jonathan Stewart & Jake Manning

// main file
package uclub;

import java.util.Scanner;

public class Uclub
{
    public static void main(String[] args) throws Exception
    {
        // object to access the program
        itemManage myItem = new itemManage();
        userManage user = new userManage();
        
        // Handle User control
        while(user.loggedIn == false)
        {
            user.userLogin(user);
        }
        
        
        myItem.readFile();
        myItem.sendToDatabase();
        
        Scanner reader = new Scanner(System.in);
        int userSelect = 0;
        
        displayMenu(user);
        
        do
        {
            userSelect = reader.nextInt();
            userChoice(userSelect, myItem, user);
            displayMenu(user);
            
        }while (userSelect != 0);
        
        reader.close();
    }
    
    // displays the initial menu
    public static void displayMenu(userManage saveUser)
    {
        if(saveUser.userPriv == 2)
        {
            System.out.println("--------------------------------");
            System.out.println("Welcome to the shopping menu.\n");
            System.out.println("Press 1: Browse by category.");
            System.out.println("Press 2: View your shopping cart");
            System.out.println("Press 3: Admin History Log");
            System.out.println("Press 0 to exit.");
            System.out.println("--------------------------------");
            System.out.print("Your Selection: ");
        }
        else if(saveUser.userPriv == 0)
        {
            System.out.println("--------------------------------");
            System.out.println("Welcome to the shopping menu.\n");
            System.out.println("Press 1: Browse by category.");
            System.out.println("Press 2: View your shopping cart");
            System.out.println("Press 3: Purchase uClub Membership");
            System.out.println("Press 0 to exit.");
            System.out.println("--------------------------------");
            System.out.print("Your Selection: ");
        }
        else
        {
            System.out.println("--------------------------------");
            System.out.println("Welcome to the shopping menu.\n");
            System.out.println("Press 1: Browse by category.");
            System.out.println("Press 2: View your shopping cart");
            System.out.println("Press 0 to exit.");
            System.out.println("--------------------------------");
            System.out.print("Your Selection: ");
        }
    }
    
    // function to get the user's choice 
    public static void userChoice(int select, itemManage myItem, userManage saveUser) throws Exception
    {
        if(saveUser.userPriv == 2)
        {
            switch(select)
            {
                case 1: myItem.displayCategory(saveUser);
                break;
                case 2: myItem.printCart(saveUser);
                break;
                case 3: myItem.readHistory();
                break;
                case 0: System.out.println("\nHave a nice day!");
                break;
            }
        }
        if(saveUser.userPriv == 0)
        {
            switch(select)
            {
                case 1: myItem.displayCategory(saveUser);
                break;
                case 2: myItem.printCart(saveUser);
                break;
                case 3: myItem.buyMembership(saveUser);
                break;
                case 0: System.out.println("\nHave a nice day!");
                break;
            }
        }
        else
        {
            switch(select)
            {
                case 1: myItem.displayCategory(saveUser);
                break;
                case 2: myItem.printCart(saveUser);
                break;
                case 0: System.out.println("\nHave a nice day!");
                break;
            }
        }
        
    }
}
  
