
// class that handles all the main functionality of the program
package uclub;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class itemManage
{
    // input scanner
    Scanner reader = new Scanner(System.in);

    // 2D arrays set up to gather the data from a file
    String[][] furniture = new String[4][5];
    String[][] rugs = new String[4][5];
    String[][] decor = new String[4][5];
    String[][] bedAndBath = new String[4][5];
    String[][] homeImprovement = new String[4][5];
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

    //Item tempArray[] = new Item[5];

    // array to store full item catalog
    Item fullCatalog[] = new Item[35];

    ArrayList<Item> currentCart = new ArrayList<>();
    
    userManage user = new userManage();

    // function that reads the file that has the inventory
    public void readFile() throws Exception
    {
        int furnCounter = 0;
        int rugCounter = 0;
        int decCounter = 0;
        int bnbCounter = 0;
        int homeCounter = 0;
        int kitchCounter = 0;
        int outdCounter = 0;

        File file = new File("file.txt");
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

            else if (tmp[0].equals("rugs"))
            {
                inventory.useDelimiter(",");

                rugs[0][rugCounter] = tmp[1]; // id
                rugs[1][rugCounter] = tmp[2]; // quantity
                rugs[2][rugCounter] = tmp[3]; // price
                rugs[3][rugCounter] = tmp[4]; // name

                rugCounter++;
                // fill in 2D array
            }

            else if (tmp[0].equals("decor"))
            {
                inventory.useDelimiter(",");

                decor[0][decCounter] = tmp[1]; // id
                decor[1][decCounter] = tmp[2]; // quantity
                decor[2][decCounter] = tmp[3]; // price
                decor[3][decCounter] = tmp[4]; // name

                decCounter++;
                // fill in 2D array
            }

            else if (tmp[0].equals("bedBath"))
            {
                inventory.useDelimiter(",");

                bedAndBath[0][bnbCounter] = tmp[1]; // id
                bedAndBath[1][bnbCounter] = tmp[2]; // quantity
                bedAndBath[2][bnbCounter] = tmp[3]; // price
                bedAndBath[3][bnbCounter] = tmp[4]; // name

                bnbCounter++;
                // fill in 2D array
            }

            else if (tmp[0].equals("homeImprove"))
            {
                inventory.useDelimiter(",");

                homeImprovement[0][homeCounter] = tmp[1]; // id
                homeImprovement[1][homeCounter] = tmp[2]; // quantity
                homeImprovement[2][homeCounter] = tmp[3]; // price
                homeImprovement[3][homeCounter] = tmp[4]; // name

                homeCounter++;
                // fill in 2D array
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

    // function to update the quantity of items available in the store
    public void saveFile() throws IOException
    {
        // format is: delimiter, ID, Quantity, Price, Name
        // Open the file.txt BufferedWriter out = new BufferedWriter(new FileWriter(file));
        // Check if that line is the line that needs to be written
        // We read the ID of the item that has been bought and go to that line since they are in order
        // within that line we know exactly where the quantity is so we edit the quantity according to how much we bought
        try (BufferedWriter out = new BufferedWriter(new FileWriter("file.txt"))) {


        // Furn Category
        for(int i = 0; i < 5; i++)
        {
          out.write("furn," + furnitureItems[i].getId() + "," + furnitureItems[i].getQuantity() + "," + furnitureItems[i].getPrice() + "," + furnitureItems[i].getName());
          out.newLine();
        }

        // Rugs Category
        for(int i = 0; i < 5; i++)
        {
          out.write("rugs," + rugItems[i].getId() + "," + rugItems[i].getQuantity() + "," + rugItems[i].getPrice() + "," + rugItems[i].getName());
          out.newLine();
        }

        // Decor Category
        for(int i = 0; i < 5; i++)
        {
          out.write("decor," + decorItems[i].getId() + "," + decorItems[i].getQuantity() + "," + decorItems[i].getPrice() + "," + decorItems[i].getName());
          out.newLine();
        }

        // BedBath Category
        for(int i = 0; i < 5; i++)
        {
          out.write("bedBath," + bedBathItems[i].getId() + "," + bedBathItems[i].getQuantity() + "," + bedBathItems[i].getPrice() + "," + bedBathItems[i].getName());
          out.newLine();
        }

        // HomeImprove Category
        for(int i = 0; i < 5; i++)
        {
          out.write("homeImprove," + homeImproveItems[i].getId() + "," + homeImproveItems[i].getQuantity() + "," + homeImproveItems[i].getPrice() + "," + homeImproveItems[i].getName());
          out.newLine();
        }

        // Kitch Category
        for(int i = 0; i < 5; i++)
        {
          out.write("kitch," + kitchenItems[i].getId() + "," + kitchenItems[i].getQuantity() + "," + kitchenItems[i].getPrice() + "," + kitchenItems[i].getName());
          out.newLine();
        }

        // Outd Category
        for(int i = 0; i < 5; i++)
        {
          out.write("outd," + outdoorItems[i].getId() + "," + outdoorItems[i].getQuantity() + "," + outdoorItems[i].getPrice() + "," + outdoorItems[i].getName());
          out.newLine();
        }

        } catch (IOException e){
                e.printStackTrace();
        }
    }
    
    // function used to store data in the full catalog
    public void sendToDatabase()
    {
        //  parses data from 2D arrays then sends it to be an Item
        // furniture
        for (int i = 0; i < 5; i++)
        {
            int id = Integer.parseInt(furniture[0][i]);
            int quantity = Integer.parseInt(furniture[1][i]);
            double price = Double.parseDouble(furniture[2][i]);
            String name = furniture[3][i];
            furnitureItems[i] = new Item(id, quantity, price, name);

            fullCatalog[i] = furnitureItems[i];
        }
        // rugs
        for (int i = 0; i < 5; i++)
        {
            int id = Integer.parseInt(rugs[0][i]);
            int quantity = Integer.parseInt(rugs[1][i]);
            double price = Double.parseDouble(rugs[2][i]);
            String name = rugs[3][i];
            rugItems[i] = new Item(id, quantity, price, name);

            fullCatalog[i + 5] = rugItems[i];
        }
        // decor
        for (int i = 0; i < 5; i++)
        {
            int id = Integer.parseInt(decor[0][i]);
            int quantity = Integer.parseInt(decor[1][i]);
            double price = Double.parseDouble(decor[2][i]);
            String name = decor[3][i];
            decorItems[i] = new Item(id, quantity, price, name);

            fullCatalog[i + 10] = decorItems[i];
        }
        // bed and bath
        for (int i = 0; i < 5; i++)
        {
            int id = Integer.parseInt(bedAndBath[0][i]);
            int quantity = Integer.parseInt(bedAndBath[1][i]);
            double price = Double.parseDouble(bedAndBath[2][i]);
            String name = bedAndBath[3][i];
            bedBathItems[i] = new Item(id, quantity, price, name);

            fullCatalog[i + 15] = bedBathItems[i];
        }
        // home improvement
        for (int i = 0; i < 5; i++)
        {
            int id = Integer.parseInt(homeImprovement[0][i]);
            int quantity = Integer.parseInt(homeImprovement[1][i]);
            double price = Double.parseDouble(homeImprovement[2][i]);
            String name = homeImprovement[3][i];
            homeImproveItems[i] = new Item(id, quantity, price, name);

            fullCatalog[i + 20] = homeImproveItems[i];
        }
        // kitchen
        for (int i = 0; i < 5; i++)
        {
            int id = Integer.parseInt(kitchen[0][i]);
            int quantity = Integer.parseInt(kitchen[1][i]);
            double price = Double.parseDouble(kitchen[2][i]);
            String name = kitchen[3][i];
            kitchenItems[i] = new Item(id, quantity, price, name);

            fullCatalog[i + 25] = kitchenItems[i];
        }
        // outdoor
        for (int i = 0; i < 5; i++)
        {
            int id = Integer.parseInt(outdoor[0][i]);
            int quantity = Integer.parseInt(outdoor[1][i]);
            double price = Double.parseDouble(outdoor[2][i]);
            String name = outdoor[3][i];
            outdoorItems[i] = new Item(id, quantity, price, name);

            fullCatalog[i + 30] = outdoorItems[i];
        }
    }
    
    // menu prompts that display each of the categories in the store
    public void displayCategory(userManage saveUser)
    {
        user = saveUser;
        int menuSelect;
        String userChoice;
        boolean userCheck;
 
        System.out.println("--------------------------------");
        System.out.println("Please select a category: ");
        System.out.println("Press 1 to list Furniture\n" +
                           "Press 2 to list Rugs\n" +
                           "Press 3 to list Decor\n" +
                           "Press 4 to list Bed & Bath\n" +
                           "Press 5 to list Home Improvement\n" +
                           "Press 6 to list Kitchen\n" +
                           "Press 7 to list Outdoor\n" +
                           "\nPress 9 to go to your cart" +
                           "\nPress 0 to return to Main Menu.");
        System.out.println("--------------------------------");
        System.out.print("Your Selection: ");
        menuSelect = reader.nextInt();
        reader.nextLine();
 
        if (menuSelect == 1)
        {
            userCheck = false;
            System.out.println("--------------------------------");
            System.out.println("Items: Furniture Category");
            System.out.println("ID   " + "Amnt   " + "Price   " + "Name");
            for (int i = 0; i < 5; i++)
            {
                furnitureItems[i].display();
            }
            System.out.println("--------------------------------");
            
            System.out.print("Purchase an Item? (Yes/No): ");
            do{
                userChoice = reader.nextLine();

                if("Yes".equals(userChoice) || "yes".equals(userChoice) || "y".equals(userChoice) || "Y".equals(userChoice))
                {
                  initiateCart(furnitureItems, furniture);
                  userCheck = true;
                }

                else if("No".equals(userChoice) || "no".equals(userChoice) || "n".equals(userChoice) || "N".equals(userChoice))
                {
                  userCheck = true;
                  System.out.println("Returning to category menu..");
                  displayCategory(user);
                }

                else
                {
                  System.out.println("Incorrect choice. Try 'Yes' or 'No'");
                }
            }while(!userCheck);
        }
        if (menuSelect == 2)
        {
            userCheck = false;
            System.out.println("--------------------------------");
            System.out.println("Items: Rug Category");
            System.out.println("ID   " + "Amnt   " + "Price   " + "Name");
            for (int i = 0; i < 5; i++)
            {
                rugItems[i].display();
            }
            System.out.println("--------------------------------");
            System.out.print("Purchase an Item? (Yes/No): ");
            do{
                userChoice = reader.nextLine();

                if("Yes".equals(userChoice) || "yes".equals(userChoice) || "y".equals(userChoice) || "Y".equals(userChoice))
                {
                  initiateCart(rugItems, rugs);
                  userCheck = true;
                }

                else if("No".equals(userChoice) || "no".equals(userChoice) || "n".equals(userChoice) || "N".equals(userChoice))
                {
                  userCheck = true;
                  System.out.println("Returning to category menu..");
                  displayCategory(user);
                }

                else
                {
                  System.out.println("Incorrect choice. Try 'Yes' or 'No'");
                }
            }while(!userCheck);
        }
        if (menuSelect == 3)
        {
            userCheck = false;
            System.out.println("--------------------------------");
            System.out.println("Items: Decor Category");
            System.out.println("ID   " + "Amnt   " + "Price   " + "Name");
            for (int i = 0; i < 5; i++)
            {
                decorItems[i].display();
            }
            System.out.println("--------------------------------");
            System.out.print("Purchase an Item? (Yes/No): ");
            do{
                userChoice = reader.nextLine();

                if("Yes".equals(userChoice) || "yes".equals(userChoice) || "y".equals(userChoice) || "Y".equals(userChoice))
                {
                  initiateCart(decorItems, decor);
                  userCheck = true;
                }

                else if("No".equals(userChoice) || "no".equals(userChoice) || "n".equals(userChoice) || "N".equals(userChoice))
                {
                  userCheck = true;
                  System.out.println("Returning to category menu..");
                  displayCategory(user);
                }

                else
                {
                  System.out.println("Incorrect choice. Try 'Yes' or 'No'");
                }
            }while(!userCheck);
        }
        if (menuSelect == 4)
        {
            userCheck = false;
            System.out.println("--------------------------------");
            System.out.println("Items: Bed & Bath Category");
            System.out.println("ID   " + "Amnt   " + "Price   " + "Name");
            for (int i = 0; i < 5; i++)
            {
                bedBathItems[i].display();
            }
            System.out.println("--------------------------------");
            System.out.print("Purchase an Item? (Yes/No): ");
            do{
                userChoice = reader.nextLine();

                if("Yes".equals(userChoice) || "yes".equals(userChoice) || "y".equals(userChoice) || "Y".equals(userChoice))
                {
                  initiateCart(bedBathItems, bedAndBath);
                  userCheck = true;
                }

                else if("No".equals(userChoice) || "no".equals(userChoice) || "n".equals(userChoice) || "N".equals(userChoice))
                {
                  userCheck = true;
                  System.out.println("Returning to category menu..");
                  displayCategory(user);
                }

                else
                {
                  System.out.println("Incorrect choice. Try 'Yes' or 'No'");
                }
            }while(!userCheck);
        }
        if (menuSelect == 5)
        {
            userCheck = false;
            System.out.println("--------------------------------");
            System.out.println("Items: Home Improvement Category");
            System.out.println("ID   " + "Amnt   " + "Price   " + "Name");
            for (int i = 0; i < 5; i++)
            {
                homeImproveItems[i].display();
            }
            System.out.println("--------------------------------");
            System.out.print("Purchase an Item? (Yes/No): ");
            do{
                userChoice = reader.nextLine();

                if("Yes".equals(userChoice) || "yes".equals(userChoice) || "y".equals(userChoice) || "Y".equals(userChoice))
                {
                  initiateCart(homeImproveItems, homeImprovement);
                  userCheck = true;
                }

                else if("No".equals(userChoice) || "no".equals(userChoice) || "n".equals(userChoice) || "N".equals(userChoice))
                {
                  userCheck = true;
                  System.out.println("Returning to category menu..");
                  displayCategory(user);
                }

                else
                {
                  System.out.println("Incorrect choice. Try 'Yes' or 'No'");
                }
            }while(!userCheck);
        }
        if (menuSelect == 6)
        {
            userCheck = false;
            System.out.println("--------------------------------");
            System.out.println("Items: Kitchen Category");
            System.out.println("ID   " + "Amnt   " + "Price   " + "Name");
            for (int i = 0; i < 5; i++)
            {
                kitchenItems[i].display();
            }
            System.out.println("--------------------------------");
            System.out.print("Purchase an Item? (Yes/No): ");
            do{
                userChoice = reader.nextLine();

                if("Yes".equals(userChoice) || "yes".equals(userChoice) || "y".equals(userChoice) || "Y".equals(userChoice))
                {
                  initiateCart(kitchenItems, kitchen);
                  userCheck = true;
                }

                else if("No".equals(userChoice) || "no".equals(userChoice) || "n".equals(userChoice) || "N".equals(userChoice))
                {
                  userCheck = true;
                  System.out.println("Returning to category menu..");
                  displayCategory(user);
                }

                else
                {
                  System.out.println("Incorrect choice. Try 'Yes' or 'No'");
                }
            }while(!userCheck);
            
        }
        if (menuSelect == 7)
        {
            userCheck = false;
            System.out.println("--------------------------------");
            System.out.println("Items: Outdoors Category");
            System.out.println("ID   " + "Amnt   " + "Price   " + "Name");
            for (int i = 0; i < 5; i++)
            {
                outdoorItems[i].display();
            }
            System.out.println("--------------------------------");
            System.out.print("Purchase an Item? (Yes/No): ");
            do{
                userChoice = reader.nextLine();

                if("Yes".equals(userChoice) || "yes".equals(userChoice) || "y".equals(userChoice) || "Y".equals(userChoice))
                {
                  initiateCart(outdoorItems, outdoor);
                  userCheck = true;
                }

                else if("No".equals(userChoice) || "no".equals(userChoice) || "n".equals(userChoice) || "N".equals(userChoice))
                {
                  userCheck = true;
                  System.out.println("Returning to category menu..");
                  displayCategory(user);
                }

                else
                {
                  System.out.println("Incorrect choice. Try 'Yes' or 'No'");
                }
            }while(!userCheck);
            
        }
        if (menuSelect == 9)
        {
            printCart(user);
        }
        if (menuSelect == 0)
        {
            emptyfunc();
        }
    }
    
    // function that is called to return to main menu
    private void emptyfunc()
    {
        System.out.println("Returning to main menu...");
    }

    // function that will establish the cart items
    private void initiateCart(Item[] category, String[][] catDat)
    {
        String inputIDs;
        String inputAmnts;
       
        boolean inputOK = false;
       
        int i = 0;
        // counter to account for all ids
        int j = 0;
 
        ArrayList<String> arrID = new ArrayList<>();
        ArrayList<String> arrQ = new ArrayList<>();
 
        // get input
        inputValidation:
        do{
            i = 0;
            System.out.print("Enter IDs (seperated by commas): ");
            inputIDs = reader.nextLine();
            //reader.nextLine();
            System.out.print("Enter Respective Quantities (seperated by commas): ");
            inputAmnts = reader.nextLine();
            //reader.nextLine();
 
            arrID = new ArrayList<>(Arrays.asList(inputIDs.split(",")));
            arrQ = new ArrayList<>(Arrays.asList(inputAmnts.split(",")));
           
            if (arrID.size() > arrQ.size())
            {
                while (arrID.size() > arrQ.size())
                {
                    System.out.println("Not enough respective Quantity values.");
                    continue inputValidation;
                }
            }
            else if (arrID.size() < arrQ.size())
            {
                while (arrID.size() < arrQ.size())
                {
                    System.out.println("Not enough ID values to match Quantity values.");
                    continue inputValidation;
                }
            }
            else
            {
                while (j != arrID.size())
                {
                    if (Integer.parseInt(arrID.get(j)) == category[i].getId())
                    {
                        //found = true;
                        int quant = category[i].getQuantity();
                        if (quant == 0)
                        {
                            System.out.println("This item is unavailable");
                            continue inputValidation;
                        }
                        else if ((quant - Integer.parseInt(arrQ.get(j))) < 0)
                        {
                            System.out.println("I'm sorry, not enough stock to meet your demand");
                            continue inputValidation;
                        }
                        j++;
                    }
                    else
                    {
                        i++;
                    }
                }
            }
            inputOK = true;
        }while (!inputOK);
 
        i = 0;
        // counter to account for all ids
        j = 0;
        // counter to see if there's an empty spot
        int p = 0;        
       
        while (j != arrID.size())
        {
            //if ArrayList.get(p) == empty, fill that position up
            try {
                currentCart.get(p);
            }
            catch (IndexOutOfBoundsException e)
            {
                boolean didWeFindIt = false;
                while (didWeFindIt != true)
                {
                    if (Integer.parseInt(arrID.get(j)) == category[i].getId())
                    {
                        // get initial quantity
                        int quant = category[i].getQuantity();
                       
                        // these overwrite the items that are initially set in the category arrays (quantity is the only change that happens though)
                        category[i].setQuantity(Integer.parseInt(arrQ.get(j)));
                        category[i].setPrice(Integer.parseInt(arrQ.get(j)) * category[i].getPrice());
                        category[i].setId(Integer.parseInt(arrID.get(j)));
                        currentCart.add(new Item(category[i].getId(), category[i].getQuantity(), category[i].getPrice(), category[i].getName()));
                        // update the quantity in the cart
 
                        // after adding the quantity to currentCart, reset the category quantity
                        // category arrays hold the id, quantity, price, and name
                        // update the quantity to be the initial quantity, then subtract from the amount being purchased
                        category[i].setQuantity(quant);
                        category[i].setQuantity(category[i].getQuantity() - Integer.parseInt(arrQ.get(j)));
                       
                        int newQuant = category[i].getQuantity();
 
                        // update full catalog
                        catDat[1][j] = Integer.toString(newQuant);
                        sendToDatabase();
 
                        j++;
 
                        didWeFindIt = true;
                    }
                    else
                    {
                        i++;
                    }
                }
            }
            i = 0;
            p++;
        }
 
        //Test file save
        try
        {
            saveFile();
        } catch (IOException ex)
        {
            Logger.getLogger(itemManage.class.getName()).log(Level.SEVERE, null, ex);
        }
        //printCart(user);
        displayCategory(user);
    }
    
    // print out items in cart
    public void printCart(userManage saveUser)
    {
        user = saveUser;
        
        System.out.println("--------------------------------");
        System.out.println("Your Current Cart for Checkout");
        System.out.println("Items: ");

        int n = currentCart.size();
        ArrayList<Integer> arrID = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            Item item = currentCart.get(i);

            // create a dynamic array to hold ID values (used to calculate total)
            arrID.add(i, item.getId());

            // display cart values
            item.displayCart();
        }

        calculateTotal(arrID);
        checkout();
    }

    // calculate the total price of all items in cart
    private void calculateTotal(ArrayList<Integer> IDs)
    {
        double subtotal = 0.0;
        double tax = 0.0;
        double finTotal = 0.0;
        int j = 0;
        int i = 0;
        double reward = 0.0;
        while (j != IDs.size())
        {
            boolean didWeFindIt = false;
            while (didWeFindIt != true)
            {
                if (IDs.get(j) == fullCatalog[i].getId())
                {
                    subtotal += (fullCatalog[i].getPrice() * currentCart.get(j).getQuantity());
                    didWeFindIt = true;
                    i++;
                    j++;
                }
                else
                {
                    i++;
                }
            }
            i = 0;
        }

        tax = (0.0825 * subtotal);
        finTotal = (tax + subtotal);
        if(user.userPriv == 1 || user.userPriv == 2)
        {
            reward = (0.05 * finTotal);          
        }

        DecimalFormat priceForm = new DecimalFormat("#.00");
        System.out.println("--------------------------------");
        System.out.print("Subtotal:        $");
        System.out.print(priceForm.format(subtotal));
        System.out.print("\nTax (8.25%):     $");
        System.out.print(priceForm.format(tax));
        System.out.print("\nTOTAL:           $");
        System.out.print(priceForm.format(finTotal));
        if(user.userPriv == 1 || user.userPriv == 2)
        {
            System.out.print("\nuClub Rewards:   $");
            System.out.print(reward);
        }
        System.out.println("\n--------------------------------");
    }
    
    // saves checkout menu to be viewed by admin in history
    // displays thank you message after using saying "yes" to checkout
    public void checkout()
    {
      String userChoice;
      boolean userCheck = false;
            
      if (currentCart.isEmpty())
      {
          System.out.println("No items in cart, press enter to return to menu...");
          reader.nextLine();
          displayCategory(user);
      }

      System.out.print("Confirm Checkout? (Yes/No): ");
      do{
      userChoice = reader.nextLine();

      if("Yes".equals(userChoice) || "yes".equals(userChoice) || "y".equals(userChoice) || "Y".equals(userChoice))
      {
        System.out.println("Thank you for your purchase! Press enter to continue.");
        reader.nextLine();
        saveHistory();
        userCheck = true;
      }

      else if("No".equals(userChoice) || "no".equals(userChoice) || "n".equals(userChoice) || "N".equals(userChoice))
      {
        userCheck = true;
        System.out.println("Returning to category menu..");                 
        displayCategory(user);
      }

      else
      {
        System.out.println("Incorrect choice. Try 'Yes' or 'No'");
      }
      }while(!userCheck);
    }
    
    // Saves the history from the current cart
    public void saveHistory()
    {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("history.txt"))) {

        // Save the buy history with the username
        for(int i = 0; i < currentCart.size(); i++)
        {
          out.write(currentCart.get(i).getId() + "," + currentCart.get(i).getQuantity() + "," + currentCart.get(i).getPrice() + "," + currentCart.get(i).getName() + "," + user.username);
          out.newLine();
        }

        } catch (IOException e){
                e.printStackTrace();
        }
    }
    
    // Reads out the history of purchases from the history.txt file
    public void readHistory() throws Exception
    {
        reader = new Scanner(new File("history.txt"));
        String line;
        
        while(reader.hasNextLine())
        {
           line = reader.nextLine();
           String tmp[] = line.split(",");
            
           reader.useDelimiter(",");
           
           System.out.println("Item ID: " + tmp[0] + " Quantity: " + tmp[1] + " Price: $" + tmp[2] + " Item Name: " + tmp[3] + " Username: " + tmp[4]);

        }
    }
    
    // Asks if the user wants to buy membership. If so it will switch the priveleges so they get the rewards.
    void buyMembership(userManage saveUser)
    {
        String userChoice;
        boolean userCheck = false;
        String uClubName = "", uClubPaypal = "", uClubLastName = "", uClubEmail = "";
        System.out.println("uClub Membership - $19.99/Annually");
        System.out.println("Members receive 5% rewards on every purchase.\n");
        System.out.println("Would you like to buy uClub membership? (Yes/No): ");
        do{
            userChoice = reader.nextLine();
           
            if("Yes".equals(userChoice) || "yes".equals(userChoice) || "y".equals(userChoice) || "Y".equals(userChoice))
            {
                // Take in the user's data to buy membership
                do{
                System.out.println("Please provide the following to checkout: ");
               
                System.out.println("First Name: ");
                uClubName = reader.nextLine();
                System.out.println("Last Name: ");
                uClubLastName = reader.nextLine();
                System.out.println("Email: ");
                uClubEmail = reader.nextLine();
                System.out.println("Paypal: ");
                uClubPaypal = reader.nextLine();
                }while((uClubName.equals("") || uClubLastName.equals("") || uClubEmail.equals("") || uClubPaypal.equals("")) || (!uClubEmail.contains("@") || !uClubPaypal.contains("@")));
               
                // Print Receipt and Change userPriv
                System.out.println("\n------------Receipt-------------");
                System.out.println("Name: " +uClubName + " " + uClubLastName);
                System.out.println("Email: " + uClubEmail);
                System.out.println("Paypal: " + uClubPaypal);
                System.out.println("Price: $19.99 / Year");
                System.out.println("--------------------------------");
                System.out.println("Thank you for your purchase! Press enter to continue.");
                reader.nextLine();
                saveUser.setUserPriv(1);
                userCheck = true;
            }
 
            else if("No".equals(userChoice) || "no".equals(userChoice) || "n".equals(userChoice) || "N".equals(userChoice))
            {
                System.out.println("Thank you! We hope to see you back. Press enter to continue.");
                reader.nextLine();
                userCheck = true;
            }
 
            else
            {
                System.out.println("Incorrect choice. Try 'Yes' or 'No'");
            }  
        } while(!userCheck);
    }
}
