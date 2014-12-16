package hs.mannheim_TPE_UIB01_Uebung4_Test;

import hs.mannheim_TPE_UIB01_Uebung04.Crypter;
import hs.mannheim_TPE_UIB01_Uebung04.CrypterException;
import hs.mannheim_TPE_UIB01_Uebung04.CrypterFactory;
import hs.mannheim_TPE_UIB01_Uebung04.IterableCrypter;
import hs.mannheim_TPE_UIB01_Uebung04.IterableDecrypter;
import hs.mannheim_TPE_UIB01_Uebung04.VerschlüsselungsEnum;

import java.util.Arrays;
import java.util.List;



public class IterableCryptoDemo {

	public static void main(String[] args) throws CrypterException {

		Crypter caesar = new CrypterFactory().createCrypter(VerschlüsselungsEnum.CAESAR,"U");
		Crypter xor = new CrypterFactory().createCrypter(VerschlüsselungsEnum.XOR, "TPEISTCOOL"
				);

		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");

		IterableCrypter iterableCrypter = new IterableCrypter(
				new IterableCrypter(liste, caesar), xor);

		for (String cypherText : iterableCrypter) {
			System.out.println(cypherText);
		}
		System.out.println("------------------------------------------------");

		List<String> liste2 = Arrays.asList("MT_G", "P^J", "NTL", "[JKF");

		IterableDecrypter iterableDecrypter = new IterableDecrypter(
				new IterableDecrypter(liste2, xor), caesar);

		for (String message : iterableDecrypter) {
			System.out.println(message);
		}
	}
}
