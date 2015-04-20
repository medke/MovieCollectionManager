package Projet.Mediateur;
import org.w3c.dom.Document;


public class Globaldb {
	private Globaldb[] global;
	private String Id;
	private String titre;
	private String genre;
	private String lien;
	private String date_sortie;
	private String apercu;
	private String evaluation;
	private String image;
	private String certification;
	private String imdb_id;
	private String titre_original;
	private String titre_alternative;
	private String annee;
	private String votes;
	private String langue;
	private String traduit;
	private String popularite;
	private String adult;
	private String runtime;
	private String lieux_tournage;
	private String pays;
	private String trailer;
	private String ecrivains;
	private String directeurs;
	private String acteurs;
	private String source;
	private String file;
	public void extractInfo(Document doc)
	{
		int l=doc.getElementsByTagName("Movie").getLength();
		
		this.global = new Globaldb[l];
		for (int i=0;i<l;i++)
		{
			
			global[i]=new Globaldb(doc.getElementsByTagName("id").item(i).getTextContent(),
					doc.getElementsByTagName("titre").item(i).getTextContent(),
					doc.getElementsByTagName("genre").item(i).getTextContent(),
					doc.getElementsByTagName("lien").item(i).getTextContent(),
					doc.getElementsByTagName("date_sortie").item(i).getTextContent(),
					doc.getElementsByTagName("apercu").item(i).getTextContent(),
					doc.getElementsByTagName("evaluation").item(i).getTextContent(),
					doc.getElementsByTagName("image").item(i).getTextContent(),
					doc.getElementsByTagName("certification").item(i).getTextContent(),
					doc.getElementsByTagName("imdb_id").item(i).getTextContent(),
					doc.getElementsByTagName("titre_original").item(i).getTextContent(),
					doc.getElementsByTagName("titre_alternative").item(i).getTextContent(),
					doc.getElementsByTagName("annee").item(i).getTextContent(),
					doc.getElementsByTagName("votes").item(i).getTextContent(),
					doc.getElementsByTagName("langue").item(i).getTextContent(),
					doc.getElementsByTagName("traduit").item(i).getTextContent(),
					doc.getElementsByTagName("popularite").item(i).getTextContent(),
					doc.getElementsByTagName("adult").item(i).getTextContent(),
					doc.getElementsByTagName("runtime").item(i).getTextContent(),
					doc.getElementsByTagName("lieux_tournage").item(i).getTextContent(),
					doc.getElementsByTagName("pays").item(i).getTextContent(),
					doc.getElementsByTagName("trailer").item(i).getTextContent(),
					doc.getElementsByTagName("ecrivains").item(i).getTextContent(),
					doc.getElementsByTagName("directeurs").item(i).getTextContent(),
					doc.getElementsByTagName("acteurs").item(i).getTextContent(),
					doc.getElementsByTagName("source").item(i).getTextContent());
		}
	}
	public Globaldb()
	{
		
	}
	
	public Globaldb(String s0,String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,
			String s9,String s10,String s11,String s12,String s13,String s14,String s15,String s16,String s17
			,String s18, String s19, String s20, String s21, String s22, String s23, String s24,String s25)
	{
		
		this.Id=s0;
		this.titre=s1;
		this.genre=s2.replace("\"", "").replace("[", "").replace("]", "");
		this.lien=s3;
		this.date_sortie=s4;
		this.apercu=s5;
		this.evaluation=s6;
		this.image=s7;
		this.certification=s8;
		this.imdb_id=s9;
		this.titre_original=s10;
		this.titre_alternative=s11.replace("\"", "").replace("[", "").replace("]", "");
		this.annee=s12;
		this.votes=s13;
		this.langue=s14.replace("\"", "").replace("[", "").replace("]", "");
		this.traduit=s15;
		this.popularite=s16;
		this.adult=s17;
		this.runtime=s18;
		this.lieux_tournage=s19.replace("\"", "").replace("[", "").replace("]", "");
		this.pays=s20.replace("\"", "").replace("[", "").replace("]", "");
		this.trailer=s21;
		this.ecrivains=s22.replace("\"", "").replace("[", "").replace("]", "");
		this.directeurs=s23.replace("\"", "").replace("[", "").replace("]", "");
		this.acteurs=s24.replace("\"", "").replace("[", "").replace("]", "");
		this.source=s25;

	}
	public String getId()
	{
		return this.Id;
	}
	public String getTitre()
	{
		return this.titre;
	}
	public String getGenre()
	{
		return this.genre ;
	}
	public String getLien()
	{
		return this.lien ;
	}
	public String getApercu()
	{
		return this.apercu ;
	}
	public String getEvaluation()
	{
		return this.evaluation ;
	}
	public String getImdb_id()
	{
		return this.imdb_id ;
	}	
	public String getTitre_original()
	{
		return this.titre_original ;
	}	
	public String getTitre_alternative()
	{
		return this.titre_alternative ;
	}	
	public String getAnnee ()
	{
		return this.annee ;
	}
	public String getVotes ()
	{
		return this.votes;
	}
	public String getLangue ()
	{
		return this.langue ;
	}
	public String getTraduit ()
	{
		return this.traduit ;
	}
	public String getPopularite ()
	{
		return this.popularite ;
	}
	public String getAdult ()
	{
		return this.adult ;
	}
	public String getDuree ()
	{
		return this.runtime ;
	}
	public String getLieux_tournage ()
	{
		return this.lieux_tournage ;
	}
	public String getPays ()
	{
		return this.pays ;
	}
	public String getTrailer ()
	{
		return this.trailer ;
	}
	public String getEcrivains ()
	{
		return this.ecrivains ;
	}
	public String getDirecteurs ()
	{
		return this.directeurs ;
	}
	public String getActeurs ()
	{
		return this.acteurs ;
	}
	public  void setFile (String s)
	{
		this.file = s ;
	}
	public String getFile ()
	{
		return this.file ;
	}
	public String getDateSortie()
	{
		return this.date_sortie;
	}
	public String getImage()
	{
		return this.image;
	}
	public String getCertification()
	{
		return this.certification;
	}
	public String getSource()
	{
		return this.source;
	}
	public Globaldb[] getMovies()
	{
		return this.global;
	}
	



}
