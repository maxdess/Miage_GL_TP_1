package machine_cafe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MachineCafe {

	/**
	 * Stock de chaque ingrédient dans la machine
	 */
	private HashMap<Ingredient, Integer> listeIngredients;
	
	/**
	 * Liste des boissons de la machine
	 */
	private ArrayList<Boisson> listeBoissons;
	
	/**
	 * Scanner pour lire les commandes au clavier
	 */
	private Scanner sc;
	
	/**
	 * Constructeur de la classe machine à café
	 */
	public MachineCafe() {
		this.listeIngredients = new HashMap<Ingredient, Integer>();
		this.listeBoissons = new ArrayList<Boisson>(3);
		this.sc = new Scanner(System.in);
		
		int quantiteInitiale = 100; // Quantité initiale de chaque ingrédient
		
		// Création des ingrédients
		Ingredient lait = new Lait();
		Ingredient cafe = new Cafe();
		Ingredient chocolat = new Chocolat();
		Ingredient sucre = new Sucre();
		
		// Ajout des ingrédients à la machine
		this.listeIngredients.put(cafe, quantiteInitiale);
		this.listeIngredients.put(lait, quantiteInitiale);
		this.listeIngredients.put(chocolat, quantiteInitiale);
		this.listeIngredients.put(sucre, quantiteInitiale);
		
		// Création des boissons
		HashMap recette = new HashMap<Ingredient, Integer>();
		recette.put(cafe, 3);
		recette.put(sucre, 2);
		Boisson boisson1 = new Boisson("Café", 1, recette);
		
		recette = new HashMap<Ingredient, Integer>();
		recette.put(cafe, 2);
		recette.put(lait, 1);
		recette.put(sucre, 2);
		Boisson boisson2 = new Boisson("Cappuccino", 2, recette);
		
		recette = new HashMap<Ingredient, Integer>();
		recette.put(chocolat, 3);
		recette.put(lait, 2);
		recette.put(sucre, 2);
		Boisson boisson3 = new Boisson("Chocolat", 3, recette);
		
		// Ajout des boissons à la machine
		this.listeBoissons.add(boisson1);
		this.listeBoissons.add(boisson2);
		this.listeBoissons.add(boisson3);
	}
	
	/**
	 * @return the listeIngredients
	 */
	public HashMap<Ingredient, Integer> getListeIngredients() {
		return listeIngredients;
	}



	/**
	 * @param listeIngredients the listeIngredients to set
	 */
	public void setListeIngredients(HashMap<Ingredient, Integer> listeIngredients) {
		this.listeIngredients = listeIngredients;
	}



	/**
	 * @return the listeBoissons
	 */
	public ArrayList<Boisson> getListeBoissons() {
		return listeBoissons;
	}



	/**
	 * @param listeBoissons the listeBoissons to set
	 */
	public void setListeBoissons(ArrayList<Boisson> listeBoissons) {
		this.listeBoissons = listeBoissons;
	}



	public void acheterBoisson() {
		System.out.println("Quelle boisson souhaitez-vous acheter ? Tapez le numéro de l'action que vous voulez acheter.");
		System.out.println();
		for (Boisson b : this.listeBoissons) {
			System.out.println((this.listeBoissons.indexOf(b) + 1) + " - " + b.getNom());
		}
		System.out.println(this.listeBoissons.size() + " - Annuler");
		System.out.println();
		System.out.print("Votre choix : ");
		String reponse = sc.nextLine();
		System.out.println();
		
		int choix = -1;
		try {
			choix = Integer.parseInt(reponse);
			if (choix >= 0 && choix < this.listeBoissons.size()) {
				this.demanderPaiement(this.listeBoissons.get(choix - 1));
			} else {
				System.err.println("Votre choix est incorrect.");
			}
		}
		catch(Exception e) {
			System.err.println("Veuillez entrer un nombre correct.");
		}
	}
	
	public void ajouterBoisson() {

	}
	
	public void modifierBoisson() {
		
	}
	
	public void supprimerBoisson() {
		
	}
	
	public void ajouterIngredient() {
		
		System.out.println("Quel ingredient voulez-vous ajouter ? ");
		System.out.println();
		System.out.println("1 - Cafe");
		System.out.println("2 - lait");
		System.out.println("3 - Chocolat");
		System.out.println("4 - Sucre");
		System.out.println("5 - Retour au menu");
		System.out.println();
		System.out.print("Votre choix : ");
		String reponse = this.sc.nextLine();
		System.out.println();
		
		int choix = -1;
		try {
			choix = Integer.parseInt(reponse);
			
			switch(choix) {
			case 1: 
				this.listeIngredients.get(0).remplir();
				break;
			case 2: 
				this.listeIngredients.get(1).remplir();
				break;
			case 3: 
				this.listeIngredients.get(2).remplir();
				break;
			case 4: 
				this.listeIngredients.get(3).remplir();
				break;
			case 5: 
				break;
			default : // choix incorrect
				System.err.println("Cet ingredient n'existe pas.\n");
				break;
			}
		}catch(Exception e) {
			System.err.println("Veuillez entrer un nombre valide, de type 1, 2, ..., 5.");
			System.out.println();
		}
			
	}
	
	public void remplir(){
		Scanner sc = new Scanner(System.in);
		System.out.println("La quantit� actuelle de "+this.nom+" est de "+this.qte+" .");
		System.out.println("Combien d'unit� de "+this.nom+"voulez-vous ajouter ?");
		String s=sc.nextLine();
		int i= Integer.parseInt(s);
		if(i>0){
			this.qte+=i;
		}
		if(i>100){
			this.qte=100;
		}
	}
	
	public void diminuerStock(int qteBoisson){
			
			this.qte=this.qte-qteBoisson;
			if (this.qte<0) this.qte = 0;
			
		}
	
	public void verifierStock() {
		String message="Voici la quantité restante de chaques ingrédient : \n";
		for (Ingredient ingredient : this.listeIngredients ) {
			message+=ingredient.toString()+"\n";
			
		}
		System.out.println(message);
	}
	
	public void demanderPaiement(Boisson b) {
		System.out.println("Votre boisson " + b.getNom() + " coûte " + b.getPrix() + "€.");
		System.out.println("Veuillez entrer votre monnaie.");
		
		String monnaie = this.sc.nextLine();
		
		System.out.println("Voici votre boisson !");
	}
	
	
}
