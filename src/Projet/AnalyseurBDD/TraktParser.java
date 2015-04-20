package Projet.AnalyseurBDD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.net.URLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TraktParser {
	private int limit=5;
	TraktParser(){
		
	}

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONArray readJsonFromUrl(String titre) throws IOException, JSONException {
	 
	  
	  titre = titre.replaceAll(" ", "+").toLowerCase();
	  URL urli = new URL("http://api.trakt.tv/search/movies.json/c5645e36facb6160ad19edc0bb5bc246?query="+titre+"") ;
	  //URL urli = new URL("file:///M:/Users/mohamed2/workspace/Projet/1.json") ;
	  URLConnection con = urli.openConnection(); ;
	  con.setRequestProperty("User-Agent",
	     "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.10 (KHTML, like Gecko) Chrome/8.0.552.237 Safari/534.10");

	  InputStream is =con.getInputStream();
    
    try {
  	  
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONArray inputArray=null ;
      if(jsonText.contains("error")&&jsonText.contains("Film not found"))
    	  return inputArray;
      
      
      inputArray = new JSONArray(jsonText);
  

      return inputArray;
    } finally {

      
    }
  }

  }
