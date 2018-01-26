package machine_cafe;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean end = false; // booléen qui permet de quitter l'application
		Scanner sc = new Scanner(System.in); // scanner qui permet de lire le clavier
		MachineCafe machine = new MachineCafe();
		
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
					break;
				case 2: // ajouter boisson
					break;
				case 3: // modifier boisson
					break;
				case 4: // supprimer boisson
					break;
				case 5: // ajouter ingredient
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
		}
		// Affichage à la sortie de la boucle while
		System.out.println("Merci d'avoir utilisé notre machine.");

	}

}
