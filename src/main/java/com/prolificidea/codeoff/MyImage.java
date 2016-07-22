package com.prolificidea.codeoff;

public class MyImage {
    private char[][] image;

    public MyImage() {
        image = new char[43][43];

    }

    public boolean drawMe(int x, int y){
        if((x < 0 || x >= Config.SCREEN_SIZE) || (y < 0 || y >= Config.SCREEN_SIZE)){
            return false;
        }

        return true;//image[x][y] == 'x';
    }
}
