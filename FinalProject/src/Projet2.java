import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class Projet2 extends projet1 implements ActionListener, WindowListener,
		ChangeListener {
	// Set up animation parameters.
	
	int frameNumber = 10;
	int NUM_FRAMES = 20;
	//ImageIcon[] images = new ImageIcon[NUM_FRAMES];
	
	JSlider c_volume;
	int volume;
	JSlider c_frequence;
	int frequence;
	JSlider c_claque;
	int claque;
	JSlider c_claquefrequence;
	int claquefrequence;
	JSlider c_tonique;
	int tonique;
	JSlider c_toniquefrequence;
	int toniquefrequence;
	JSlider c_bass;
	int bass;
	JSlider c_bassfrequence;
	int bassfrequence;
	JSlider c_mateclaque;
	int mateclaque;
	JSlider c_mateclaquefrequence;
	int mateclaquefrequence;
	JSlider c_matetonique;
	int matetonique;
	JSlider c_matetoniquefrequence;
	int matetoniquefrequence;
	
	public Projet2() {
		super();
		
		//setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		//setLayout(new BoxLayout(GridTitle);
	

		// Create the label.
		JLabel sliderLabel = new JLabel("  Volume", JLabel.CENTER);
		sliderLabel.setAlignmentY(Component.CENTER_ALIGNMENT);

		JLabel sliderLabel11 = new JLabel("Frequence", JLabel.LEFT);
		sliderLabel11.setAlignmentY(Component.CENTER_ALIGNMENT);

		JLabel sliderLabel1 = new JLabel(" Claqué", JLabel.LEFT);
		sliderLabel1.setAlignmentY(Component.CENTER_ALIGNMENT);

		JLabel sliderLabel6 = new JLabel(" ClaquéFrequence", JLabel.LEFT);
		sliderLabel6.setAlignmentY(Component.CENTER_ALIGNMENT);

		JLabel sliderLabel2 = new JLabel(" Tonique", JLabel.LEFT);
		sliderLabel2.setAlignmentY(Component.CENTER_ALIGNMENT);

		JLabel sliderLabel7 = new JLabel(" ToniqueFrequence", JLabel.LEFT);
		sliderLabel2.setAlignmentY(Component.CENTER_ALIGNMENT);

		JLabel sliderLabel3 = new JLabel(" Bass", JLabel.CENTER);
		sliderLabel3.setAlignmentY(Component.CENTER_ALIGNMENT);

		JLabel sliderLabel8 = new JLabel(" BassFrequence", JLabel.LEFT);
		sliderLabel8.setAlignmentY(Component.CENTER_ALIGNMENT);

		JLabel sliderLabel4 = new JLabel(" MatéClaqué", JLabel.LEFT);
		sliderLabel4.setAlignmentY(Component.CENTER_ALIGNMENT);

		JLabel sliderLabel9 = new JLabel(" MatéClaquéFrequence", JLabel.LEFT);
		sliderLabel4.setAlignmentY(Component.CENTER_ALIGNMENT);

		JLabel sliderLabel5 = new JLabel(" MatéTonique", JLabel.LEFT);
		sliderLabel5.setAlignmentY(Component.CENTER_ALIGNMENT);
													
		JLabel sliderLabel10 = new JLabel("MatéToniqueFrequence", JLabel.LEFT);
		sliderLabel10.setAlignmentY(Component.CENTER_ALIGNMENT);
																																						
		// Create the slider.
		c_volume = new JSlider(JSlider.VERTICAL);
		c_volume.addChangeListener(this);

		c_frequence = new JSlider(JSlider.VERTICAL);
		c_frequence.addChangeListener(this);

		c_claque = new JSlider(JSlider.VERTICAL);
		c_claque.addChangeListener(this);

		c_claquefrequence = new JSlider(JSlider.VERTICAL);
		c_claquefrequence.addChangeListener(this);

		c_tonique = new JSlider(JSlider.VERTICAL);
		c_tonique.addChangeListener(this);

		c_toniquefrequence = new JSlider(JSlider.VERTICAL);
		c_toniquefrequence.addChangeListener(this);

		c_bass = new JSlider(JSlider.VERTICAL);
		c_bass.addChangeListener(this);

		c_bassfrequence = new JSlider(JSlider.VERTICAL);
		c_bassfrequence.addChangeListener(this);

		c_mateclaque = new JSlider(JSlider.VERTICAL);
		c_mateclaque.addChangeListener(this);

		c_mateclaquefrequence = new JSlider(JSlider.VERTICAL);
		c_mateclaquefrequence.addChangeListener(this);

		c_matetonique = new JSlider(JSlider.VERTICAL);
		c_matetonique.addChangeListener(this);

		c_matetoniquefrequence = new JSlider(JSlider.VERTICAL);
		c_matetoniquefrequence.addChangeListener(this);

		// Turn on labels at major tick marks.

		
		c_volume.setPaintTicks(true);
		c_volume.setPaintLabels(true);
		c_volume.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		Font font = new Font("Serif", Font.ITALIC, 15);
		c_volume.setFont(font);

		c_frequence.setPaintTicks(true);
		c_frequence.setPaintLabels(true);
		c_frequence.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		Font font11 = new Font("Serif", Font.ITALIC, 15);
		c_frequence.setFont(font);

		c_claque.setPaintTicks(true);
		c_claque.setPaintLabels(true);
		c_claque.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		Font font1 = new Font("Serif", Font.ITALIC, 15);
		c_claque.setFont(font1);
		c_claque.setFont(font1);

		c_claquefrequence.setPaintTicks(true);
		c_claquefrequence.setPaintLabels(true);
		c_claquefrequence.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		Font font6 = new Font("Serif", Font.ITALIC, 15);
		c_claquefrequence.setFont(font6);
		c_claquefrequence.setFont(font6);

		c_tonique.setPaintTicks(true);
		c_tonique.setPaintLabels(true);
		c_tonique.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		Font font2 = new Font("Serif", Font.ITALIC, 15);
		c_tonique.setFont(font2);
		c_tonique.setFont(font2);

		c_toniquefrequence.setPaintTicks(true);
		c_toniquefrequence.setPaintLabels(true);
		c_toniquefrequence.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		Font font7 = new Font("Serif", Font.ITALIC, 15);
		c_toniquefrequence.setFont(font7);
		c_toniquefrequence.setFont(font7);

		c_bass.setPaintTicks(true);
		c_bass.setPaintLabels(true);
		c_bass.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		Font font3 = new Font("Serif", Font.ITALIC, 15);
		c_bass.setFont(font3);
		c_bass.setFont(font3);

		c_bassfrequence.setPaintTicks(true);
		c_bassfrequence.setPaintLabels(true);
		c_bassfrequence.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		Font font8 = new Font("Serif", Font.ITALIC, 15);
		c_bassfrequence.setFont(font8);
		c_bassfrequence.setFont(font8);

		c_mateclaque.setPaintTicks(true);
		c_mateclaque.setPaintLabels(true);
		c_mateclaque.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		Font font4 = new Font("Serif", Font.ITALIC, 15);
		c_mateclaque.setFont(font4);
		c_mateclaque.setFont(font4);

		c_mateclaquefrequence.setPaintTicks(true);
		c_mateclaquefrequence.setPaintLabels(true);
		c_mateclaquefrequence.setBorder(BorderFactory.createEmptyBorder(0, 0, 10,0));
		Font font9 = new Font("Serif", Font.ITALIC, 15);
		c_mateclaquefrequence.setFont(font9);
		c_mateclaquefrequence.setFont(font9);

		c_matetonique.setPaintTicks(true);
		c_matetonique.setPaintLabels(true);
		c_matetonique.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		Font font5 = new Font("Serif", Font.ITALIC, 15);
		c_matetonique.setFont(font4);
		c_matetonique.setFont(font4);

		c_matetoniquefrequence.setPaintTicks(true);
		c_matetoniquefrequence.setPaintLabels(true);
		c_matetoniquefrequence.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		Font font10 = new Font("Serif", Font.ITALIC, 15);
		c_matetoniquefrequence.setFont(font10);
		c_matetoniquefrequence.setFont(font10);

		
	

		// Put everything together.
	
		add(c_volume);
		add(c_frequence);
		add(c_claque);
		add(c_claquefrequence);
		add(c_tonique);
		add(c_toniquefrequence);
		add(c_bass);
		add(c_bassfrequence);
		add(c_mateclaque);
		add(c_mateclaquefrequence);
		add(c_matetonique);
		add(c_matetoniquefrequence);
	

	}

	/** Add a listener for window events. */
	void addWindowListener(Window w) {
		w.addWindowListener(this);
	}

	

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	/** Listen to the slider. */

	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
			if (source == c_volume) {
				volume = (int) source.getValue();
			} else
			if (source == c_frequence) {
				frequence = (int) source.getValue();
			}else
			if (source == c_claque)	 {
				claque = (int) source.getValue();
			}else
			if (source == c_claquefrequence) {
				frequence = (int) source.getValue();
			}else
			if (source == c_tonique ) {
				tonique = (int)  source.getValue();
			}else
			if (source == c_bass ) {
				bass = (int)  source.getValue();	
			}else
			if (source == c_bassfrequence ) {
					bassfrequence = (int)  source.getValue();		
			}else
			if (source == c_mateclaque ) {
				mateclaque = (int)  source.getValue();	
			}else
			if (source == c_mateclaquefrequence ) {
				mateclaquefrequence = (int)  source.getValue();	
			}else
			if (source == c_matetonique ) {
				matetonique = (int)  source.getValue();
			}else
			if (source == c_matetoniquefrequence ) {
				matetoniquefrequence = (int)  source.getValue();
				
				System.out.println("c_matetoniquefrequence ");
				System.out.println("source.getValue()");
						
			}
		}
	}

	

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("SliderDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Projet2 animator = new Projet2();

		// Add content to the window.
		//frame.add(animator, BorderLayout.CENTER);

		// Display the window.
		frame.pack();
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		
		UIManager.put("swing.boldMetal", Boolean.FALSE);

		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}