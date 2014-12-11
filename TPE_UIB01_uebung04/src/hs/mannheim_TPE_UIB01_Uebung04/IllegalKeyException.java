package hs.mannheim_TPE_UIB01_Uebung04;

/**
 * The Class IllegalKeyException.
 *
 * @author Sovann Som 1326670
 * @author Maximilian Czerwonka 1415407
 * @author Stephen Kessler 1412750
 * @version JDK8.0
 */

@SuppressWarnings("serial")
public class IllegalKeyException extends CrypterException {

	/**
	 * Instantiates a new illegal key exception.
	 */
	public IllegalKeyException(){} 
	 	 
	 	/**
	 	 * Instantiates a new illegal key exception.
	 	 *
	 	 * @param message the message
	 	 */
	 	public IllegalKeyException(String message){ 
	 		 
	 		super(message); 
	 	}	

}
