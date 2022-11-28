import java.net.*;
import java.io.*;
import java.util.*;

public  class client {
	
	public static void main (String[] args) throws IOException{
		try(Socket s = new Socket("localhost", 54131)) {
			Scanner in = new Scanner (s.getInputStream());
			PrintWriter out = new PrintWriter(new OutputStreamWriter (s.getOutputStream()), true);
			
			
			out.println(args[0]);
			out.println(args[1]);
			System.out.println( in.nextLine());
			
			}
		  
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		

		
	}
}

