/*
Estructuras y organización de datos.
Unidad 2. Examen Unidad 2. Implementación de la clase BDAlumnos
Clase que registra y almacena datos de objetos tipo Alumno
Permite crear nuevos registros, almacenarlos, eliminarlos,
buscarlos y mostrarlos
(Interfaz de usuario para la clase ListaSimple)
*********** Agrega los métodos para verificar si el primer
alumno de la lista es el mismo que el que ingresa el usuario*********
Elaborado por Alí Jaén Carmona
23 de octubre, 2020
*/


// importa clase para leer del teclado
import java.util.Scanner;

// declara la clase BDAlumnos
class BDAlumnos
{

    // declara método principal
    public static void main(String[]args)
    {
        // declara e inatancia objetos, declara e inicia variables
        Scanner s = new Scanner(System.in);
        ListaSimple milista = new ListaSimple();
        Alumno alu = null;
        String cad = "";
        int opc=0;

        // Crea lista, insertando al inicio o al final
        System.out.print("\nBD de Alumnos\nCrear lista, decide (inicio=0, final:1):");
        opc = Integer.parseInt(s.nextLine());
        switch(opc)
        {
            case 0:milista.crea_Inicio();
                break;
            case 1:milista.crea_Final();
                break;
        }

        do
        {
            // Opera la BD con menú de opciones
            System.out.print("\nMenú\n");
            System.out.println("1. Recorre alumnos (listado)");
            System.out.println("2. Inserta alumno al inicio de la lista (altas)");
            System.out.println("3. Inserta alumno al final de la lista");
            System.out.println("4. Elimina alumno del inicio de la lista (bajas)");
            System.out.println("5. Elimina último alumno de la lista");
            System.out.println("6. Busca un alumno (constulas)");
            System.out.println("7. Compara si el alumno es el primero de la lista *** COMPARA CLAVE INTERNA DEL OBJETO ALUMNO");
            System.out.println("8. Compara si el alumno es el primero de la lista *** COMPARA CLAVE (NÚMERO DE CONTRÓL) DEL ALUMNO");
            System.out.println("9. Muestra cantidad de alumnos NO becados");
            System.out.println("0. Salir");
            System.out.print("\t:Elige:");
            opc = Integer.parseInt(s.nextLine());
            switch(opc)
            {
                case 1:	if (milista.esVacia())
                    System.out.println("\t No hay alumnos");
                else
                    milista.recorre_Iterativo();
                    break;
                case 2:	// inserta nuevo alumno al inicio de la lista
                    // crea nuevo alumno
                    alu = new Alumno();
                    System.out.print("\nIngresa número de control:");
                    alu.setClave(s.nextLine());
                    System.out.print("Ingresa nombre:");
                    alu.setNombre(s.nextLine());
                    System.out.print("Ingresa fecha nacimiento(dd/mm/aaaa):");
                    alu.setFechaNac(s.nextLine());
                    System.out.print("¿Tiene beca? (true/false):");
                    alu.setTieneBeca(Boolean.parseBoolean(s.nextLine()));
                    System.out.print("Ingresa calif1:");
                    alu.setCalif1(Double.parseDouble(s.nextLine()));
                    System.out.print("Ingresa calif2:");
                    alu.setCalif2(Double.parseDouble(s.nextLine()));
                    // inserta nuevo alumno al inicio de la lista
                    milista.inserta_Inicio(alu);
                    break;
                case 3: // inserta nuevo alumno al final de la lista
                    break;
                case 4: // elimina alumno del inicio de la lista
                    if (milista.esVacia())
                        System.out.println("\tLista sin alumnos");
                    else
                    {
                        // elimina_Inicio regresa Object
                        // Object se debe convertir (casting) a Alumno
                        alu=(Alumno)milista.elimina_Inicio();
                        // muestra alumno eliminado
                        System.out.println("\nAlumno eliminado:");
                        System.out.println("\tNúmero de control:"+alu.getClave());
                        System.out.println("\tNombre:"+alu.getNombre());
                        System.out.println("\tFecha nacimiento:"+alu.getFechaNac());
                        System.out.println("\t¿Tiene beca?:"+alu.getTieneBeca());
                        System.out.println("\tCalif1:"+alu.getCalif1());
                        System.out.println("\tCalif2:"+alu.getCalif2());
                    }
                    break;
                case 5:
                    break;
                case 6: //
                    // leer de teclado el nc, el número de control del alumno a buscar
                    // boolean b=milista.busqueda_desordenada(nc)
                    // if(b) print("alumno encontrado")
                case 7:
                    System.out.println("COMPARA CLAVE INTERNA DEL OBJETO ALUMNO");
                    System.out.println("Ingresa la clave del alumno que deseas rectificar");
                    cad = s.nextLine(); // Variable que se emplea en el método de la lista

                    if (milista.verificaPrimero(cad)) // Si el método retorna TRUE
                        System.out.println("El alumno " + cad + " es el primero de la lista");
                    else
                        System.out.println("El alumno " + cad + " NO es el primero de la lista");
                    break;
                case 8:
                    System.out.println("COMPARA CLAVE (NÚMERO DE CONTRÓL) DEL ALUMNO");
                    System.out.println("Ingresa la clave del alumno que deseas rectificar");
                    cad = s.nextLine(); // Variable que se emplea en el método de la lista

                    if (milista.verificaPrimeroNUMCONTROL(cad)) // Si el método retorna TRUE
                        System.out.println("El alumno " + cad + " es el primero de la lista");
                    else
                        System.out.println("El alumno " + cad + " NO es el primero de la lista");
                    break;
                case 9:
                    System.out.println("Número de alumnos NO becados: " + milista.verificaaNOBecadod());
                    break;
            }
        }while(opc!=0);
    }
}