package miaous;

public class Romain  { 
	private String nom; 
	private int force; 
	private int nbEquipement = 0;
	private Equipement[] equipements = new Equipement[2];
	
	public Romain(String nom, int force) {
		assert force >=0 : "Force négative";
		this.nom = nom; 
		this.force = force; 
	} 
	public String getNom() { 
		return nom; 
	} 
	public void parler(String texte) { 
		System.out.println(prendreParole() + "<<" + texte + ">>"); 
	} 
	private String prendreParole() { 
		return "Le romain " + nom + " : "; 
	} 
//	public void recevoirCoup(int forceCoup) { 
//		assert force >= 0 : "Force nï¿½gative";
//		int forcePre = force;
//		force -= forceCoup; 
//		if (force > 0) { 
//			parler("Aï¿½e"); 
//		} else { 
//			parler("J'abandonne..."); 
//		} 
//		assert force < forcePre : "La force n'a pas diminuÃ©";
//	}
	

	 public Equipement[] recevoirCoup(int forceCoup) { 
		Equipement[] equipementEjecte = null; 
		// précondition 
		assert force > 0; 
		int oldForce = force; 
		forceCoup = calculResistanceEquipement(forceCoup); 
		force -= forceCoup; 
//  	if (force > 0) { 
//  		parler("Aïe"); 
//  	} else { 
//  		equipementEjecte = ejecterEquipement(); 
//  		parler("J'abandonne..."); 
//  	}	 
		if (force == 0) { 
				parler("Aïe"); 
		} else { 
				equipementEjecte = ejecterEquipement(); 
				parler("J'abandonne...");  
		} 
		// post condition la force à diminuer 
		assert force < oldForce; 
		return equipementEjecte; 
	} 
	 

	 private int calculResistanceEquipement(int forceCoup) { 
		String texte = "Ma force est  de " + this.force + ", et la force du "
				+ "coup est de " + forceCoup; 
		int resistanceEquipement = 0; 
		if (nbEquipement != 0) { 
			texte += "\nMais heureusement, grace à mon équipement sa "
					+ "force est diminué de "; 
			for (int i = 0; i < nbEquipement; i++) { 
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) { 
					resistanceEquipement += 8; 
				} else { 
					System.out.println("Equipement casque"); 
					resistanceEquipement += 5; 
				}  
			} 
			texte += resistanceEquipement + "!"; 
	 	} 
	 	parler(texte); 
	 	forceCoup -= resistanceEquipement; 
	 	return forceCoup; 
	 }
	 
	 private Equipement[] ejecterEquipement() { 
		Equipement[] equipementEjecte = new Equipement[nbEquipement]; 
		System.out.println("L'équipement  de  "  +  nom  +
				"	s'envole sous la force du coup."); 
		int nbEquipementEjecte = 0; 
		for (int i = 0; i < nbEquipement; i++) { 

			if (equipements[i] != null) { 
				equipementEjecte[nbEquipementEjecte]  = 
						equipements[i]; 
				nbEquipementEjecte++; 
				equipements[i] = null; 
			} 
		 } 
		 return equipementEjecte; 
	 } 

	 
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
			case 2: 
				System.out.println("Le soldat " + nom + " est déjà  bien protégé !");
				break;
			case 1:
				if (equipement == equipements[0]) {
				System.out.println("Le soldat " + nom + " possède déjà  un " + equipement.toString() + ".");
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
		Chat croquette = new Chat("Croquette",7);
		noa.sEquiper(Equipement.CASQUE);
		noa.sEquiper(Equipement.CASQUE);
		noa.sEquiper(Equipement.BOUCLIER);
		noa.sEquiper(Equipement.BOUCLIER);
		croquette.frapper(noa);
		noa.calculResistanceEquipement(8);
	}
} 