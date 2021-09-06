/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *
 * @author USUARIOTC
 */
public class Comisiones {
    private Scanner entrada;
        private String nombre;
        private int enero;
        private int febrero;
        private int marzo;
        private int total;
        private double promedio;
    
        File archivo = new File("C:\\Users\\USUARIOTC\\OneDrive\\Escritorio\\PROGRA 2\\Archivos\\comisiones.txt");
    
    public Comisiones(){
    }
              
    public void crearArchivo(){
        try{
            if(archivo.exists()){
                System.out.println("Archivo existente");
            }else{
                archivo.createNewFile();
                System.out.println("Archivo creado");
            }
            }catch(Exception ex){
            System.out.println(ex.getMessage());
        }       
    }
    
    public void agregarDatos(String name2, double enero2, double febrero2, double marzo2){
        
        nombre = name2;
        enero = (int) enero2;
        febrero = (int) febrero2;
        marzo = (int) marzo2;
        total = enero+febrero+marzo;
        promedio = total/3;
        
        try{
            
            BufferedWriter wrdata = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo, true)));
            wrdata.write( nombre +" , "+ enero +" , "+ febrero +" , "+ marzo +" , "+ total +" , "+ promedio);
            System.out.println("\nSe agregaron los datos al archivo\n");
            wrdata.close();
            
            }catch(Exception ex){           
            System.out.println(ex.getMessage());
            
        }        
    }
    
    public void verDatos(){
        
        try{
            FileReader filerd = new FileReader("C:\\Users\\USUARIOTC\\OneDrive\\Escritorio\\PROGRA 2\\Archivos\\comisiones.txt");
            BufferedReader show = new BufferedReader(filerd);
            String cadena;
            while((cadena=show.readLine())!=null){
                System.out.println(" "+cadena);
            }
            }catch(Exception ex){
            System.out.println();
        }        
    }
    
    public void buscarDatos(String nVenta){
        
        String usuario=nVenta;
        try{
            BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\USUARIOTC\\OneDrive\\Escritorio\\PROGRA 2\\Archivos\\comisiones.txt"));
            String linea = "";
            while((linea =read.readLine())!=null){
                if(linea.indexOf(usuario)!=-1){
                    System.out.println("Registro: \n"+linea);
                }
            }
            }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    } 
    
    
}
