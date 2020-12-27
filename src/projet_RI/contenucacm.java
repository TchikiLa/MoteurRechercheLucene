package projet_RI;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class contenucacm {

	private int id;
	private List<String> Titre;
	private List<String> Auteur;
	private List<String> Resume;
	private List<String> Reference;
	/*constructeurr*/
	public contenucacm() {
		this.id = -1;
		this.Titre = new ArrayList<String>();
		this.Auteur = new ArrayList<String>();
		this.Resume = new ArrayList<String>();
		this.Reference = new ArrayList<String>();
	}
	/*Identifiant*/
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	/*Titre*/
	public String getTitre() {
		//StringUtils.join pour deviser la chaine decaractere en un tableau de sous chaine 
		
		return StringUtils.join(this.Titre, ",");
		
	}
	public void setTitre(List<String> Titre) {
		this.Titre = Titre;
	}
	public void addTitre(String Titre) {
		this.Titre.add(Titre);
	}
	/*Auteur*/
	public String getAuteur() {
		return StringUtils.join(this.Auteur, ",");
		
	}
	public void setAuteur(List<String> Auteure) {
		this.Auteur = Auteure;
	}
	public void addAuteur(String Auteur) {
		this.Auteur.add(Auteur);
	}
	/*Resume*/
	public String getresum() {
		return StringUtils.join(this.Resume, ",");
		
	}
	public void setresum(List<String> resum) {
		this.Resume = resum;
	}
	public void addresum(String resum) {
		this.Resume.add(resum);
	}
	/*Reference*/
	public String getreff() {
		return StringUtils.join(this.Reference, ",");
		
	}
	public void setreff(List<String> refference) {
		this.Reference = refference;
	}
	public void addreff(String refference) {
		this.Reference.add(refference);
	}
	
	
}
