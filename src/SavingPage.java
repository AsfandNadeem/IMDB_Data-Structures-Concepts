

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SavingPage extends JFrame {
	private JLabel background;
	private JButton saveDB;
	private ImageIcon logo;

	public SavingPage() {
		super("Welcome");
		setSize(600, 350);
		setLayout(new BorderLayout());

		logo = new ImageIcon(getClass().getResource("logo-IMDB.jpg"));
		background = new JLabel(logo);

		saveDB = new JButton("Save IMDB database");
		// saveDB.setBounds(x, y, width, height);
		saveDB.setBounds(220, 30, 150, 20);
		saveDB.addActionListener(new ButtonListener());

		add(saveDB);
		add(background);
		setVisible(true);
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == saveDB) {

				MovieHash movieHash = new MovieHash();// making a Movie hash
														// reference
				ActorHash actorHash = new ActorHash();// making an actor hash
														// reference
				DirectorHash directorHash = new DirectorHash();// making a
																// Director hash
																// reference

				YearHash yearHash = new YearHash();// making a year hash

				String csvFile = "C:\\Users\\123\\workspace\\DSProject034_008\\src\\IMDB_Top5000.csv";
				BufferedReader br = null;
				String line = "";
				String cvsSplitBy = ",";// reading file

				try {

					br = new BufferedReader(new FileReader(csvFile));
					while ((line = br.readLine()) != null) {

						// use comma as separator
						String[] abc = line.split(cvsSplitBy);

						ActorNode a1 = new ActorNode();// making
						ActorNode a2 = new ActorNode();// 3
						ActorNode a3 = new ActorNode();// actornodes as there
														// are 9 columns for
														// actors

						DirectorNode d = new DirectorNode(abc[1], abc[4]);

						a1 = new ActorNode(abc[10], abc[7]);// adding respective
															// columns to actor
															// as well as list
															// of movie
															// that the actor
															// has done
						a2 = new ActorNode(abc[6], abc[24]);// adding respective
															// columns to actor
						a3 = new ActorNode(abc[14], abc[5]);// adding respective
															// columns to actor
						// and also a default empty movie link list is being
						// created with each actor

						MovieActorList MA = new MovieActorList();// A list
																	// having
																	// all 3
																	// actors of
																	// a certain
																	// movie
						MA.addAtFront(a1);// adding actornodes into actors list
											// of respective movie node
						MA.addAtFront(a2);
						MA.addAtFront(a3);
						MovieNode Movienode = new MovieNode(abc[0], abc[2], abc[3], abc[8], abc[9], abc[11], abc[12],
								abc[13], abc[15], abc[16], abc[17], abc[18], abc[19], abc[20], abc[21], abc[22],
								abc[23], abc[25], abc[26], abc[27], MA, d);// creating
																			// a
																			// movie
																			// node
						// with respective list of actors and a director

						movieHash.insertMovie(Movienode);// inserting movie into
															// a hash table
															// consisting
						// of avl trees

						actorHash.insertActor(a1, Movienode);// inserting actors
																// into a hash
																// table
																// consisting
						// of avl trees
						actorHash.insertActor(a2, Movienode);
						actorHash.insertActor(a3, Movienode);

						directorHash.insertDirector(d, Movienode);// inserting
																	// directors
																	// into a
																	// hash
																	// table
																	// consisting
						// of avl trees

						yearHash.insertMovie(Movienode);

						// DirectorTree.insert(d,Movienode);

					}
					

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					if (br != null) {
						try {
							br.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}

				JOptionPane.showMessageDialog(null, "DataBase Established!");
				new MainPage(movieHash, actorHash, directorHash, yearHash).setVisible(true);
				dispose();
			}

		}

	}

}
