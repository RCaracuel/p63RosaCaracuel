
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosa
 */
public class EmpresaAlquilerVehiculos {
     // Atributos de la empresa
    private String cif;
    private String nombre;
    private String paginaWeb;
    /* Atributos para controlar el total de clientes que tiene la
empresa y array de almacenamiento para los objetos Cliente */
    private int totalClientes;
    private ArrayList <Cliente> clientes;
    /* Atributos para controlar el total de vehiculos disponibles en
alquiler que tiene la empresa y array de almacenamiento para los objetos
Vehiculo */
    private int totalVehiculos;
    private ArrayList <Vehiculo> vehiculos;
    /* Atributos para controlar el histórico de alquileres: total de
alquileres realizados y array de almacenamiento para los objetos
VehiculoAlquilado */
    private int totalAlquileres;
    private VehiculoAlquilado[] alquileres;
// se omiten los métodos ‘get’ y ‘set’ de la clase
/* Constructor parametrizado donde se establece que el total de clientes
será 50, igual que el total de vehiculos disponibles. El histórico de
vehiculos puede contener hasta 100 elementos */
    public EmpresaAlquilerVehiculos(String cif, String nombre, String paginaWeb) {
        this.cif = cif;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
// Incialmente no hay clientes creados en la empresa
        this.clientes = new ArrayList<>(25); // apuntan a null
// Incialmente no hay vehiculos creados en la empresa
        this.totalVehiculos = 0;
        this.vehiculos =new ArrayList<>(25); // apuntan a null
// Incialmente no hay histórico de alquileres en la empresa
        this.totalAlquileres = 0;
        this.alquileres = new VehiculoAlquilado[100]; // apuntan a null
    }

    //método registrarCliente
    public void registrarCliente(Cliente nuevo) {
        this.clientes.add(nuevo);
    }

    //método registrar vehículo
    public void registrarVehiculo(Vehiculo nuevo) {
        this.vehiculos.add(nuevo);
    }

    //Método imprimir clientes
    public void imprimirClientes() {
        System.out.println("NIF cliente\tNombre\n");
        for (int i = 0; i < this.clientes.size(); i++) {
            System.out.println(clientes.get(i).getNif()+ "\t" + clientes.get(i).getNombre());
        }
    }
    
    
    //Método que rellene clientes aleatorios
    public void rellenarClientes(){
        
        for (int i = 0; i <this.clientes.size(); i++) {
            
            this.clientes.add(i, new Cliente());
        }
        
    }
    
    //Método rellenar vehículos aleatorios
   
    public void rellenarVehiculos(){
        
        for (int i = 0; i <this.vehiculos.size(); i++) {
            this.vehiculos.add(i, new Vehiculo());
        
        }
   
    }
 
    
    //método imprimir vehículos
    public void imprimirVehiculos() {
        System.out.println("Matricula\tModelo\tColor\tImporte\tDisponible\n");
        for (int i = 0; i < this.vehiculos.size(); i++) {
            System.out.println(vehiculos.get(i).toString());
        }
    }

    //Método getCliente
    private Cliente getCliente(String nif) {
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i).getNif().equals(nif)) {
                return this.clientes.get(i);
            }

        }
        return null;
    }

    //Método getVehiculos
    private Vehiculo getVehiculo(String matricula) {
        for (int i = 0; i < this.vehiculos.length; i++) {
            if (this.vehiculos[i].getMatricula().equals(matricula)) {
                return this.vehiculos[i];
            }
        }
        return null;
    }

    //método alquilarVehiculos
    public void alquilarVehiculo(String matricula, String nif, int dias) {
        Cliente cliente = getCliente(nif);
        Vehiculo vehiculo = getVehiculo(matricula);
// busca el cliente con el NIF dado en el array
// clientes y el vehículo con la matrícula dada en el
// array vehiculos, si el vehículo está disponible se
// alquila con la fecha actual, que se obtiene
// ejecutando los métodos diaHoy(), mesHoy() y
// añoHoy(), cuya declaración no se incluye
        if (vehiculo.isDisponible()) {
            vehiculo.setDisponible(false);
            this.alquileres[this.totalAlquileres] = new VehiculoAlquilado(cliente, vehiculo, 15, 3, 2018, dias);

            this.totalAlquileres++;
        }
    }
    

    //Método burbuja con cliente por nif
    public void burbujaCliente(){
        Cliente auxiliar;
        int valor=0;
        for (int i = 0; i <this.clientes.length; i++) {
            for (int j =i+1; j <this.clientes.length; j++) {
                valor=this.clientes[i].getNif().compareToIgnoreCase(this.clientes[j].getNif());
                if(valor>0){
                    auxiliar=this.clientes[i];
                    this.clientes[i]=this.clientes[j];
                    this.clientes[j]=auxiliar;
                }
            }
        }
        
            }
    
    //Método burbuja con vehiculos por matrícula
    public  void burbujaVehiculos(){
        Vehiculo auxiliar;
        int valor=0;
        for (int i = 0; i <this.vehiculos.length; i++) {
            for (int j =i+1; j <this.vehiculos.length; j++) {
                valor=this.vehiculos[i].getMatricula().compareTo(this.vehiculos[j].getMatricula());
                if(valor>0){//que [i] es mayor que [j]
                    auxiliar=this.vehiculos[i];
                    this.vehiculos[i]=this.vehiculos[j];
                    this.vehiculos[j]=auxiliar;
                }
            }
        }
    }
    
    //Búsqueda binaria con clientes
    public int busquedaNif(String aux){

        int mitad=0;
        int limiteInferior = 0;
        int limiteSuperior = this.clientes.length-1;
    
        int valor=0;
        
//        int numeroBusqueda = 11;
//        boolean encontrado = false;
//        while ((limiteInferior <= limiteSuperior) && (!encontrado)) {
//            mitad = (limiteInferior + limiteSuperior) / 2;
//            if (numeros[mitad] == numeroBusqueda) {
//                encontrado = true; // ¡encontrado!
//            } else if (numeros[mitad] > numeroBusqueda) {
//                limiteSuperior = mitad - 1; // buscar en la primera mitad
//            } else {
//                limiteInferior = mitad + 1; // buscar en la segunda mitad
//            }
//        }
        while((limiteInferior<=limiteSuperior)){
            mitad=(limiteInferior + limiteSuperior)/2;
            valor=this.clientes[mitad].getNif().compareTo(aux);

            if(valor==0){
                return mitad;
            }else if(valor<0){
                limiteInferior=mitad+1;
            }else{
                limiteSuperior=mitad-1;
            }
            
           
        }
         return -1;
         
}
    
    
    //Método búsqueda binaria por matrícula
    
    public int busquedaMatricula(String aux){
        
        int mitad=0;
        int limiteInferior = 0;
        int limiteSuperior = this.vehiculos.length-1;
    
        int valor=0;
        
         while((limiteInferior<=limiteSuperior)){
            mitad=(limiteInferior + limiteSuperior)/2;
            valor=this.vehiculos[mitad].getMatricula().compareTo(aux);

            if(valor==0){
                return mitad;
            }else if(valor<0){
                limiteInferior=mitad+1;
            }else{
                limiteSuperior=mitad-1;
            }
            
           
        }
         
         return -1;
         
    }
    
    //método recibirVehiculo
    public void recibirVehiculo(String matricula) {
// busca el vehículo con la matrícula dada en el
// array vehiculos y modifica su disponibilidad
// para que se pueda alquilar de nuevo
        Vehiculo vehiculo = getVehiculo(matricula);
        if (vehiculo != null) {
            vehiculo.setDisponible(true);
        }

    }

    //getters y setters
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public int getTotalClientes() {
        return totalClientes;
    }

    public void setTotalClientes(int totalClientes) {
        this.totalClientes = totalClientes;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public int getTotalVehiculos() {
        return totalVehiculos;
    }

    public void setTotalVehiculos(int totalVehiculos) {
        this.totalVehiculos = totalVehiculos;
    }

    public Vehiculo[] getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculo[] vehiculos) {
        this.vehiculos = vehiculos;
    }

    public int getTotalAlquileres() {
        return totalAlquileres;
    }

    public void setTotalAlquileres(int totalAlquileres) {
        this.totalAlquileres = totalAlquileres;
    }

    public VehiculoAlquilado[] getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(VehiculoAlquilado[] alquileres) {
        this.alquileres = alquileres;
    }

    @Override
    public String toString() {
        return "EmpresaAlquilerVehiculos{" + "cif=" + cif + ", nombre=" + nombre + ", paginaWeb=" + paginaWeb + ", totalClientes=" + totalClientes + ", clientes=" + clientes + ", totalVehiculos=" + totalVehiculos + ", vehiculos=" + vehiculos + ", totalAlquileres=" + totalAlquileres + ", alquileres=" + alquileres + '}';
    }

    public static void main(String[] args) {
        
        EmpresaAlquilerVehiculos prueba= new EmpresaAlquilerVehiculos("iouiuhi","Rosa","wwww.iowjfjhweof.com");
        

      
        prueba.imprimirVehiculos();
        System.out.println("---------------------------------");
        prueba.rellenarClientes(prueba);

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
