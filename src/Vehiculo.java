
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosa
 */
public class Vehiculo {
    private String matricula;
private String marca;
private String modelo;
private String color;
private double tarifa;
private boolean disponible;

 




//constructor parametrizado

    public Vehiculo(String matricula, String marca, String modelo, String color, double tarifa, boolean disponible) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tarifa = tarifa;
        this.disponible = disponible;
    }


    //getters and setters

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    public Vehiculo(){
        
        Random rnd=new Random();
        
        String[] marcaArray={"Nisan", "Jeep", "Audi","Seat"};
        String[] modeloArray={"Astra","Megane","Fiesta","Laguna","Evoque"};
        String[] colorArray={"Blanco","Negro","Amarillo","Rojo","Verde"};
        double[] tarifaArray={258.3,896.35,785,56.25,548.32};
        int[] matriculaArray=new int[4];
        int[] letrArray= new int[3];
        String matri="";
        
        
        for (int i = 0; i <matriculaArray.length; i++) {
            matriculaArray[i]=rnd.nextInt(10);
            matri+=Integer.toString(matriculaArray[i]);
        }
        
        for (int i = 0; i <letrArray.length; i++) {
            letrArray[i]=rnd.nextInt(90-65+1)+65;
            matri+=(char)letrArray[i];
        }
     
        this.marca=marcaArray[rnd.nextInt(3)];
        this.matricula=matri;
        this.modelo=modeloArray[rnd.nextInt(4)];
        this.color=colorArray[rnd.nextInt(4)];
        this.tarifa=tarifaArray[rnd.nextInt(4)];
        this.disponible=rnd.nextBoolean();
         
    }
    //toString

    @Override
    public String toString() {
        return "Matricula=" +matricula + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", tarifa=" + tarifa + ", disponible=" + disponible + '}';
    }
}
