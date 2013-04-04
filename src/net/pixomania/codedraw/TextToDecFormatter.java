/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.pixomania.codedraw;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class TextToDecFormatter {
    
    public static ArrayList<Integer> getList(String text){
        char[] charList = text.toCharArray();
        ArrayList<Integer> decList = new ArrayList<Integer>();
        
        for(char c : charList){
            decList.add((int) c);
        }
        
        return decList;
    }
       
    
}
