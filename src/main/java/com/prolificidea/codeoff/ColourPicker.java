package com.prolificidea.codeoff;

import java.awt.*;

public class ColourPicker {
    public static Color getColour(Colours colours, Shade shade){
        Color colour = new Color(0,0,0);

        if(colours == Colours.GREEN){
            colour = getGreen(shade);
        }

        if(colours == Colours.BLUE){
            colour = getBlue(shade);
        }

        if(colours == Colours.RED){
            colour = getRed(shade);
        }

        return colour;
    }

    private static Color getGreen(Shade shade){
        if(shade == Shade.LIGHT) return new Color(29, 253, 7);
        else if(shade == Shade.MEDIUM) return new Color(24, 151, 7);
        else  return new Color(19, 91, 7);
    }

    private static Color getBlue(Shade shade){
        if(shade == Shade.LIGHT) return new Color(5, 194, 253);
        else if(shade == Shade.MEDIUM) return new Color(5, 106, 147);
        else  return new Color(4, 62, 80);
    }

    private static Color getRed(Shade shade){
        if(shade == Shade.LIGHT) return new Color(253, 61, 5);
        else if(shade == Shade.MEDIUM) return new Color(201, 52, 5);
        else  return new Color(132, 31, 5);
    }
}
