package machine_cafe;

import java.util.ArrayList;

public class MachineCafe {

	/**
	 * Stock de chaque ingrÃ©dient dans la machine
	 */
	private ArrayList<Ingredient> listeIngredients;
	
	/**
	 * Liste des boissons de la machine
	 */
	public ArrayList<Boisson> listeBoissons;
	
	/**
	 * Constructeur de la classe machine Ã  cafÃ©
	 */
	public MachineCafe() {
		this.listeIngredients = new ArrayList<Ingredient>();
		this.listeBoissons = new ArrayList<Boisson>();
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
		String message="Voici la quantité restante de chaques ingrédient : \n";
		for (Ingredient ingredient : this.listeIngredients ) {
			message+=ingredient.toString()+"\n";
			
		}
		System.out.println(message);
		
	}
}
