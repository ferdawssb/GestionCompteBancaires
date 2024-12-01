package enig.tn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientTCP {

	public static void main(String[] args) {
		try {

			Socket sc = new Socket("127.0.0.1", 2000);
			BufferedReader in_sc = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			PrintWriter out = new PrintWriter(sc.getOutputStream(), true);

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("Donner votre cmd");
				String msg = in.readLine();
				out.println(msg);
				String msg1 = in_sc.readLine();
				System.out.println(msg1);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
