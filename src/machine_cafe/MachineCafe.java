package machine_cafe;

import java.util.List;

public class MachineCafe {

	/**
	 * Stock de chaque ingrédient dans la machine
	 */
	private List<Ingredient> listeIngredients;
	
	/**
	 * Liste des boissons de la machine
	 */
	public List<Boisson> listeBoissons;
	
	/**
	 * Constructeur de la classe machine à café
	 */
	public MachineCafe() {
		this.listeIngredients = new List<Ingredient>();
		this.listeBoissons = new List<Boisson>();
	}
	
	/**
	 * @return the listeIngredients
	 */
	public List<Ingredient> getListeIngredients() {
		return listeIngredients;
	}



	/**
	 * @param listeIngredients the listeIngredients to set
	 */
	public void setListeIngredients(List<Ingredient> listeIngredients) {
		this.listeIngredients = listeIngredients;
	}



	/**
	 * @return the listeBoissons
	 */
	public List<Boisson> getListeBoissons() {
		return listeBoissons;
	}



	/**
	 * @param listeBoissons the listeBoissons to set
	 */
	public void setListeBoissons(List<Boisson> listeBoissons) {
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
		
	}
}
