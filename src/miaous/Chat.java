package miaous;


public class Chat{ 
	private String nom; 
	private int force; 
	private int effetPotion = 1; 
	
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
	private String prendreParole() { 
		return "Le chat " + nom + " : "; 
	} 
	public void frapper(Romain romain) { 
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " 
				+ romain.getNom()); 
		romain.recevoirCoup(force / 3); 
	} 

	@Override
	public String toString() { 
		return "Chat [nom=" + nom + ", force=" + force 
				+ ", effetPotion=" + effetPotion + "]"; 
	} 
	
	public static void main(String[] args) {
		Romain noa = new Romain("Noa",5);
		Chat cotton = new Chat("Cotton",8);
		System.out.println(cotton);
		cotton.prendreParole();
		cotton.parler("Miaou miaou");
		cotton.frapper(noa);
		
		//TODO créer un main permettant de tester la classe Chat 
	} 
} 
