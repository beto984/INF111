package gui;

import java.awt.*;

import javax.swing.*;
import audio.*;

/**
 * PanneauClavier
 */
public class PanneauClavier{

    //---------------------------
    // ATTRIBUTS D'INSTANCE
    //---------------------------

    JPanel clavier = new JPanel();
    ModuleAudio audio;
    int octave;

    public PanneauClavier(int octave, ModuleAudio audio){
        this.octave = octave;
        this.audio = audio; 
        initComposants();
    }


    private void initComposants(){
        clavier.setLayout(new BoxLayout(clavier, BoxLayout.X_AXIS));
        clavier.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10, true));
        clavier.setPreferredSize(new Dimension( 600,200));

        clavier.add(new ToucheClavier("C", octave, Color.WHITE));
        clavier.add(new ToucheClavier("C#", octave, Color.BLACK));
        clavier.add(new ToucheClavier("D", octave, Color.WHITE));
        clavier.add(new ToucheClavier("D#", octave, Color.BLACK));
        clavier.add(new ToucheClavier("E", octave, Color.WHITE));
        clavier.add(new ToucheClavier("F", octave, Color.WHITE));
        clavier.add(new ToucheClavier("F#",octave, Color.BLACK));
        clavier.add(new ToucheClavier("G", octave, Color.WHITE));
        clavier.add(new ToucheClavier("G#", octave, Color.BLACK));
        clavier.add(new ToucheClavier("A", octave, Color.WHITE));
        clavier.add(new ToucheClavier("A#", octave, Color.BLACK));
        clavier.add(new ToucheClavier("B", octave, Color.WHITE));
        clavier.add(new ToucheClavier("C", octave+1, Color.WHITE));
    }

    public JPanel getClavier(){
        return clavier;
    }

}