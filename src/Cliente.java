
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
public class Cliente {

    private String nif;
    private String nombre;
    private String apellidos;

//Constructor parametrizado
    public Cliente() {

        Random rnd = new Random();
        String[] nombreArray = {"María", "Antonio", "Pepa", "Roberta", "Facundo", "Noelia", "Miguel", "Isi", "Bernardo", "Paco"};
        String[] apellidoArray = {"Cabrales", "Pérez", "Calderón", "Rupia", "Jimenez", "Gonzalez", "Cabeza", "Bocanegra", "Ledezma", "Caracuel"};

        int[] nifArray = new int[8];

        for (int i = 0; i < nifArray.length; i++) {
            nifArray[i] = rnd.nextInt(10);
        }

        String nifS = "";
        for (int i = 0; i < nifArray.length; i++) {
            nifS += Integer.toString(nifArray[i]);
        }
        int letra = rnd.nextInt(90 - 65 + 1) + 65;
        this.nif = nifS + (char) letra;
        this.nombre = nombreArray[rnd.nextInt(9)];
        this.apellidos = apellidoArray[rnd.nextInt(9)] + " " + apellidoArray[rnd.nextInt(9)];
    }

    public Cliente(String nif, String nombre, String apellidos) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    //getters and setters
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    //toString
    @Override
    public String toString() {
        return "Cliente{" + "nif=" + nif + ", nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }
}
