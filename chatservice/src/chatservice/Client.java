/*
 * 5964074
 */
package chatservice;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client implements Runnable  
{
    Scanner scn = new Scanner(System.in); 
    private String name; 
    DataInputStream is; 
    DataOutputStream os; 
    Socket s; 
    boolean isloggedin; 
    Client aClient;
    PrintWriter test;
      
    // constructor 
    public Client(Socket s, String name, 
     DataInputStream dis, DataOutputStream dos) 
    { 
        this.is = dis; 
        this.os = dos; 
        this.name = name; 
        this.s = s; 
        this.isloggedin=true; 
    } 
  
    @Override
    public void run() 
    { 
        String received; 
        while (true)  
        { 
            try
            { 
                // receive the string 
                received = is.readUTF();
                  
                System.out.println(received); 
                  
                if(received.equals("logout")){ 
                    this.isloggedin=false; 
                    this.s.close(); 
                    break; 
                } 
                  
                // break the string into message and recipient part 
               scn = new Scanner(s.getInputStream());
               test = new PrintWriter(s.getOutputStream());
               runChat();
  
                // search for the recipient in the connected devices list. 
                // ar is the vector storing client of active users 
           
            } catch (IOException e) 
            { 
                  
                e.printStackTrace(); 
            } 
            
              
        } 
        try
        { 
            // closing resources 
            this.is.close(); 
            this.os.close(); 
            s.close();
              
        }catch(IOException e){ 
            e.printStackTrace(); 
        } 
    }
    
     public void runChat() throws IOException
 {
     while(true)
     {
         try
         {
             Thread.sleep(1);
             String text = scn.nextLine();
             if(text.equalsIgnoreCase("Quit"))
             {
                 this.isloggedin=false; 
                    this.s.close(); 
                    break; 
             }
             else
             {
                 test.write("Client: " + text);
             }
         } catch (InterruptedException ex)
         {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
 }
    
}
    