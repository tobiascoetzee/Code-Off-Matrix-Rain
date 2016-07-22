package com.prolificidea.codeoff;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.net.URL;

public class Rain extends JPanel {

    private Drop[] drops;

    Rain() {
        try {
            URL t = getClass().getClassLoader().getResource("matrix42.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(t);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(100);
            clip.start();
        }catch (Exception e){
            e.printStackTrace();
        }

        drops = new Drop[Config.SCREEN_SIZE / Config.FONT_SIZE];
        for (int i = 0; i < drops.length; i++) {
            drops[i] = new Drop(i * Config.FONT_SIZE);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g.fillRect(0, 0, Config.SCREEN_SIZE, Config.SCREEN_SIZE);
        g.setColor(Color.BLACK);
        Font font = new Font("SANS_SERIF", Font.PLAIN, Config.FONT_SIZE);
        g2.setFont(font);

        for (int i = 0; i < drops.length; i++) {
            if (drops[i].isOffScreen()) {
                drops[i] = new Drop(i * Config.FONT_SIZE);
            }
            drops[i].draw(g2);
        }

        try {
            Thread.sleep(10);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        repaint();
    }

}
