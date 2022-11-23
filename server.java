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
	float price = 0;
	
	Scanner in = new Scanner (s.getInputStream());
	String Color = in.nextLine();
	String Size = in.nextLine();

	
	if(Color.equals("Rot")){
		price = price + 10;
		}
	else if(Color.equals("Blau")){
		price = price + 12;
		}
	else if(Color.equals("Gelb")){
		price = price + 11;
		}
	else if(Color.equals("Schwarz")){
		price = price + 15;
		}
	
	if (Size.equals("XXL")){
		price = price * 3;
		}
	else if (Size.equals("XL")){
		price = price - 5 * 2;
		}
	else if (Size.equals("L")){
		price = price  * 2 * 2 / 4;
		}
	else if (Size.equals("M")){
		price = price * 2 * 2 / 3;
		}
		
	PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
	out.println("Ihre bestellung ist ein TShirt in der farbe " + Color + " und in der Groesse " + Size + " der Preis ist "+ price + " Euro");
	System.exit(0);
	}
	
}
