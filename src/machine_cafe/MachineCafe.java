package machine_cafe;

import java.util.ArrayList;
import java.util.Scanner;

public class MachineCafe {

	/**
	 * Stock de chaque ingrédient dans la machine
	 */
	private ArrayList<Ingredient> listeIngredients;
	
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
		this.listeIngredients = new ArrayList<Ingredient>();
		this.listeBoissons = new ArrayList<Boisson>();
		this.sc = new Scanner(System.in);
		
		int quantiteInitiale = 100; // Quantité initiale de chaque ingrédient
		
		// Création des ingrédients
		Ingredient lait = new Lait(quantiteInitiale);
		Ingredient cafe = new Cafe(quantiteInitiale);
		Ingredient chocolat = new Chocolat(quantiteInitiale);
		Ingredient sucre = new Sucre(quantiteInitiale);
		
		// Ajout des ingrédients à la machine
		this.listeIngredients.add(lait);
		this.listeIngredients.add(cafe);
		this.listeIngredients.add(chocolat);
		this.listeIngredients.add(sucre);
	}
	
	/**
	 * @return the listeIngredients
	 */
	public ArrayList<Ingredient> getListeIngredients() {
		return listeIngredients;
	}



	/**
	 * @param listeIngredients the listeIngredients to set
	 */
	public void setListeIngredients(ArrayList<Ingredient> listeIngredients) {
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
		this.sc.nextLine();
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
			case 1: // acheter boisson
				break;
			case 2: // ajouter boisson
				break;
			case 3: // modifier boisson
				break;
			case 4: // supprimer boisson
				break;
			case 5: // ajouter ingredient
				break;
			case 6: // verifier stock
				machine.verifierStock();
				break;
			case 7: // quitter
				end = true;
				break;
			default : // choix incorrect
				System.err.println("Je n'ai pas compris votre choix, veuillez réessayer.");
				System.out.println();
				break;
			}
		}
		
		
	}
	
	public void verifierStock() {
		String message="Voici la quantit� restante de chaques ingr�dient : \n";
		for (Ingredient ingredient : this.listeIngredients ) {
			message+=ingredient.toString()+"\n";
			
		}
		System.out.println(message);
		
	}
}
