package hs.mannheim_TPE_UIB01_Uebung04;

public class CrypterFactory {

	public void createCrypter(VerschlüsselungsEnum verschlüsselung, String key) throws IllegalKeyException
	{
		
		
			switch(verschlüsselung) {
				case CAESAR: CrypterCaesar(key);
					break;
					
				case SUBSTITUTION:
					break;
					
				case REVERSE:
					break;
					
				case XOR:
					break;
					
				case NULL:	
					break;
					
					
				
			}
		
		
		
		
	
	
	}
		
}
