package uclub;

import java.text.NumberFormat;

public class Item
{
    private int id;
    private int quantity;
    
    private double price;
    
    private String name;
    
    public Item (int id, int quantity, double price, String name)
    {
        this.id = id;
        this.quantity = quantity;
        
        this.price = price;
        
        this.name = name;
    }
    
    public void display() //it do
    {        
        NumberFormat dollars = NumberFormat.getCurrencyInstance();
        System.out.printf("%-5s%-6s%-9s%-8s\n", id, quantity, dollars.format(price), name);
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
