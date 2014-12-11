package hs.mannheim_TPE_UIB01_Uebung04;


/**
 * Eine Factory-Klasse zur Erzeugung von verschiedenen Implementierungsmethoden.
 * In der Factory-Klasse sind ebenfalls die Fehlerbahandlung.
 *
 * @author Sovann Som 1326670
 * @author Maximilian Czerwonka 1415407
 * @author Stephen Kessler 1412750
 * @version JDK8.0
 */
public class CrypterFactory {

	/**
	 * Hier wird eine Verschlüsselungsimplementierung zur Verfügung gestellt.
	 * Mittels switch-case wird anhand des Verschlüsselungsenum die jeweilige
	 * Implementierung ausgewählt. In jedem Case kann eine IllegalKeyException
	 * geworfen werden, falls es Fehler beim Schlüssel gibt.
	 *
	 * @param verschlüsselung
	 *            the verschlüsselung
	 * @param key
	 *            the key
	 * @return the crypter
	 * @throws IllegalKeyException
	 *             the illegal key exception
	 */

	public Crypter createCrypter(VerschlüsselungsEnum verschlüsselung,
			String key) throws IllegalKeyException {

		Crypter newCrypter = null;

		switch (verschlüsselung) {
		case CAESAR:

			if (key.length() == 1) {

				if (key.charAt(0) >= 'A' && key.charAt(0) <= 'Z') {

					newCrypter = new CrypterCaesar(key);
					break;
				}
			}

			throw new IllegalKeyException(
					"Fehlerhafter Schlüssel für Caesar-Verschlüsselung. "
							+ "Verschlüsselung besteht nur aus 1 Key");

		case SUBSTITUTION:

			if (key.length() == 26) {
				newCrypter = new CrypterSubstitution(key);
			} else {

				throw new IllegalKeyException(
						"Schlüssel ist ungültig. Der Schlüssel "
								+ "muss 26 Zeichen lang sein.");
			}

			break;

		case REVERSE:

			newCrypter = new CrypterReverse();

			break;

		case XOR:

			if (key.length() > 0) {

				newCrypter = new CrypterXOR(key);

			} else {
				throw new IllegalKeyException(
						"Der Schüssel für die XOR-Verschlüsselung"
								+ "muss einen Key enthalten");

			}

			break;

		case NULL:

			newCrypter = new CrypterNull();

			break;

		}

		return newCrypter;

	}

}
