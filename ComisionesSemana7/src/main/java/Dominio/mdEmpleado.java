/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.Scanner;

/**
 *
 * @author USUARIOTC
 */
public class mdEmpleado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int salir = 1;
        
        Comisiones obj = new Comisiones();
        
        System.out.println("Opciones:\n\n1. Crear archivo\n2. Ingresar datos"
                + "\n3. Mostrar datos\n4. Buscar registro\n5. ver un vendedor\n6. Salir");
        
            while(salir!=6){//finaliza el programa
            try{
                System.out.println("                                           ");
                System.out.println("Seleccion:");
                salir=teclado.nextInt();
                
                if(salir==1){obj.crearArchivo();} 
                if(salir==2){
                    System.out.println("Ingresar nombre");
                    String name = teclado.next();
                    System.out.println("Valor Enero");
                    int enero = (int) teclado.nextDouble();
                    System.out.println("Valor Febrero");
                    int febrero = (int) teclado.nextDouble();
                    System.out.println("Valor Marzo");
                    int marzo = (int) teclado.nextDouble();
                    obj.agregarDatos(name,enero,febrero,marzo);
                }
                if(salir==3){obj.verDatos();}
                if(salir == 4){ 
                    System.out.println("Ingrese venta que necesita buscar");
                    String venta = teclado.next();
                    obj.buscarDatos(venta);
                }
                if(salir==5){ 
                    System.out.println("Ingrese ususario para mostrar su informacion");
                    String name1 = teclado.next();
                    obj.buscarDatos(name1);
                }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                teclado.nextLine();
            }
            
        }
       // TODO code application logic here
    }
    
}
