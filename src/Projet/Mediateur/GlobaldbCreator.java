package Projet.Mediateur;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class GlobaldbCreator {
	Imdb[] imdb;
	Trakt[] trakt;
	Linkedmdb[] links;

	public GlobaldbCreator(Imdb[] i, Trakt[] tr,Linkedmdb[] l)
	{
		this.imdb=i;
		this.trakt=tr;
		this.links= l;
		
	}

	public  Document createXML() throws ParserConfigurationException, TransformerException
	{
		try{
			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Movies");
			doc.appendChild(rootElement);
			String release;
			if(imdb!=null){
			for(int i=0;i<imdb.length;i++)
			{

		
				Element movie = doc.createElement("Movie");
				rootElement.appendChild(movie);
				Element id = doc.createElement("id");
				Element titre = doc.createElement("titre");
				Element genre = doc.createElement("genre");
				Element lien = doc.createElement("lien");
				Element date_sortie = doc.createElement("date_sortie");
				Element apercu = doc.createElement("apercu");
				Element evaluation = doc.createElement("evaluation");
				Element image = doc.createElement("image");
				Element certification = doc.createElement("certification");
				Element imdb_id = doc.createElement("imdb_id");
				Element titre_original = doc.createElement("titre_original");
				Element titre_alternative = doc.createElement("titre_alternative");
				Element annee = doc.createElement("annee");
				Element votes = doc.createElement("votes");
				Element langue = doc.createElement("langue");
				Element traduit = doc.createElement("traduit");
				Element popularite = doc.createElement("popularite");
				Element adult = doc.createElement("adult");
				Element runtime = doc.createElement("runtime");
				Element lieux_tournage = doc.createElement("lieux_tournage");
				Element pays = doc.createElement("pays");
				Element trailer = doc.createElement("trailer");
				Element ecrivains = doc.createElement("ecrivains");
				Element directeurs = doc.createElement("directeurs");
				Element acteurs = doc.createElement("acteurs");
				Element source = doc.createElement("source");
				
				id.setTextContent(imdb[i].getImdbId()+"");
				movie.appendChild(id);

				titre.setTextContent(imdb[i].getTitle()+"");
				movie.appendChild(titre);
				
				genre.setTextContent(imdb[i].getGenres()+"");
				movie.appendChild(genre);
				
				lien.setTextContent(imdb[i].getImdbUrl()+"");
				movie.appendChild(lien);
				
				release = imdb[i].getReleased().toString();
				if(release.length()>1) release =release.substring(0,4)+"-"+release.substring(4,6)+"-"+release.substring(6,release.length());
				date_sortie.setTextContent(release+" ");
				release="";
				movie.appendChild(date_sortie);
				
				apercu.setTextContent(imdb[i].getPlotSimple()+"");
				movie.appendChild(apercu);
				
				evaluation.setTextContent(imdb[i].getRating()+"");
				movie.appendChild(evaluation);
				
				image.setTextContent(imdb[i].getImage()+"");
				movie.appendChild(image);
				
				certification.setTextContent(imdb[i].getCertification()+"");
				movie.appendChild(certification);
				
				imdb_id.setTextContent(imdb[i].getImdbId()+"");
				movie.appendChild(imdb_id);
				
				titre_original.setTextContent(" ");
				movie.appendChild(titre_original);
				
				titre_alternative.setTextContent(imdb[i].getAsKnownAs()+"");
				movie.appendChild(titre_alternative);
				
				annee.setTextContent(imdb[i].getYear()+"");
				movie.appendChild(annee);
				
				votes.setTextContent(imdb[i].getVotes()+"");
				movie.appendChild(votes);
				
				langue.setTextContent(imdb[i].getLangue()+"");
				movie.appendChild(langue);
				
				traduit.setTextContent(" ");
				movie.appendChild(traduit);
				
				popularite.setTextContent(" ");
				movie.appendChild(popularite);
				
				adult.setTextContent(" ");
				movie.appendChild(adult);
				
				runtime.setTextContent(" ");
				movie.appendChild(runtime);
				
				pays.setTextContent(imdb[i].getCountry()+"");
				movie.appendChild(pays);
				
				trailer.setTextContent(" ");
				movie.appendChild(trailer);
				
				lieux_tournage.setTextContent(imdb[i].getLocation()+"");
				movie.appendChild(lieux_tournage);
				
				ecrivains.setTextContent(imdb[i].getWriters()+"");
				movie.appendChild(ecrivains);
				
				directeurs.setTextContent(imdb[i].getDirectors()+"");
				movie.appendChild(directeurs);
				
				acteurs.setTextContent(imdb[i].getActors()+"");
				movie.appendChild(acteurs);
				
				source.setTextContent("IMDB");
				movie.appendChild(source);

			}}
			if(trakt!=null)
			{
				for(int i=0;i<trakt.length;i++)
				{
					Element movie = doc.createElement("Movie");
					rootElement.appendChild(movie);
					Element id = doc.createElement("id");
					Element titre = doc.createElement("titre");
					Element genre = doc.createElement("genre");
					Element lien = doc.createElement("lien");
					Element date_sortie = doc.createElement("date_sortie");
					Element apercu = doc.createElement("apercu");
					Element evaluation = doc.createElement("evaluation");
					Element image = doc.createElement("image");
					Element certification = doc.createElement("certification");
					Element imdb_id = doc.createElement("imdb_id");
					Element titre_original = doc.createElement("titre_original");
					Element titre_alternative = doc.createElement("titre_alternative");
					Element annee = doc.createElement("annee");
					Element votes = doc.createElement("votes");
					Element langue = doc.createElement("langue");
					Element traduit = doc.createElement("traduit");
					Element popularite = doc.createElement("popularite");
					Element adult = doc.createElement("adult");
					Element runtime = doc.createElement("runtime");
					Element lieux_tournage = doc.createElement("lieux_tournage");
					Element pays = doc.createElement("pays");
					Element trailer = doc.createElement("trailer");
					Element ecrivains = doc.createElement("ecrivains");
					Element directeurs = doc.createElement("directeurs");
					Element acteurs = doc.createElement("acteurs");
					Element source = doc.createElement("source");
					
					id.setTextContent(trakt[i].getImdbId()+"");
					movie.appendChild(id);

					titre.setTextContent(trakt[i].getTitle()+"");
					movie.appendChild(titre);
					
					genre.setTextContent(trakt[i].getGenres()+"");
					movie.appendChild(genre);
					
					lien.setTextContent(trakt[i].getUrl()+"");
					movie.appendChild(lien);
					
					date_sortie.setTextContent(trakt[i].getReleased()+" ");
					movie.appendChild(date_sortie);
					
					apercu.setTextContent(trakt[i].getOverview()+"");
					movie.appendChild(apercu);
					
					evaluation.setTextContent(trakt[i].getRatings()+"");
					movie.appendChild(evaluation);
					
					image.setTextContent(trakt[i].getImages()+"");
					movie.appendChild(image);
					
					certification.setTextContent(trakt[i].getCertification()+"");
					movie.appendChild(certification);
					
					imdb_id.setTextContent(trakt[i].getImdbId()+"");
					movie.appendChild(imdb_id);
					
					titre_original.setTextContent(" ");
					movie.appendChild(titre_original);
					
					titre_alternative.setTextContent(" ");
					movie.appendChild(titre_alternative);
					
					annee.setTextContent(trakt[i].getYear()+"");
					movie.appendChild(annee);
					
					votes.setTextContent(" ");
					movie.appendChild(votes);
					
					langue.setTextContent(" ");
					movie.appendChild(langue);
					
					traduit.setTextContent(" ");
					movie.appendChild(traduit);
					
					popularite.setTextContent(" ");
					movie.appendChild(popularite);
					
					adult.setTextContent(" ");
					movie.appendChild(adult);
					
					runtime.setTextContent(trakt[i].getRuntime()+"");
					movie.appendChild(runtime);
					
					pays.setTextContent(" ");
					movie.appendChild(pays);
					
					trailer.setTextContent(trakt[i].getTrailer()+"");
					movie.appendChild(trailer);
					
					lieux_tournage.setTextContent(" ");
					movie.appendChild(lieux_tournage);
					
					ecrivains.setTextContent(" ");
					movie.appendChild(ecrivains);
					
					directeurs.setTextContent(" ");
					movie.appendChild(directeurs);
					
					acteurs.setTextContent(" ");
					movie.appendChild(acteurs);
					
					source.setTextContent("TRAKT.TV");
					movie.appendChild(source);
					
					
				}
				
				
				if(links!=null)
				{
					for(int i=0;i<links.length;i++)
					{
						Element movie = doc.createElement("Movie");
						rootElement.appendChild(movie);
						Element id = doc.createElement("id");
						Element titre = doc.createElement("titre");
						Element genre = doc.createElement("genre");
						Element lien = doc.createElement("lien");
						Element date_sortie = doc.createElement("date_sortie");
						Element apercu = doc.createElement("apercu");
						Element evaluation = doc.createElement("evaluation");
						Element image = doc.createElement("image");
						Element certification = doc.createElement("certification");
						Element imdb_id = doc.createElement("imdb_id");
						Element titre_original = doc.createElement("titre_original");
						Element titre_alternative = doc.createElement("titre_alternative");
						Element annee = doc.createElement("annee");
						Element votes = doc.createElement("votes");
						Element langue = doc.createElement("langue");
						Element traduit = doc.createElement("traduit");
						Element popularite = doc.createElement("popularite");
						Element adult = doc.createElement("adult");
						Element runtime = doc.createElement("runtime");
						Element lieux_tournage = doc.createElement("lieux_tournage");
						Element pays = doc.createElement("pays");
						Element trailer = doc.createElement("trailer");
						Element ecrivains = doc.createElement("ecrivains");
						Element directeurs = doc.createElement("directeurs");
						Element acteurs = doc.createElement("acteurs");
						Element source = doc.createElement("source");
						
						id.setTextContent(" ");
						movie.appendChild(id);

						titre.setTextContent(links[i].getTitle()+"");
						movie.appendChild(titre);
						
						genre.setTextContent(" ");
						movie.appendChild(genre);
						
						lien.setTextContent(" ");
						movie.appendChild(lien);
						
						date_sortie.setTextContent(" ");
						movie.appendChild(date_sortie);
						
						apercu.setTextContent(" ");
						movie.appendChild(apercu);
						
						evaluation.setTextContent(" ");
						movie.appendChild(evaluation);
						
						image.setTextContent(" ");
						movie.appendChild(image);
						
						certification.setTextContent(" ");
						movie.appendChild(certification);
						
						imdb_id.setTextContent(" ");
						movie.appendChild(imdb_id);
						
						titre_original.setTextContent(" ");
						movie.appendChild(titre_original);
						
						titre_alternative.setTextContent(" ");
						movie.appendChild(titre_alternative);
						
						annee.setTextContent(" ");
						movie.appendChild(annee);
						
						votes.setTextContent(" ");
						movie.appendChild(votes);
						
						langue.setTextContent(" ");
						movie.appendChild(langue);
						
						traduit.setTextContent(" ");
						movie.appendChild(traduit);
						
						popularite.setTextContent(" ");
						movie.appendChild(popularite);
						
						adult.setTextContent(" ");
						movie.appendChild(adult);
						
						runtime.setTextContent(" ");
						movie.appendChild(runtime);
						
						pays.setTextContent(" ");
						movie.appendChild(pays);
						
						trailer.setTextContent(" ");
						movie.appendChild(trailer);
						
						lieux_tournage.setTextContent(" ");
						movie.appendChild(lieux_tournage);
						
						ecrivains.setTextContent(" ");
						movie.appendChild(ecrivains);
						
						directeurs.setTextContent(" ");
						movie.appendChild(directeurs);
						
						acteurs.setTextContent(" ");
						movie.appendChild(acteurs);
						
						source.setTextContent("Linkedmdb");
						movie.appendChild(source);
						
						
					}}
			}
			
			   TransformerFactory transformerFactory = TransformerFactory  
					     .newInstance();  
					   Transformer transformer = transformerFactory.newTransformer();  
					   DOMSource domSource = new DOMSource(doc);  
					   StreamResult streamResult = new StreamResult(new File(  
					     "createdFiles/createFile.xml"));  
					  
					   transformer.transform(domSource, streamResult);  
					  
					   System.out.println("File saved to specified path!");  

		
			return doc;
			
	  }finally
	  {
		  
	  }
	  
	  }

}
