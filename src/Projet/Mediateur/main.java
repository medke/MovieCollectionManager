package Projet.Mediateur;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

import javax.swing.UIManager;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.jena.atlas.logging.Log;
import org.apache.jena.atlas.logging.LogCtl;
import org.json.JSONException;
import org.xml.sax.SAXException;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;

import Projet.GesionDeCollectionPersonelle.GestionDeCollectionPersonelle;


public class main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws JSONException 
	 * @throws NumberFormatException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public static void main(String[] args) throws NumberFormatException, JSONException, IOException, ParserConfigurationException, SAXException {
		
		/*final String authUser = "f.boug";
		final String authPassword = "uvrt311";
		Authenticator.setDefault(
		   new Authenticator() {
		      public PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication(
		               authUser, authPassword.toCharArray());
		      }
		   }
		);
		
		System.getProperties().put("proxySet", "true");
		System.getProperties().put("proxyHost", "192.168.5.1");
		System.getProperties().put("proxyPort", "8080");
		System.setProperty("http.proxyUser", authUser);
		System.setProperty("http.proxyPassword", authPassword);
*/
		new GestionDeCollectionPersonelle();




}}
