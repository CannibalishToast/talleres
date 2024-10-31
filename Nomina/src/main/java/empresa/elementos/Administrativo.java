/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresa.elementos;

/**
 *
 * @author danie
 */
public class Administrativo extends Empleado {
    
    private float descuentoFiscales;
    private float descuentoRenta;
    
    public Administrativo(String cedula, String nombre, String apellido, String dependencia){
        super(cedula, nombre, apellido, dependencia);
        rol = "Administrativo";
    }
    
    public boolean setDescuentoFiscales(float descuentoFiscales){
        if(descuentoFiscales<0)
            return false;
        this.descuentoFiscales = descuentoFiscales;
        return true;
    }
    
    public boolean setDescuentoRenta(float descuentoRenta){
        if(salarioBase<0)
            return false;
        if(salarioBase>100)
            return false;
        this.descuentoRenta = descuentoRenta;
        return true;
    }

    
    @Override
    public float calcularSalarioDevengado(){
        float salarioDevengado = salarioBase - (descuentoRenta*salarioBase/100) - descuentoFiscales;
        return salarioDevengado;
    }
    
}
