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
public class Convert {
    /**
     * Convert ints to bytes
     * @param intArray
     * @return 
     */
    public static byte[] convertIntArrayToByte(int[] intArray){
        byte[] byteArray = new byte[intArray.length];
        
        for(int i = 0; i < intArray.length; i++){
            Integer num = new Integer(intArray[i]); 
            byteArray[i] = num.byteValue();
        }
        return byteArray;
    }
    
    /**
     * Convert the list to an array
     * @param list the list of ints
     * @return 
     */
    public static int[] convertListToArray(ArrayList<Integer> list){
        int[] array = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            array[i] = list.get(i);
        }
        
        return array;
    }
}
