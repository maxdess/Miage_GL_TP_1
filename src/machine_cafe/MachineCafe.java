package machine_cafe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MachineCafe {

	/**
	 * Stock de chaque ingrédient dans la machine
	 */
	private HashMap<Ingredient, Integer> listeIngredients;

	/**
	 * Liste des boissons de la machine
	 */
	private ArrayList<Boisson> listeBoissons;
	
	public static int NB_BOISSONS_MAX = 3;

	/**
	 * Scanner pour lire les commandes au clavier
	 */
	private Scanner sc;

	/**
	 * Constructeur de la classe machine Ã  cafÃ©
	 */
	public MachineCafe() {
		this.listeIngredients = new HashMap<Ingredient, Integer>();
		this.listeBoissons = new ArrayList<Boisson>(NB_BOISSONS_MAX);
		this.sc = new Scanner(System.in);

		int quantiteInitiale = 100; // QuantitÃ© initiale de chaque ingrÃ©dient

		// CrÃ©ation des ingrÃ©dients
		Ingredient lait = new Lait();
		Ingredient cafe = new Cafe();
		Ingredient chocolat = new Chocolat();
		Ingredient sucre = new Sucre();

		// Ajout des ingrÃ©dients Ã  la machine
		this.listeIngredients.put(cafe, quantiteInitiale);
		this.listeIngredients.put(lait, quantiteInitiale);
		this.listeIngredients.put(chocolat, quantiteInitiale);
		this.listeIngredients.put(sucre, quantiteInitiale);


		// Création des boissons
		HashMap<Ingredient, Integer> recette = new HashMap<Ingredient, Integer>();
		recette.put(cafe, 3);
		recette.put(sucre, 2);
		Boisson boisson1 = new Boisson("CafÃ©", 1, recette);

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

		// Ajout des boissons Ã  la machine
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
		System.out.println(this.listeBoissons.size() + 1 + " - Annuler");
		System.out.println();
		System.out.print("Votre choix : ");
		String reponse = sc.nextLine();
		System.out.println();

		int choix = -1;
		try {
			choix = Integer.parseInt(reponse) - 1;
			if (choix >= 0 && choix <= this.listeBoissons.size()) {
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
		if (this.listeBoissons.size() >= NB_BOISSONS_MAX) {
			System.err.println("Le nombre maximum de boissons est atteint. Veuillez en supprimer une avant d'en ajouter une nouvelle.");
		}
		else {
			System.out.println("Quelle boisson souhaitez-vous ajouter ? Entrez le nom de la boisson.");
			System.out.println();
			System.out.print("Votre choix : ");
			String boisson = sc.nextLine();
			System.out.println();
			
			boolean valide = false;
			int prix = -1;
			while (!valide) {
				try {
					System.out.println("Quel est son prix (un entier) ?");
					System.out.println();
					System.out.print("Votre choix : ");
					String choix = sc.next();
					prix = Integer.parseInt(choix);	
					valide = true;
				}
				catch (Exception e) {
					System.err.println("Le prix n'est pas un entier.");
				}
			}
			
			HashMap<Ingredient, Integer> recette = new HashMap<Ingredient, Integer>();
			
			for (Ingredient i : this.listeIngredients.keySet()) {
				valide = false;
				while (!valide) {
					try {
						System.out.println(" Choisissez la quantité de : " + i.getNom());
						System.out.print("Votre choix : ");
						String res = sc.next();
						int quantite = Integer.parseInt(res);
						valide = true;
						recette.put(i, quantite);
					}
					catch (Exception e) {
						System.err.println("Merci de renseigner la bonne quantité.");
					}
				}
			}
			Boisson nouvelleBoisson = new Boisson(boisson, prix, recette);
			this.listeBoissons.add(nouvelleBoisson);
		}
	}

	public void modifierBoisson() {

	}

	public void supprimerBoisson() {
		System.out.println("Quelle boisson souhaitez-vous supprimer ? Tapez le numéro de l'action que vous voulez acheter.");
		System.out.println();
		for (Boisson b : this.listeBoissons) {
			System.out.println((this.listeBoissons.indexOf(b) + 1) + " - " + b.getNom());
		}
		System.out.println(this.listeBoissons.size() + 1 + " - Annuler");
		System.out.println();
		System.out.print("Votre choix : ");
		String reponse = sc.nextLine();
		System.out.println();

		int choix = -1;
		try {
			choix = Integer.parseInt(reponse) - 1;
			if (choix >= 0 && choix <= this.listeBoissons.size()) {
				this.listeBoissons.remove(choix);
				System.out.println("Votre boisson a bien été supprimée.");
			} else {
				System.err.println("Votre choix est incorrect.");
			}
		}catch(Exception e) {
			System.err.println("Veuillez entrer un nombre correct.");
		}

	}

	public void ajouterIngredient() {

		System.out.println("Quel ingredient voulez-vous ajouter ? ");
		System.out.println();
		System.out.println("1 - Cafe");
		System.out.println("2 - Lait");
		System.out.println("3 - Chocolat");
		System.out.println("4 - Sucre");
		System.out.println("5 - Retour au menu");
		System.out.println();
		System.out.print("Votre choix : ");
		System.out.println();

		String reponse = this.sc.nextLine();

		int choix = -1;

		try {
			choix = Integer.parseInt(reponse);

			switch(choix) {
			case 1: 
				this.remplir("Cafe");
				break;
			case 2: 
				this.remplir("Lait");
				break;
			case 3: 
				this.remplir("Chocolat");
				break;
			case 4: 
				this.remplir("Sucre");
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

	public void remplir(String ing){

		Set set = this.listeIngredients.entrySet();
		Iterator iterator = set.iterator();
		boolean finish=false;
		Map.Entry ingredient=null;

		while(iterator.hasNext() && finish==false) {

			Map.Entry mentry = (Map.Entry)iterator.next();
			System.out.println(mentry.getKey());
			if(((Ingredient)mentry.getKey()).getNom().equals(ing)){
				finish=true;
				ingredient=mentry;
				System.out.println("ok");
			}
		}


		System.out.println("La quantité actuelle de "+ ingredient.getKey()+" est de "+ ingredient.getValue()+" .");
		System.out.println();
		System.out.println("Combien d'unité de "+ingredient.getKey()+" voulez-vous ajouter ?");
		String s=this.sc.nextLine();
		int i= Integer.parseInt(s);

		if(i>0){
			ingredient.setValue(i+(int)ingredient.getValue());
		}
		if(i>100){
			ingredient.setValue(100);
		}

	}


	public void diminuerStock(Ingredient i, int quantite) {
		// On récupère la quantité dans la machine
		int quantiteInitiale = this.listeIngredients.get(i);
		// On diminue le stock dans la machine
		int nouvelleQuantite = quantiteInitiale - quantite;
		if (nouvelleQuantite < 0) {
			nouvelleQuantite = 0;
		}
		// On met à jour à jour la valeur
		this.listeIngredients.put(i, nouvelleQuantite);
	}


	public void verifierStock() {
		// Message initial
		String message="Voici la quantité restante de chaques ingrédient : \n";

		// Pour chaque ingrédient de la machine
		for(Entry<Ingredient, Integer> entry : this.listeIngredients.entrySet()) {
			Ingredient ingredient = entry.getKey();
			Integer quantite = entry.getValue();
			// On affiche l'ingrédient et la quantité restante
			message += ingredient.getNom() + " : " + quantite + " unité(s) restante(s)\n";
		}
		System.out.println(message);
	}

	public void demanderPaiement(Boisson b) {
		System.out.println("Votre boisson " + b.getNom() + " coÃ»te " + b.getPrix() + "â‚¬.");
		System.out.println("Veuillez entrer votre monnaie.");


		System.out.println();
		System.out.print("Votre choix : ");

		String monnaie = this.sc.nextLine();		
		int montant = -1;
		try {
			montant = Integer.parseInt(monnaie);
			if (montant >= b.getPrix()) {
				System.out.println("Voici votre boisson !");
				this.consommerBoisson(b);
			} else {
				System.err.println("Vous n'avez pas entré assez d'argent.");
			}
		}
		catch(Exception e) {
			System.err.println("Veuillez entrer un nombre correct.");
		}

	}

	public void consommerBoisson(Boisson b) {
		int index = this.listeBoissons.indexOf(b);

		for(Entry<Ingredient, Integer> entry : this.listeBoissons.get(index).getNbUnitesIngredient().entrySet()) {
			Ingredient ingredient = entry.getKey();
			Integer quantite = entry.getValue();
			this.diminuerStock(ingredient, quantite);
		}

	}

}
