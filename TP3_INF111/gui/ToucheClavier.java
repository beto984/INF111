package gui;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.*;

/**
 * ToucheClavier
 */
public class ToucheClavier extends JPanel{


    //------------------------
    // ATTRIBUTS D'INSTANCE
    //------------------------
    
    private String note;
    private int octave;
    private Color couleur;
    JLabel etiquette = new JLabel();


    /**
     * Cree une touche pour le clavier de la couleur desiree
     * avec un label contenant le nom de la note l'octave
     * @param note Note a ecrire sur le label
     * @param octave Octave actuelle
     * @param couleur Couleur de la touche 
     */
    public ToucheClavier(String note, int octave, Color couleur) {
        this.note = note;
        this.octave = octave;
        this.couleur = couleur;
        this.setLayout(new BorderLayout());
        initComposants();
    }

    /**
     * Initialisation des composantes
     */
    private void initComposants(){
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK,1,true));
        this.setBackground(couleur);

        if(couleur == Color.BLACK){
            etiquette.setForeground(Color.WHITE);
        }

        etiquette.setText(note + Integer.toString(octave));
        etiquette.setHorizontalAlignment(SwingConstants.CENTER);
        add(etiquette, BorderLayout.SOUTH);
    }
    
    //----------------
    //GETTERS
    //----------------
    public String getNomNoteOctave(){ 
        String noteOctave = note + Integer.toString(octave);
        return noteOctave;
    }
    //----------------
    //SETTERS
    //----------------
    public void setOctave(int Octave){ 
        this.octave = Octave;
    }
}