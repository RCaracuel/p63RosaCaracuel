
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosa
 */
public class MisVehiculos {
    public static void main(String[] args) {
        
        Scanner teclado=new Scanner(System.in);
         EmpresaAlquilerVehiculos prueba= new EmpresaAlquilerVehiculos("iouiuhi","Rosa","wwww.iowjfjhweof.com");
        

      
        prueba.imprimirVehiculos();
        System.out.println("---------------------------------");
        prueba.rellenarClientes();

        prueba.rellenarVehiculos();
        prueba.imprimirVehiculos();
        System.out.println("---------------------------------");
        prueba.rellenarClientes();

        prueba.imprimirClientes();
        
        System.out.println("------------------");
        prueba.burbujaCliente();
        System.out.println("ORDENADOS LOS CLIENTES");
        prueba.imprimirClientes();
      
        System.out.println("-----------------------");
        prueba.burbujaVehiculos();
        System.out.println("ORDENADOR POR MATRÍCULA");
        prueba.imprimirVehiculos();
        System.out.println("-----------------------");
        System.out.println("Introduzca Nif a buscar:");
        String aux=teclado.nextLine();
        
        prueba.busquedaNif(aux);
        
        if(prueba.busquedaNif(aux)==-1){
            System.out.println("No se ha encontrado");
        }else{
            System.out.println("Lo hemos encontrado en la posición "+prueba.busquedaNif(aux));
        }
        
        System.out.println("------------------------");
        System.out.println("Introduzca matrícula a buscar");
        String aux2=teclado.nextLine();
        
        prueba.busquedaMatricula(aux2);
        
        if(prueba.busquedaMatricula(aux2)==-1){
            System.out.println("No se ha encontrado");
        }else{
            System.out.println("Lo hemos encontrado en la posición "+prueba.busquedaMatricula(aux2));
        }
        
        System.out.println("Introduzca mátricula para alquilar:");
        String matAlquiler=teclado.nextLine();
        System.out.println("Introduzca nif:");
        String nifAlquiler=teclado.nextLine();
        System.out.println("Introduzca número de días:");
        int dias=teclado.nextInt();
        
        teclado.nextLine();
        
        prueba.alquilarVehiculo(matAlquiler, nifAlquiler, dias);
        
    }
}
