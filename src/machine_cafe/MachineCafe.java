package machine_cafe;

import java.util.ArrayList;

public class MachineCafe {

	/**
	 * Stock de chaque ingrédient dans la machine
	 */
	private ArrayList<Ingredient> listeIngredients;
	
	/**
	 * Liste des boissons de la machine
	 */
	public ArrayList<Boisson> listeBoissons;
	
	/**
	 * Constructeur de la classe machine à café
	 */
	public MachineCafe() {
		this.listeIngredients = new ArrayList<Ingredient>();
		this.listeBoissons = new ArrayList<Boisson>();
		
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
		
	}
	
	public void ajouterBoisson() {

	}
	
	public void modifierBoisson() {
		
	}
	
	public void supprimerBoisson() {
		
	}
	
	public void ajouterIngredient() {
		
	}
	
	public void verifierStock() {
		String message="Voici la quantit� restante de chaques ingr�dient : \n";
		for (Ingredient ingredient : this.listeIngredients ) {
			message+=ingredient.toString()+"\n";
			
		}
		System.out.println(message);
		
	}
}
