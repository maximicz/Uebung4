package hs.mannheim_TPE_UIB01_Uebung04;

import java.util.Iterator;

public class IterableCrypter implements Iterable<String> {

	Iterable<String> messages;
	Crypter verschluesselung;

	public IterableCrypter(Iterable<String> messages, Crypter verschluesselung) {

		this.messages = messages;
		this.verschluesselung = verschluesselung;

	}

	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {

			Iterator<String> iterator = messages.iterator();

			@Override
			public boolean hasNext() {

				return iterator.hasNext();
			}

			@Override
			public String next() {

				try {
					return verschluesselung.encrypt(iterator.next());
				} catch (CrypterException e) {

					return "";
				}

			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}

		};
	}
}
