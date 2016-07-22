package com.prolificidea.codeoff;

import java.awt.*;

public class ColourPicker {
    public static Color getColour(Colours colours, Shade shade){
        Color colour = new Color(0,0,0);

        if(colours == Colours.BLUE){
            colour = getBlue(shade);
        }

        if(colours == Colours.YELLOW){
            colour = getYellow(shade);
        }

        if(colours == Colours.RED){
            colour = getRed(shade);
        }

        return colour;
    }

    private static Color getBlue(Shade shade){
        if(shade == Shade.LIGHT) return new Color(8, 150, 253);
        else if(shade == Shade.MEDIUM) return new Color(8, 96, 168);
        else  return new Color(8, 61, 122);
    }

    private static Color getYellow(Shade shade){
        if(shade == Shade.LIGHT) return new Color(240, 253, 9);
        else if(shade == Shade.MEDIUM) return new Color(140, 153, 9);
        else  return new Color(74, 83, 8);
    }

    private static Color getRed(Shade shade){
        if(shade == Shade.LIGHT) return new Color(253, 61, 5);
        else if(shade == Shade.MEDIUM) return new Color(201, 52, 5);
        else  return new Color(132, 31, 5);
    }
}
