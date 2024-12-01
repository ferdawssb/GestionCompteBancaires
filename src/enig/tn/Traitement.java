package enig.tn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Traitement extends Thread {
	Socket s;

	public Traitement(Socket s) {
		super();
		this.s = s;
	}

	public void run() {

		try {

			BufferedReader in_sc = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);

			while (true) {

				String msg = in_sc.readLine();
				System.out.println(msg);
				if (msg.startsWith("CREATION")) {

					String cmd = msg.substring(9);
					boolean test = false;
					for (Compte cp : ServerTCP.lcompte) {

						if (cmd.equals(cp.getNom())) {
							test = true;
						}
					}

					if (test == false) {

						Compte c = new Compte(cmd);
						ServerTCP.lcompte.add(c);
						out.println("Le compte est créé avec succès");
						while (true) {

							msg = in_sc.readLine();
							if (msg.startsWith("CREDIT")) {

								String m = msg.substring(7);
								float mon = Float.parseFloat(m);
								float mon1 = c.getSolde() + mon;
								c.setSolde(mon1);
								out.println("Compte crédité avec succès");

							} else if (msg.startsWith("DEBIT")) {

								String m1 = msg.substring(5);
								float mon = Float.parseFloat(m1);
								if (mon <= c.getSolde()) {
									float moins = c.getSolde() - mon;
									c.setSolde(moins);
									out.println("Compte a été débité avec succès");
								} else {
									out.println("Solde insuffisant");

								}

							} else if (msg.startsWith("SOLDE")) {

								out.println(c.getSolde());

							}else {
								out.println("erreur c");
							}
						}
					} else {

						out.println("Erreur Compte déja exist!!!!");

					}
					//

				}else {
					out.println("Commande incorrect Répeter!!!!");
					
				}

			}

		} catch (Exception e) {

		}

	}

}
