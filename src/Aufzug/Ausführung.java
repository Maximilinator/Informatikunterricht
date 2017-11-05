package Aufzug;

import java.util.Scanner;

public class Ausführung {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			int maxEtage = eingabeMitInt(sc, "Maximale Etage: ");
			int minEtage = eingabeMitInt(sc, "Minimale Etage: ");
			int maxPersonen = eingabeMitInt(sc, "Maximale Personen: ");

			Aufzug aufzug = new Aufzug(maxEtage, minEtage, maxPersonen);

			System.out.println("Befehlszeile für Aufzug ('help' für Hilfe): ");

			String eingabe = "";
			while (!"Stop".equalsIgnoreCase(eingabe)) {
				if ("".equals(eingabe) || "Um".equals(eingabe) || "Auf".equals(eingabe)
						|| "Einsteigen".equals(eingabe) || "Aussteigen".equalsIgnoreCase(eingabe)) {
					eingabe = eingabeMitPrompt(sc, "Befehl eingeben: ");
				} else {
					eingabe = eingabeMitPrompt2(sc, "Befehl eingeben: ");
				}
				switch (eingabe) {
				case "Info":
					System.out.println("---------------Info---------------");
					System.out.println(aufzug);
					break;
				case "Türstatus":
					aufzug.gibTuerStatus();
					break;
				case "Tür":
					aufzug.machTuerAufOderZu();
					break;
				case "Auf":
					int eingabeAuf = eingabeMitInt(sc, "Auf welche Etage soll der Aufzug fahren? ");
					aufzug.fahreAuf(eingabeAuf);
					break;
				case "Um":
					int eingabeUm = eingabeMitInt(sc, "Um wieviele Etagen soll der Aufzug sich bewegen? ");
					aufzug.fahreUm(eingabeUm);
					break;
				case "Personen":
					aufzug.gibPersonen();
					break;
				case "Etage":
					aufzug.gibEtage();
					break;
				case "maxPersonen":
					aufzug.gibMaxPersonen();
					break;
				case "maxEtage":
					aufzug.gibMaxEtage();
					break;
				case "minEtage":
					aufzug.gibMinEtage();
					break;
				case "Einsteigen":
					aufzug.lassPersonenEinsteigen(eingabeMitInt(sc, "Wieviele Personen sollen einsteigen? "));
					break;
				case "Aussteigen":
					aufzug.lassPersonenAussteigen(eingabeMitInt(sc, "Wieviele Personen sollen aussteigen? "));
					break;
				case "Stop":
					System.out.println("Programm wird beendet...");
					System.out.println("Programm erfolgreich beendet!");
					System.exit(0);
				case "help":
					System.out.println(
							"Unterstütze Befehle:\n--> Info: Gibt jegliche Informationen zum Aufzug an\n--> Türstatus: Gibt Türstatus an (auf/zu)\n--> Tür: Öffnet bzw. schließt die Tür\n"
									+ "--> Auf: Der Aufzug fährt auf die angegebene Etage\n--> Um: Der Aufzug fährt um x Etagen\n--> Personen: Gibt aktuelle Personenzahl im Aufzug an\n"
									+ "--> Etage: Gibt die aktuelle Etage an\n--> maxPersonen: Gibt die maximale Anzahl an Personen für den Aufzug an\n--> maxEtage: Gibt die oberste Etage an\n"
									+ "--> minEtage: Gibt die unterste Etage an\n --> Einsteigen: Lässt angegebene Anzahl an Personen in den Aufzug einsteigen\n"
									+ "--> Aussteigen: Lässt angegebene Anzahl an Personen in den Aufzug aussteigen\n--> Stop: Stoppt das Programm");
					break;
				default:
					System.out.println("(!) Keinen Befehl namens '" + eingabe + "' gefunden!");
				}
			}
		} catch (Exception e) {
			System.out.println("Fehler! " + e.getMessage());
		}
		sc.close();

		System.out.println("Programm wird beendet...");
		System.out.println("Programm erfolgreich beendet!");
	}

	public static String eingabeMitPrompt(Scanner sc, String frage) {
		System.out.print(frage);
		sc.nextLine();
		return sc.nextLine();
	}

	public static String eingabeMitPrompt2(Scanner sc, String frage) {
		System.out.print(frage);
		return sc.nextLine();
	}

	public static int eingabeMitInt(Scanner sc, String angabe) {
		System.out.print(angabe);
		int eingabe = sc.nextInt();
		return eingabe;
	}
}
