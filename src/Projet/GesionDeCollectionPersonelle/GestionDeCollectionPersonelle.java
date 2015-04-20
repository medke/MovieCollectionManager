package Projet.GesionDeCollectionPersonelle;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringTokenizer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

import org.json.JSONException;
import org.xml.sax.SAXException;

import Projet.AnalyseurBDD.ImdbParser;
import Projet.AnalyseurBDD.TraktParser;
import Projet.Mediateur.Globaldb;
import Projet.Mediateur.GlobaldbCreator;
import Projet.Mediateur.Imdb;
import Projet.Mediateur.Linkedmdb;
import Projet.Mediateur.Trakt;


public class GestionDeCollectionPersonelle extends JFrame implements ActionListener, MouseListener {
	
	JPanel pane = new JPanel();
	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	//Toolbar
	private  JButton addButton;
	private  JButton delbutton;
	private  JButton showbutton;
	//Menu
	  private JMenuBar menuBar = new JMenuBar();
	  private JMenu fichier = new JMenu("Fichier");
	  private JMenu edition = new JMenu("Edition");
	  private JMenu configuration = new JMenu("Configuration");

	  private JMenu aide = new JMenu("Aide");
	  
	  private JMenuItem item1_1 = new JMenuItem("New");
	  private JMenuItem item1_2 = new JMenuItem("Open");
	  private JMenuItem item1_3 = new JMenuItem("Save");
	  private JMenuItem item1_4 = new JMenuItem("Add a film");
	  private JMenuItem item1_5 = new JMenuItem("Delete a film");
	  private JMenuItem item1_6= new JMenuItem("Exit");
	  private JMenuItem item2_1= new JMenuItem("Join to a file");
	  private JMenuItem item3_1= new JMenuItem("Results limit");
	  private JMenuItem item5_1= new JMenuItem("About");
	  
	//table
		private DefaultTableModel model ;
		private DefaultTableModel model2 ;
		private JTable table;
		private Object[] tab;
		private JButton apercu = new JButton("                  Overview                    ");
		private JButton annuler = new JButton("                  Cancel                    ");
		private JButton valider = new JButton("                  Validate                    ");
		private JComboBox filtre_choix = new JComboBox();
		private JComboBox filtre_text = new JComboBox();
		private JButton filtrerB = new JButton("                         Filtre                         ");
	 //info
		private Globaldb[] movies=null;
		private Globaldb[] movies_enrg=null;
		private JPanel image_space = new JPanel();
		private JLabel lab = new JLabel("id :");
		private JTextField tf1 = new JTextField(5);
		private JLabel lab0 = new JLabel("Title :");
		private JTextField tf2 = new JTextField(20);
		private JLabel lab00 = new JLabel("year :  ");
		private JTextField tf02 = new JTextField(5);
		private JLabel lab1 = new JLabel("Original Title:");
		private JTextField tf3 = new JTextField(20);
		private JLabel lab2 = new JLabel("Date :");
		private JTextField tf4 = new JTextField(20);
		private JLabel lab3 = new JLabel("Language :");
		private JTextField tf5 = new JTextField(20);
		private JLabel lab4 = new JLabel("Country :");
		private JTextField tf6 = new JTextField(20);
		private JLabel lab5 = new JLabel("Link :");
		private JTextField tf7 = new JTextField(20);
		private JLabel lab6 = new JLabel("Director :");
		private JTextField tf8 = new JTextField(20);
		private JLabel lab7 = new JLabel("Type :");
		private JTextField tf9 = new JTextField(20);
		private JLabel lab8 = new JLabel("Actors :");
		private JTextArea ta1 = new JTextArea();
		private JLabel lab9 = new JLabel("Actors :");
		private JTextArea ta2 = new JTextArea();
		private Globaldb glob = new Globaldb();
		private JLabel lab2_1 = new JLabel("Alternative Title :");
		private JTextField tf2_1 = new JTextField(20);
		private JLabel lab2_2 = new JLabel("Evaluation :");
		private JTextField tf2_2 = new JTextField(20);
		private JLabel lab2_3 = new JLabel("Votes :");
		private JTextField tf2_3 = new JTextField(20);
		private JLabel lab2_4 = new JLabel("Year :");
		private JTextField tf2_4 = new JTextField(20);
		private JLabel lab2_5 = new JLabel("Lieux de tournage :");
		private JTextField tf2_5 = new JTextField(20);
		private JLabel lab2_6 = new JLabel("Trailer :");
		private JTextField tf2_6 = new JTextField(20);
		private JLabel lab2_7 = new JLabel("Traduit :");
		private JTextField tf2_7 = new JTextField(20);
		private JLabel lab2_8 = new JLabel("Adult :");
		private JTextField tf2_8 = new JTextField(20);
		private JLabel lab2_9 = new JLabel("Popularité :");
		private JTextField tf2_9 = new JTextField(20);
		private JLabel lab2_10 = new JLabel("Durée :");
		private JTextField tf2_10 = new JTextField(20);
		private JLabel lab2_11 = new JLabel("Imdb id :");
		private JTextField tf2_11 = new JTextField(20);
		private JLabel lab2_12 = new JLabel("Aperçu :");
		private JTextArea ta2_12 = new JTextArea();
		
		DocumentBuilderFactory docFactory ;
		DocumentBuilder docBuilder ;
		static Document doc ;
		static Element rootElement;
		
		private  JButton telechInfo = new JButton("Download the information");
		private String titre;
		private int annee;
		private int limit_tmdb=5;
		private int limit_imdb=5;
		private int limit_trakt=5;
		private JTable table2;
		private JFrame choix = new JFrame();
		private JButton valider2;
		JButton limit;
		JLabel image;
		int meta=0;
		private static int numero_film=0;
	public GestionDeCollectionPersonelle()
	{
		numero_film=0;
		this.setSize(900,650);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Gestion de collection de Films");
		
		JPanel pane_table = new JPanel();pane_table.setBorder(BorderFactory.createLineBorder(Color.gray));
		JPanel pane_info = new JPanel();pane_info.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		pane.setLayout(null);
		pane_table.setBounds(10,10,320, 500);
		pane_info.setBounds(340,10,530, 500);
		
		docFactory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		movies_enrg= new Globaldb[100];
		doc = docBuilder.newDocument();
		rootElement = doc.createElement("Movies");
		rootElement.setAttribute("id", numero_film+"");
		doc.appendChild(rootElement);
		
		model = new DefaultTableModel() {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.addMouseListener(this);
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setPreferredSize(new Dimension(300,480));
		scrollpane.setBounds(new Rectangle(21,32,120,450));
		table.setShowGrid(false);
		scrollpane.getViewport().add(table,null);
		tab=new Object[100];
		tab[0]="Nouveau Film";
		model.addColumn("Film",tab);
		pane_table.add(scrollpane);
		pane.add(pane_table);
		

		JTabbedPane tabPane = new JTabbedPane();
		
		pan1.setLayout(null);
		pan2.setLayout(null);
		lab1.setBounds(40, 5, 100, 20);
		tf3.setBounds(160, 5, 240, 20);
		pan1.add(lab1);
		pan1.add(tf3);
		
		image_space.setBounds(40,50,150,150);
		ImageIcon img = new ImageIcon("movie.png");
		Image img2 = img.getImage();    	
		image = new JLabel(new ImageIcon(img2.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH)));
		image_space.add(image);
		pan1.add(image_space);
		
		lab2.setBounds(210, 50, 100, 20);
		tf4.setBounds(280, 50, 200, 20);
		pan1.add(lab2);
		pan1.add(tf4);
		
		lab3.setBounds(210, 80, 100, 20);
		tf5.setBounds(280, 80, 200, 20);
		pan1.add(lab3);
		pan1.add(tf5);
		
		lab4.setBounds(210, 110, 100, 20);
		tf6.setBounds(280, 110, 200, 20);
		pan1.add(lab4);
		pan1.add(tf6);
		
		lab5.setBounds(210, 140, 100, 20);
		tf7.setBounds(280, 140, 200, 20);
		pan1.add(lab5);
		pan1.add(tf7);
		
		lab6.setBounds(210, 170, 100, 20);
		tf8.setBounds(280, 170, 200, 20);
		pan1.add(lab6);
		pan1.add(tf8);
		
		lab7.setBounds(10, 220, 100, 20);
		tf9.setBounds(80, 220, 400, 20);
		pan1.add(lab7);
		pan1.add(tf9);
		
		lab8.setBounds(10, 250, 100, 20);
		ta1.setBounds(80, 250, 400, 60);ta1.setBorder(tf1.getBorder());
		pan1.add(lab8);
		pan1.add(ta1);
		
		lab9.setBounds(10, 320, 100, 20);
		ta2.setBounds(80, 320, 400, 60);ta2.setBorder(tf1.getBorder());
		pan1.add(lab9);
		pan1.add(ta2);
		
		pan1.setPreferredSize(new Dimension(500,390));
		
		lab2_1.setBounds(10, 10, 100, 20);
		tf2_1.setBounds(150, 10, 340, 20);;
		pan2.add(lab2_1);
		pan2.add(tf2_1);
		
		lab2_2.setBounds(10, 40, 100, 20);
		tf2_2.setBounds(150, 40, 340, 20);;
		pan2.add(lab2_2);
		pan2.add(tf2_2);
		
		lab2_3.setBounds(10, 70, 100, 20);
		tf2_3.setBounds(150, 70, 340, 20);;
		pan2.add(lab2_3);
		pan2.add(tf2_3);		
		
		lab2_4.setBounds(10, 100, 100, 20);
		tf2_4.setBounds(150, 100, 340, 20);;
		pan2.add(lab2_4);
		pan2.add(tf2_4);
		
		lab2_5.setBounds(10, 130, 100, 20);
		tf2_5.setBounds(150, 130, 340, 20);;
		pan2.add(lab2_5);
		pan2.add(tf2_5);
		
		lab2_6.setBounds(10, 160, 100, 20);
		tf2_6.setBounds(150, 160, 340, 20);;
		pan2.add(lab2_6);
		pan2.add(tf2_6);
		
		lab2_7.setBounds(10, 190, 100, 20);
		tf2_7.setBounds(150, 190, 340, 20);;
		pan2.add(lab2_7);
		pan2.add(tf2_7);
		
		lab2_8.setBounds(10, 220, 100, 20);
		tf2_8.setBounds(150, 220, 340, 20);;
		pan2.add(lab2_8);
		pan2.add(tf2_8);
		
		lab2_9.setBounds(10, 250, 100, 20);
		tf2_9.setBounds(150, 250, 340, 20);;
		pan2.add(lab2_9);
		pan2.add(tf2_9);
		
		lab2_10.setBounds(10, 280, 100, 20);
		tf2_10.setBounds(150, 280, 340, 20);;
		pan2.add(lab2_10);
		pan2.add(tf2_10);
		
		lab2_11.setBounds(10, 310, 100, 20);
		tf2_11.setBounds(150, 310, 340, 20);;
		pan2.add(lab2_11);
		pan2.add(tf2_11);
		
		lab2_12.setBounds(10, 340, 100, 20);
		ta2_12.setBounds(150, 340, 340, 40);ta2_12.setBorder(tf1.getBorder());
		pan2.add(lab2_12);
		pan2.add(ta2_12);
		
		tabPane.addTab("Générals", pan1);
		tabPane.addTab("Détails", pan2);
		tabPane.setBounds(80,50,400,500);
		pane_info.add(lab);
		tf1.setText("00"+numero_film+"");
		pane_info.add(tf1);
		pane_info.add(lab0);
		pane_info.add(tf2);
		pane_info.add(lab00);
		pane_info.add(tf02);
		pane_info.add(telechInfo);
		pane_info.add(tabPane);
		pane.add(pane_info );
	
		addMenu();
		addToolbar();
		
		this.add(pane);
		
		telechInfo.addActionListener(this);
		
		this.setVisible(true);
	}
	public void addMenu()
	{
		fichier.add(item1_1);
		fichier.add(item1_2);
		item1_2.addActionListener(this);
		fichier.add(item1_3);
		item1_3.addActionListener(this);
		fichier.addSeparator();
		fichier.add(item1_4);
		item1_4.addActionListener(this);
		fichier.add(item1_5);
		fichier.addSeparator();
		fichier.add(item1_6);
		menuBar.add(fichier);
		edition.add(item2_1);
		item2_1.addActionListener(this);
		menuBar.add(edition);
		configuration.add(item3_1);
		item3_1.addActionListener(this);
		menuBar.add(configuration);
		aide.add(item5_1);
		item5_1.addActionListener(this);
		menuBar.add(aide);
		menuBar.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.gray));
		this.setJMenuBar(menuBar);
	}
	
	public void addToolbar()
	{
		JToolBar toolbar = new JToolBar(JToolBar.HORIZONTAL);
		
		
		addButton = new JButton("Add ",new ImageIcon("E:\\projet\\icons\\1.png"));
		toolbar.add(addButton);
		addButton.addActionListener(this);
		delbutton = new JButton("Delete",new ImageIcon("E:\\projet\\icons\\2.png"));
		toolbar.add(delbutton);
		delbutton.addActionListener(this);
		showbutton = new JButton("Display",new ImageIcon("E:\\projet\\icons\\3.png"));
		toolbar.add(showbutton);
		showbutton.addActionListener(this);
		delbutton.setEnabled(false);
		showbutton.setEnabled(false);
		this.add(toolbar,BorderLayout.NORTH);
	}
	public void setTitreOrignale(String t)
	{
		this.tf3.setText(t) ;
	}
	
	public void fentetreChoix(Globaldb[] movies)
	{
		setFocusableWindowState(false);
		choix.setSize(650, 520);
		JPanel pan = new JPanel();
		
		
		Object[] tab1,tab2,tab3;
		model2 = new DefaultTableModel(){ @Override
		    public boolean isCellEditable(int row, int column) {
	        return false;
	    }};
	    
		table2 = new JTable(model2);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setPreferredSize(new Dimension(620,400));
		table2.setShowGrid(false);
		table2.setIntercellSpacing(new Dimension(0, 0));
		table2.setSelectionBackground(new Color(99,130,191));
		table2.setSelectionForeground(Color.white);
		table2.setRowHeight(40);
		scrollpane.getViewport().add(table2,null);
		int l =movies.length;
		tab1=new Object[l];tab2=new Object[l];tab3=new Object[l];
		
		for(int i=0;i<l;i++)
		{
			tab1[i]=movies[i].getTitre();
			tab2[i]=movies[i].getDateSortie();
			tab3[i]=movies[i].getLangue();
		}
		model2.addColumn("Titre",tab1);model2.addColumn("Date de sortie",tab2);model2.addColumn("Langue",tab3);
		apercu.setBounds(30, 50, 200, 50);
		pan.add(scrollpane);filtre_choix.setSize(400, 20);
		filtre_choix.addItem("        Langue      ");filtre_choix.addItem("        Genre       ");filtre_choix.addItem("        Adult       ");filtre_choix.addItem("        Acteur       "); filtre_choix.addActionListener(this);
		filtre_text.addItem("     Anglais    ");filtre_text.addItem("     Français     ");filtre_text.addItem("     Espagnol   ");
		filtrerB.addActionListener(this);
		pan.add(filtre_choix);pan.add(filtre_text);pan.add(filtrerB);pan.add(apercu);pan.add(valider);pan.add(annuler);
		if(meta==0)
		{
		apercu.addActionListener(this);
		valider.addActionListener(this);
		}
		meta=1;
		choix.setContentPane(pan);
		choix.setLocationRelativeTo(null);
		choix.addWindowListener(new WindowAdapter(){
		      public void windowClosing(WindowEvent we){
					setFocusableWindowState(true);
					
		      }});
		annuler.addActionListener(new ActionListener() {

		    public void actionPerformed(ActionEvent e)
		    {
		    	setFocusableWindowState(true);
		    	choix.dispose();

		    }
		});
		
		choix.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(numero_film<=0)
		{
			delbutton.setEnabled(false);
			showbutton.setEnabled(false);
		}else
		{
			delbutton.setEnabled(true);
			showbutton.setEnabled(true);
		}
		if(e.getSource()==telechInfo)
		{

			long startTime = System.currentTimeMillis();
			
			this.setTitle(this.getTitle()+" |  Chargement des resultats depuis les source , patienter svp ...");
			
		
		
		Imdb im = new Imdb();
		Trakt tr = new Trakt();
		tr.setLimit(limit_trakt);
		
		
		titre=tf2.getText();
		if(tf02.getText().length()==4)
		annee =Integer.parseInt(tf02.getText());
		
		
		try {
			if(annee>1900 && annee<2030)
			{
			
				im.ExtractInfo(ImdbParser.readJsonFromUrl(titre,annee,limit_imdb));
			}
			else
			{
			
				im.ExtractInfo(ImdbParser.readJsonFromUrl(titre,annee,limit_imdb));
				tr.ExtractInfo(TraktParser.readJsonFromUrl(titre));
			}
			Linkedmdb link = new Linkedmdb();
			link.ExtractLinkedmdb(titre);
			GlobaldbCreator global=new GlobaldbCreator(im.getMovies(),tr.getMovies(),link.getLinks());
			try {
				glob.extractInfo(global.createXML());
			} catch (TransformerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			movies = glob.getMovies();
			fentetreChoix(movies);
			long endTime = System.currentTimeMillis();;
			System.out.println("That took " + (endTime - startTime) + " milliseconds");

			this.setTitle("Gestion de collection de Films");
			
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (JSONException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		}
		else if(e.getSource()==filtrerB)
		{
			model2.setRowCount(0);
			model2.setColumnCount(0);
			Object[] tab1,tab2,tab3;
			
			int compteur =0;
			int l = movies.length;
			tab1=new Object[l];tab2=new Object[l];tab3=new Object[l];
			if(filtre_choix.getSelectedIndex()==0){
				String lang1 ="";
				String lang2 = filtre_text.getSelectedItem().toString().replaceAll(" ", "");
				if(lang2.equals("Anglais"))
					lang1="ENGLISH";
				else if (lang2.equals("Français"))
					lang2="FRENCH";
				for(int i =0;i<l;i++)
				{
					if(movies[i].getLangue().contains(lang2.toUpperCase()) || movies[i].getLangue().contains("lang1") ){
						
						tab1[i]=movies[i].getTitre();
						tab2[i]=movies[i].getDateSortie()+" "+movies[i].getAnnee();
						tab3[i]=movies[i].getLangue();
					}
				}

			
				
			}else if(filtre_choix.getSelectedIndex()==1)
			{
				String genre = filtre_text.getSelectedItem().toString().replaceAll(" ", "");
				if(genre.equals("Aventure"))
					genre="Aventure";
				else if(genre.equals("Guerre"))
					genre="War";
				else if(genre.equals("Famille"))
					genre="Family";
				for(int i =0;i<l;i++)
				{
					if(movies[i].getGenre().contains(genre) ){
						
						tab1[i]=movies[i].getTitre();
						tab2[i]=movies[i].getDateSortie()+" "+movies[i].getAnnee();
						tab3[i]=movies[i].getLangue();
					}
				}
				
			}
			else if(filtre_choix.getSelectedIndex()==2)
			{
				String adult = filtre_text.getSelectedItem().toString().replaceAll(" ", "");
				if(adult.equals("OUI"))
					adult="true";
				else 
					adult="false";
				for(int i =0;i<l;i++)
				{
					
					if(movies[i].getAdult().contains(adult) ){
						
						tab1[i]=movies[i].getTitre();
						tab2[i]=movies[i].getDateSortie()+" "+movies[i].getAnnee();
						tab3[i]=movies[i].getLangue();
					}
				}
				
			}
			else if(filtre_choix.getSelectedIndex()==3)
			{
				String acteur = filtre_text.getSelectedItem().toString();
				for(int i =0;i<l;i++)
				{
					
					if(movies[i].getActeurs().contains(acteur) ){
						
						tab1[i]=movies[i].getTitre();
						tab2[i]=movies[i].getDateSortie()+" "+movies[i].getAnnee();
						tab3[i]=movies[i].getLangue();
					}
					
				}

				
			}
			model2.addColumn("Title",tab1);model2.addColumn("Released Data",tab2);model2.addColumn("Language",tab3);
		}
		else if(e.getSource()==valider)
		{
			delbutton.setEnabled(true);
			showbutton.setEnabled(true);
			
			setFocusableWindowState(true);
			int selected = table2.getSelectedRow();
			
			if(movies!=null && selected>=0)
			{
			tf3.setText(movies[selected].getTitre_original());
			tf4.setText(movies[selected].getDateSortie());
			tf5.setText(movies[selected].getLangue());
			tf6.setText(movies[selected].getPays());
			tf7.setText(movies[selected].getLien());
			tf8.setText(movies[selected].getDirecteurs());
			tf9.setText(movies[selected].getGenre());
			ta1.setText(movies[selected].getActeurs());
			tf2_1.setText(movies[selected].getTitre_alternative());
			tf2_2.setText(movies[selected].getEvaluation());
			tf2_3.setText(movies[selected].getVotes());
			tf2_4.setText(movies[selected].getAnnee());
			tf2_5.setText(movies[selected].getLieux_tournage());
			tf2_6.setText(movies[selected].getTrailer());
			tf2_7.setText(movies[selected].getTraduit());
			tf2_8.setText(movies[selected].getAdult());
			tf2_9.setText(movies[selected].getPopularite());
			tf2_10.setText(movies[selected].getDuree());
			tf2_11.setText(movies[selected].getImdb_id());
			ta2_12.setText(movies[selected].getApercu());

				movies_enrg[numero_film]=movies[selected];

			
			String imageUrl = movies[selected].getImage();

			tab[0] = movies[selected].getTitre();
			model.setValueAt(movies[selected].getTitre(), numero_film, 0);
			
			
			try {
				
				save(movies[selected]);
			} 
			catch (TransformerException e1) {
			
				e1.printStackTrace();
					
			} 
			catch (ParserConfigurationException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			numero_film++;
			
			
			telechInfo.setEnabled(false);

			if(imageUrl.replaceAll(" ", "").length()>3)
			{
				image_space.remove(image);
				String destinationFile = "Movies//"+movies[selected].getId()+".jpg";
				ImageIcon img = new ImageIcon(destinationFile);
				Image img2 = img.getImage();    	
				image.setIcon(new ImageIcon(img2.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH)));
				image = new JLabel(new ImageIcon(img2.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH)));
				image_space.add(image);
				image_space.revalidate();
				pan1.repaint();
				try {
					saveImage(imageUrl, destinationFile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

			choix.dispose();
			setFocusableWindowState(true);
							
				      	
						
					
			
		}
		else if(e.getSource()==item3_1)
		{
			final JFrame fn =new JFrame("Limiter le nombre de resultat des sources ");
			JPanel pan = new JPanel();
			pan.setLayout(null);
			fn.setContentPane(pan);
			JLabel lab1 = new JLabel("Site 1 (The Movie Database) :");lab1.setBounds(5, 5, 150, 20);
			final JTextField tf1 = new JTextField(3);tf1.setBounds(200, 5, 50, 20);tf1.setText(limit_tmdb+"");
			JLabel lab2 = new JLabel("Site 2 (IMDB) :");lab2.setBounds(5, 35, 150, 20);
			final JTextField tf2 = new JTextField(3);tf2.setBounds(200, 35, 50, 20);tf2.setText(limit_imdb+"");
			JLabel lab3 = new JLabel("Site 3 (Trakt.tv) :");lab3.setBounds(5, 65, 150, 20);
			final JTextField tf3 = new JTextField(3);tf3.setBounds(200, 65, 50, 20);tf3.setText(limit_trakt+"");
			limit = new JButton("Valider");limit.setBounds(100, 95, 100, 20);
			limit.addActionListener(new ActionListener() {

			    public void actionPerformed(ActionEvent e)
			    {
			    	limit_imdb=Integer.parseInt(tf2.getText());
			    	limit_tmdb=Integer.parseInt(tf1.getText());
			    	limit_trakt=Integer.parseInt(tf3.getText());
			    	fn.dispose();

			    }
			});
			pan.add(lab1);pan.add(tf1);
			pan.add(lab2);pan.add(tf2);
			pan.add(lab3);pan.add(tf3);
			pan.add(limit);
			fn.setSize(300, 200);
			fn.setLocationRelativeTo(null);
			fn.setVisible(true);
			
		}
		else if(e.getSource()==filtre_choix)
		{
			if(filtre_choix.getSelectedIndex()==0)
			{
				filtre_text.removeAllItems();
				filtre_text.addItem("     Anglais     ");filtre_text.addItem("     Français     ");filtre_text.addItem("     Espagnol     ");
			}else if(filtre_choix.getSelectedIndex()==1)
			{
				filtre_text.removeAllItems();
				filtre_text.addItem("     Aventure     ");filtre_text.addItem("     Drama     ");filtre_text.addItem("     Romance     ");filtre_text.addItem("     Thriller     ");filtre_text.addItem("     Crime     ");filtre_text.addItem("     Famille     ");
				filtre_text.addItem("     Comedy     ");filtre_text.addItem("     Guerre     ");filtre_text.addItem("     Comedy     ");
			}else if(filtre_choix.getSelectedIndex()==2)
			{
				filtre_text.removeAllItems();
				filtre_text.addItem("                   OUI                   ");filtre_text.addItem("                   NON                   ");
			}
			else if(filtre_choix.getSelectedIndex()==3)
			{
				filtre_text.removeAllItems();
				String acteurs="";
				String acteur[];
				int j = 0;
				for(int i=0;i<movies.length;i++)
				{
				acteurs +=movies[i].getActeurs()+",";
				}
				StringTokenizer st = new StringTokenizer(acteurs,"," );
		        while(st.hasMoreTokens())
		        {
		          tab[j] = st.nextToken();
		          if(tab[j].toString().replaceAll(" ", "").length()>3)
		          filtre_text.addItem(tab[j]);
		        
		        j++;
		      }
				
			}
		}
		else if(e.getSource()==apercu)
		{
			choix.setFocusableWindowState(false);
		
			
			if(movies!=null)
			{
		
			int selected=table2.getSelectedRow();
			if(selected>=0)
			{
			final JFrame fn=new JFrame("Aperçu");
			fn.addWindowListener(new WindowAdapter(){
			      public void windowClosing(WindowEvent we){	
						choix.setFocusableWindowState(true);
					
						
			      }});
			fn.setAlwaysOnTop(true);
			fn.setLocation(500, 100);
			fn.setSize(300, 500);
			
			JScrollPane scrollpane = new JScrollPane();
			scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			
			JLabel lb1= new JLabel("Titre :");
			JTextField tf1 = new JTextField();tf1.setEditable(false);tf1.setText(movies[selected].getTitre()+"");tf1.setCaretPosition(0);
			lb1.setBounds(5, 5, 150, 20);
			tf1.setBounds(120, 5, 150,20);
			
			JLabel lb2= new JLabel("Date de sortie :");
			JTextField tf2 = new JTextField();tf2.setEditable(false);tf2.setText(movies[selected].getDateSortie()+"");
			lb2.setBounds(5, 35, 150, 20);
			tf2.setBounds(120,35, 150, 20);
			
			JLabel lb3= new JLabel("Durée :");
			JTextField tf3 = new JTextField();tf3.setEditable(false);tf3.setText(movies[selected].getDuree()+"");
			lb3.setBounds(5, 65, 150, 20);
			tf3.setBounds(120,65, 150, 20);
			
			JLabel lb4= new JLabel("Directeur :");
			JTextField tf4 = new JTextField();tf4.setText(movies[selected].getDirecteurs()+"");tf4.setCaretPosition(0);
			lb4.setBounds(5, 95, 150, 20);tf4.setEditable(false);
			tf4.setBounds(120,95, 150, 20);
			
			JLabel lb5= new JLabel("Ecrivains :");
			JTextField tf5 = new JTextField();tf5.setEditable(false);tf5.setText(movies[selected].getEcrivains()+"");tf5.setCaretPosition(0);
			lb5.setBounds(5, 125, 150, 20);
			tf5.setBounds(120,125, 150, 20);
			
			JLabel lb6= new JLabel("Acteurs :");
			JTextField tf6 = new JTextField();tf6.setEditable(false);tf6.setText(movies[selected].getActeurs()+"");tf6.setCaretPosition(0);
			lb6.setBounds(5, 155, 150, 20);
			tf6.setBounds(120,155, 150, 20);
			
			JLabel lb7= new JLabel("Lieu de tournage :");
			JTextField tf7 = new JTextField();tf7.setEditable(false);tf7.setText(movies[selected].getLieux_tournage()+"");tf7.setCaretPosition(0);
			lb7.setBounds(5, 185, 150, 20);
			tf7.setBounds(120,185, 150, 20);
			
			JLabel lb8= new JLabel("pays :");
			JTextField tf8 = new JTextField();tf8.setEditable(false);tf8.setText(movies[selected].getPays()+"");
			lb8.setBounds(5, 215, 150, 20);
			tf8.setBounds(120,215, 150, 20);
			
			JLabel lb9= new JLabel("Langue :");
			JTextField tf9 = new JTextField();tf9.setEditable(false);tf9.setText(movies[selected].getLangue()+"");tf9.setCaretPosition(0);
			lb9.setBounds(5, 245, 150, 20);
			tf9.setBounds(120,245, 150, 20);
			
			JLabel lb10= new JLabel("Lien :");
			JTextField tf10 = new JTextField();tf10.setEditable(false);tf10.setText(movies[selected].getLien()+"");tf10.setCaretPosition(0);
			lb10.setBounds(5, 275, 150, 20);
			tf10.setBounds(120,275, 150, 20);
			
			JLabel lb11= new JLabel("Image :");
			JButton b1 = new JButton("Voir l'image");
			final String urrl=movies[selected].getImage();
	
			
			b1.addActionListener(new ActionListener() {

			    public void actionPerformed(ActionEvent e)
			    {
			        //Execute when button is pressed
			    	try {
						Runtime.getRuntime().exec("cmd /c start "+urrl);
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						
					}
			    }
			});
			
			lb11.setBounds(5, 305, 150, 20);
			b1.setBounds(120,305, 150, 20);
			
			JLabel lb12= new JLabel("Titre Alternative :");
			JTextField tf12 = new JTextField();tf12.setEditable(false);tf12.setText(movies[selected].getTitre_alternative()+"");tf12.setCaretPosition(0);
			lb12.setBounds(5, 335, 150, 20);
			tf12.setBounds(120,335, 150, 20);
			
			JLabel lb13= new JLabel("Source :");
			JTextField tf13 = new JTextField();tf13.setEditable(false);tf13.setText(movies[selected].getSource()+"");tf13.setCaretPosition(0);
			lb13.setBounds(5, 365, 150, 20);
			tf13.setBounds(120,365, 150, 20);
			
			valider2 = new JButton("Valide");valider2.setBounds(40,410, 200, 20);
			scrollpane.setLayout(null);
			scrollpane.add(lb1);scrollpane.add(tf1);
			scrollpane.add(lb2);scrollpane.add(tf2);
			scrollpane.add(lb3);scrollpane.add(tf3);
			scrollpane.add(lb4);scrollpane.add(tf4);
			scrollpane.add(lb5);scrollpane.add(tf5);
			scrollpane.add(lb6);scrollpane.add(tf6);
			scrollpane.add(lb7);scrollpane.add(tf7);
			scrollpane.add(lb8);scrollpane.add(tf8);
			scrollpane.add(lb9);scrollpane.add(tf9);
			scrollpane.add(lb10);scrollpane.add(tf10);	
			scrollpane.add(lb11);scrollpane.add(b1);
			scrollpane.add(lb12);scrollpane.add(tf12);	
			scrollpane.add(lb13);scrollpane.add(tf13);	
			scrollpane.add(valider2);

			valider2.addActionListener(new ActionListener() {

			    public void actionPerformed(ActionEvent e)
			    {
			    	 		fn.dispose();
							choix.setFocusableWindowState(true);
							
				      	
						
					
			}});
			fn.setContentPane(scrollpane);
			fn.setVisible(true);
			}
		}}else if(e.getSource()==addButton || e.getSource()==item1_4){
			

			
			model.setValueAt("New Film", numero_film, 0);
			telechInfo.setEnabled(true);
			tf1.setText("00"+numero_film+"");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			tf6.setText("");
			tf7.setText("");
			tf8.setText("");
			tf9.setText("");
			ta1.setText("");
			tf2_1.setText("");
			tf2_2.setText("");
			tf2_3.setText("");
			tf2_4.setText("");
			tf2_5.setText("");
			tf2_6.setText("");
			tf2_7.setText("");
			tf2_8.setText("");
			tf2_9.setText("");
			tf2_10.setText("");
			tf2_11.setText("");
			ta2_12.setText("");
			image_space.remove(image);
			ImageIcon img = new ImageIcon("movie.png");
			Image img2 = img.getImage();    	
			image = new JLabel(new ImageIcon(img2.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH)));
			image_space.add(image);
			image_space.revalidate();
			pan1.repaint();
			tf2.setText("");
			tf02.setText("");
			
		}
		else if (e.getSource()==item1_2)
		{
			FileFilter imagesFilter = new FileNameExtensionFilter("xml","xml");
			JFileChooser c = new JFileChooser();
			c.setAcceptAllFileFilterUsed(false);
			c.addChoosableFileFilter(imagesFilter);
			String dir="";
			String filename="sans_titre";
			
			int rVal = c.showOpenDialog(c);
			 if (rVal == JFileChooser.APPROVE_OPTION) {
			        filename=c.getSelectedFile().getName();
			        dir=c.getCurrentDirectory().toString();
			      }
			 File file = new File(dir+"\\"+filename); 
			
			 DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
			 DocumentBuilder db;
			try {
				db = dbf.newDocumentBuilder();
				Document doc = db.parse(file);
				glob.extractInfo(doc);
				movies_enrg = glob.getMovies();
				tab=new Object[100];
				for(int i=0;i<movies_enrg.length;i++)
				tab[i]=movies_enrg[i].getTitre();
				numero_film = movies_enrg.length;
				model.setColumnCount(0);
				model.setRowCount(0);
				model.addColumn("Film",tab);
				
			}catch (SAXException e1) {
					// TODO Auto-generated catch block
					
			} catch (IOException e1) {
					// TODO Auto-generated catch block
					
			} 
			 catch (ParserConfigurationException e1) {
				// TODO Auto-generated catch block
				
			} 
			 
		}else if (e.getSource()==delbutton)
		{
			if(numero_film<=0)
			{
				delbutton.setEnabled(false);
			}else{
			int selected = table.getSelectedRow();
			model.removeRow(selected);
			if(movies_enrg.length!=selected)
			{
			for(int i =0;i<movies_enrg.length;i++)
			{
				if(i>=selected && i!=movies_enrg.length-1)
					movies_enrg[i]=movies_enrg[i+1];
			}
			}else
			{
				movies_enrg[selected]=null;
			}
			numero_film--;
			}
			
		}else if (e.getSource()==showbutton)
		{
			int selected = table.getSelectedRow();
			tf3.setText(movies_enrg[selected].getTitre_original());
			tf4.setText(movies_enrg[selected].getDateSortie());
			tf5.setText(movies_enrg[selected].getLangue());
			tf6.setText(movies_enrg[selected].getPays());
			tf7.setText(movies_enrg[selected].getLien());
			tf8.setText(movies_enrg[selected].getDirecteurs());
			tf9.setText(movies_enrg[selected].getGenre());
			ta1.setText(movies_enrg[selected].getActeurs());
			tf2_1.setText(movies_enrg[selected].getTitre_alternative());
			tf2_2.setText(movies_enrg[selected].getEvaluation());
			tf2_3.setText(movies_enrg[selected].getVotes());
			tf2_4.setText(movies_enrg[selected].getAnnee());
			tf2_5.setText(movies_enrg[selected].getLieux_tournage());
			tf2_6.setText(movies_enrg[selected].getTrailer());
			tf2_7.setText(movies_enrg[selected].getTraduit());
			tf2_8.setText(movies_enrg[selected].getAdult());
			tf2_9.setText(movies_enrg[selected].getPopularite());
			tf2_10.setText(movies_enrg[selected].getDuree());
			tf2_11.setText(movies_enrg[selected].getImdb_id());
			ta2_12.setText(movies_enrg[selected].getApercu());
			if(movies_enrg[selected].getImage().replaceAll(" ", "").length()>3)
			{
			image_space.remove(image);
			ImageIcon img = new ImageIcon("movies//"+movies_enrg[selected].getImdb_id()+".jpg");
			Image img2 = img.getImage();    	
			image = new JLabel(new ImageIcon(img2.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH)));
			image_space.add(image);
			image_space.revalidate();
			pan1.repaint();
			}
			else
			{
				image_space.remove(image);
				ImageIcon img = new ImageIcon("movie.png");
				Image img2 = img.getImage();    	
				image = new JLabel(new ImageIcon(img2.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH)));
				image_space.add(image);
				image_space.revalidate();
				pan1.repaint();
			}
			
		}
		else if (e.getSource()==item2_1)
		{
			JFileChooser c = new JFileChooser();
			c.setAcceptAllFileFilterUsed(false);
			//c.addChoosableFileFilter(new FileNameExtensionFilter("avi", "mpg", "mp4"));
			String dir="";
			String filename="sans_titre";
			int rVal = c.showOpenDialog(c);
			int selected=table.getSelectedRow();
		      if (rVal == JFileChooser.APPROVE_OPTION) {
		    	filename="";
		        filename= c.getSelectedFile().getName();
		        dir = c.getCurrentDirectory().toString();
		        movies_enrg[selected].setFile(dir+"\\"+filename);
		    
		        
		      }
		}else if (e.getSource()==item5_1)
		{
			JFrame fn = new JFrame();
			JPanel pane = new JPanel();
			ImageIcon img =new ImageIcon("apropos.jpg");
			JLabel image = new JLabel(img);
			//pane.setLayout(new BorderLayout, CENTER);
			pane.add(image);
			fn.setContentPane(pane);
			fn.setSize(img.getIconWidth(),img.getIconHeight());
			fn.setLocationRelativeTo(null);
			fn.setVisible(true);
		}
		else if (e.getSource()==item1_3)
		{
			if(numero_film>0)
			{
			FileFilter imagesFilter = new FileNameExtensionFilter("xml","xml");
			JFileChooser c = new JFileChooser();
			c.setAcceptAllFileFilterUsed(false);
			c.addChoosableFileFilter(imagesFilter);
			String dir="";
			String filename="sans_titre";
			int rVal = c.showSaveDialog(c);
		      if (rVal == JFileChooser.APPROVE_OPTION) {
		    	  filename="";
		        filename= c.getSelectedFile().getName();
		        dir = c.getCurrentDirectory().toString();
		        
		      }
		      
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = null;
			try {
				transformer = transformerFactory.newTransformer();
			} catch (TransformerConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			DOMSource sources = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(dir+"\\"+filename+".xml"));
			
			try {
				transformer.transform(sources, result);
			} catch (TransformerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
			 
		}
		

	}
	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
		try {
			
			
		URL url = new URL(imageUrl);
		  URLConnection con = url.openConnection(); ;
		  con.setRequestProperty("User-Agent",
		     "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.10 (KHTML, like Gecko) Chrome/8.0.552.237 Safari/534.10");
		InputStream is = con.getInputStream();
		OutputStream os = new FileOutputStream(destinationFile);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}
		
		is.close();
		os.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	public static void save(Globaldb film) throws ParserConfigurationException, TransformerException
	{
	

		
		Element movie = doc.createElement("Movie");
		movie.setAttribute("id", numero_film+"");
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
		

		id.setTextContent(film.getImdb_id()+"");
		movie.appendChild(id);

		titre.setTextContent(film.getTitre()+"");
		movie.appendChild(titre);
		
		genre.setTextContent(film.getGenre()+"");
		movie.appendChild(genre);
		
		lien.setTextContent(film.getLien()+"");
		movie.appendChild(lien);
		
		
		date_sortie.setTextContent(film.getDateSortie()+" ");
		movie.appendChild(date_sortie);
		
		apercu.setTextContent(film.getApercu()+"");
		movie.appendChild(apercu);
		
		evaluation.setTextContent(film.getEvaluation()+"");
		movie.appendChild(evaluation);
		
		image.setTextContent(film.getImage()+"");
		movie.appendChild(image);
		
		certification.setTextContent(film.getCertification()+"");
		movie.appendChild(certification);
		
		imdb_id.setTextContent(film.getImdb_id()+"");
		movie.appendChild(imdb_id);
		
		titre_original.setTextContent(film.getTitre_original());
		movie.appendChild(titre_original);
		
		titre_alternative.setTextContent(film.getTitre_alternative()+"");
		movie.appendChild(titre_alternative);
		
		annee.setTextContent(film.getAnnee()+"");
		movie.appendChild(annee);
		
		votes.setTextContent(film.getVotes()+"");
		movie.appendChild(votes);
		
		langue.setTextContent(film.getLangue()+"");
		movie.appendChild(langue);
		
		traduit.setTextContent(film.getTraduit());
		movie.appendChild(traduit);
		
		popularite.setTextContent(film.getPopularite());
		movie.appendChild(popularite);
		
		adult.setTextContent(film.getAdult());
		movie.appendChild(adult);
		
		runtime.setTextContent(film.getDuree());
		movie.appendChild(runtime);
		
		pays.setTextContent(film.getPays()+"");
		movie.appendChild(pays);
		
		trailer.setTextContent(film.getTrailer());
		movie.appendChild(trailer);
		
		lieux_tournage.setTextContent(film.getLieux_tournage()+"");
		movie.appendChild(lieux_tournage);
		
		ecrivains.setTextContent(film.getEcrivains()+"");
		movie.appendChild(ecrivains);
		
		directeurs.setTextContent(film.getDirecteurs()+"");
		movie.appendChild(directeurs);
		
		acteurs.setTextContent(film.getActeurs()+"");
		movie.appendChild(acteurs);
		
		
		movie.appendChild(source);

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	      JTable target = (JTable)e.getSource();
	      int row = target.getSelectedRow();
	      if(row<numero_film)
	      {
		 if (e.getClickCount() == 2) {
			 if(movies_enrg[row].getFile()!=null)
			 {
		      
		    	try {
		    		
					Runtime.getRuntime().exec("cmd /c start "+movies_enrg[row].getFile());
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					
				}
				}
		      }
		      
		    
		 if(e.getClickCount()==1)
		 {
			 showbutton.doClick();
		 }
	      }
	}
	@Override
	public void mouseEntered(MouseEvent e) {

		
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	

}
