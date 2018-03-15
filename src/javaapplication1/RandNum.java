/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author rasikh
 */
public class RandNum {
int rand = 0;
    public RandNum() {    
        try 
                {
                SecureRandom randomGenerator = SecureRandom.getInstance("SHA1PRNG");         
                HashSet<Integer> set = new HashSet<>();
                set.add(randomGenerator.nextInt(9999));
                rand = Integer.parseInt(set.toString().substring(1, 5));
                
        } catch (NoSuchAlgorithmException nsae) {
  // Forward to handler
        }
    }
    public int getRand() {
        return rand;
    }
}
