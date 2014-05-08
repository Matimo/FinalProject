
/*
 
/*
 *	WaveVisualizer.java
 *
 *	This file is part of jsresources.org
 */

/*
 * Copyright (c) 1999 - 2001 by Matthias Pfisterer
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * - Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/*
 |<---            this code is formatted to fit into 80 columns             --->|
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * <titleabbrev>WaveVisualizer</titleabbrev> <title>Playing an audio file
 * (easy)</title>
 * 
 * <formalpara><title>Purpose</title> <para>Plays a single audio
 * file.</para></formalpara>
 * 
 * <formalpara><title>Usage</title> <cmdsynopsis> <command>java
 * WaveVisualizer</command> <replaceable
 * class="parameter">audiofile</replaceable> </cmdsynopsis> </formalpara>
 * 
 * <formalpara><title>Parameters</title> <variablelist> <varlistentry>
 * <term><option><replaceable
 * class="parameter">audiofile</replaceable></option></term> <listitem><para>the
 * name of the audio file that should be played</para></listitem>
 * </varlistentry> </variablelist> </formalpara>
 * 
 * <formalpara><title>Bugs, limitations</title>
 * 
 * <para>Only PCM encoded files are supported. A-law, &mu;-law, ADPCM, ogg
 * vorbis, mp3 and other compressed data formats are not supported. For playing
 * these, see <olink targetdoc="AudioPlayer"
 * targetptr="AudioPlayer">AudioPlayer</olink>.</para>
 * 
 * </formalpara>
 * 
 * <formalpara><title>Source code</title> <para> <ulink
 * url="WaveVisualizer.java.html">WaveVisualizer.java</ulink> </para>
 * </formalpara>
 */
public class WaveVisualizer extends GameWindow {
	//private static final int EXTERNAL_BUFFER_SIZE = 128000;
	private static final int EXTERNAL_BUFFER_SIZE = 3000*4;
	
	static int[] left;
	static int[] right;
	
	static boolean B;
	static boolean C;
	static boolean T;
	static boolean MC;
	static boolean MT;
	static double  B0;
	static double  C0;
	static boolean choisir_sons;
	static boolean strFilename;
	static boolean variableFile;
			
	
	
	public static void main(String[] args) {
		new WaveVisualizer();
		String strFilename = variableFile("B","C","T","MC","MT");
		//if(strFilename != "B") {play (0, 1, 3);}
		//if(strFilename != "C") play (1, 1, 1);
		//if(strFilename != "T") play (2, 2, 2);
		if(strFilename != "MC")play (3, 1, 1);
		if(strFilename != "MT")play (4, 1, 1);


	}
	

	private static String variableFile(String string, String string2,
			String string3, String string4, String string5) {
		// TODO Auto-generated method stub
		return null;
	}



	//	Mise à jour de l'affichage
	public void Paint(Graphics2D g, int w, int h) {
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, w, h);
		
		//	Dessiner les courbes des sons
		if ((left != null) && (right != null)) {
			if ((left.length > 0) && (right.length > 0)) {
				g.setColor(Color.BLUE);
				DrawCurve(g,0,h/4,w,h/2,left);
				g.setColor(Color.RED);
				DrawCurve(g,0,h*3/4,w,h/2,right);
			}
		}
	}
	
	public void DrawCurve( Graphics2D g, int x0, int y0, int xscale, int yscale, int[] p ) {
		int x, y, xx, yy;
		
		xx = x0;
		yy = (int)(y0+(long)p[0]*yscale/65535L);
		
		for (int i=1; i<p.length; i++) {
			x = i*xscale/p.length;
			y = (int)(y0+(long)p[i]*yscale/65535L);
			g.drawLine(xx, yy, x, y);
			xx = x; yy = y;
		}
	}

	public static void play( int code, double rapport_freq, double volume ) {

		
		String strFilename;
		
		switch(code) {
		case 0 : 
			strFilename = "Bass.wav";
			break;
		case 1 : 
			strFilename = "Claque.wav";
			break;
		case 2 : 
			strFilename = "Tonique.wav";
			break;
		case 3 : 
			strFilename = "MateClaque.wav";
			break;
		case 4 : 
			strFilename = "MateTonique.wav";
			break;
			default:return;
		}
		
		
		File soundFile = new File(strFilename);

		/*
		 *Il faut lire dans le fichier audio.
		 */
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (Exception e) {
			/*
			 * En cas d'exception, nous jetons l'exception, y compris le 
			 * Trace de la pile à la sortie de la console. Ensuite, nous sortons du programme.
			 */
			e.printStackTrace();
			System.exit(1);
		}

		/*
		 *De la AudioInputStream, c'est à dire à partir du fichier de son, nous allons chercher 
		 * Les informations sur le format des données audio. Ces informations 
		 * Inclure la fréquence d'échantillonnage, le nombre de canaux et la taille 
		 * Des échantillons. Ces informations sont nécessaires pour demander Java Sound pour une 
		 * La ligne de sortie approprié pour ce fichier audio.

		 */
		AudioFormat audioFormat = audioInputStream.getFormat();

		/*
		 * Demande d'une ligne est une chose assez difficile. Nous devons construire un 
		 * Objet Info qui spécifie les propriétés souhaitées pour la ligne. 
		 * Tout d'abord, nous avons à dire quel type de ligne que nous voulons. les possibilités 
		 * Sont: SourceDataLine (pour la lecture), clip (pour la lecture répétée) et 
		 * TargetDataLine (pour l'enregistrement). Ici, nous voulons faire la lecture normale, 
		 * Si nous demandons un SourceDataLine. Ensuite, nous devons passer un AudioFormat 
		 * Objet, de sorte que la ligne sait quel format les données qui lui sont transmises 
		 * Aura. En outre, nous pouvons donner Java sonore une indication sur la taille 
		 * La mémoire tampon interne pour la ligne devrait être. Ce n'est pas utilisé ici, 
		 * Signalisation que nous ne nous soucions pas de la taille exacte. Java SOUND 
		 * Utiliser une valeur par défaut de la taille de la mémoire tampon.
		 */
		SourceDataLine line = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class,
				audioFormat);
		try {
			line = (SourceDataLine) AudioSystem.getLine(info);

			/*
			 *La ligne est là, mais il n'est pas encore prêt à recevoir des données audio. 
			 * Nous devons ouvrir la ligne.
			 */
			line.open(audioFormat);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		/*
		 * Toujours pas assez. La ligne peut maintenant recevoir des données, mais ne passera pas 
		 * Les sur le périphérique de sortie audio (ce qui signifie à votre carte son). 
		 * Ceci doit être activé.
		 */
		line.start();

		/*
		 * Ok, enfin la ligne est prête. Maintenant vient le vrai travail: nous devons 
		 * Données d'écriture à la ligne. Nous faisons cela dans une boucle. Tout d'abord, nous lisons données 
		 * De la AudioInputStream à un tampon. Ensuite, nous écrivons de cette 
	* Tampon de la ligne. Cela se fait jusqu'à ce que la fin du fichier est 
	* Atteint, ce qui est détecté par une valeur de retour de -1 à partir de la lecture 
	* Méthode de la AudioInputStream.
		 */
		
		int nBytesRead = 0;
		byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
		while (nBytesRead != 1) {
			try {
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//	Construit les tableaux des échantillons
			//	à partir des données du fichier WAV
			
	
			int[] left0 = new int[EXTERNAL_BUFFER_SIZE/ 4];
			int[] right0 = new int[EXTERNAL_BUFFER_SIZE/4];
			int j = 0;
			for (int i=0; i<nBytesRead; i+=4) {
				left0[j] = abData[i] + 256*abData[i+1];
				right0[j] = abData[i+2] + 256*abData[i+3];
				j++;
			}
			
			
			
			//double rapport_freq = b0; 
			int n_echant = (int)((double)(nBytesRead/4)*rapport_freq);
			
			left = new int[n_echant];
			right = new int[n_echant];
			
			for (j=0; j<n_echant; j++) {
				int i = (int)(j/rapport_freq);
				if (i >= EXTERNAL_BUFFER_SIZE/4) i=EXTERNAL_BUFFER_SIZE/4-1;
				left[j] = left0[i];
				right[j] = right0[i];				
			}
			
			for (j=0; j<n_echant; j++) {
				left[j] = (int)(volume*left[j]);
				right[j] = (int)(volume*right[j]);
			}
		
			
			byte[] newData = new byte[n_echant*4];
			int i = 0;
			for (j=0; j<n_echant; j++) {
				newData[i] = (byte)(left[j] % 256);
				newData[i+1] = (byte)(left[j] / 256);
				newData[i+2] = (byte)(right[j] % 256);
				newData[i+3] = (byte)(right[j] / 256);
				i+=4;
			}		
			
			
			if (nBytesRead >= 0) {
				int nBytesWritten = line.write(newData, 0, n_echant*4);
				//System.out.format("%d %d\n",nBytesWritten,nBytesRead);
		 
			}
		}
		
		
		/*
		 *Attendez jusqu'à ce que toutes les données sont lues. Cela n'est nécessaire en raison de la 
		 * Bug indiqué ci-dessous. (Si nous n'attendons pas, nous interrompre la lecture 
		 * Par la fermeture prématurée de la ligne et la sortie de la machine virtuelle.) 
		 * 
		 * Merci à Margie Fitch pour me mettre sur la bonne voie pour ce 
		 * Solution.

		 */
		line.drain();

		/*
		 * Toutes les données sont lues. Nous pouvons fermer la boutique.
		 */
		line.close();

		/*
		 * Il ya un bug dans le jdk1.3/1.4. Il empêche la terminaison correcte de 
		 * La VM. Donc, nous devons nous quitter.
		 */
		System.exit(0);
	}

	private static void printUsageAndExit() {
		out("WaveVisualizer: usage:");
		out("\tjava WaveVisualizer <soundfile>");
		System.exit(1);
	}

	private static void out(String strMessage) {
		System.out.println(strMessage);
	}

	public static String ChooseFile( String default_dir, String filtertext, String filterext ) {
		//	Choix d'un fichier
		
		String pathname = "";

		//	Initialiation du FileChooser avec définition du répertoire courant
		//	et du filtre de fichiers (existant)
		JFileChooser chooser = new JFileChooser(new File(default_dir));
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(filtertext,filterext);
	    chooser.setFileFilter(filter);
	    
	    //	Ouverture du dialog FileChooser
	    if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	    	pathname = chooser.getSelectedFile().getAbsolutePath();
	    	System.out.println("You chose to open this file: " + pathname);
	    } else {
	    	return null;
	    }
	    return pathname;
	}
}

/*** WaveVisualizer.java ***/

