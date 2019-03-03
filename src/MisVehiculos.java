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
      
    }
}
