package hs.mannheim_TPE_UIB01_Uebung04;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CrypterSubstitution implements Crypter {
 
	private Map<Character, Character> map = new HashMap<>();
	private String key;
	
	
	public CrypterSubstitution(String key) {
		this.key = key;
	}
	
	@Override
	public String encrypt(String message) throws CrypterException {
		
		 	   
		 	       String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		 	 
		 	       for(int i = 0; i < alphabet.length(); ++i) {
		 	          map.put(alphabet.charAt(i), key.charAt(i));
		 	       }
		 	       
		 	       String a = new String(""); 
		 	       for(int k = 0; k < message.length(); k++) {
		 	    	  char c = message.charAt(k);
		 	    	  a += Character.toString(map.get(c)) ;
		 	       }
		 	       return a;
		 	  
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for (String message : messages) {
			ergebnis.add(encrypt(message));
		}
		return ergebnis;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		 
		String alphabet = "UFLPWDRASJMCONQYBVTEXHZKGI";
	 	 
	       for(int i = 0; i < alphabet.length(); ++i) {
	          map.put(alphabet.charAt(i), key.charAt(i));
	       }
	       
	       String a = new String(""); 
	       for(int k = 0; k < cypherText.length(); k++) {
	    	  char c = cypherText.charAt(k);
	    	  a += Character.toString(map.get(c)) ;
	       }
	       return a;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte) throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for (String message : cypherTexte) {
			ergebnis.add(decrypt(message));
		}
		return ergebnis;
	}

}
