package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.event.*;

import audio.*;


/**
 * GUISynthetiseur
 */
public class GUISynthetiseur extends JFrame 
        implements Runnable,ActionListener,ChangeListener, KeyListener{

    //----------------------------
    // CONSTANTES DE CLASSE
    //----------------------------
    public final static int LARG_FENETRE = 600;
    public final static int HAUT_FENETRE = 300;


    //------------------------------
    // VARIABLES D'INSTANCE
    //------------------------------

    private BarreMenus barreMenu;
    private PanneauControle panneauControle;
    private PanneauClavier panneauClavier;
    private ModuleAudio audio;
   

    /**
     * Constructeur d'initialisation
     */
    public GUISynthetiseur(){  
        //Rien a faire pour cet exemple
    }

    @Override
    public void run() {
        //initialisation des composants
        initComposants();

    }

    /**
     * Initialise les composantes et les ajoute a la 
     * a la fenetre de visualisation 
     */
    private void initComposants() {

        audio = new ModuleAudio(5);

        Container c = this.getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        //---------------------------------------
        // INIT FENETRE PRINCIPALE
        //---------------------------------------

        // initialisation des proprietes de la fenetre
        this.setTitle("TP3");
        this.setMinimumSize(new Dimension(LARG_FENETRE,HAUT_FENETRE));
        this.setSize(new Dimension(LARG_FENETRE, HAUT_FENETRE));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setFocusable(true);

        //positionner la fenetre au milieu d l'ecran
        this.setLocationRelativeTo(null);

        // Creer la barre de menu
        barreMenu = new BarreMenus();
        
        //Ajouter la barre de menu
        this.setJMenuBar(barreMenu.getBarreMenu());

        // Creer le panneau de controle
        panneauControle = new PanneauControle(5,4);

        //Ajouter le panneau de controle;
        c.add(panneauControle);

        //Creer le panneau du clavier
        panneauClavier= 
                new PanneauClavier(panneauControle.getNumOctave(), audio);

        //Ajouter le panneau de clavier 
        c.add(panneauClavier.getClavier());
        
        // Ajustement du volume du synthetiseur
        panneauControle.getSlider().addChangeListener(this);
            
        
        
        //Ajout du ActionListener pour le bouton augmente
        panneauControle.getAugmente().addActionListener(this);

        //Ajout du ActionListener pour le bouton diminue
        panneauControle.getDiminue().addActionListener(this);

        //Ajout du ActionListener pour le menuBar
        barreMenu.getMenuItem(0).addActionListener(this);
        barreMenu.getMenuItem(1).addActionListener(this);

        //rend la fenetre visible
        this.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
       JSlider source = (JSlider) e.getSource();
       audio.setVolume(source.getValue());  
       this.requestFocus();
    }
    /**
     * Verifie sur quel objet l'action a ete effectué
     * 
     * Si l'action est sur le bouton d'augmenter l'octave et l'octave 
     * est inferieure a 5 on augmente l'octave
     * 
     * Si l'action est sur le bouton diminue et l'octave est superieure
     * a 3 on diminue l'octave
     * 
     * Si l'action est sur le MenuItem mode Souris on desactive le 
     * MouseListener et on active le KeyListener 
     * 
     * Si l'action est sur le MenuItem mode Clavlier on desactive
     * le KeyListener et on active le MouseListener
     */
    @Override
    public void actionPerformed(ActionEvent e){
        Container c = this.getContentPane();
        if(e.getSource() == panneauControle.getAugmente() 
                && panneauControle.getNumOctave() <5){
            // On augmente l'octave dans le panneauControle
            panneauControle.augmenteNumOctave();
            //On enleve le panneau existant
            c.remove(panneauClavier.getClavier());
            
            //Creation d'un nouveau panneau avec la nouvelle octave
            panneauClavier = 
                    new PanneauClavier(panneauControle.getNumOctave(),audio);
            // Ajout du panneau au ContentPane
            c.add(panneauClavier.getClavier());
            // Retour du focus a la fenetre principale
            this.requestFocus();
            c.validate();
            c.repaint();

        }else if(e.getSource() == panneauControle.getDiminue() 
                    && panneauControle.getNumOctave() > 3){
            //Diminue l'octave 
            panneauControle.diminueNumOctave();

            //On enleve le panneau existant
            c.remove(panneauClavier.getClavier());

            //Creation d'un nouveau panneau avec la nouvelle octave
            panneauClavier = 
                    new PanneauClavier(panneauControle.getNumOctave(),audio);
            // Ajout du panneau au ContentPane
            c.add(panneauClavier.getClavier());
            // Retour du focus a la fenetre principale
            this.requestFocus();
            c.validate();
            c.repaint();

        }else if(e.getSource() == barreMenu.getMenuItem(0)){
            this.removeKeyListener(this);
            panneauClavier.ajouteMouseListener();
            this.requestFocus();  
            
        }else if(e.getSource() == barreMenu.getMenuItem(1)){
            panneauClavier.enleveMouseListener();// Il faut une repetition 
            panneauClavier.enleveMouseListener();
            this.addKeyListener(this);
            this.requestFocus();
        }
    }
    
    /**
     * On determine quelle cle du keyboard joue quelle note
     */
    @Override
    public void keyPressed(KeyEvent e) {
        //Variable créée pour definir l'octave du clavier
        String octave = Integer.toString(panneauControle.getNumOctave());
        
        if (e.getKeyCode() == KeyEvent.VK_A) {
            audio.jouerUneNote("C" + octave);
        }else if(e.getKeyCode() == KeyEvent.VK_W){
            audio.jouerUneNote("C#" + octave);
        }else if(e.getKeyCode() == KeyEvent.VK_S){
            audio.jouerUneNote("D" + octave);
        }else if(e.getKeyCode() == KeyEvent.VK_E){
            audio.jouerUneNote("D#" + octave);
        }else if(e.getKeyCode() == KeyEvent.VK_D){
            audio.jouerUneNote("E" + octave);
        }else if(e.getKeyCode() == KeyEvent.VK_F){
            audio.jouerUneNote("F" + octave);
        }else if(e.getKeyCode() == KeyEvent.VK_T){
            audio.jouerUneNote("F#" + octave);
        }else if(e.getKeyCode() == KeyEvent.VK_G){
            audio.jouerUneNote("G" + octave);
        }else if(e.getKeyCode() == KeyEvent.VK_Y){
            audio.jouerUneNote("G#" + octave);
        }else if(e.getKeyCode() == KeyEvent.VK_H){
            audio.jouerUneNote("A" + octave);
        }else if(e.getKeyCode() == KeyEvent.VK_U){
            audio.jouerUneNote("A#" + octave);
        }else if(e.getKeyCode() == KeyEvent.VK_J){
            audio.jouerUneNote("B" + octave);
        }else if(e.getKeyCode() == KeyEvent.VK_K){
            String prochaineOctave = 
                    Integer.toString(panneauControle.getNumOctave()+1);        
            audio.jouerUneNote("C" + prochaineOctave);
        }
     
    }

    @Override
    public void keyReleased(KeyEvent e) {
       audio.jouerUnSilence();
    }
    
    public void keyTyped(KeyEvent e){
    //ne fait rien
    }
   
}