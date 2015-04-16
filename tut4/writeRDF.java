package tut4;

import java.io.FileWriter;
import java.io.IOException;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.VCARD;

public class writeRDF {
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		// some definitions
		// some definitions
		String personURI    = "http://somewhere/JohnSmith";
		String givenName    = "John";
		String familyName   = "Smith";
		String fullName     = givenName + " " + familyName;

		String fileName = "card.rdf";
		FileWriter out;
		try {
			out = new FileWriter( fileName );
		
		
		
		
		// create an empty Model
		Model model = ModelFactory.createDefaultModel();

		// create the resource
		Resource johnSmith = model.createResource(personURI)
				.addProperty(VCARD.FN, fullName)
				.addProperty(VCARD.N, model.createResource()
						.addProperty(VCARD.Given,givenName)
						.addProperty(VCARD.Family,familyName));
	
	
		StmtIterator iter = model.listStatements();
		while(iter.hasNext()){
			Statement stmt = iter.nextStatement();
			Resource subject = stmt.getSubject();
			Property predicate = stmt.getPredicate();
			RDFNode object  =stmt.getObject();
			try {
			    model.write( out, "RDF/XML-ABBREV" );
			}
			finally{
				
			}
		
			
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	
	}
	}

