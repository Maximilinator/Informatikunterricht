/*
 *  @authorMaximilianGrossmann
 *  @version1.0
 */

package carDriving;

public class Auto {

	private int tempo;
	private int maxTempo;
	private boolean motorAn;
	private boolean lichtAn;
	private String autoMarke;

	public void auto(int tempo, int maxTempo, boolean motorAn, boolean lichtAn, String autoMarke) {
		this.tempo = tempo;
		this.maxTempo = maxTempo;
		this.motorAn = motorAn;
		this.lichtAn = lichtAn;
		this.autoMarke = autoMarke;

	}

}
