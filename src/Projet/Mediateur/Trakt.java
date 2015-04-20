package Projet.Mediateur;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;


public class Trakt {
	private Trakt[] trakt;
	private String title;
	private String released;
	private int year;
	private String url;
	private String trailer;
	private int runtime;
	private String tagline;
	private String overview;
	private String certification;
	private String imdb_id;
	private int tmdb_id;
	private String images;
	private String genres;
	private String ratings;
	private static int limit;
	
	public Trakt()
	{}
	public void ExtractInfo(JSONArray tab) throws NumberFormatException, JSONException
	{
		if(tab !=null)
		{
			if(limit>tab.length())
				limit=tab.length();
		this.trakt = new Trakt[limit];
		String title,url,trailer,tagline,overview,certification,imdb_id,images,genres,ratings;
		int released,year,runtime,tmdb_id;
		
		for (int i=0;i<limit;i++)
		{
			if(tab.getJSONObject(i).has("title")) title = tab.getJSONObject(i).get("title").toString();
			else title=" ";
			
			//if(tab.getJSONObject(i).has("released"))released = Integer.parseInt(tab.getJSONObject(i).get("released").toString());
			//else 
				released=0;
			
			//if(tab.getJSONObject(i).has("year"))year = tab.getJSONObject(i).getInt("year");
			//else 
				year=0;
			
			if(tab.getJSONObject(i).has("url"))url = tab.getJSONObject(i).get("url").toString();
			else url=" ";
			
			if(tab.getJSONObject(i).has("trailer"))trailer = tab.getJSONObject(i).get("trailer").toString();
			else trailer=" ";
			
			if(tab.getJSONObject(i).has("runtime"))runtime = tab.getJSONObject(i).getInt("runtime");
			else runtime=0;
			
			if(tab.getJSONObject(i).has("tagline"))tagline = tab.getJSONObject(i).get("tagline").toString();
			else tagline=" ";
			
			if(tab.getJSONObject(i).has("overview"))overview = tab.getJSONObject(i).get("overview").toString();
			else overview=" ";
			
			if(tab.getJSONObject(i).has("certification"))certification = tab.getJSONObject(i).get("certification").toString();
			else certification=" ";
			
			if(tab.getJSONObject(i).has("imdb_id"))imdb_id = tab.getJSONObject(i).get("imdb_id").toString();
			else imdb_id=" ";
			
			if(tab.getJSONObject(i).has("tmdb_id"))tmdb_id = tab.getJSONObject(i).getInt("tmdb_id");
			else tmdb_id=0;
			
			if(tab.getJSONObject(i).has("images"))images = tab.getJSONObject(i).getJSONObject("images").get("poster").toString();
			else images=" ";
			
			if(tab.getJSONObject(i).has("genres"))genres = tab.getJSONObject(i).get("genres").toString();
			else genres=" ";
			
			if(tab.getJSONObject(i).has("ratings"))ratings = tab.getJSONObject(i).get("ratings").toString();
			else ratings=" ";
			
			
			trakt[i]=new Trakt(title,released,year,url,trailer,runtime,tagline,overview,certification,
					imdb_id,tmdb_id,images,genres,ratings);
			
		}}else
		{
			trakt = null;
		}
	}

	public Trakt(String s1,int i1,int i2, String s2,String s3,int i3,String s4,String s5,String s6,String s7,int i4,String s8,String s9,String s10)
	{
		this.title=s1;
		Date d =new Date((long)i1*1000);
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
		
		this.released=f.format(d);
		this.year=i2;
		this.url=s2;
		this.trailer=s3;
		this.runtime=i3;
		this.tagline=s4;
		this.overview=s5;
		this.certification=s6;
		this.imdb_id=s7;
		this.tmdb_id=i4;
		this.images=s8;
		this.genres=s9;
		this.ratings=s10;
		
	}
	public String getTitle()
	{
		return this.title;
	}
	public String getReleased()
	{
		return this.released;
	}
	public int getYear()
	{
		return this.year;
	}
	public String getUrl()
	{
		return this.url;
	}
	public String getImdbId()
	{
		return this.imdb_id;
	}
	public String getTrailer()
	{
		return this.trailer;
	}
	public int getRuntime()
	{
		return this.runtime;
	}
	public String getTagline()
	{
		return this.tagline;
	}
	public String getCertification()
	{
		return this.certification;
	}
	public String getOverview()
	{
		return this.overview;
	}
	public int getTmdb_id()
	{
		return this.tmdb_id;
	}
	public String getImages()
	{
		return this.images;
	}
	public String getGenres()
	{
		return this.genres;
	}
	public String getRatings()
	{
		return this.ratings;
	}

	public Trakt[] getMovies()
	{
		return this.trakt;
	}
	public void setLimit(int l)
	{
		this.limit = l;
	}



}
