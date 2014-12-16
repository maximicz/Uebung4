package hs.mannheim_TPE_UIB01_Uebung4_Test;

import hs.mannheim_TPE_UIB01_Uebung04.Crypter;
import hs.mannheim_TPE_UIB01_Uebung04.CrypterException;
import hs.mannheim_TPE_UIB01_Uebung04.CrypterFactory;
import hs.mannheim_TPE_UIB01_Uebung04.IllegalKeyException;
import hs.mannheim_TPE_UIB01_Uebung04.VerschlüsselungsEnum;

public class Geheimbotschaft {
	
	public static void main(String[] args) throws IllegalKeyException, CrypterException {
		
		String geheimbotschaft = "QOZEG]A[UXDKZIZLAB\\NUQIO^^RXYHADV[EFFJ\\\\[\\U_]YDVZABDZT\\V\\SKB@X";
		Crypter xor = new CrypterFactory().createCrypter(VerschlüsselungsEnum.XOR, "IAMTHEONEWHOKNOCKS");
		Crypter reverse = new CrypterFactory().createCrypter(VerschlüsselungsEnum.REVERSE, "");
		Crypter caesar = new CrypterFactory().createCrypter(VerschlüsselungsEnum.CAESAR, "L");
		Crypter sub = new CrypterFactory().createCrypter(VerschlüsselungsEnum.SUBSTITUTION, "MNBVCXYLKJHGFDSAPOIUZTREWQ");
		
		geheimbotschaft = xor.decrypt(geheimbotschaft);
		geheimbotschaft = reverse.decrypt(geheimbotschaft);
		geheimbotschaft = caesar.decrypt(geheimbotschaft);
		geheimbotschaft = sub.decrypt(geheimbotschaft);
		
		System.out.println(geheimbotschaft);
	}
}
