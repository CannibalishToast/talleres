/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresa;
import empresa.elementos.Empleado;
import empresa.elementos.Obrero;
import empresa.elementos.Administrativo;

/**
 *
 * @author danie
 */
public class Empresa {
    private Empleado empleados[];
    
    
    public Empresa(){
        empleados = new Empleado[10];
    }
    
    public int agregarEmpleado(String cedula, String nombre, String apellido, String dependencia, int rol){
        if(comprobarCedula(cedula)==false)
            return -1;
        
        int indice = buscarEspacioLibre();
        if(indice<0)
           return -2;
        
        switch(rol){
            case 1:
              empleados[indice]= new Obrero(cedula, nombre, apellido, dependencia);
              return 1;
            case 2:
              empleados[indice]= new Administrativo(cedula, nombre, apellido, dependencia);
              return 1;
            default:
              return -3;
        }
    }
    
        private boolean comprobarCedula(String cedula){
            for(int i=0; i<empleados.length;i++){
                if(empleados[i]==null)
                    break;
                if(empleados[i].getCedula().equals(cedula))
                    return false;
            }
            return true;
        }

        private int buscarEspacioLibre(){

            for(int i=0; i<empleados.length; i++){
                if(empleados[i]==null)
                    return i;
            }
            return -1;
        }
    
    public Empleado[] listarEmpleados(){
        return empleados;
    }
    
    public Empleado buscarEmpleadoPorCedula(String cedula){
        for(int i=0;i<empleados.length;i++){
            if(empleados[i]==null)
                break;
            if(cedula.equals(empleados[i].getCedula()))
                return empleados[i];
        }
        return null;
    }
    
   public float calcularPromedioSalarios(){
       float total = 0;
       int cantidadEmpleados = 0;
       for(int i=0;i<empleados.length;i++){
           if(empleados[i]==null)
               break;
           total += empleados[i].calcularSalarioDevengado();
           cantidadEmpleados++;
       }
       float promedioSalarios = total/cantidadEmpleados;
       return promedioSalarios;
   }
   
   public Empleado buscarEmpleadoMayorSalario(){
       Empleado empleadoMayorSalario = new Empleado("", "", "", "");
       for(int i=0;i<empleados.length;i++){
           if(empleados[i]==null)
               break;
           if(empleados[i].calcularSalarioDevengado()>empleadoMayorSalario.calcularSalarioDevengado())
               empleadoMayorSalario = empleados[i];
       }
       return empleadoMayorSalario;
   } 
}
