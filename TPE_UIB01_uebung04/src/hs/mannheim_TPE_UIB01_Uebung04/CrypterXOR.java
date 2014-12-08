package hs.mannheim_TPE_UIB01_Uebung04;

import java.util.List;

public class CrypterXOR implements Crypter {

	private char[] key;
	
	public CrypterXOR(String key) {
		this.key = key.toCharArray();
	}

	@Override
	public String encrypt(String message) throws CrypterException {
	
		char[] message2 = message.toCharArray();
		char[] encryptedMessage = new char[message2.length];
	
		for(int i = 0; i < message2.length; i++) {
			encryptedMessage[i] = (char) (message2[i] ^ key[i % key.length]);
		}
		
		return new String(encryptedMessage);
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}
}

