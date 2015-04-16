package createOntology;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.VCARD;

public class createOnt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// some definitions
		 String personURI    = "http://somewhere/Alex";
		 String fullName     = "Alex Kok";

		// create an empty Model
		Model model = ModelFactory.createDefaultModel();

		// create the resource
		Resource johnSmith = model.createResource(personURI);

		// add the property
		 johnSmith.addProperty(VCARD.FN, fullName);
	}

}
