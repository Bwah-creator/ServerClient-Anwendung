
import java.net.*;
import java.io.*;
import java.util.*;

public class server {
	
	public static void main (String[] args) throws IOException{
		
		
		try(ServerSocket ss = new ServerSocket(4999)){
			while (true)
			try(Socket s = ss.accept()){
				handleConnection(s);
			}
			catch (IOException e) {
				
			}
		}
		
		
		
		}
	private static void handleConnection(Socket s) throws IOException {
	Scanner in = new Scanner (s.getInputStream());
	String Color = in.nextLine();
	String Size = in.nextLine();
	PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
	out.println("Ihre bestellung ist ein TShirt in der farbe " + Color + " und in der Groesse " + Size);
	}
}

