import java.net.*;
import java.io.*;
import java.util.*;

public abstract class Client {
	
	public static void main (String[] args) {
		Socket client = null;
		
		
		try{
			client = new Socket("localhost", 4999);
			//PrintWriter raus = new PrintWriter(client.getOutputStream());
			DataOutputStream raus = new DataOutputStream(client.getOutputStream());
			raus.writeUTF(args[0]);
			BufferedReader leser = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String leserS = leser.readLine();
			
			
			
			
			while(leserS != null){
				System.out.println(leserS);
				
				
				
				Scanner eingabeGF = new Scanner(System.in);
				String gF = eingabeGF.nextLine();
				raus.writeUTF( gF);
				
				
				leserS = leser.readLine();
		}
			
			}
			catch(Exception e){
				System.out.println(e);
				}
		
	}
	
	
}


