package hs.mannheim_TPE_UIB01_Uebung04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The Class IterableCrypter.
 *
 * @author Sovann Som 1326670
 * @author Maximilian Czerwonka 1415407
 * @author Stephen Kessler 1412750
 * @version JDK8.0
 */

public class IterableCrypter implements Iterable<String> {

	/** The messages. */
	private List <String> messages = new ArrayList<String>();
	
	/** The verschluesselung. */
	Crypter verschluesselung;

	/**
	 * Instantiates a new iterable crypter.
	 *
	 * @param messages the messages
	 * @param verschluesselung the verschluesselung
	 */
	public IterableCrypter(List<String> messages, Crypter verschluesselung) {

		this.messages = messages;
		this.verschluesselung = verschluesselung;

	}

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {

			Iterator<String> iterator = messages.iterator();

			public boolean hasNext() {

				return iterator.hasNext();
			}


			public String next() {

				try {
					return verschluesselung.encrypt(iterator.next());
				} catch (CrypterException e) {
					System.out.println(e.getMessage());
					return "";
				}

			}

		};
	}
}
