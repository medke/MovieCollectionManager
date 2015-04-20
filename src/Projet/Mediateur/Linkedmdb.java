package Projet.Mediateur;

import org.apache.jena.atlas.logging.LogCtl;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFactory;
import com.hp.hpl.jena.query.ResultSetRewindable;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;

public class Linkedmdb {
	private Linkedmdb[] links;
	private String title;
	public Linkedmdb(){
		
	}
	public void ExtractLinkedmdb(String title){
		title= Character.toUpperCase(title.charAt(0)) + title.substring(1);
		System.out.println("\n \n title : "+title);
		LogCtl.setCmdLogging();
		Model model = ModelFactory.createDefaultModel();
        String sparqlQueryString = "PREFIX mdb: <http://data.linkedmdb.org/resource/movie/>"
        	+"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"+
        	"PREFIX text: <http://jena.apache.org/text#>"+
        	 "PREFIX dc: <http://purl.org/dc/terms/>"+
"        		select * where {"+
"        		  service <http://linkedmdb.org/sparql> {"+
"        		    ?director dc:title  ?s ;"+
"        		              rdfs:label ?label ."+
"        		    FILTER(REGEX(?s, '"+title+"'))."+
//"        		    ?lab         mdb:actor ?director ; "+

"        		  }"+
"        		}"+
"        		limit 100";
        Query query = QueryFactory.create(sparqlQueryString);
        QueryExecution qexec = QueryExecutionFactory.sparqlService("http://linkedmdb.org/sparql", query);
        ResultSet results = qexec.execSelect();
        
        System.out.print("The movies which the actor "+ title +" is involved are : ");
        int l=0;
        ResultSetRewindable rsrw = ResultSetFactory.copyResults(results);
        int numberOfResults = rsrw.size(); 
        this.links= new Linkedmdb[numberOfResults];
        System.out.println(numberOfResults);
        while (rsrw.hasNext()) {
            QuerySolution soln = rsrw.nextSolution();
         Literal label = soln.getLiteral("label");
         Resource director= soln.getResource("director");
            System.out.print(
           label.toString()+ ", ");
            links[l]= new Linkedmdb();
            links[l].setTitle(label.toString());
            l++;
	}
        
	}
	public void setTitle(String t)
	{
		this.title = t;
	}
	public String getTitle()
	{
		return this.title;
	}
	public Linkedmdb[] getLinks()
	{
		return this.links;
	}

}
