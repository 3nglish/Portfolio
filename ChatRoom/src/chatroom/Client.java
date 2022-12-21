/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroom;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Moses
 */
public class Client implements Runnable
{
    
 private Socket client;
 private Scanner in;
 private PrintWriter out;
 
 public Client(Socket aSocket)
 {
     client = aSocket;
 }
 @Override
 public void run()
 {
     try
     {
         try
         {
             in = new Scanner(client.getInputStream());
             out = new PrintWriter(client.getOutputStream());
             runChat();
         }
         finally
     {
         client.close();
     }
     }
     catch(Exception e)
         {
         }
     
 }
 
 public void runChat() throws IOException
 {
     while(true)
     {
         try
         {
             Thread.sleep(1);
             String text = in.nextLine();
             if(text.equalsIgnoreCase("Quit"))
             {
                    this.client.close(); 
                    break; 
             }
             else
             {
                 out.write("Client: " + text);
             }
         } catch (InterruptedException ex)
         {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
 }
}
