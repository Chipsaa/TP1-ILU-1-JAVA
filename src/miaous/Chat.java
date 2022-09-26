package miaous;

public class Chat {
	private String nom;
	private int force;
	private int effetPotion = 1;
	
	public Chat(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	@Override
	public String toString() {
		return "Chat [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	public void parler(String texte) {
		prendreParole()
	}
	
}

