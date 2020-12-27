package projet_RI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Indexation {
private static final String cacm = "C:\\Users\\Lakhdar\\Desktop\\prj_eclipce\\projet_RI\\cacm.htm";
	
	
	public static String indexationcacm() {
		BufferedReader br = null;
		String reponse = "";
		String		ligne;
		try {
			br = new BufferedReader(new FileReader(cacm));
			char c = 0;
			contenucacm doc = null;
			ArrayList<contenucacm> doclist = new ArrayList<contenucacm>();
		while((ligne = br.readLine()) != null) {
			
		if(ligne.isEmpty()) {
			continue;
		}
		//parser
			
		//si la ligne commance par un '.'
		if(ligne.charAt(0) == '.') {
			c = ligne.charAt(1);
			if(c == 'I') {
				if(doc != null) {
					doclist.add(doc);
				}
				doc = new contenucacm();
				doc.setid(Integer.parseInt(ligne.substring(2).trim()));
			}
		}else {
			
			// si la ligne commance par '.T'
			
			if (c == 'T') {
				doc.addTitre(ligne);
			} else if (c == 'A') { 
				
				// si la ligne commance par '.A'
				
				doc.addAuteur(ligne);
			} else if (c == 'W' ) {
				
				// si la ligne commance par '.W'
				
				doc.addresum(ligne);
			} else if (c == 'X') {
				
				// si la ligne commance par '.X'
				
				doc.addreff(ligne);
			}
		}
		
		}
		doclist.add(doc);
		index(doclist);
	} catch (FileNotFoundException e) {
		reponse = "DOC pas retrouve.";
	} catch (IOException e) {
		reponse = "Erreure de lecture du DOC.";
	}
		return reponse;
	}
	private static void index(ArrayList<contenucacm> doclist) throws IOException {
		Path pa = Paths.get("C:\\Users\\Lakhdar\\Desktop\\LUC"); 
		StandardAnalyzer analyzer = new StandardAnalyzer();
		Directory directory = FSDirectory.open(pa);
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		IndexWriter iwriter = new IndexWriter(directory, config);
		for (contenucacm cacm : doclist) {
	
			Document doc = new Document();

			doc.add(new TextField("id", String.valueOf(cacm.getid()), Field.Store.YES));
			doc.add(new TextField("Titre",cacm.getTitre() , Field.Store.YES));
			doc.add(new TextField("Auteur",cacm.getAuteur() , Field.Store.YES));
			doc.add(new TextField("Resume",cacm.getresum() , Field.Store.YES));
			doc.add(new TextField("Reference",cacm.getreff() , Field.Store.YES));
			

			iwriter.addDocument(doc);
		}
		iwriter.close();
	}
}
