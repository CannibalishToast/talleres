/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresa.gui;
import empresa.Empresa;
import empresa.elementos.Empleado;
import empresa.elementos.Obrero;
import empresa.elementos.Administrativo;
import java.util.Scanner;

/**
 *
 * @author danie
 */
public class Menu {
    private Empresa empresa;
    private Scanner teclado;
    
    public Menu(){
        teclado = new Scanner(System.in);
    }
    
    public void setEmpresa(Empresa empresa){
        this.empresa = empresa;
    }
    
    public static void main(String[] args){
        Menu menu = new Menu();
        Empresa yoKonstruyo = new Empresa();
        menu.setEmpresa(yoKonstruyo);
        
        boolean ejecucion=true;
        while(ejecucion==true){
            System.out.println("////////////////////////////////////////////////////////////");
            System.out.println("Bienvenido al sistema de empleados de la empresa YoKonstruyo");
            System.out.println("Ingrese el respectivo numero de la accion que desee realizar");
            System.out.println("////////////////////////////////////////////////////////////");
            System.out.println();
            System.out.println("1. Agregar empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Buscar empleado por cedula");
            System.out.println("4. Mostrar salario devengado de empleado");
            System.out.println("5. Mostrar promedio de salarios");
            System.out.println("6. Mostrar el mayor salario devengado");
            System.out.println("7. Modificar salarios y descuentos");
            System.out.println("8. Salir");
            System.out.println();
            int accion = menu.teclado.nextInt();
            System.out.println();

            switch(accion){
                case 1:
                    System.out.println("/////// Agregar empleado /////// ");
                    System.out.println();
                    
                    System.out.println("Digite la cedula del empleado");
                    String cedula = menu.teclado.nextLine();
                    cedula = menu.teclado.nextLine();
                    System.out.println("Digite los nombres del empleado");
                    String nombre = menu.teclado.nextLine();
                    System.out.println("Digite los apellidos del empleado");
                    String apellido = menu.teclado.nextLine();
                    System.out.println("Digite la dependencia donde trabaja el empleado");
                    String dependencia = menu.teclado.nextLine();
                    System.out.println("Digite el rol del empleado (1 para rol de obrero, 2 para rol de administrativo)");
                    int rol = menu.teclado.nextInt();
                    int salida = yoKonstruyo.agregarEmpleado(cedula, nombre, apellido, dependencia, rol);
                    switch(salida){
                        case 1:
                            System.out.println("Registro exitoso");
                            break;
                        case -1:
                            System.out.println("Registro no exitoso, la cedula ya ha sido registrada");
                            break;
                        case -2:
                            System.out.println("Registro no exitoso, no queda espacio");
                            break;
                        case -3:
                            System.out.println("Registro no exitoso, el rol ingresado no es valido");
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("/////// Lista de empleados /////// ");
                    System.out.println();
                    
                    Empleado listaEmpleados[] = yoKonstruyo.listarEmpleados();
                    for(int i=0;i<listaEmpleados.length;i++){
                        if(listaEmpleados[i]==null)
                            break;
                        System.out.println(listaEmpleados[i].getNombreCompleto());
                        System.out.println(listaEmpleados[i].getCedula());
                        System.out.println(listaEmpleados[i].getRol());
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("/////// Buscar empleado por cedula /////// ");
                    System.out.println();
                    
                    System.out.println("Digite la cedula que desea buscar");
                    String cedulaABuscar = menu.teclado.nextLine();
                    cedulaABuscar = menu.teclado.nextLine();
                    
                    Empleado empleado = yoKonstruyo.buscarEmpleadoPorCedula(cedulaABuscar);
                    if(empleado==null){
                        System.out.println("Empleado no encontrado");
                        break;
                    }
                    
                    System.out.println();
                    System.out.println("Empleado encontrado:");  
                    System.out.println(empleado.getNombreCompleto());
                    System.out.println(empleado.calcularSalarioDevengado());
                    System.out.println(empleado.getRol());
                    
                    break;
                case 4:
                    System.out.println("/////// Mostrar salario devengado /////// ");
                    System.out.println();
                    
                    System.out.println("Digite la cedula del empleado");
                    cedulaABuscar = menu.teclado.nextLine();
                    cedulaABuscar = menu.teclado.nextLine();
                    
                    empleado = yoKonstruyo.buscarEmpleadoPorCedula(cedulaABuscar);
                    if(empleado==null){
                        System.out.println("Empleado no encontrado");
                        break;
                    }
                    
                    System.out.println("Salario devengado: ");
                    System.out.println(empleado.calcularSalarioDevengado());
                    
                    break;
                case 5:
                    System.out.println("/////// Mostrar el promedio de salarios /////// ");
                    System.out.println();
                    
                    System.out.println("Promedio= " + yoKonstruyo.calcularPromedioSalarios());
                    break;
                case 6:
                    System.out.println("/////// Mostrar el mayor salario /////// ");
                    System.out.println();
                    
                    empleado = yoKonstruyo.buscarEmpleadoMayorSalario();
                    System.out.println("El mayor salario es del empleado: ");
                    System.out.println(empleado.getNombreCompleto() + " con un salario de: ");
                    System.out.println(empleado.calcularSalarioDevengado());
                    System.out.println(empleado.getCedula());
                    System.out.println();
                    break;
                case 7:
                    System.out.println("/////// Modificar salarios y descuentos /////// ");
                    System.out.println();
                    
                    System.out.println("Digite la cedula del empleado");
                    String c = menu.teclado.nextLine();
                    c = menu.teclado.nextLine();
                    System.out.println("Digite el salario base inicial del empleado");
                    float salarioBase = menu.teclado.nextInt();
                    if(yoKonstruyo.buscarEmpleadoPorCedula(c)==null){
                        System.out.println("Empleado no encontrado");
                        break;
                    }
                    if(yoKonstruyo.buscarEmpleadoPorCedula(c).getRol().equals("Obrero")){
                        Obrero e = (Obrero)yoKonstruyo.buscarEmpleadoPorCedula(c);
                        System.out.println("Digite la retencion en la fuente inicial del obrero en porcentaje (debe ser un valor entre 0 y 100)");
                        float retencionFuente = menu.teclado.nextInt();
                        System.out.println("Digite el auxilio de transporte del obrero");
                        float auxilioTransporte = menu.teclado.nextInt();
                        
                        e.setAuxilioTransporte(auxilioTransporte);
                        e.setRetencionFuente(retencionFuente);
                        e.setSalarioBase(salarioBase);
                    }
                    
                    if(yoKonstruyo.buscarEmpleadoPorCedula(c).getRol().equals("Administrativo")){
                        Administrativo e = (Administrativo)yoKonstruyo.buscarEmpleadoPorCedula(c);
                        System.out.println("Digite el descuento por renta del administrativo en porcentaje (debe ser un valor entre 0 y 100)"); 
                        float descuentoPorRenta = menu.teclado.nextInt();
                        System.out.println("Digite el descuento para fiscales del administrativo");
                        float descuentoFiscales = menu.teclado.nextInt();
                        
                        e.setDescuentoFiscales(descuentoFiscales);
                        e.setDescuentoRenta(descuentoPorRenta);
                        e.setSalarioBase(salarioBase);
                    }
                    
                    break;
                case 8:
                    ejecucion = false;
                    break;
                default:
                    break;

            }
        }
    }
}
