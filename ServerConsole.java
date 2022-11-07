import java.io.IOException;
import java.util.Scanner;

import client.ChatClient;
import common.ChatIF;
import ocsf.server.ConnectionToClient;

public class ServerConsole implements ChatIF {
	final public static int DEFAULT_PORT = 5555;
	EchoServer server;
	Scanner fromConsole;
	
	public void display(String message) 
	  {
	    System.out.println("> " + message);
	  }
	
	public ServerConsole(int port) 
	  {
	    server = new EchoServer(port);
	    
	    // Create scanner object to read from console
	    fromConsole = new Scanner(System.in); 
	  }
	public void accept() 
	  {
	    try
	    {

	      String message;

	      while (true) 
	      {
	        message = fromConsole.nextLine();
	        server.handleMessageFromClientUI(message);
	      }
	    } 
	    catch (Exception ex) 
	    {
	      System.out.println
	        ("Unexpected error while reading from console!");
	    }
	  }
	public static void main(String[] args) 
	  {
	    String host = "";
	    int port = 0;

	    try
	    {
	    	host = args[0];
	    	port = Integer.parseInt(args[1]);
	    }
	    catch(ArrayIndexOutOfBoundsException e)
	    {
	    	host = "localhost";
	    	port = DEFAULT_PORT;
	    }
	    catch(NumberFormatException ne) 
	    {
	    	port = DEFAULT_PORT;
	    }
	    ServerConsole chat= new ServerConsole(port);
	    chat.accept();  //Wait for console data
	  }
}
