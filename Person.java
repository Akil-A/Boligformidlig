public class Person {

private String fornavn;
private String etternavn;
private String adresse;
private String email;
private String telefon;
private String poststed;
private int postnr;

public Person(String fornavn, String etternavn, String adresse, String poststed, int postnr, String email, String telefon)
{
this.fornavn = fornavn;
this.etternavn = etternavn;
this.adresse = adresse;
this.email = email;
this.telefon = telefon;
this.poststed = poststed;
this.postnr = postnr;
}

public String getFornavn() {
return fornavn;
}

public void setFornavn(String fornavn) {
this.fornavn = fornavn;
}
public String getEtternavn()
{
	return etternavn;
}

public void setEtternavn(String etternavn)
{
	this.etternavn = etternavn;
}
public String getAdresse() {
return adresse;
}

public void setAdresse(String adresse) {
this.adresse = adresse;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getTelefon() {
return telefon;
}

public void setTelefon(String telefon) {
this.telefon = telefon;
}

public String getPoststed() {
	return poststed;
}

public void setPoststed(String poststed) {
	this.poststed = poststed;
}

public int getPostnr() {
	return postnr;
}

public void setPostnr(int postnr) {
	this.postnr = postnr;
}

}
