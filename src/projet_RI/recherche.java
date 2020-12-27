package projet_RI;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;


public class recherche {

	
	public static List<contenucacm> Resultat_Recherche(String Type, String requete) {
		try {
			
			Path pa = Paths.get("C:\\Users\\Lakhdar\\Desktop\\LUC");
			Directory directory = FSDirectory.open(pa);

			IndexReader reader = DirectoryReader.open(directory);
			IndexSearcher searcher = new IndexSearcher(reader);
			StandardAnalyzer analyzer = new StandardAnalyzer();
			
			List<contenucacm> resultatCACM = new ArrayList<contenucacm>();
			
			if ("Tout".equals(Type)) {
				String[] fields = {"Titre", "Auteur", "Resume", "Reference"};
				MultiFieldQueryParser parser = new MultiFieldQueryParser(fields,analyzer);
				Query query = parser.parse(requete.trim());
				resultatCACM.addAll(chercher(searcher, query));
			} else {
				QueryParser parser = new QueryParser(Type,analyzer);
				Query query = parser.parse(requete.trim());
				resultatCACM.addAll(chercher(searcher, query));
			
				
			}

			reader.close();
			return resultatCACM;

		} catch (IOException e) {
			System.out.println("Aucun dossier trouvé");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null; 
	}
	
	private static List<contenucacm> chercher(IndexSearcher searcher, Query query){
		try {
			
			TopDocs topDocs = searcher.search(query, 10000);
			List<contenucacm> docList = new ArrayList<contenucacm>();			
		
			
			for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
				
				contenucacm cacmDoc = new contenucacm();
				Document doc = searcher.doc(scoreDoc.doc);
				cacmDoc.setid(Integer.parseInt(doc.get("id")));
				String[] titre = doc.get("Titre").split(",");
				cacmDoc.setTitre(Arrays.asList(titre));
				String[] auteur = doc.get("Auteur").split(",");
				cacmDoc.setAuteur(Arrays.asList(auteur));
				String[] resume = doc.get("Resume").split(",");
				cacmDoc.setresum(Arrays.asList(resume));
				String[] reference = doc.get("Reference").split(",");
				cacmDoc.setreff(Arrays.asList(reference));
				
				docList.add(cacmDoc);
			}
			return docList;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
