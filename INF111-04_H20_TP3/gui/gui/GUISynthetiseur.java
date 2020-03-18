package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;
import javax.swing.event.*;

import audio.*;


/**
 * GUISynthetiseur
 */
public class GUISynthetiseur extends JFrame implements Runnable,ActionListener,ChangeListener {

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
        panneauClavier= new PanneauClavier(panneauControle.getNumOctave(), audio);

        //Ajouter le panneau de clavier 
        c.add(panneauClavier.getClavier());
        
        // Ajustement du volume du synthetiseur
        panneauControle.getSlider().addChangeListener(this);
        
            

        //Ajout du ActionListener pour le bouton augmente
        panneauControle.getAugmente().addActionListener(this);

        //Ajout du ActionListener pour le bouton diminue
        panneauControle.getDiminue().addActionListener(this);

        this.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
       JSlider source = (JSlider) e.getSource();
       audio.setVolume(source.getValue());  
       System.out.println(Integer.toString(source.getValue()));
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Container c = this.getContentPane();
        if(e.getSource() == panneauControle.getAugmente() && panneauControle.getNumOctave() <5){
            panneauControle.augmenteNumOctave();
            System.out.println("CLICK +");
            c.remove(panneauClavier.getClavier());
            panneauClavier = new PanneauClavier(panneauControle.getNumOctave(),audio);
            c.add(panneauClavier.getClavier());
            c.validate();
            c.repaint();
        }else if(e.getSource() == panneauControle.getDiminue() && panneauControle.getNumOctave() > 3){
            panneauControle.diminueNumOctave();
            System.out.println("CLICK -");
            c.remove(panneauClavier.getClavier());
            panneauClavier = new PanneauClavier(panneauControle.getNumOctave(),audio);
            c.add(panneauClavier.getClavier());
            c.validate();
            c.repaint();
        }
    }
    
}