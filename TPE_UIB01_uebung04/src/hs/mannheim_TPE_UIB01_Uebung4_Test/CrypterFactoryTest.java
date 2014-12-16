package hs.mannheim_TPE_UIB01_Uebung4_Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import hs.mannheim_TPE_UIB01_Uebung04.Crypter;
import hs.mannheim_TPE_UIB01_Uebung04.CrypterException;
import hs.mannheim_TPE_UIB01_Uebung04.CrypterFactory;
import hs.mannheim_TPE_UIB01_Uebung04.IllegalKeyException;
import hs.mannheim_TPE_UIB01_Uebung04.VerschlüsselungsEnum;

import org.junit.Test;

public class CrypterFactoryTest {

	@Test
	public void CrypterCaesartest() throws CrypterException {
		
		Crypter caesar = new CrypterFactory().createCrypter(
				VerschlüsselungsEnum.CAESAR, "C");
		assertEquals("DEFGHIJKLMNOPQRSTUVWXYZABC",
				caesar.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
				caesar.decrypt("DEFGHIJKLMNOPQRSTUVWXYZABC"));
		assertEquals("FDHVDU", caesar.encrypt("Caesar"));
		assertEquals("CAESAR", caesar.decrypt("FDHVDU"));

		List<String> list = Arrays.asList("ZIEL", "MESSER", "CAESAR");
		List<String> list1 = Arrays.asList("CLHO", "PHVVHU", "FDHVDU");
		assertEquals(list1, caesar.encrypt(list));
		assertEquals(list, caesar.decrypt(list1));
		
	}
	
	
	@Test (expected = CrypterException.class)
	public void testCaesarAusnahme() throws CrypterException {
		
	Crypter caesar =  new CrypterFactory().createCrypter(VerschlüsselungsEnum.CAESAR, "E");
	String falscherString = "jkhk34234s";
	caesar.decrypt(falscherString);
	
	}
		
	
	@Test
	public void CrypterXORTest() throws CrypterException{
		
	Crypter xor = new CrypterFactory().createCrypter(VerschlüsselungsEnum.XOR, "TPERULES");
	assertEquals("URFVPJB[]ZN^XBJCEBVF@ZRKMJ", xor.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
	assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", xor.decrypt("URFVPJB[]ZN^XBJCEBVF@ZRKMJ"));
	assertEquals("L_W", xor.encrypt("XOR"));
	assertEquals("XOR", xor.decrypt("L_W"));
	
	List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
	List<String> liste1 = Arrays.asList("PY@A", "]CQ", "QYK", "@UVF");
	assertEquals(liste1, xor.encrypt(liste));
	assertEquals(liste,xor.decrypt(liste1));

	}
	
	@Test (expected = CrypterException.class)
	public void testXORAusnahme() throws CrypterException {
		
	Crypter xor = new CrypterFactory().createCrypter(VerschlüsselungsEnum.XOR, "TPERULES");
	String falscherString = "jkhk34234s";
	xor.decrypt(falscherString);
	
	}
	
	@Test
	public void CrypterSubstitutionTest() throws CrypterException {
		
		Crypter subs = new CrypterFactory().createCrypter(VerschlüsselungsEnum.SUBSTITUTION, "UFLPWDRASJMCONQYBVTEXHZKGI");
		assertEquals("ZSMSYWPSUSTESNDQVOUESH", subs.encrypt("WIKIPEDIAISTINFORMATIV"));
		assertEquals("WIKIPEDIAISTINFORMATIV", subs.decrypt("ZSMSYWPSUSTESNDQVOUESH"));
		
		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
		List<String> liste1 = Arrays.asList("PSWT", "STE", "WSN", "EWTE");
		assertEquals(liste1, subs.encrypt(liste));
		assertEquals(liste, subs.decrypt(liste1));
	}
	
	@Test
	public void CrypterNullTest() throws CrypterException {
		
		Crypter nullCrypter = new CrypterFactory().createCrypter(VerschlüsselungsEnum.NULL, "TPERULES");
		assertEquals("HALLO", nullCrypter.encrypt("HALLO"));
		assertEquals("HALLO", nullCrypter.decrypt("HALLO"));
		
		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
		List<String> liste1 = Arrays.asList("DIES", "IST", "EIN", "TEST");
		assertEquals(liste1, nullCrypter.encrypt(liste));
		assertEquals(liste, nullCrypter.decrypt(liste1));
	}
	
	@Test
	public void CrypterReverseTest() throws CrypterException {
		
		Crypter reverse = new CrypterFactory().createCrypter(VerschlüsselungsEnum.REVERSE, "TPERULES");
		assertEquals("ZELUREPT", reverse.encrypt("TPERULEZ"));
		assertEquals("TPERULEZ", reverse.decrypt("ZELUREPT"));
		
		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
		List<String> liste1 = Arrays.asList("SEID", "TSI", "NIE", "TSET");
		assertEquals(liste1, reverse.encrypt(liste));
		assertEquals(liste, reverse.decrypt(liste1));
	}
	
	@Test(expected = IllegalKeyException.class)
	public void testIllegalKeyException() throws CrypterException {
	String key = "HALLO";
	Crypter caesar = new CrypterFactory().createCrypter(VerschlüsselungsEnum.CAESAR, key);
	caesar.encrypt("TEST");
	
	}
	
}
