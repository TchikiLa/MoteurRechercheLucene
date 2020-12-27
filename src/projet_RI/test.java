package projet_RI;


import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;


public class test {
	public static void main(String[] args) throws IOException, ParseException {
	/*	
		//INDEXATION
		Date debut = new Date(); 
		Indexation.indexationcacm();
		Date fin = new Date(); 
		System.out.println("////////////////////Indexation//////////////////////////");
		System.out.println("Temp pris pour l'indexation ::::"+String.valueOf(fin.getTime() - debut.getTime()));
		System.out.println("//////////////////////////////////////////////");
	*/
	/*
	 //RECHERCHE SIMPLE
		String Type = "Tout";
		String Requete = "Sequential";

		
		Date start = new Date(); 
		List<contenucacm> docs = recherche.Resultat_Recherche( Type,  Requete);
		Date end = new Date(); 
		System.out.println("//////////////////////////////////////////////");
		System.out.println("Temp pris pour la recherche ::::"+String.valueOf(end.getTime() - start.getTime()));
		
		if (docs == null || docs.size() == 0) {
			System.out.println("No result found");
		}else {
			System.out.println("//////////////////////////////////////////////");
			for(int i=0; i<docs.size();i++) {
				System.out.println("Dossier N:"+(i+1));
				System.out.println("ID::::"+docs.get(i).getid());
				System.out.println("Titre::::"+docs.get(i).getTitre());
				System.out.println("Auteur:::"+docs.get(i).getAuteur());
				System.out.println("Resume:::"+docs.get(i).getresum());
				System.out.println("Referance:::"+docs.get(i).getreff());
				System.out.println("//////////////////////////////////////////////");
			}
		}
		*/
		/*
		 * RECHERCHE BOOLEAN
		String Type = "Titre";
		String requete = "Sequential";
		String requete2 = "Techniques ";
		String bool = "must";
		String bool2 = "must";
		
		Date start = new Date(); 
		List<contenucacm> docs = booleanRecherche.Resultat_Recherche( Type,  requete,  requete2 ,  bool,  bool2);
		Date end = new Date(); 
		System.out.println("//////////////////////////////////////////////");
		System.out.println("Temp pris pour la recherche ::::"+String.valueOf(end.getTime() - start.getTime()));
		
		if (docs == null || docs.size() == 0) {
			System.out.println("No result found");
		}else {
			System.out.println("//////////////////////////////////////////////");
			for(int i=0; i<docs.size();i++) {
				System.out.println("Dossier N:"+(i+1));
				System.out.println("ID::::"+docs.get(i).getid());
				System.out.println("Titre::::"+docs.get(i).getTitre());
				System.out.println("Auteur:::"+docs.get(i).getAuteur());
				System.out.println("Resume:::"+docs.get(i).getresum());
				System.out.println("Referance:::"+docs.get(i).getreff());
				System.out.println("//////////////////////////////////////////////");
	}
}
	*/
	}
}


