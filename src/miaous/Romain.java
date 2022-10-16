package miaous;

public class Romain  { 
	private String nom; 
	private int force; 
	private int nbEquipement = 0;
	private Equipement[] equipements = new Equipement[2];
	
	public Romain(String nom, int force) {
		assert force >=0 : "Force n�gative";
		this.nom = nom; 
		this.force = force; 
	} 
	public String getNom() { 
		return nom; 
	} 
	public void parler(String texte) { 
		System.out.println(prendreParole() + "� " + texte + "�"); 
	} 
	private String prendreParole() { 
		return "Le romain " + nom + " : "; 
	} 
	public void recevoirCoup(int forceCoup) { 
		assert force >= 0 : "Force n�gative";
		int forcePre = force;
		force -= forceCoup; 
		if (force > 0) { 
			parler("A�e"); 
		} else { 
			parler("J'abandonne..."); 
		} 
		assert force < forcePre : "La force n'a pas diminué";
	} 
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
			case 2: 
				System.out.println("Le soldat " + nom + " est déjà bien protégé !");
				break;
			case 1:
				if (equipement == equipements[0]) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement.toString() + ".");
				break;
				}
			default:
				equipements[nbEquipement] = equipement;
				nbEquipement ++;
				System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.toString() + ".");
		}
	}
	
	public static void main(String[] args) {
		Romain noa = new Romain("Noa",6);
		noa.sEquiper(Equipement.CASQUE);
		noa.sEquiper(Equipement.CASQUE);
		noa.sEquiper(Equipement.BOUCLIER);
		noa.sEquiper(Equipement.BOUCLIER);
	}
} 