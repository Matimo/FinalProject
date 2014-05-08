import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.UIManager;

public class Projet extends Projet2 {

	static int n = 0; // compteur pour le nombre de clics
	
	static JButton Reset; // variable repr�sentant le bouton
	static JButton Play;
	
	double Bass = 'B' ;
	double Claque = 'C' ;
	double Tonique = 'T' ;
	double MateClaque = 'M' ;
	double MateTonique = 'm' ;
	
	COMListener serialport = null;	

	JMenuBar menubar;
	JMenu fichiers_menu;
	JMenuItem ouvrir_image_item, quitter_item;
	JMenu edit_menu;
	JMenuItem new_edit_item, ouvrir_edit_item;
	//WaveVisualizer Visualiseur;
	
	public Projet() {
		super();
		// Cr�ation de la fen�tre
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(1001, 1001);
		Container contentPane = super.getContentPane();
		//Visualiseur = new WaveVisualizer();
		//contentPane.add(Visualiseur);
		
		// Cr�ation du bouton
		Play = new JButton("Play");
		Reset = new JButton("Reset");
		contentPane.add(Play);
		contentPane.add(Reset);
		
		
		
		/*
		// Cr�ation du bouton
		play = new JButton("Tonique");
		Reset = new JButton("Claqu�");
		button2 = new JButton("Basse");
		button3 = new JButton("Mat� Claqu�");
		button4 = new JButton("Mat� Tonique");

		// Cr�ation de la fen�tre

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(2000, 2000);

		// R�cup�ration de l'int�rieure de la fen�tre
		// avec style de placement des composants
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new FlowLayout());
		// contentPane.setLayout(null);

		// Rajouter le bouton dans le panneau int�rieur
		// de la fen�tre
		// button.setBounds(10,10,300,50);
		contentPane.add(button);
		contentPane.add(button1);
		contentPane.add(button2);
		contentPane.add(button3);
		contentPane.add(button4);

		// Afficher la fen�tre
		frame.setVisible(true);

		// Rajouter un "Listener" pour capturer les actions
		// sur le bouton
		button.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				// Lorsqu'on clique sur le bouton,
				// incr�menter n le compteur de clics
				// et mettre � jour le texte
				n++;
				button.setText(String.format("Tonique : %d", n));
			}
		});

		button1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				// Lorsqu'on clique sur le bouton,
				// incr�menter n le compteur de clics
				// et mettre � jour le texte
				n++;
				button1.setText(String.format("Claqu�: %d", n));
			}
		});

		button2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				// Lorsqu'on clique sur le bouton,
				// incr�menter n le compteur de clics
				// et mettre � jour le texte
				n++;
				button2.setText(String.format("Basse : %d", n));
			}
		});

		button3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				// Lorsqu'on clique sur le bouton,
				// incr�menter n le compteur de clics
				// et mettre � jour le texte
				n++;
				button3.setText(String.format("Mat� Tonique : %d", n));
			}
		});

		button4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				// Lorsqu'on clique sur le bouton,
				// incr�menter n le compteur de clics
				// et mettre � jour le texte
				n++;
				button4.setText(String.format("Mat� Claqu� : %d", n));
			}
		});
		*/
		
//		Initialiser le port s�rie
		serialport = new COMListener();		
		serialport.port = "COM1";
		serialport.rate = 9600;
		serialport.Init();
		serialport.Write('b');
	}

	public void SetMenuActions() {
		quitter_item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Close();
				// System.exit(0);
			}
		});

		ouvrir_Fichier_item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 OuvrirFichier(".","WAV files","WAV");
			}
		});

		new_edit_item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewEdit();
			}
		});

		
	}
	
	public static void main(String[] args) {
		new Projet();
	}
	
	public void OuvrirFichier() {

		String commande = "";

		while (true) {
			// lecture du port s�rie
		
			
			commande = "type de son = intensite ";
			
			while (true) {
				if (serialport.DataAvail() > 0) {
					char c = serialport.Read();
					if (c == '#') {
						break;
					}
					commande = commande + c;
				}
			}
			
			// interpretation du message
			char type = commande.charAt(0);
			String volstring = commande.substring(2);
			double vol = Float.parseFloat(volstring)/2.51;			
			
			switch (type) {
			case 'B':
				//	Jouer la bass
				//Play('B',freq,vol);
				break;
			}			

			// lancement de la fonction Play()
		}

	}

}
