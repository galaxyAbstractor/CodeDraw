/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.pixomania.codedraw;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class CodeCanvas extends Canvas {
    private static ArrayList<Integer> colors = new ArrayList<Integer>();
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        int x = 0;
        int y = 0;
        // go trough the list by elemnts of 3
        for(int i = 0;i < colors.size();i +=3) {
            
            int b = colors.get(i); // blue
            int gr = (i+1) < colors.size() ? colors.get(i+1) : 0; // green
            int r = (i+2) < colors.size() ? colors.get(i+2) : 0; // red
            
            // set the color of the rectangle
            g.setColor(new Color(r, gr, b));
            
            // draw the rectangle
            g.fillRect(x, y, 10, 10);
            x +=10;
            if(x == 840) {
                x = 0;
                y +=10;
            }
        }
    }
    
    public static void addColor(ArrayList<Integer> list){
        colors = list;
    }
}
