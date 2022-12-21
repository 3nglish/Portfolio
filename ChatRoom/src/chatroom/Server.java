
package chatroom;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server 
{
      ArrayList<PrintWriter> clients ;
      static int port = 8888;
      String addy = "10.0.0.160";
      int clientCount = 0;
      ServerSocket server;
      Socket client;
      
      public Server(int port)
      {
          this.port = port;
      }
      
      public void startServer() throws IOException {
        
        server = new ServerSocket(port);
        System.out.println("Server starting...");
        System.out.println("Any client can stop the server by sending -1");
        while(true)
        {
            client = server.accept();
            clientCount++;
            Thread t = new Thread(new ServerThread(client,clientCount,this));
        }
        
    }
      
    public static void main(String [] args)
    {
        try
        {
        Server serverobj=new Server(5000);
        serverobj.startServer();
        
         
        }
        catch(Exception e)
        {
            
        }
        finally
        {
            
        }
        
    }
    
   
    private static class  ServerThread  implements Runnable    {
        
        Server server;
        Socket client;
        InputStream inStream;
        OutputStream outStream;
        Scanner in = new Scanner(inStream); 
        PrintWriter out = new PrintWriter(outStream);
        int id;
        String s;
        
        ServerThread(Socket client, int count ,Server server ) throws IOException 
        {
            this.client=client;
            this.server=server;
            this.id=count;
            System.out.println("Connection "+id+"established with client "+client);
            
              inStream = new DataInputStream(client.getInputStream());
              outStream = client.getOutputStream(); 
        
        }

        @Override
        public void run() 
        {
            int x=1;
         try{
         while(true){
               s = in.nextLine();
  			 
			System. out.print("Client("+id+") :"+s+"\n");
			System.out.print("Server : ");
			//s=stdin.readLine();
                            s = in.nextLine();
                        if (s.equalsIgnoreCase("bye"))
                        {
                            out.println("BYE");
                            x=0;
                            System.out.println("Connection ended by server");
                            break;
                        }
			out.println(s);
		}
		
            
                in.close();
                client.close();
		out.close();
                if(x==0) {
			System.out.println( "Server cleaning up." );
			System.exit(0);
                }
         } 
         catch(IOException ex){
             System.out.println("Error : "+ex);
         }
            
 		
        }
    }

    
    


    
}
