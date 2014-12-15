package hs.mannheim_TPE_UIB01_Uebung04;

import java.util.Iterator;

/**
 * The Class IterableDecrypter.
 */
public class IterableDecrypter implements Iterable<String> {

	/** The cypher texte. */
	Iterable<String> cypherTexte;
	
	/** The verschluesselung. */
	Crypter verschluesselung;

	/**
	 * Instantiates a new iterable decrypter.
	 *
	 * @param cypherTexte the cypher texte
	 * @param verschluesselung the verschluesselung
	 */
	public IterableDecrypter(Iterable<String> cypherTexte,
			Crypter verschluesselung) {

		this.cypherTexte = cypherTexte;
		this.verschluesselung = verschluesselung;

	}

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */

	public Iterator<String> iterator() {
		return new Iterator<String>() {

			Iterator<String> iterator = cypherTexte.iterator();

			public boolean hasNext() {

				return iterator.hasNext();
			}

			public String next() {

				try {
					return verschluesselung.decrypt(iterator.next());
				} catch (CrypterException e) {

					System.out.println(e.getMessage());
					return "";
				}

			}

		};
	}

}
