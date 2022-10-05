package miaous;

public class Romain  { 
	private String nom; 
	private int force; 
	
	public Romain(String nom, int force) {
		assert force >=0 : "Force négative";
		this.nom = nom; 
		this.force = force; 
	} 
	public String getNom() { 
		return nom; 
	} 
	public void parler(String texte) { 
		System.out.println(prendreParole() + "« " + texte + "»"); 
	} 
	private String prendreParole() { 
		return "Le romain " + nom + " : "; 
	} 
	public void recevoirCoup(int forceCoup) { 
		assert force >= 0 : "Force négative";
		int forcePre = force;
		force -= forceCoup; 
		if (force > 0) { 
			parler("Aïe"); 
		} else { 
			parler("J'abandonne..."); 
		} 
		assert force < forcePre : "La force n'a pas diminué":
	} 
	
	public static void main(String[] args) {
		Romain noa = new Romain("Noa",6);
		System.out.println(Equipement.BOUCLIER);
		System.out.println(Equipement.CASQUE);
	}
} 