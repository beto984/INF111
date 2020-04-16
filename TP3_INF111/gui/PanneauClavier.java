/**
 * Cette classe représente l'interface graphique du Panneau du Clavier
 * PanneauClavier
 * 
 * @author Kenza Zniber & Humberto Villarino
 * Codes permanents : ZNIK07569704 & VILH24019807
 * Courriels : kenza.zniber.1@ens.etsmtl.ca & humberto.villarino@ens.etsmtl.ca
 * Cours : INF111
 * @version 2020-04-05
 */
 
package gui;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;


import audio.*;

/*******************************
 ***  Classe PanneauClavier  ***
 *******************************/
public class PanneauClavier implements MouseListener {
    
    //------------------------
    //-------CONSTANTE--------
    //------------------------
    ToucheClavier ToucheC;
    ToucheClavier ToucheCDiese;
    ToucheClavier ToucheD;
    ToucheClavier ToucheDDiese;
    ToucheClavier ToucheE;
    ToucheClavier ToucheF;
    ToucheClavier ToucheFDiese;
    ToucheClavier ToucheG;
    ToucheClavier ToucheGDiese;
    ToucheClavier ToucheA;
    ToucheClavier ToucheADiese;
    ToucheClavier ToucheB;
    ToucheClavier ToucheCAvecOctaveSuivant;
    
    public String[] NOTES = 
    {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C"};

    public Color[] COULEUR_TOUCHE = 
    {Color.WHITE, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, 
            Color.WHITE, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE,
            Color.BLACK, Color.WHITE, Color.WHITE};
    
    public static  ToucheClavier[] toucheClavier = new ToucheClavier[12];

    //------------------------
    //- ATTRIBUTS D'INSTANCE -
    //------------------------
    private JPanel clavier = new JPanel();
    private ModuleAudio audio;
    private int octave;

    //----------------
    //- CONSTRUCTEUR -
    //----------------
    public PanneauClavier(int octave, ModuleAudio audio) {
        this.octave = octave;
        this.audio = audio; 
        initComposants();
    }

    /**
     * Initialisation des composantes du panneauClavier 
     * et ajout au JPanel 
     */
    private void initComposants() {
        //Esthétique du JPanel
        clavier.setLayout(new BoxLayout(clavier, BoxLayout.X_AXIS));
        clavier.setBorder(BorderFactory.createLineBorder(Color.BLACK,
				10, true));
        clavier.setPreferredSize(new Dimension(600, 200));

        for (int i = 0 ; i < 12 ; i++ ) {
            if (i == 11) {
                toucheClavier[i] = new ToucheClavier(NOTES[i], octave + 1, COULEUR_TOUCHE[i] );
            } else {
                toucheClavier[i] = new ToucheClavier(NOTES[i], octave, COULEUR_TOUCHE[i] );
            }
            clavier.add(toucheClavier[i]);//Ajout des touches au JPanel 
        }
            
        ajouteMouseListener();
    }

	//----------------------
    //- GETTER POUR JPANEL -
    //----------------------
    /**
     * Getter pour JPanel
     * @return JPanel contenant toutes les touches
     */
    public JPanel getClavier() {
        return clavier;
    }

    /**
     * Enlève le MouseListener pour toutes les touches du clavier
     */
    public void enleveMouseListener() {
        for (int i = 0 ; i < 12 ; i++ ) {
            toucheClavier[i].removeMouseListener(this); 
        }
    }

    /**
     * Ajoute le MouseListener pour toutes les touches du clavier
     */
    public void ajouteMouseListener() {
        for (int i = 0 ; i < 12 ; i++ ) {
            toucheClavier[i].addMouseListener(this); 
        }
    }
    
    //-----------------------------------------------
    //- IMPLEMENTATION DE L'INTERFACE MOUSELISTENER -
    //-----------------------------------------------
    public void mouseClicked (MouseEvent e) {
        //ne fait rien
    }
	
    public void mouseEntered (MouseEvent e) {
        //ne fait rien
    }
    
    public void mouseExited (MouseEvent e) {
        //ne fait rien
    }
    
    public void mousePressed (MouseEvent e) {
        ToucheClavier touche = (ToucheClavier) e.getSource();
        audio.jouerUneNote(touche.getNomNoteOctave());
    }
	
    public void mouseReleased (MouseEvent e) {
        audio.jouerUnSilence();
    }
}