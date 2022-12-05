import java.net.*;
import java.io.*;
import java.util.*;

public abstract class Client {
	
	public static void main (String[] args) {
		Socket client = null;
		
		
		try{
			client = new Socket("localhost", 4999);
			DataOutputStream raus = new DataOutputStream(client.getOutputStream());
			raus.writeUTF(args[0]);
			BufferedReader leser = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String leserS = leser.readLine();
		
			System.out.println(leserS);
		
			Scanner eingabeGF = new Scanner(System.in);
			String gF = eingabeGF.nextLine();
			
			
			
		
			raus.writeUTF( gF);
			
			BufferedReader leser2 = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String leserS2 = leser2.readLine();
			
			System.out.println(leserS2);
			
			
			Scanner b = new Scanner(System.in);
			String be = b.nextLine();
			raus.writeUTF(be);
			
			BufferedReader leser3 = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String leserS3 = leser3.readLine();
			System.out.println(leserS3);
			}
			catch(Exception e){
				System.out.println(e);
				}
		
	}
	
	
}


