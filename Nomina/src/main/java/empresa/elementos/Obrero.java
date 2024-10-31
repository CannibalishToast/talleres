/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresa.elementos;

/**
 *
 * @author danie
 */
public class Obrero extends Empleado {
    
    private float retencionFuente;
    private float auxilioTransporte;
    
    public Obrero(String cedula, String nombre, String apellido, String dependencia){
        super(cedula, nombre, apellido, dependencia);
        rol = "Obrero";
    }
    
    public boolean setRetencionFuente(float retencionFuente){
        if(retencionFuente<0)
            return false;
        if(retencionFuente>100)
            return false;
        this.retencionFuente = retencionFuente;
        return true;
    }
    
    public boolean setAuxilioTransporte(float auxilioTransporte){
        if(auxilioTransporte<0)
            return false;
        this.auxilioTransporte = auxilioTransporte;
        return true;
    }


    
    @Override
    public float calcularSalarioDevengado(){
        float salarioDevengado = salarioBase + auxilioTransporte - (retencionFuente*salarioBase/100);
        return salarioDevengado;
    }
    
}
