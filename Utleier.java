/* Klasse for Utleier-objektet.
 * laget av Ali
 */

import java.io.Serializable;
import java.util.ArrayList;

public class Utleier extends Person  implements Serializable
{
	private String firma;
	
	public Utleier (String fornavn, String etternavn, String adresse, String postnr, String poststed, String email, String telefon)
	{
		super(fornavn, etternavn, adresse, postnr, poststed, email, telefon);
	}
	
	public String getFirma()
	{
		return firma;
	}
	
	public void setFirma(String firma) 
	{
		this.firma = firma;
	}
}
