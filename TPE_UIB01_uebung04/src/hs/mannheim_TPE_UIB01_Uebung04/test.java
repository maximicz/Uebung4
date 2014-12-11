package hs.mannheim_TPE_UIB01_Uebung04;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class test.
 */
public class test {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws CrypterException the crypter exception
	 */
	public static void main(String[] args) throws CrypterException {

		
		List<String> list = new ArrayList<String>();
		list.add("Ziel");
		list.add("Messer");
		list.add("Caesar");
		
		
		
		
		CrypterCaesar a = new CrypterCaesar("Y");
		
		System.out.println(a.encrypt("CAESAR"));
		System.out.println(a.encrypt(list));
		
		List<String> list2 = new ArrayList<String>();
		list2.add("CLHO");
		list2.add("PHVVHU");
		
		System.out.println(a.decrypt("FDHVDU"));
		System.out.println(a.decrypt(list2));
		
		
		CrypterSubstitution b = new CrypterSubstitution("UFLPWDRASJMCONQYBVTEXHZKGI");
		
		//System.out.println(b.encrypt("WIKIPEDIAISTINFORMATIV"));
		
		/*List<String> list3 = new ArrayList<String>();
		list3.add("WIKIPEDIAISTINFORMATIV");
		list3.add("WIKIPEDIAISTINFORMATIV");
		System.out.println(b.encrypt(list3));
		*/
		
		/*
		CrypterSubstitution c = new CrypterSubstitution("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		
		System.out.println(c.decrypt("ZSMSYWPSUSTESNDQVOUESH"));
		*/
		/*
		String a = "TPERULESTPERULESTPERULESTP";
		String b1 = "URFVPJB[]ZN^XBJCEBVF@ZRKMJ";
		CrypterXOR d = new CrypterXOR(a);
	
		
		
		//'T','P','E','R','U','L','E','S','T','P','E','R','U','L','E','S','T','P','E','R','U','L','E','S','T','P'
		System.out.println(d.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		System.out.println(d.decrypt(b1));
		
		CrypterReverse e = new CrypterReverse();
		//System.out.println(e.encrypt("Hallo"));
		//System.out.println(e.decrypt("ollaH"));
		
		List<String> list4 = new ArrayList<String>();
		list4.add("TPERULEZ");
		list4.add("TPERULEZ");
		
		System.out.println(e.decrypt(list4));
		
		*/
		
	}	
}
