package hs.mannheim_TPE_UIB01_Uebung04;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Diese Klasse legt sich um ein beliebgies anderen Iterable und entschluesselt
 * die Eingabe direkt bei der Iteration. Die Klasse implementiert das Interface
 * Iterable<String>.
 * 
 * 
 */

public class IterableDecrypter implements Iterable<String> {

	private List<String> list;
	private Crypter crypt;

	/**
	 * Konstrukor um ein Objekt der Klasse IterableDecrypter zu erzeugen. Hierzu
	 * wird eine Liste, sowie eine Verschluesselungsart angegeben.
	 * 
	 * @param liste
	 *            Die Liste
	 * @param crypt
	 *            die Verschluesselungsart
	 * @throws CrypterException
	 *             Wird geworfen, falls bei der Verschluesselung ein Fehler
	 *             auftritt.
	 */

	public IterableDecrypter(List<String> liste, Crypter crypt)
			throws CrypterException {
		this.list = liste;
		this.crypt = crypt;
	}

	/**
	 * Konstrukor um ein Objekt der Klasse IterableDecrypter zu erzeugen. Hierzu
	 * ein Iterable, sowie eine Verschluesselungsart angegeben.
	 * 
	 * @param iterableCrypt
	 *            das Iterabl
	 * @param crypt
	 *            die Verschluesselungsart
	 * @throws CrypterException
	 *             Wird geworfen, falls bei der Verschluesselung ein Fehler
	 *             auftritt.
	 */

	public IterableDecrypter(Iterable<String> iterableCrypt, Crypter crypt)
			throws CrypterException {
		list = new LinkedList<String>();
		for (String text : iterableCrypt) {
			list.add(text);
		}
		this.crypt = crypt;
	}

	/**
	 * Methode, die eine interne anonyme Klasse beinhaltet, zur Implementierung
	 * des Iterators.
	 */

	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {

			private int pos = 0;

			@Override
			public boolean hasNext() {
				return (pos < list.size());
			}

			@Override
			public String next() {
				try {
					return crypt.decrypt(list.get(pos++));
				} catch (CrypterException e) {
					System.out.println(e.getMessage());
				}
				return null;

			}

		};
	}

}
