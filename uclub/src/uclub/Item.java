
// class to store the object details of every item
package uclub;

import java.text.NumberFormat;
import java.text.DecimalFormat;

public class Item
{
    private int id;
    private int quantity;
    
    private double price;
    
    private String name;
    
    // constructor
    public Item (int id, int quantity, double price, String name)
    {
        this.id = id;
        this.quantity = quantity;
        
        this.price = price;
        
        this.name = name;
    }
    
    // display items
    public void display()
        {
            NumberFormat dollars = NumberFormat.getCurrencyInstance();
            if (quantity == 0)
            {
                System.out.printf("%-5s-UNAVAILABLE-  %-8s\n", id, name);
            }
            else
            {
                System.out.printf("%-5s%-6s%-9s%-8s%n", id, quantity, dollars.format(price), name);
            }
        }
    
    // display function for outputting the cart contents in a specific format
    public void displayCart()
    {
        DecimalFormat priceForm = new DecimalFormat("#.00");
        NumberFormat dollars = NumberFormat.getCurrencyInstance();
        
        String nameFormat = "%d x %-6s | ";
        String pFormat = "%2s\n";
        
        String format = nameFormat.concat(pFormat);
        System.out.printf(format, quantity, name, priceForm.format(price));
    }
    
    // getters
    public int getId(){return id;}

    public int getQuantity(){return quantity;}

    public double getPrice(){return price;}

    public String getName(){return name;}

    // setters
    public void setId(int id)
    {
        this.id = id;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
