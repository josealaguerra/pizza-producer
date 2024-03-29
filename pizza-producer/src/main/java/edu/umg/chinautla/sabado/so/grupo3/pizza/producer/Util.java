/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.umg.chinautla.sabado.so.grupo3.pizza.producer;


import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author jag
 */
public class Util {

     private static final String formatDatePrint="yyyy-MM-dd";
    
    
    public static String int2str(int numeroEntero){
        String nuevaCadenaDeCaracteres=null;
        try{        
            nuevaCadenaDeCaracteres = Integer.toString(numeroEntero);
        }catch(Exception e){
            Util.printException("Util.int2str", e);
            nuevaCadenaDeCaracteres = "";
        }
        return nuevaCadenaDeCaracteres;
    }
    

    
    
    
    
    /***
     * Permite inicializar la fecha de nacimiento
     * @return 
     */
    public static String obtieneFechaNac(){
        DateFormat format = new SimpleDateFormat(formatDatePrint); //display your format.
        Date date = new Date();//puts the date in variable.
        return format.format(date); //returns the format to the date variable.
    }
     
    /***
     * Convierte un string a fecha y maneja errores internamente, siempre devuelve una Date valido.
     * @param sDate
     * @return 
     */
    public static Date str2date(String sDate){
        Date nuevaFecha=null;
        
        try{
            nuevaFecha = new SimpleDateFormat().parse(sDate);
        }catch(Exception e){
            Util.printException("Util.str2date", e);
            nuevaFecha=new Date();
        }
        return nuevaFecha;
    }
    
    /***
     * Convierte un string a entero y maneja errores internamente, siempre devuelve un entero valido.
     * @param sDate
     * @return 
     */    
    public static int str2int(String str){
        int nuevoInt = 0;
        
        try{
            if((str==null) || (str.equals(""))){
                nuevoInt =0;
            }else{
                nuevoInt = Integer.parseInt( str );
            }
        }catch(Exception e){
            Util.printException("Util.str2int", e);
            nuevoInt = 0;
        }
        return nuevoInt;
        
    }
    
    /***
     * Convierte un java.util.Date en un java.sqlDate.  Util para insertar en BD.
     * @param sDate
     * @return 
     */        
    public static java.sql.Date utilDate2sqlDate(java.util.Date utilDate) {

        java.sql.Date sqlDate=null;
        
        try{
            sqlDate = new java.sql.Date(utilDate.getTime());            
        }catch(Exception e){
            Util.printException("Util.str2int", e);
            sqlDate = new java.sql.Date(0);
        }
        
        return sqlDate;
    }

   
        
    /***
     * Imprime en consola una excepción.
     * @param sDate
     * @return 
     */             
    public static void printException(String msj, Exception ex){
        System.out.println(msj+" | Mensaje: "+ex.getMessage()+", stack trace: "+ex.getStackTrace());
        Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);        
    }
    
    /***
     * Imprime en consola una excepción.  Versión simplificada
     * @param sDate
     * @return 
     */                 
    public static void printException(Exception ex){
        printException("", ex);
    }

    /***
     * Convierte el ID obtenido de un combo box (que empieza en cero), en el verdadero ID (ID de la tabla)
     * @param id_genero - ID obtenido del combo box 
     * @return ID que se usara para insertar en la tabla
     */
    public static int int2cbx(int id_genero) {
        return id_genero+1;
    }
    
            
    /***
     * Convierte el ID obtenido de un combo box en STRING (que empieza en cero), en el verdadero ID (ID de la tabla)
     * @param id_genero - ID obtenido del combo box 
     * @return ID que se usara para insertar en la tabla
     */
    public static int str2cbx(String id_genero) {
        return int2cbx( str2int( id_genero ) );
    }            

    public static double str2double(String numeroAModificar) {
        double nuevoDoble=0.00;
        try{
            nuevoDoble = Double.parseDouble(numeroAModificar); 
        }catch(Exception e){
            Util.printException("str2double", e);
            nuevoDoble=0.00;
        }
        return nuevoDoble;
    }
    
    public static String getMessageWTS(String msg){
        String sTimeStamp = new Date().toString();
		
	return sTimeStamp + " "+msg;
    }



   
        
    /***
     * Imprime en consola una excepción.
     * @param sDate
     * @return 
     */             
    public static void print(String msj){
        System.out.println(msj);
        //Logger.getLogger(Util.class.getName()).log(Level.INFO, null, msj);
    }



    /***
     * Imprime en consola una excepción.
     * @param sDate
     * @return 
     */             
    public static void getMsgWTS(String msj){
        print( getMessageWTS(msj+"\n") );
    }


}
