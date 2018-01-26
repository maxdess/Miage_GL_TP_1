package machine_cafe;

import java.util.Scanner;

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

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	@Override
	public String toString() {
		return "[" + nom + "] : [" + qte + "]";
	}
	
	public void remplir(){
		Scanner sc = new Scanner(System.in);
		System.out.println("La quantité actuelle de "+this.nom+" est de "+this.qte+" .");
		System.out.println("Combien d'unité de "+this.nom+"voulez-vous ajouter ?");
		String s=sc.nextLine();
		int i= Integer.parseInt(s);
		if(i>0){
			this.qte+=i;
		}
		if(i>100){
			this.qte=100;
		}
	}
	
	
}
