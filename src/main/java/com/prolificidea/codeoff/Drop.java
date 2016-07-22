package com.prolificidea.codeoff;

import java.awt.*;
import java.util.Random;

public class Drop {

    private MyImage image;

    private Random rng = new Random();
    private int velocity, length, x, y;
    private char[][] text;

    Drop(int x) {
        image = new MyImage();
        this.x = x;
        length = getRandomInteger(30, 60);
        text = createContent(length);
        velocity = getRandomInteger(5, 10);
        this.y = (-1) * length * Config.FONT_SIZE;
    }

    protected char[][] createContent(int length) {
        char[][] result = new char[length][1];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = getRandomCharacter();
        }
        return result;
    }

    public void draw(Graphics2D g2) {
        int fontSize = g2.getFont().getSize();
        for (int i = 0; i < length; i++) {
            Colours colour = Colours.GREEN;
            Shade shade;

            if (getRandomInteger(0, length) == i)
                text[i][0] = getRandomCharacter();
            if (i >= length - 5)
                shade = Shade.LIGHT;
            else if (i <= length - 6 && i >= length - 30)
                shade = Shade.MEDIUM;
            else
                shade = Shade.DARK;

            int startX = 140;
            int startY = 250;
            int realY = y + (i * fontSize);
            colour = checkForI(colour, startX, startY, realY);
            colour = checkForC(colour, startX, startY, realY);
            colour = checkForJ(colour, startX, startY, realY);
            colour = checkFor1(colour, startX, startY, realY);
            colour = checkFor6(colour, startX, startY, realY);

            g2.setColor(ColourPicker.getColour(colour, shade));

            g2.drawChars(text[i], 0, 1, x, y + (i * fontSize));
        }
        y += velocity;
    }

    private Colours checkFor6(Colours colour, int startX, int startY, int realY) {
        //6
        //left side
        if ((x > startX + 360 && x < startX + 380) && (realY > startY && realY < startY + 115)) {
            colour = Colours.BLUE;
        }

        //bottom
        if ((x > startX + 360 && x < startX + 430) && (realY > startY + 100 && realY < startY + 115)) {
            colour = Colours.BLUE;
        }

        //right side
        if ((x > startX + 410 && x < startX + 430) && (realY > startY + 50 && realY < startY + 115)) {
            colour = Colours.BLUE;
        }

        //middle
        if ((x > startX + 360 && x < startX + 430) && (realY > startY + 50 && realY < startY + 55)) {
            colour = Colours.BLUE;
        }
        return colour;
    }

    private Colours checkFor1(Colours colour, int startX, int startY, int realY) {
        //1
        //top
        if ((x > startX + 300 && x < startX + 320) && (realY > startY && realY < startY + 15)) {
            colour = Colours.BLUE;
        }

        //middle
        if ((x > startX + 320 && x < startX + 340) && (realY > startY && realY < startY + 115)) {
            colour = Colours.BLUE;
        }
        return colour;
    }

    private Colours checkForJ(Colours colour, int startX, int startY, int realY) {
        //J
        //top
        if ((x > startX + 200 && x < startX + 280) && (realY > startY && realY < startY + 15)) {
            colour = Colours.RED;
        }

        //middle
        if ((x > startX + 240 && x < startX + 250) && (realY > startY && realY < startY + 115)) {
            colour = Colours.RED;
        }

        //bottom
        if ((x > startX + 200 && x < startX + 260) && (realY > startY + 100 && realY < startY + 115)) {
            colour = Colours.RED;
        }
        return colour;
    }

    private Colours checkForC(Colours colour, int startX, int startY, int realY) {
        //C
        //top
        if ((x > startX + 100 && x < startX + 180) && (realY > startY &&realY < startY + 15)) {
            colour = Colours.RED;
        }


        //side
        if ((x > startX + 100 && x < startX + 110) && (realY > startY && realY < startY + 115)) {
            colour = Colours.RED;
        }

        //bottom
        if ((x > startX + 100 && x < startX + 180) && (realY > startY + 100 && realY < startY + 115)) {
            colour = Colours.RED;
        }
        return colour;
    }

    private Colours checkForI(Colours colour, int startX, int startY, int realY) {
        //I
        //top
        if ((x > startX && x < startX + 80) && (realY > startY && realY < startY + 15)) {
            colour = Colours.RED;
        }

        //middle
        if ((x > startX + 40 && x < startX + 60) && (realY > startY && realY < startY + 115)) {
            colour = Colours.RED;
        }

        //bottom
        if ((x > startX && x < startX + 80) && (realY > startY + 100 && realY < startY + 115)) {
            colour = Colours.RED;
        }
        return colour;
    }

    public char getRandomCharacter() {
        int minJpnCharCode = 0x30a0;
        int maxJpnCharCode = 0x30ff;

        return (char)getRandomInteger(minJpnCharCode, maxJpnCharCode);
    }

    public int getRandomInteger(int min, int max) {
        int randomNum = rng.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public boolean isOffScreen() {
        return (y > Config.SCREEN_SIZE);
    }

    /*public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char[][] getText() {
        return text;
    }

    public void setText(char[][] text) {
        this.text = text;
    }*/
}