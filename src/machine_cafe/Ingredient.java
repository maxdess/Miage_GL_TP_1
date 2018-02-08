package machine_cafe;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Ingredient implements Serializable {
	
	protected String nom;
	
	public Ingredient(){
		
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

	@Override
	public String toString() {
		return nom ;
	}
	
	
}
