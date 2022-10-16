package miaous;


public class Village { 
	private String nom; 
	private Chef chef; 
	private Chat[] villageois;
	private int nbVillageois=0;
	
	public Village(String nom, int nbVillageoisMaximum) { 
		this.nom = nom; 
		villageois = new Chat[nbVillageoisMaximum];
	} 
	public void setChef(Chef chef) { 
		this.chef = chef; 
	} 
	public String getNom() { 
		return nom; 
	} 
	public void ajouterHabitant(Chat chat) {
		villageois[nbVillageois] = chat;
		nbVillageois++;
	}
	public Chat trouverHabitant(int numVillageois) {
		return villageois[numVillageois];
	}
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "+chef.getNom()+" vivent les légendaires chats :");
		for (int i=0; i< nbVillageois; i++) {
			
			System.out.println("-"+villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles",30);
		
		//Chat chat = village.trouverHabitant(30);
		//Le nombre max = 30 donc de 0 � 29
		
		Chef chef = new Chef("Amiaouracourcix",6,1,village);
		village.setChef(chef);
		Chat cotton = new Chat("Cotton",8);
		village.ajouterHabitant(cotton);

		//Chat chat = village.trouverHabitant(1);
		//System.out.println(chat);
		//null car cotton est � la place 0 pas 1
		
		Chat croquette = new Chat("Croquette",25);
		village.ajouterHabitant(croquette);
		//village.afficherVillageois();
	}
}
