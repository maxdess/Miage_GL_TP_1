package machine_cafe;

import java.io.Serializable;
import java.util.HashMap;

public class Boisson implements Serializable, Cloneable {
	
	/**
	 * Nom de la boisson
	 */
	private String nom;
	
	/**
	 * Prix de la boisson
	 */
	private int prix;
	
	/**
	 * Quantit√© utilis√©e pour chaque ingr√©dient
	 */
	private HashMap<Ingredient, Integer> nbUnitesIngredient;
	
	/**
	 * Constructeur Boisson
	 * 
	 * @param n
	 * 			nom de la boisson
	 * @param p
	 * 			prix de la boisson
	 * @param recette
	 * 			quantit√© pour chaque ingr√©dient
	 */
	public Boisson(String n, int p, HashMap<Ingredient, Integer> recette) {
		this.nom = n;
		this.prix = p;
		this.nbUnitesIngredient = recette;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prix
	 */
	public int getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(int prix) {
		this.prix = prix;
	}

	/**
	 * @return the nbUnitesIngredient
	 */
	public HashMap<Ingredient, Integer> getNbUnitesIngredient() {
		return nbUnitesIngredient;
	}

	/**
	 * @param nbUnitesIngredient the nbUnitesIngredient to set
	 */
	public void setNbUnitesIngredient(HashMap<Ingredient, Integer> nbUnitesIngredient) {
		this.nbUnitesIngredient = nbUnitesIngredient;
	}
	
	public Object clone() {
		Object o = null;
		try {
			// On rÈcupËre l'instance ‡ renvoyer par l'appel de la 
			// mÈthode super.clone()
			o = super.clone();
		} catch(CloneNotSupportedException cnse) {
			// Ne devrait jamais arriver car nous implÈmentons 
			// l'interface Cloneable
			cnse.printStackTrace(System.err);
		}
		// on renvoie le clone
		return o;
	}
	
}
