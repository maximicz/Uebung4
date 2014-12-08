package hs.mannheim_TPE_UIB01_Uebung04;

import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) throws CrypterException {

		
		List<String> list = new ArrayList<String>();
		list.add("Ziel");
		list.add("Messer");
		list.add("Caesar");
		
		
		
		/*
		CrypterCaesar a = new CrypterCaesar("C");
		
		System.out.println(a.encrypt("CAESAR"));
		System.out.println(a.encrypt(list));
		
		List<String> list2 = new ArrayList<String>();
		list2.add("CLHO");
		list2.add("PHVVHU");
		
		System.out.println(a.decrypt("FDHVDU"));
		System.out.println(a.decrypt(list2));
		
		*/
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
	
		CrypterXOR d = new CrypterXOR("TPERULESTPERULESTPERULESTP");
		
		System.out.println(d.encrypt("@ABCDEFGHIJKLMNOPQRSTUVWXYZ[/]^_"));
		
		CrypterReverse e = new CrypterReverse();
		//System.out.println(e.encrypt("Hallo"));
		//System.out.println(e.decrypt("ollaH"));
		
		List<String> list4 = new ArrayList<String>();
		list4.add("TPERULEZ");
		list4.add("TPERULEZ");
		
		System.out.println(e.decrypt(list4));
		
		
		
	}	
}
