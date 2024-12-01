package enig.tn;

public class Compte {
	static private int count = 0;
	private String nom;
	private int num;
	private float solde;

	public Compte() {
		super();

	}

	public Compte(String nom) {
		super();
		count++;
		this.nom = nom;
		this.num = count;
		this.solde = 0;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Compte.count = count;
	}

}
