/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresa.elementos;

/**
 *
 * @author danie
 */
public class Empleado {
    
    protected String cedula;
    protected String nombre;
    protected String apellido;
    protected float salarioBase;
    protected String dependencia;
    protected String rol;
        
    public Empleado(String cedula, String nombre, String apellido, String dependencia){
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dependencia = dependencia;
        
    }
    
    public float calcularSalarioDevengado(){
        float salarioDevengado = salarioBase;
        return salarioDevengado;
    }
    
    public String getCedula(){
        return cedula;
    }
    
    public String getNombreCompleto(){
        String nombreCompleto = nombre + " " + apellido;
        return nombreCompleto;
    }
    
    public String getRol(){
        return rol;
    }
    
    public boolean setSalarioBase(float salarioBase){
        if(salarioBase<0)
            return false;
        this.salarioBase = salarioBase;
        return true;
    }
}
