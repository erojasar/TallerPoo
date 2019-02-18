/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerenclasepoo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emlad
 */
public class TallerEnClasePoo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Universidad universidad = new Universidad();
        File archivo = new File("archivo.txt");
        if(!archivo.exists()){
            try {
                archivo.createNewFile();
                ObjectOutputStream objecto = new ObjectOutputStream(new FileOutputStream(archivo));
                objecto.writeObject(universidad);
                objecto.close();
            } catch (IOException ex) {
                Logger.getLogger(TallerEnClasePoo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try { 
                ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo));
                universidad = (Universidad)entrada.readObject();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TallerEnClasePoo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(TallerEnClasePoo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Bienvenido Universidad");
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("Elige la operacion a realizar:");
            System.out.println("1.Agregar Sede \n2.Eliminar Sede \n3.Modificar Sede \n4.Informacion de sede \n5.Informacion universidad  \n6.salir");
            opcion = scanner.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Que tipo de sede es:\n1.Sede Profesional\n2.Sede Tecnologica\n3.Sede de Educacion Continuada");
                    int tipo = scanner.nextInt();
                    System.out.println("Digite el nombre de la sede:");
                    String nombre = scanner.next();
                    System.out.println("Ingrese la direccion de la sede:");
                    String direccion = scanner.next();
                    System.out.println("Ingrese el numero telefonico:");
                    int telefono = scanner.nextInt();
                    System.out.println("Digite el valor del Area Construida:");
                    double areaConstruida = scanner.nextDouble();
                    switch(tipo){
                        case 1:
                            System.out.println("Agregue un programa a la sede");
                            System.out.println("Cual es el nombre del programa:");
                            String nombrePrograma = scanner.next();
                            System.out.println("Describa el programa:");
                            String descripcion = scanner.next();
                            System.out.println("Que tipo de programa es:\n1.Profesional \n2.Tecnologico \n3.Educacion continuada");
                            int tipoPrograma = scanner.nextInt();
                            System.out.println("El programa es de Alta Calidad: \n 0.no \n 1.si");
                            int altaCalidad = scanner.nextInt();
                            if(tipoPrograma == 1){
                                universidad.nuevaSedeP(altaCalidad, nombre, direccion, telefono, areaConstruida, nombrePrograma, descripcion, "Profesional");
                            } 
                            if(tipoPrograma == 2){
                                universidad.nuevaSedeP(altaCalidad, nombre, direccion, telefono, areaConstruida, nombrePrograma, descripcion, "Tecnologico");
                            }
                            if(tipoPrograma == 3){
                                universidad.nuevaSedeP(altaCalidad, nombre, direccion, telefono, areaConstruida, nombrePrograma, descripcion, "Educacion continuada");
                            }
                            break;
                        case 2:
                            System.out.println("Ingrese el numero de estudiantes:");
                            int numeroEstudiantes = scanner.nextInt();
                            System.out.println("Agregue un programa a la sede");
                            System.out.println("Cual es el nombre del programa:");
                            String nombrePrograma1 = scanner.next();
                            System.out.println("Describa el programa:");
                            String descripcion1 = scanner.next();
                            universidad.nuevaSedeT(numeroEstudiantes, nombre, direccion, telefono, areaConstruida, nombrePrograma1, descripcion1, "Tecnologico");
                            break;
                        case 3:
                            System.out.println("Agregue un programa a la sede");
                            System.out.println("Cual es el nombre del programa:");
                            String nombrePrograma2 = scanner.next();
                            System.out.println("Describa el programa:");
                            String descripcion2 = scanner.next();
                            universidad.nuevaSedeEC(nombrePrograma2, nombre, direccion, telefono, areaConstruida, nombrePrograma2, descripcion2, "Educacion continuada");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la sede a borrar: ");
                    String nombreSede = scanner.next();
                    universidad.eliminarSede(nombreSede);
                    break;
                case 3:
                    int opcion2;
                    do{ 
                    System.out.println("Ingresa el nombre de la sede a administrar: ");
                    String nombreSedeAdm = scanner.next();
                    Sede sedeAdm = universidad.buscarSede(nombreSedeAdm);
                    System.out.println("Aqui esta el nuevo menu para administrar una sede: \n1. Cambiar el nombre de la sede\n2. Cambiar la direccion de la sede\n3. Cambiar numero de telefono"
                            + "             \n4. Cambiar area construida\n5. Administrar programas");
                    opcion2 = scanner.nextInt();
                    switch(opcion2){
                        case 1:
                            System.out.println("Ingrese el nuevo nombre de la sede: ");
                            String nuevoNombre = scanner.next();
                            universidad.buscarSede(sedeAdm.getNombre()).setNombre(nuevoNombre);
                            break;
                        case 2:
                            System.out.println("Ingrese la nueva direccion de la sede: ");
                            String nuevaDir = scanner.next();
                            universidad.buscarSede(sedeAdm.getNombre()).setDireccion(nuevaDir);
                            break;
                        case 3:
                            System.out.println("Ingrese el nuevo telefono de la sede: ");
                            int nuevoTel = scanner.nextInt();
                            universidad.buscarSede(sedeAdm.getNombre()).setTelefono(nuevoTel);
                            break;
                        case 4:
                            System.out.println("Ingrese la nueva area construida de la sede: ");
                            double nueAreaCons = scanner.nextDouble();
                            universidad.buscarSede(sedeAdm.getNombre()).setAreaConstruida(nueAreaCons);
                            break;
                        case 5: 
                            int opcion3;
                            do{
                            System.out.println("Desde aqui puedes administrar los programas de la sede: \n1. Crear programa\n2. Borrar programa\n3. Cambiar nombre al programa\n4. Cambiar descripcion al programa");
                            opcion3 = scanner.nextInt();
                            switch(opcion3){
                                case 1:
                                    System.out.println("Ingrese el nombre del programa: ");
                                    String nomPrograma = scanner.next();
                                    System.out.println("Ingrese la descripcion del programa: ");
                                    String descripPrograma = scanner.next();
                                    System.out.println("Ingrese el tipo del programa: ");
                                    String tipoPrograma = scanner.next();
                                    universidad.buscarSede(sedeAdm.getNombre()).agregarPrograma(tipoPrograma, nomPrograma, descripPrograma);
                                    break;
                                case 2:
                                    System.out.println("Ingrese el nombre del programa a eliminar: ");
                                    String nomProgramaBorrar = scanner.next();
                                    universidad.buscarSede(sedeAdm.getNombre()).eliminarPrograma(nomProgramaBorrar);
                                    break;
                                case 3:
                                    System.out.println("Ingrese el nombre del programa que va a cambiar: ");
                                    String nomPrograCam = scanner.next();
                                    System.out.println("Ingrese el nuevo nombre: ");
                                    String nuevoNombrePrograma = scanner.next();
                                    universidad.buscarSede(sedeAdm.getNombre()).getPrograma(nomPrograCam).setNombrePrograma(nuevoNombrePrograma);
                                    break;
                                case 4:
                                    System.out.println("Ingrese el nombre del programa que va a cambiar: ");
                                    String nomPrograCam1 = scanner.next();
                                    System.out.println("Ingrese la nueva descripcion: ");
                                    String nuevaDescPrograma = scanner.next();
                                    universidad.buscarSede(sedeAdm.getNombre()).getPrograma(nomPrograCam1).setDescripcion(nuevaDescPrograma);
                                    break;                  
                            }    
                            break;                        
                            }while(opcion3>0 && opcion3<5);
                        }
                    }while(opcion2>0 && opcion2<6); 
                    break;
                case 4:   
                    System.out.println("Ingrese el nombre de la sede de la cual quiere obtener la informacion: ");
                    String sedeInformacion = scanner.next();
                    ArrayList informacion = universidad.buscarSede(sedeInformacion).darInformacion();
                    for(int i=0;i<informacion.size();i++){
                        System.out.println(informacion.get(i));
                    }
                    break;
                case 5:
                    for(int i=0;i<universidad.getSedes().size();i++){
                        ArrayList informacion2 = universidad.getSedes().get(i).darInformacion();
                        for(int j=0;j<informacion2.size();j++){
                            System.out.println(informacion2.get(j));
                        }      
                    }
                    break;
            }
        }while(opcion>0 && opcion<6);
    }
    
}
