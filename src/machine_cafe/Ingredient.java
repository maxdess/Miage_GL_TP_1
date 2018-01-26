package machine_cafe;

public abstract class Ingredient {
	
	String nom;

	int qte;
	
	public Ingredient(int qteDepart){
		this.qte=qteDepart;
	}
	
	public void diminuerStock(int qteBoisson){
		
		this.qte=this.qte-qteBoisson;
		if (this.qte<0) this.qte = 0;
		
	}

	@Override
	public String toString() {
		return "[" + nom + "] : [" + qte + "]";
	}
	
	
	
}
