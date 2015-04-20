package Projet.Mediateur;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;


public class Imdb {
	private Imdb[] imdb;
	private int rating;
	private String rated;
	private String genres;
	private String language;
	private String title;
	private String filming_locations;
	private String poster;
	private String imdb_url;
	private String writers;
	private String imdb_id;
	private String directors;
	private int rating_count;
	private String actors;
	private String plot_simple;
	private int year;
	private String country;
	private String type;
	private String release_date;
	private String also_known_as;

	public void ExtractInfo(JSONArray tab) throws NumberFormatException, JSONException
	{
		if(tab !=null)
		{
		this.imdb = new Imdb[tab.length()];
		String release,language,rated,genres,plot_simple,also_known_as,filming_locations,poster,actors,directors,country,imdb_id,title,writers,imdb_url,type;
		int rating,year,rating_count;
		
		for (int i=0;i<tab.length();i++)
		{
			if(tab.getJSONObject(i).has("release_date")) release = tab.getJSONObject(i).get("release_date").toString();
			else release=" ";
			
			if(tab.getJSONObject(i).has("rated"))rated = tab.getJSONObject(i).get("rated").toString();
			else rated=" ";
			
			if(tab.getJSONObject(i).has("genres"))genres = tab.getJSONObject(i).get("genres").toString();
			else genres=" ";
			
			if(tab.getJSONObject(i).has("plot_simple"))plot_simple = tab.getJSONObject(i).get("plot_simple").toString();
			else plot_simple=" ";
			
			if(tab.getJSONObject(i).has("also_known_as"))also_known_as = tab.getJSONObject(i).get("also_known_as").toString();
			else also_known_as=" ";
			
			if(tab.getJSONObject(i).has("filming_locations"))filming_locations = tab.getJSONObject(i).get("filming_locations").toString();
			else filming_locations=" ";
			
			if(tab.getJSONObject(i).has("poster"))poster = tab.getJSONObject(i).get("poster").toString();
			else poster=" ";
			
			//if(tab.getJSONObject(i).has("rating"))rating = tab.getJSONObject(i).getInt("rating");
			//else
			rating=0;
			
			if(tab.getJSONObject(i).has("language"))language = tab.getJSONObject(i).get("language").toString();
			else language=" ";
			
			if(tab.getJSONObject(i).has("title"))title = tab.getJSONObject(i).get("title").toString();
			else title=" ";
			
			if(tab.getJSONObject(i).has("imdb_url"))imdb_url = tab.getJSONObject(i).get("imdb_url").toString();
			else imdb_url=" ";
			
			if(tab.getJSONObject(i).has("writers"))writers = tab.getJSONObject(i).get("writers").toString();
			else writers=" ";
			
			if(tab.getJSONObject(i).has("directors"))directors = tab.getJSONObject(i).get("directors").toString();
			else directors=" ";
			
			if(tab.getJSONObject(i).has("rating_count"))rating_count = tab.getJSONObject(i).getInt("rating_count");
			else rating_count=0;
			
			if(tab.getJSONObject(i).has("actors"))actors = tab.getJSONObject(i).get("actors").toString();
			else actors=" ";
			
			if(tab.getJSONObject(i).has("year"))year = tab.getJSONObject(i).getInt("year");
			else year=0;
			
			if(tab.getJSONObject(i).has("country"))country = tab.getJSONObject(i).get("country").toString();
			else country=" ";
			
			if(tab.getJSONObject(i).has("type"))type = tab.getJSONObject(i).get("type").toString();
			else type=" ";
			
			if(tab.getJSONObject(i).has("imdb_id"))imdb_id = tab.getJSONObject(i).get("imdb_id").toString();
			else imdb_id=" ";
			imdb[i]=new Imdb(rating,rated,genres,language,title,filming_locations,poster,imdb_url,writers,directors,
					rating_count,actors,plot_simple,year,country,type,also_known_as,imdb_id,release);
			
		}}else
		{
			imdb = null;
		}
	}
	public Imdb()
	{	
	}
	public Imdb(int i1, String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,
			String s9,int i3,String s10,String s11,int i4,String s12,String s13,String s14,String s15,String s16)
	{
		this.rating=i1;
		this.rated=s1;
		this.genres=s2;
		this.language=s3.replace("\"", "").replace("[", "").replace("]", "").toUpperCase();
		this.title=s4;
		this.filming_locations=s5;
		this.poster=s6;
		this.imdb_url=s7;
		this.writers=s8;
		this.imdb_id=s15;
		this.directors=s9;
		this.rating_count=i3;
		this.actors=s10;
		this.plot_simple=s11;
		this.year=i4;
		this.country=s12;
		this.type=s13;
		this.release_date=s16;
		this.also_known_as=s14;
		
	}
	public String getTitle()
	{
		return this.title;
	}
	public String getWriters()
	{
		return this.writers;
	}
	public String getDirectors()
	{
		return this.directors;
	}
	public String getActors()
	{
		return this.actors;
	}
	public String getImdbId()
	{
		return this.imdb_id;
	}
	public String getImdbUrl()
	{
		return this.imdb_url;
	}
	public String getPlotSimple()
	{
		return this.plot_simple;
	}
	public String getImage()
	{
		return this.poster;
	}
	public String getCertification()
	{
		return this.rated;
	}
	public String getAsKnownAs()
	{
		return this.also_known_as;
	}
	public String getLangue()
	{
		return this.language;
	}
	public String getLocation()
	{
		return this.filming_locations;
	}
	public String getCountry()
	{
		return this.country;
	}
	public int getYear()
	{
		return this.year;
	}
	public int getVotes()
	{
		return this.rating_count;
	}
	public String getReleased()
	{
		return this.release_date;
	}
	public String getGenres()
	{
		return this.genres;
	}
	public int getRating()
	{
		return this.rating;
	}
	public Imdb[] getMovies()
	{
		return this.imdb;
	}
	public void setMovies(Imdb[] m)
	{
		this.imdb=m;
	}
	

}
