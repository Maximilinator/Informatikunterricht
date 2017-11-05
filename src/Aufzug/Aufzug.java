/*
 * @author M. Großmann
 * @version 1.1
 */

package Aufzug;

public class Aufzug {

	private boolean tuerAuf = false;
	private int maxEtage = 0;
	private int minEtage = 0;
	private int aktuelleEtage = 0;
	private int maxPersonen = 0;
	private int aktuellePersonen = 0;

	@Override
	public String toString() {
		return "\nTürstatus: " + tuerAuf + "\n" + "Maximale Etage: " + maxEtage + "\n" + "Minimale Etage: " + minEtage
				+ "\n" + "Aktuelle Etage: " + aktuelleEtage + "\n" + "Maximale Personen: " + maxPersonen + "\n"
				+ "Aktuelle Anzahl an Personen: " + aktuellePersonen + "\n";
	}

	public Aufzug(int maxEtage, int minEtage, int maxPersonen) {
		this.maxEtage = maxEtage;
		this.minEtage = minEtage;
		this.maxPersonen = maxPersonen;
	}

	public void fahreAuf(int etage) {
		if (tuerAuf == false) {
			if (etage <= maxEtage && etage >= minEtage) {
				aktuelleEtage = etage;
				fahrstuhlstimme(aktuelleEtage);
				machTuerAufOderZu();
			} else {
				System.out.println("(!) Diese Etage existiert nicht!");
			}
		} else {
			System.out.println("(!) Der Aufzug kann bei offener Tür nicht in Betrieb genommen werden!");
		}
	}

	public void fahreUm(int etage) {
		if (tuerAuf == false) {
			int ergebnis = aktuelleEtage + etage;
			if (ergebnis <= maxEtage && ergebnis >= minEtage) {
				aktuelleEtage = ergebnis;
				fahrstuhlstimme(aktuelleEtage);
				machTuerAufOderZu();
			} else {
				System.out.println("(!) Diese Etage existiert nicht!");
			}
		} else {
			System.out.println("(!) Die Aufzug kann bei offener Tür nicht in Betrieb genommen werden!");
		}
	}

	public boolean gibTuerStatus() {
		System.out.println("Türstatus: " + tuerAuf);
		return tuerAuf;
	}

	public boolean machTuerAufOderZu() {
		if (tuerAuf == false) {
			System.out.println("Tür öffnet...");
			tuerAuf = true;
		} else {
			System.out.println("Tür schließt...");
			tuerAuf = false;
		}
		return tuerAuf;
	}

	public int gibPersonen() {
		System.out.println("Aktuelle Anzahl an Personen: " + aktuellePersonen);
		return aktuellePersonen;
	}

	public int gibEtage() {
		System.out.println("Aktuelle Etage: " + aktuelleEtage);
		return aktuelleEtage;
	}

	public int gibMaxEtage() {
		System.out.println("Maximale Etage: " + maxEtage);
		return maxEtage;
	}

	public int gibMaxPersonen() {
		System.out.println("Maximale Personen: " + maxPersonen);
		return maxPersonen;
	}

	public int gibMinEtage() {
		System.out.println("Minimale Etage: " + minEtage);
		return minEtage;
	}

	public int lassPersonenEinsteigen(int einsteigen) {
		if (maxPersonen >= aktuellePersonen + einsteigen) {
			if (tuerAuf == false) {
				machTuerAufOderZu();
			} else {
			}
			aktuellePersonen += einsteigen;
			System.out.println(einsteigen + " Personen sind erfolgreich eingestiegen!");
			machTuerAufOderZu();
			gibPersonen();
		} else {
			System.out.println("(!) Höchstanzahl an Personen überschritten");
			gibMaxPersonen();
			gibPersonen();
		}
		return einsteigen;
	}

	public int lassPersonenAussteigen(int aussteigen) {
		if (aktuellePersonen >= aussteigen) {
			if (tuerAuf == false) {
				machTuerAufOderZu();
			} else {
			}
			aktuellePersonen -= aussteigen;
			System.out.println(aussteigen + " Personen sind erfolgreich ausgestiegen!");
			machTuerAufOderZu();
			gibPersonen();
		} else {
			System.out.println("(!) So viele Personen befinden sich nicht im Aufzug!");
		}
		return aussteigen;
	}

	private void fahrstuhlstimme(int input) {
		System.out.print("Fahrstuhl: ");
		if (input == 0) {
			System.out.println("*Bing* Erdgeschoss");
		} else if (input < 0) {
			int inputKleinerNull = input * (-1);
			System.out.println("*Bing* " + inputKleinerNull + "tes Untergeschoss");
		} else if (input > 0) {
			System.out.println("*Bing* " + input + "tes Obergeschoss");
		}
	}

	public void setTuerAuf(boolean jaNein) {
		tuerAuf = jaNein;
	}
}
