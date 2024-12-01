package enig.tn;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerTCP {

	public static List<Compte> lcompte = new ArrayList<Compte>();

	public static void main(String[] args) {

		try {
			ServerSocket sc = new ServerSocket(2000);
			while (true) {
				System.out.println("Server en ecoute !!!!!");

				Socket s = sc.accept();
				Traitement t = new Traitement(s);
				t.start();

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
