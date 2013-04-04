/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.pixomania.codedraw;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author galaxyAbstractor
 */
public class CreateImage {
    /**
     * Create a BufferedImage from the integers so we can save it as a bmp
     * @param list
     * @return 
     */
    public static BufferedImage create(ArrayList<Integer> list){
        // If the list size is not yet divisible by 3, we need to add some elements with the color value 0.
        while(list.size() % 3 != 0) list.add(0);
            
        // Create the image and set it's dimension so it would be *number of pixels* wide and 1 px high
        BufferedImage image = new BufferedImage((int)Math.ceil((double)(list.size())/3), 1, BufferedImage.TYPE_INT_RGB);

        int x = 0;
        int y = 0;
        // Go trough the list 3 elements at a time
        for(int i = 0;i < list.size()-3;i+=3){
            // set the color of the pixel
            image.setRGB(x, y, new Color(list.get(i+2), list.get(i+1), list.get(i)).getRGB());
            x++;
            
        }      
        return image;  
    }
 
}
