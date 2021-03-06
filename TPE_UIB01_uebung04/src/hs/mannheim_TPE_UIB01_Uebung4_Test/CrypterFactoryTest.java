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

	@Test(expected = IllegalKeyException.class)
	public void testIllegalKeyException() throws CrypterException {
		String key = "17";
		Crypter caesar = new CrypterFactory().createCrypter(
				VerschlüsselungsEnum.CAESAR, key);
		caesar.encrypt("TEST");

	}

	@Test(expected = CrypterException.class)
	public void crypterCaesarAusnahmeMessage() throws CrypterException {
		Crypter caesar = new CrypterFactory().createCrypter(
				VerschlüsselungsEnum.CAESAR, "A");
		Crypter caesar1 = new CrypterFactory().createCrypter(
				VerschlüsselungsEnum.CAESAR, "b");
		Crypter caesar2 = new CrypterFactory().createCrypter(
				VerschlüsselungsEnum.CAESAR, "C");
		caesar.encrypt("!Li/");
		caesar1.decrypt("ab []");

		List<String> liste = Arrays.asList("DIES", "IST", "EI[N", "TEST");
		caesar2.encrypt(liste);
		caesar2.decrypt(liste);
	}

	@Test
	public void crypterXORTest() throws CrypterException {
		Crypter xor = new CrypterFactory().createCrypter(
				VerschlüsselungsEnum.XOR, "TPERULES");
		assertEquals("URFVPJB[]ZN^XBJCEBVF@ZRKMJ",
				xor.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
				xor.decrypt("URFVPJB[]ZN^XBJCEBVF@ZRKMJ"));
		assertEquals("L_W", xor.encrypt("XOR"));
		assertEquals("XOR", xor.decrypt("L_W"));

		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
		List<String> liste1 = Arrays.asList("PY@A", "]CQ", "QYK", "@UVF");

		assertEquals(liste1, xor.encrypt(liste));
		assertEquals(liste, xor.decrypt(liste1));
	}

	@Test
	public void CrypterSubstitutionTest() throws CrypterException {

		Crypter subs = new CrypterFactory()
				.createCrypter(VerschlüsselungsEnum.SUBSTITUTION,
						"UFLPWDRASJMCONQYBVTEXHZKGI");
		assertEquals("ZSMSYWPSUSTESNDQVOUESH",
				subs.encrypt("WIKIPEDIAISTINFORMATIV"));
		assertEquals("WIKIPEDIAISTINFORMATIV",
				subs.decrypt("ZSMSYWPSUSTESNDQVOUESH"));

		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
		List<String> liste1 = Arrays.asList("PSWT", "STE", "WSN", "EWTE");
		assertEquals(liste1, subs.encrypt(liste));
		assertEquals(liste, subs.decrypt(liste1));
	}

	@Test(expected = CrypterException.class)
	public void crypterSubstitutionAusnahmeMessage() throws CrypterException {
		Crypter sub = new CrypterFactory().createCrypter(
				VerschlüsselungsEnum.SUBSTITUTION, "12");
		Crypter sub1 = new CrypterFactory()
				.createCrypter(VerschlüsselungsEnum.SUBSTITUTION,
						"UFLPWDRASJMCONQYBVTEXHZKGI");
		sub.encrypt("as");
		sub1.encrypt("as");
		sub1.encrypt("12");
		sub1.decrypt("HFKS(");

		List<String> liste = Arrays.asList("BA!LD", "SIND");
		sub1.encrypt(liste);
		sub1.decrypt(liste);
	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalKeyException.class)
	public void crypterSubstitutionAusnahmeKey() throws IllegalKeyException {
		Crypter sub1 = new CrypterFactory().createCrypter(
				VerschlüsselungsEnum.SUBSTITUTION, "ASBSDKFE");
		Crypter sub2 = new CrypterFactory().createCrypter(
				VerschlüsselungsEnum.SUBSTITUTION, "12-+sffsddfADJVEMF");

	}

	@Test
	public void CrypterNullTest() throws CrypterException {

		Crypter nullCrypter = new CrypterFactory().createCrypter(
				VerschlüsselungsEnum.NULL, "TPERULES");
		assertEquals("HALLO", nullCrypter.encrypt("HALLO"));
		assertEquals("HALLO", nullCrypter.decrypt("HALLO"));

		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
		List<String> liste1 = Arrays.asList("DIES", "IST", "EIN", "TEST");
		assertEquals(liste1, nullCrypter.encrypt(liste));
		assertEquals(liste, nullCrypter.decrypt(liste1));
	}

	@Test
	public void CrypterReverseTest() throws CrypterException {

		Crypter reverse = new CrypterFactory().createCrypter(
				VerschlüsselungsEnum.REVERSE, "TPERULES");
		assertEquals("ZELUREPT5", reverse.encrypt("5TPERULEZ"));
		assertEquals("TPERULEZ", reverse.decrypt("ZELUREPT"));

		List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
		List<String> liste1 = Arrays.asList("SEID", "TSI", "NIE", "TSET");
		assertEquals(liste1, reverse.encrypt(liste));
		assertEquals(liste, reverse.decrypt(liste1));
	}

}
