import common.ChatIF;
import ocsf.server.ConnectionToClient;

public class ServerConsole implements ChatIF {
	final public static int DEFAULT_PORT = 5555;
	ChatIF clientUI;
	
	public void display(String message) 
	  {
	    System.out.println("> " + message);
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
	    ClientConsole chat= new ClientConsole(host, port);
	    chat.accept();  //Wait for console data
	  }
}
