package uclub;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;


public class itemManage
{
    // input scanner
    Scanner reader = new Scanner(System.in);
    
    // 2D arrays set up to gather the data from a file
    String[][] furniture = new String[4][5];
    String[][] kitchen = new String[4][5];
    String[][] outdoor = new String[4][5];
    
    // Item categories
    Item furnitureItems[] = new Item[5];
    Item rugItems[] = new Item[5];
    Item decorItems[] = new Item[5];
    Item bedBathItems[] = new Item[5];
    Item homeImproveItems[] = new Item[5];
    Item kitchenItems[] = new Item[5];
    Item outdoorItems[] = new Item[5];
    
    Item fullCatalog[] = new Item[35];
    
    ArrayList<Item> currentCart = new ArrayList<>();
    
    public void readFile() throws Exception
    {                
        int furnCounter = 0;
        int kitchCounter = 0;
        int outdCounter = 0;
        
        File file = new File("C:\\Users\\xanke\\Desktop\\oop_projects\\uclub\\src\\uclub\\file.txt");
        Scanner inventory = new Scanner(file);
        String line;
        
        while(inventory.hasNextLine())
        {
            line = inventory.nextLine();
            
            String tmp[] = line.split(","); // splits up the contents of each row
            
            if (tmp[0].equals("furn"))
            {
                inventory.useDelimiter(",");
                
                furniture[0][furnCounter] = tmp[1]; // id
                furniture[1][furnCounter] = tmp[2]; // quantity
                furniture[2][furnCounter] = tmp[3]; // price
                furniture[3][furnCounter] = tmp[4]; // name
                
                furnCounter++;                
                // fill in 2D array step by step 
            }
            
            else if (tmp[0].equals("kitch"))
            {                
                inventory.useDelimiter(",");
                
                kitchen[0][kitchCounter] = tmp[1]; // id
                kitchen[1][kitchCounter] = tmp[2]; // quantity
                kitchen[2][kitchCounter] = tmp[3]; // price
                kitchen[3][kitchCounter] = tmp[4]; // name
                
                kitchCounter++;               
                // fill in 2D array
            }
            
            else if (tmp[0].equals("outd"))
            {
                inventory.useDelimiter(",");
                
                outdoor[0][outdCounter] = tmp[1]; // id
                outdoor[1][outdCounter] = tmp[2]; // quantity
                outdoor[2][outdCounter] = tmp[3]; // price
                outdoor[3][outdCounter] = tmp[4]; // name
                
                outdCounter++;
                // fill in 2D array                
            }       
        }
    }
    
    public void saveFile()
    {
        
    }
    
    public void sendToDatabase()
    {
        //  parses data from 2D arrays then sends it to be an Item
        for (int i = 0; i < 5; i++)
        {
            int id = Integer.parseInt(furniture[0][i]);
            int quantity = Integer.parseInt(furniture[1][i]);
            double price = Double.parseDouble(furniture[2][i]);
            String name = furniture[3][i];
            furnitureItems[i] = new Item(id, quantity, price, name);
            
            fullCatalog[i] = furnitureItems[i];
        }
        for (int i = 0; i < 5; i++)
        {
            int id = Integer.parseInt(kitchen[0][i]);
            int quantity = Integer.parseInt(kitchen[1][i]);
            double price = Double.parseDouble(kitchen[2][i]);
            String name = kitchen[3][i];
            kitchenItems[i] = new Item(id, quantity, price, name);
            
            fullCatalog[i + 5] = kitchenItems[i]; 
        }
        for (int i = 0; i < 5; i++)
        {
            int id = Integer.parseInt(outdoor[0][i]);
            int quantity = Integer.parseInt(outdoor[1][i]);
            double price = Double.parseDouble(outdoor[2][i]);
            String name = outdoor[3][i];
            outdoorItems[i] = new Item(id, quantity, price, name);
            
            fullCatalog[i + 10] = outdoorItems[i];
        }
        
    }
    
    public void displayAll()
    {
        // currently just displays the 2D arrays in their natural form
        System.out.println(Arrays.deepToString(furniture));
        System.out.println("\n");
        System.out.println(Arrays.deepToString(kitchen));        
        System.out.println("\n");        
        System.out.println(Arrays.deepToString(outdoor));
    }
    
    public void displayCategory()
    {
        int menuSelect = 0;
        
        System.out.println("\n--------------------------------");
        System.out.println("Please select a category: ");
        System.out.println("Press 1 to list Furniture\n" +
                           "Press 2 to list Rugs\n" +
                           "Press 3 to list Decor\n" +
                           "Press 4 to list Bed & Bath\n" +
                           "Press 5 to list Home Improvement\n" +
                           "Press 6 to list Kitchen\n" +
                           "Press 7 to list Outdoor" +
                           "\nPress 0 to recall this menu.");
        System.out.println("--------------------------------");
        System.out.print("Your Selection: ");
        menuSelect = reader.nextInt();
        
        if (menuSelect == 1)
        {
            System.out.println("--------------------------------");
            System.out.println("Items: Furniture Category");
            System.out.println("ID   " + "Amnt   " + "Price   " + "Name");
            for (int i = 0; i < 5; i++)
            {
                furnitureItems[i].display();
            }
        }
        if (menuSelect == 2)
        {
            System.out.println("--------------------------------");
            System.out.println("Items: Kitchen Category");
            System.out.println("ID   " + "Amnt   " + "Price   " + "Name");
            for (int i = 0; i < 5; i++)
            {
                kitchenItems[i].display();
            }
        }
        if (menuSelect == 3)
        {
            System.out.println("--------------------------------");
            System.out.println("Items: Outdoors Category");
            System.out.println("ID   " + "Amnt   " + "Price   " + "Name");
            for (int i = 0; i < 5; i++)
            {
                outdoorItems[i].display();
            }
            initiateCart();
        }
        if (menuSelect == 0)
        {
            displayCategory();
        }
    }
    
    public void checkout()
    {
        
    }
    
    // function that will subtract from the available inventory
    private void initiateCart()
    {
        String inputIDs;
        String inputAmnts;
        
        ArrayList<String> arrID = new ArrayList<>();
        ArrayList<String> arrQ = new ArrayList<>();
        
        // get input
        do{
            if (arrID.size() > arrQ.size()){System.out.println("Not enough respective Quantity values.");}
            if (arrID.size() < arrQ.size()){System.out.println("Not enough ID values to match Quantity values.");}
            
            System.out.print("Enter IDs (seperated by commas): ");
            inputIDs = reader.nextLine();        
            System.out.print("Enter Respective Quantities (seperated by commas): ");
            inputAmnts = reader.nextLine();
            
            arrID = new ArrayList<>(Arrays.asList(inputIDs.split(",")));
            arrQ = new ArrayList<>(Arrays.asList(inputAmnts.split(",")));
            
        }while (arrID.size() != arrQ.size());
        
        // once all IDs for the current category have been establish, pass them into the cart
        cart(outdoorItems, arrID);
        
        int i = 0;
        int j = 0;
        ArrayList<Double> price = new ArrayList<>();
        
        while (i < arrID.size())
        {
            if (Integer.parseInt(arrID.get(i)) == fullCatalog[j].getId())
            {
                price.set(i, fullCatalog[j].getPrice());
                i = i + 1;
            }            
            else {j = j + 1;}            
        }
        // pass in price which contains number of items due to containing the prices for each ID
        calculateTotal(price);
    }
    
    private void calculateTotal(ArrayList<Double> price)
    {
        int numOfItems = price.size();
        
    }
    
    // option to remove an item from the cart which will add to the available inventory
    private void removeFromCart()
    {
        
    }
    
    public void cart(Item[] categoryList, ArrayList<String> IDs)
    {
        System.out.println("--------------------------------");
        System.out.println("Your Current Cart for Checkout");
        System.out.println("ID   " + "Amnt   " + "Price   " + "Name");
        for (int i = 0; i < 5; i++)
        {
            if (categoryList
        }
        
        
        
    }
}
