
// class to manage the login functionality
package uclub;

import java.io.File;
import java.util.Scanner;

public class userManage 
{
    // Containers for the login process
    String username, password;
    // User data stored
    String[][] users = new String[5][2];
    // Is the user logged in?
    boolean loggedIn = false;
    // User priv (0 = default, 1 = member, 2 = admin)
    int userPriv;
    // To read the user's login information
    Scanner input = new Scanner(System.in);
    
    public void userLogin(userManage user) throws Exception
    {
        // Simple login UI
        System.out.println("-------------LOGIN-------------");
        System.out.print("Username: ");
        username = input.nextLine();
        System.out.print("Password: ");
        password = input.nextLine();
        // Read the users
        readUsers();
        // Check if login is good
        checkLogin();
    }
    
    private void readUsers() throws Exception
    {
        Scanner userFile = new Scanner(new File("users.txt"));
        String line;
        
        int userNumber = 0;
        
        while(userFile.hasNextLine())
        {
           line = userFile.nextLine();
           String tmp[] = line.split(",");
            
           userFile.useDelimiter(",");
            
            users[userNumber][0] = tmp[0];
            users[userNumber][1] = tmp[1];
            
            userNumber++;
        }
        
        userFile.close();
    }
    // checks the user's login if it is correct and assigns the privelege assigned to it
    private void checkLogin()
    {
        if((username.equals(users[0][0]) || username.equals(users[1][0]) || username.equals(users[2][0])) && (password.equals(users[0][1]) || password.equals(users[1][1]) || password.equals(users[2][1])))
        {
            if(username.equals("default"))
            {
                userPriv = 0;
            }
            else if(username.equals("member"))
            {
                userPriv = 1;
            }
            else if(username.equals("admin"))
            {
                userPriv = 2;
            }
            
            System.out.println("Log in successful!");
            loggedIn = true;
        }
        else
        {
            System.out.println("Login incorrect.");
            System.out.println("Try default:password, member:password, admin:admin");
            loggedIn = false;
        }
    }
    public void setUserPriv(int priv)
    {
        this.userPriv = priv;
    }
}
