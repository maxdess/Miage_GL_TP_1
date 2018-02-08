package machine_cafe;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Main {

	public static void main(String[] args) {
		boolean end = false; // booléen qui permet de quitter l'application
		Scanner sc = new Scanner(System.in); // scanner qui permet de lire le clavier
		ObjectInputStream ois;
		MachineCafe machine =null;
		try {
			ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(
									new File("Sauvegarde.txt"))));


			machine=(MachineCafe)ois.readObject();
			ois.close();
		} catch (EOFException e) {
			machine =  new MachineCafe();
		}catch (FileNotFoundException e) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(new File("Sauvegarde.txt")));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}


		if (machine==null){
			machine =  new MachineCafe();
		}

		while (!end) {
			System.out.println("Que voulez-vous faire ? Tapez le numéro de l'action que vous voulez exécuter.");
			System.out.println();
			System.out.println("1 - Acheter une boisson");
			System.out.println("2 - Ajouter une boisson");
			System.out.println("3 - Modifier une boisson");
			System.out.println("4 - Supprimer une boisson");
			System.out.println("5 - Ajouter un ingrédient");
			System.out.println("6 - Vérifier le stock des ingrédients");
			System.out.println("7 - Quitter");
			System.out.println();
			System.out.print("Votre choix : ");
			String reponse = sc.nextLine();
			System.out.println();

			int choix = -1;
			try {
				choix = Integer.parseInt(reponse);

				switch(choix) {
				case 1: // acheter boisson
					machine.acheterBoisson();
					break;
				case 2: // ajouter boisson
					machine.ajouterBoisson();
					break;
				case 3: // modifier boisson
					machine.modifierBoisson();
					break;
				case 4: // supprimer boisson
					machine.supprimerBoisson();
					break;
				case 5: // ajouter ingredient
					machine.ajouterIngredient();
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
			catch(Exception e) {
				System.err.println("Veuillez entrer un nombre valide, de type 1, 2, ..., 7.");
				System.out.println();
			}
			machine.sauvegarder(); 
		}
		// Affichage à la sortie de la boucle while
		System.out.println("Merci d'avoir utilisé notre machine.");

	}

}
