package miaous;


public class Chat{ 
	private String nom; 
	private int force;
	private int nbTrophees; 
	private int effetPotion = 1; 
	private Equipement[] trophees = new Equipement[100];
	
	public Chat(String nom, int force) { 
		this.nom = nom; 
		this.force = force; 
	}
	
	public String getNom() { 
		return nom; 
	} 
	
	public void parler(String texte) { 
		System.out.println(prendreParole() + "« " + texte + "»"); 
	} 

//	private String prendreParole() { 
//		return "Le chat " + nom + " : "; 
//	} 
	
	 private String prendreParole() { 
		return "Le chat " + nom + " : ";  
	 }
	
//	public void frapper(Romain romain) { 
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " 
//				+ romain.getNom()); 
//		romain.recevoirCoup(force / 3); 
//	} 


	 public void frapper(Romain romain) { 
		System.out.println(nom  +  "  envoie  un  grand  coup  dans  la "
				+ "mâchoire de " + romain.getNom()); 
		Equipement[]  trophe  =  romain.recevoirCoup((force  /  3)  * 
				effetPotion); 
		for  (int  i  =  0;  trophe  !=  null  &&  i  <  trophe.length;  i++, 
				nbTrophees++) { 
			this.trophees[nbTrophees] = trophe[i]; 
		} 
	 }

	 
//	@Override
//	public String toString() { 
//		return "Chat [nom=" + nom + ", force=" + force 
//				+ ", effetPotion=" + effetPotion + "]"; 
//	}
	 
} 
