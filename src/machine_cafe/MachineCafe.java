package machine_cafe;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


public class MachineCafe implements Serializable{

	/**
	 * Stock de chaque ingrédient dans la machine
	 */
	private HashMap<Ingredient, Integer> listeIngredients;

	/**
	 * Liste des boissons de la machine
	 */
	private ArrayList<Boisson> listeBoissons;

	/**
	 * Nombre maximum de boissons dans la machine
	 */
	public static int NB_BOISSONS_MAX = 5;

	/**
	 * Scanner pour lire les commandes au clavier
	 */
	private static Scanner sc=new Scanner(System.in);


	/**
	 * Constructeur de la classe machine à café
	 */
	public MachineCafe() {
		this.listeIngredients = new HashMap<Ingredient, Integer>();
		this.listeBoissons = new ArrayList<Boisson>(NB_BOISSONS_MAX);
		this.sc = new Scanner(System.in);

		int quantiteInitiale = 100; // Quantité initiale de chaque ingrédient

		// Création des ingrédients
		Ingredient lait = new Lait();
		Ingredient cafe = new Cafe();
		Ingredient chocolat = new Chocolat();
		Ingredient sucre = new Sucre();

		// Ajout des ingrédients Ã  la machine
		this.listeIngredients.put(cafe, quantiteInitiale);
		this.listeIngredients.put(lait, quantiteInitiale);
		this.listeIngredients.put(chocolat, quantiteInitiale);
		this.listeIngredients.put(sucre, quantiteInitiale);


		// Création des boissons
		HashMap<Ingredient, Integer> recette = new HashMap<Ingredient, Integer>();
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
		
		recette = new HashMap<Ingredient, Integer>();
		recette.put(cafe, 3);
		recette.put(lait, 2);
		recette.put(sucre, 2);
		Boisson boisson4 = new Boisson("Café au lait", 4, recette);

		recette = new HashMap<Ingredient, Integer>();
		recette.put(cafe, 3);
		recette.put(chocolat, 2);
		recette.put(sucre, 2);
		Boisson boisson5 = new Boisson("Moca", 5, recette);

		// Ajout des boissons à la machine
		this.listeBoissons.add(boisson1);
		this.listeBoissons.add(boisson2);
		this.listeBoissons.add(boisson3);
		this.listeBoissons.add(boisson4);
		this.listeBoissons.add(boisson5);
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


	/**
	 * Méthode qui permet d'acheter une boisson de la machine à café
	 */
	public void acheterBoisson() {
		String message = "Quelle boisson souhaitez-vous acheter ? Tapez le numéro de l'action que vous voulez acheter. \n";

		for (Boisson b : this.listeBoissons) {
			message += (this.listeBoissons.indexOf(b) + 1) + " - " + b.getNom() + "\n";
		}

		message += 	this.listeBoissons.size() + 1 + " - Annuler\n";
		System.out.println(message);

		int choix = -1;
		boolean valide = false;

		while (!valide) {
			try {
				System.out.print("Votre choix : ");
				String reponse = sc.nextLine();
				System.out.println();

				choix = Integer.parseInt(reponse) - 1;

				// Si on choisit une boisson on demande le paiement
				if (choix >= 0 && choix < this.listeBoissons.size()) {
					valide = true;
					this.demanderPaiement(this.listeBoissons.get(choix));
				}
				// Si on annule on retourne au menu principal
				else if (choix == this.listeBoissons.size()) {
					valide = true;
				}
				// Sinon on affiche une erreur et on redemande
				else {
					System.err.println("Votre choix est incorrect.");
				}
			}
			catch(Exception e) {
				System.err.println("Veuillez entrer un nombre correct.");
			}
		}
	}


	/**
	 * Méthode qui permet d'ajouter une boisson à la machine à café
	 */
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
			
			boolean dejaPresent = false;
			int compteur = 0; 
			while (!dejaPresent && compteur < this.listeBoissons.size()) {
				if (this.listeBoissons.get(compteur).getNom().equals(boisson)) {
					dejaPresent = true;
				}
				compteur++;
			}
			
			if (dejaPresent) {
				System.err.println("Une boisson portant ce nom existe déjà, ajout annulé.");
			}
			else {
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
	}


	/**
	 * Méthode qui permet de modifier une boisson de la machine à café
	 */
	public void modifierBoisson() {
		String message = "Quelle boisson souhaitez-vous modifier ? Tapez le numéro de la boisson à modifier. \n";

		for (Boisson b : this.listeBoissons) {
			message += (this.listeBoissons.indexOf(b) + 1) + " - " + b.getNom() + "\n";
		}

		message += 	this.listeBoissons.size() + 1 + " - Annuler\n";
		System.out.println(message);

		int choix = -1;
		boolean valide = false;

		while (!valide) {
			try {
				System.out.print("Votre choix : ");
				String reponse = sc.nextLine();
				System.out.println();

				choix = Integer.parseInt(reponse) - 1;

				// Si on choisit une boisson on passe à la suite du programme
				if (choix >= 0 && choix < this.listeBoissons.size()) {
					valide = true;

					// On crée la nouvelle recette
					HashMap<Ingredient, Integer> recette = new HashMap<Ingredient, Integer>();


					// Pour chaque ingrédient on demande la nouvelle quantité
					for(Entry<Ingredient, Integer> entry : this.listeBoissons.get(choix).getNbUnitesIngredient().entrySet()) {
						Ingredient ingredient = entry.getKey();
						Integer quantite = entry.getValue();
						// On affiche l'ingrédient et la quantité restante
						message = "La quantité actuelle de " + ingredient.getNom() + " est : " + quantite + " unité(s) restante(s)\n";
						System.out.println(message);
						int nouvelleQuantite = -1;
						valide = false;
						while (!valide) {
							message = "Quelle quantité souhaitez-vous ?\n";
							message += "Votre choix : ";
							System.out.print(message);

							reponse = sc.next();
							System.out.println();

							try {
								nouvelleQuantite = Integer.parseInt(reponse);
								valide = true;
							}
							catch (Exception e) {
								System.err.println("Veuillez entrer un nombre valide");
							}
						}
						recette.put(ingredient, nouvelleQuantite);
					}
					// On remplace l'ancienne recette par la nouvelle
					this.listeBoissons.get(choix).setNbUnitesIngredient(recette);
				}
				// Si on annule on retourne au menu principal
				else if (choix == this.listeBoissons.size()) {
					valide = true;
				}
				// Sinon on affiche une erreur et on redemande
				else {
					System.err.println("Votre choix est incorrect.");
				}
			}
			catch(Exception e) {
				System.err.println("Veuillez entrer un nombre correct.");
			}
		}
	}


	/**
	 * Méthode qui permet de supprimer une boisson de la machine à café
	 */
	public void supprimerBoisson() {
		String message = "Quelle boisson souhaitez-vous supprimer ? Tapez le numéro de la boisson à supprimer.\n";
		for (Boisson b : this.listeBoissons) {
			message += (this.listeBoissons.indexOf(b) + 1) + " - " + b.getNom() + "\n";
		}
		message += this.listeBoissons.size() + 1 + " - Annuler\n";
		System.out.println(message);

		boolean valide = false;
		int choix = -1;

		while (!valide) {
			System.out.print("Votre choix : ");
			String reponse = sc.nextLine();
			System.out.println();

			try {
				choix = Integer.parseInt(reponse) - 1;
				if (choix >= 0 && choix < this.listeBoissons.size()) {
					valide = true;
					// On supprime la boisson
					this.listeBoissons.remove(choix);
					System.out.println("Votre boisson a bien été supprimée.");
				}
				else if (choix == this.listeBoissons.size()) {
					valide = true;
				}
				else {
					System.err.println("Votre choix est incorrect.");
				}
			}catch(Exception e) {
				System.err.println("Veuillez entrer un nombre correct.");
			}
		}
	}


	/**
	 * Méthode qui permet de remplir un ingrédient de la machine à café
	 */
	public void ajouterIngredient() {
		int compteur = 1;
		String message = "Quel ingrédient souhaitez-vous remplir ?\n";
		
		for(Entry<Ingredient, Integer> entry : this.listeIngredients.entrySet()) {
			Ingredient ingredient = entry.getKey();
			Integer quantite = entry.getValue();
			message += compteur + " - " + ingredient.getNom() + "\n";
			compteur++;
		}
		
		message += compteur + " - Annuler\n";
		System.out.println(message);
		
		
		System.out.print("Votre choix : ");
		System.out.println();

		String reponse = sc.nextLine();
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
			if(((Ingredient)mentry.getKey()).getNom().equals(ing)){
				finish=true;
				ingredient=mentry;
			}
		}


		System.out.println("La quantité actuelle de "+ ingredient.getKey()+" est de "+ ingredient.getValue()+" .");
		System.out.println();
		System.out.println("Combien d'unité de "+ingredient.getKey()+" voulez-vous ajouter ?");
		try{
			String s=this.sc.nextLine();
			int i= Integer.parseInt(s);

			if(i>0){
				ingredient.setValue(i+(int)ingredient.getValue());
			}
			if((int)ingredient.getValue()>100){
				ingredient.setValue(100);
			}

		}catch(Exception e) {
			System.err.println("Veuillez entrer un nombre valide, de type 1, 2, ..., 100.");
			System.out.println();
		}

	}


	/**
	 * Méthode qui permet de vérifier les stocks des ingrédients de la machine
	 */
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


	/**
	 * Méthode qui demander à l'utilisateur de payer lors de lachat d'une boisson
	 * 
	 * @param b
	 * 			boisson que l'utilisateur souhaite acheter
	 */
	public void demanderPaiement(Boisson b) {
		System.out.println("Votre boisson " + b.getNom() + " coûte " + b.getPrix() + "€.");
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

	/**
	 * Méthode qui permet de consommer une boisson lorsqu'on l'achète
	 * 
	 * @param b
	 */
	public void consommerBoisson(Boisson b) {
		int index = this.listeBoissons.indexOf(b);

		for(Entry<Ingredient, Integer> entry : this.listeBoissons.get(index).getNbUnitesIngredient().entrySet()) {
			Ingredient ingredient = entry.getKey();
			Integer quantite = entry.getValue();
			this.diminuerStock(ingredient, quantite);
		}
	}


	/**
	 * Méthode qui permet de diminuer le stock d'un ingrédient dans la machine
	 * 
	 * @param i
	 * 			ingrédient à diminuer
	 * @param quantite
	 * 			quantité du stock à diminuer
	 */
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


	/**
	 * Méthode qui permet de sauvegarder la machine dans un fichier texte
	 */
	public void sauvegarder(){
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									new File("Sauvegarde.txt"))));
			oos.writeObject(this);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}

}
