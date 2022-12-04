import java.net.*;
import java.io.*;
import java.util.*;


public abstract class Server {
	
	public static void main (String[] args) throws Exception {
		int port = 4999;
		ServerSocket ss = new ServerSocket(port);
		Socket client = ss.accept();
		PrintWriter raus = new PrintWriter(new OutputStreamWriter(client.getOutputStream()),true);
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String strc = (String)dis.readUTF();
		InetAddress kunde= client.getInetAddress();
		
		System.out.println("Daten des Kunden: " + "IP: "+ kunde +" Port: " + port);
		
		
		
		if(strc.equals("Anmeldung")){
				boolean Angemeldet = true;
				raus.println("Willkommen Waehlen Sie eine Groesse und eine Farbe für Ihr T-Shirt. Sie koennen sich jederzeit durch: Abmeldung : abmelden");
				while(true){
					DataInputStream aRein = new DataInputStream(client.getInputStream());
					String config = (String)aRein.readUTF();
					String[] configS = config.split(":");
					if(config.equals("Abmeldung")){
						raus.println("sie sind nun abgemeldet");
						System.out.println(kunde + " " + port + " hat sich abgemeldet");
						System.exit(0);
						}
					for(int i = 0; i<configS.length; i++){
					raus.println("Die Groesse des TShirts ist " + configS[1] + " und die Farbe ist " + configS[2] + ". Der Preis beträgt 19.99 Euro. Bitte bestaetigen Sie die bestellung. Mit J oder N");
					System.out.println(configS[i]);
					DataInputStream aRein2 = new DataInputStream(client.getInputStream());
					String bestätigung = (String)aRein2.readUTF();
					if(bestätigung.equals("Abmeldung")){
						raus.println("sie sind nun abgemeldet");
						System.out.println(kunde + " " + port + " hat sich abgemeldet");
						System.exit(0);
						}
					else if(bestätigung.equals("J")){
						raus.println("Danke, ihre bestellung wurde bestaetigt");
						System.out.println("Bestellung bestätigt");
						System.exit(0);
						
						}
					else if (bestätigung.equals("N")){
						raus.println("Ihre bestellung wurde nicht bestaetigt");
						System.out.println("Bestellung nicht bestätigt");

						System.exit(0);
						
					}
				}
			}
		}
		else{
			raus.println("Falsche eingabe, bitte Anmeldung eingeben");
			boolean Angemeldet = false;
			}
		
	
	}
	
	
	
	
	
}

