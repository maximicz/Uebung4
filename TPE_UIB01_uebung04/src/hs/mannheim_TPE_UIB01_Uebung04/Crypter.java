package hs.mannheim_TPE_UIB01_Uebung04;

import java.util.List;


/**
 *
 Grundlegendes Interface , um Verschlusselung durchzufuhren . Mit
 *
 * Hilfe dieses Interfaces kann man Nachrichten verschlusseln ( uber die
 * {@link # encrypt (String )} Methode ) und wieder entschlusseln ( uber die
 * {@link # decrypt (String )} Methode ).
 *
 *
 * Der Eingabetext ({@literal message }) darf nur aus den Gro - Buchstaben A -
 * Z bestehen . Kleinbuchstaben werden in Grobuchstaben umgewandelt , alle
 * anderen Zeichen werden ohne Ruckmeldung entfernt ( einschlielich der
 * Leerzeichen ).
 * 
 * Zwischen den beiden Methoden muss bei gleichem Schlussel {@code key }
 * folgendes gelten :{@code text . equals ( decrypt ( encrypt ( text )) == true }
 * .
 * 
 * @author Thomas Smits
 */

public interface Crypter {

	/**
	 * Verschlüsselt den gegebenen Text mit dem angegebenen Schlüssel.
	 * 
	 * @param message
	 *            Nachricht, die verschlüsselt werden soll
	 * 
	 * @return verschlüsselter Text
	 * @throws CrypterException
	 *             wird geworfen, wenn es Probleme bei der Verschlüsselung gibt.
	 */

	public String encrypt(String message) throws CrypterException;

	/**
	 * Verschlüsselt den gegebenen Text mit dem angegebenen Schlüssel.
	 * 
	 * @param messages
	 *            Nachrichten, die verschlüsselt werden soll
	 * 
	 * @return verschlüsselte Texte
	 * @throws CrypterException
	 *             wird geworfen, wenn es Probleme bei der Verschlüsselung gibt.
	 */

	public List<String> encrypt(List<String> messages) throws CrypterException;

	/**
	 * Entschlüsselt den gegebenen Text mit dem angegeben Schlüssel.
	 * 
	 * @param cypherText
	 *            Nachrichten, die entschlüsselt werden soll.
	 * @return entschlüsselter Text
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschlüsselung
	 *             auftreten.
	 */

	public String decrypt(String cypherText) throws CrypterException;

	/**
	 * Entschlüsselt den gegebenen Text mit dem angegeben Schlüssel.
	 * 
	 * @param cypherTexte
	 *            Nachrichten, die entschlüsselt werden soll.
	 * 
	 * @return entschlüsselte Texte
	 * @throws CrypterException
	 *             Wird geworfen, wenn Probleme mit der Verschlüsselung
	 *             auftreten.
	 */

	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException;

}
