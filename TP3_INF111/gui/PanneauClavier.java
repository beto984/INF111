
package gui;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import audio.*;

/**
 * PanneauClavier
 */
public class PanneauClavier implements MouseListener{

    //---------------------------
    // ATTRIBUTS D'INSTANCE
    //---------------------------

    JPanel clavier = new JPanel();
    ModuleAudio audio;
    int octave;
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

    //----------------------------------------
    //CONSTRUCTEUR
    //----------------------------------------
    public PanneauClavier(int octave, ModuleAudio audio){
        this.octave = octave;
        this.audio = audio; 
        initComposants();
    }

    /**
     * Initialisation des composantes du panneaClavier 
     * et ajout au JPanel 
     */
    private void initComposants(){
        //Esthetique du JPanel
        clavier.setLayout(new BoxLayout(clavier, BoxLayout.X_AXIS));
        clavier.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10, true));
        clavier.setPreferredSize(new Dimension( 600,200));
        
        //Creation des touches a ajouter au JPanel
        ToucheC = new ToucheClavier("C", octave, Color.WHITE);
        ToucheCDiese = new ToucheClavier("C#", octave, Color.BLACK);
        ToucheD = new ToucheClavier("D", octave, Color.WHITE);
        ToucheDDiese = new ToucheClavier("D#", octave, Color.BLACK);
        ToucheE = new ToucheClavier("E", octave, Color.WHITE);
        ToucheF = new ToucheClavier("F", octave, Color.WHITE);
        ToucheFDiese = new ToucheClavier("F#", octave, Color.BLACK);       
        ToucheG = new ToucheClavier("G", octave, Color.WHITE);
        ToucheGDiese = new ToucheClavier("G#", octave, Color.BLACK);
        ToucheA = new ToucheClavier("A", octave, Color.WHITE);
        ToucheADiese = new ToucheClavier("A#", octave, Color.BLACK);
        ToucheB = new ToucheClavier("B", octave, Color.WHITE);
        ToucheCAvecOctaveSuivant = new ToucheClavier("C", octave + 1, Color.WHITE);
        
        //Ajout des touches au JPanel 
        clavier.add(ToucheC);
        clavier.add(ToucheCDiese);
        clavier.add(ToucheD);
        clavier.add(ToucheDDiese);
        clavier.add(ToucheE);
        clavier.add(ToucheF);
        clavier.add(ToucheFDiese);
        clavier.add(ToucheG);
        clavier.add(ToucheGDiese);
        clavier.add(ToucheA);
        clavier.add(ToucheADiese);
        clavier.add(ToucheB);
        clavier.add(ToucheCAvecOctaveSuivant); 
        
        ajouteMouseListener();
       
    }

    /**
     * Getter pour JPanel
     * @return JPanel contenant toutes les touches
     */
    public JPanel getClavier(){
        return clavier;

    }

    /**
     * Enleve le MouseListener pour toutes les touches du clavier
     */
    public void enleveMouseListener(){
        ToucheC.removeMouseListener(this);
        ToucheCDiese.removeMouseListener(this);
        ToucheD.removeMouseListener(this);
        ToucheDDiese.removeMouseListener(this);
        ToucheE.removeMouseListener(this);
        ToucheF.removeMouseListener(this);
        ToucheFDiese.removeMouseListener(this);
        ToucheG.removeMouseListener(this);
        ToucheGDiese.removeMouseListener(this);
        ToucheA.removeMouseListener(this);
        ToucheADiese.removeMouseListener(this);
        ToucheB.removeMouseListener(this);
        ToucheCAvecOctaveSuivant.removeMouseListener(this);
        
    }

    /**
     * Ajoute le MouseListener pour toutes les touches du clavier
     */
    public void ajouteMouseListener(){
        ToucheC.addMouseListener(this);
        ToucheCDiese.addMouseListener(this);
        ToucheD.addMouseListener(this);
        ToucheDDiese.addMouseListener(this);
        ToucheE.addMouseListener(this);
        ToucheF.addMouseListener(this);
        ToucheFDiese.addMouseListener(this);
        ToucheG.addMouseListener(this);
        ToucheGDiese.addMouseListener(this);
        ToucheA.addMouseListener(this);
        ToucheADiese.addMouseListener(this);
        ToucheB.addMouseListener(this);
        ToucheCAvecOctaveSuivant.addMouseListener(this);
    }
    
    //------------------------------------------------
    // IMPLEMENTATION DE L'INTERFACE MOULISTENER
    //------------------------------------------------
    public void mouseClicked (MouseEvent e) {
        //ne fait rien
    }
    public void mouseEntered (MouseEvent e){
        //ne fait rien
    }
    
    public void mouseExited (MouseEvent e){
        //ne fait rien
    }
    
    public void mousePressed (MouseEvent e){
        ToucheClavier  Touche = (ToucheClavier)e.getSource();
        
        audio.jouerUneNote(Touche.getNomNoteOctave());//accept une string en parametre
    
    }
    public void mouseReleased (MouseEvent e){
        audio.jouerUnSilence();
    }
}

