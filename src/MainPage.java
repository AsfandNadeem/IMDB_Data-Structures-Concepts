

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainPage extends JFrame {

	private JLabel label1;

	private JTextField searchNameT;
	private JTextField searchACT;
	private JTextField searchDT;
	private JTextField searchCoT;
	private JTextField searchRatStartT;
	private JTextField searchRatEndT;
	private JTextField searchGenT;
	private JTextField searchYearT;
	private JButton searchN;
	private JButton searchAC;
	private JButton searchD;
	private JButton searchCo;
	private JButton searchRat;
	private JButton searchGen;
	private JButton searchYear;
	private JButton exitbtn;
	private JLabel background;
	private ImageIcon logo;
	private JPanel DisplayPanel;
	private JTextArea textarea;
	MovieHash movies;
	ActorHash actors;
	DirectorHash directors;
	YearHash years;
		
	public MainPage(MovieHash movieHash, ActorHash actorHash, DirectorHash directorHash,YearHash yearHash)
	{
		super("Search");
		setSize(1280,660);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		movies=movieHash;
		actors=actorHash;
		directors=directorHash;
		years=yearHash;
		
		logo= new ImageIcon(getClass().getResource("AMinpage.jpg"));
		background= new JLabel(logo);
	
				
		label1 = new JLabel("Search");
        label1.setFont(new Font("Cambria", Font.BOLD, 40));
        label1.setBounds(580, 50, 800, 50);
        add(label1);
        

        
		searchNameT = new JTextField(10);
		searchNameT = new JTextField("Enter Movie Name");
	    searchNameT.setBounds(50, 100, 300, 35);
	    		
	  	searchN=new JButton("Search By Movie");
	  	searchN.setContentAreaFilled(false);
	  	searchN.setBounds(50, 130, 300, 35);
	  		    	    

		searchCoT = new JTextField(10);
		searchCoT = new JTextField("Enter Actor Name");
	    searchCoT.setBounds(50, 200, 300, 35);
	    		
	  	searchCo=new JButton("Search CoActors");
	  	searchCo.setContentAreaFilled(false);
	  	searchCo.setBounds(50, 230, 300, 35);
	  	
	  	searchRatStartT = new JTextField(10);
		searchRatStartT = new JTextField("Enter Start rating");
		//searchRatStartT.setBounds(x, y, width, height);
		searchRatStartT.setBounds(50, 305, 100, 35);
		
		searchRatEndT = new JTextField(10);
		searchRatEndT = new JTextField("Enter end rating");
		//searchRatStartT.setBounds(x, y, width, height);
		searchRatEndT.setBounds(250, 305, 100, 35);
		    		
		 searchRat=new JButton("Search By Rating");
		 searchRat.setContentAreaFilled(false);
		searchRat.setBounds(50, 340, 300, 35);

		searchACT = new JTextField(10);
		searchACT = new JTextField("Enter Actor Name");
		searchACT.setBounds(500, 100, 300, 35);
		    		
		 searchAC=new JButton("Search By Actor");
		 searchAC.setContentAreaFilled(false);
		searchAC.setBounds(500, 130, 300, 35);
		
		
		

	        
		searchDT = new JTextField(10);
		searchDT = new JTextField("Enter Director Name");
		searchDT.setBounds(950, 100, 300, 35);
		    		
		 searchD=new JButton("Search By Director");
		 searchD.setContentAreaFilled(false);
		searchD.setBounds(950,130, 300, 35);
		
		searchGenT = new JTextField(10);
		searchGenT = new JTextField("Enter Genre");
		searchGenT.setBounds(950, 200, 300, 35);
		    		
		 searchGen=new JButton("Search By Genre");
		 searchGen.setContentAreaFilled(false);
		searchGen.setBounds(950,230, 300, 35);
		
		searchYearT = new JTextField(10);
		searchYearT = new JTextField("Enter Year");
		searchYearT.setBounds(950, 300, 300, 35);
		    		
		searchYear=new JButton("Search By Year");
		searchYear.setContentAreaFilled(false);
		searchYear.setBounds(950,330, 300, 35);
	   
	  	  	
	  	exitbtn=new JButton("Exit");
	  	exitbtn.setBounds(1000, 520, 90, 25);
	  	

	  	
	  	textarea = new JTextArea(5, 30);
	  	final JScrollPane scrollPane = new JScrollPane(textarea);
	  	 	setPreferredSize(new Dimension(450, 110));
	  	 	//scrollPane.setBounds(x, y, width, height);
	  	 	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	  	 	scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	  	 	scrollPane.setBounds(500,170, 300, 300);
	  	 	scrollPane.setVisible(false);
	  	  	add(scrollPane);
	  	  	
	  	
		add(label1);
		add(searchNameT);
		add(searchN);
		add(searchACT);
		add(searchAC);
		add(searchDT);
		add(searchD);
		add(searchCoT);
		add(searchCo);
		add(searchRatStartT);
		add(searchRatEndT);
		add(searchRat);
		add(searchGenT);
		add(searchGen);
		add(searchYearT);
		add(searchYear);
		add(exitbtn);
		
		
		add(background).setBounds(0,0,1280,660);

			
		
//		SearchListener S=new SearchListener();
		searchN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollPane.setVisible(true);
                textarea.setText(movies.searchMovie(searchNameT.getText()));

              
            }
        });
		
		searchAC.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollPane.setVisible(true);
                textarea.setText(actors.searchActor(searchACT.getText()));	
              
            }
        });
		
		searchD.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollPane.setVisible(true);
                textarea.setText(directors.searchDirector(searchDT.getText()));			
              
            }
        });
		
		searchCo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollPane.setVisible(true);
                textarea.setText((actors.PrintCoActors( searchCoT.getText())));			
              
            }
        });
		
		searchYear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollPane.setVisible(true);
                int y=Integer.parseInt(searchYearT.getText());
                textarea.setText((years.searchMoviebyYear(y)));			
              
            }
        });
		
		searchRat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollPane.setVisible(true);
                double s=Double.parseDouble(searchRatStartT.getText());
                double end=Double.parseDouble(searchRatEndT.getText());
                textarea.setText(movies.searchByHRating(s,end));		
              
            }
        });
		
		searchGen.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollPane.setVisible(true);
                textarea.setText(movies.searchByHGenre(searchGenT.getText()));			
              
            }
        });
		
		exitbtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);		              
            }
        });
	}
}


