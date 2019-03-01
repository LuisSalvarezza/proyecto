/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Ing Salvarezza
 */
public class Validaciones 
{
    
    public static boolean IsNull_Empty( final String s ) 
    {
  // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }
    
    public static Boolean validarInt(String dato) 
    {
        boolean esEntero = false;
        int num = 0;
        
        try
        {
            num = Integer.parseInt(dato);
            esEntero = true;
        } catch (NumberFormatException nfe) {
            
            esEntero = false;
        }
        
        return esEntero;
    }

    public static Boolean validarDouble(String dato) 
    {
        boolean esDouble = false;
        double num = 0;

            try {
                num = Double.parseDouble(dato);
                esDouble = true;
            } catch (NumberFormatException nfe) 
            {
                 esDouble = false;
            }
       
    
        return esDouble;
    }
    
}
