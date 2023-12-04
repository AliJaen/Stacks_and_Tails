/*
Estructuras y organización de datos.
Unidad 2. Práctica 2. Implementación de la clase BDAlumnos
Clase que crea una base de datos de Alumnos mediante una lista
conformada por Nodos
*********** Agrega los métodos para verificar si el primer
alumno de la lista es el mismo que el que ingresa el usuario*********
Elaborado por Alí Jaén Carmona
23 de octubre, 2020
*/

// importa clase para leer del teclado
import java.util.Scanner;

// define la clase Lisa simple que implementa la interfaz Lista
class ListaSimple implements Lista
{
    // declara atributos
    private Nodo p;

    // declara constructores
    public ListaSimple(Nodo n)
    {
        p=n;
    }

    public ListaSimple()
    {
        this(null); // inicia la lista vacía, p es null
    }

    // declara accesores
    public void setP(Nodo n)
    {
        p=n;
    }
    public Nodo getP()
    {
        return p;
    }

    // verifica si la lista está vacía o no
    public boolean esVacia()
    {
        return p==null;
        //	if (p==null)
        //		return true;
        //	else
        //		return false;
    }

    // Crea una lista simplemente ligada, agregando cada
    // nuevo nodo al inicio de la misma
    public void crea_Inicio()
    {
        // 1. crear(P). p es el atributo privado
        p = new Nodo();

        // 2. leer p.info: 1°Lee alumno, 2°Lo pone en p, 3°Agrega clave en p
        // 1°: leer información del alumno
        Scanner teclado = new Scanner(System.in);
        Alumno alu = new Alumno(); // crea un nuevo alumno
        System.out.print("\nIngresa número de control:");
        alu.setClave(teclado.nextLine());
        System.out.print("Ingresa nombre:");
        alu.setNombre(teclado.nextLine());
        System.out.print("Ingresa fecha nacimiento(dd/mm/aaaa):");
        alu.setFechaNac(teclado.nextLine());
        System.out.print("¿Tiene beca? (true/false):");
        alu.setTieneBeca(Boolean.parseBoolean(teclado.nextLine()));
        System.out.print("Ingresa calif1:");
        alu.setCalif1(Double.parseDouble(teclado.nextLine()));
        System.out.print("Ingresa calif2:");
        alu.setCalif2(Double.parseDouble(teclado.nextLine()));
        // 2°: poner alumno dentro del nodo p (p.info)
        p.setInfo(alu);
        // 3°Agrega clave en p
        p.setClave(alu.getClave());

        // 3. hacer p.liga=nill
        p.setLiga(null);

        // 4. escribir "Más nodos?: Si:1, No:0"
        System.out.print("\n¿Más nodos: Sí:1, No:0?:");

        // 5. leer res
        int res = Integer.parseInt(teclado.nextLine());

        // 6. Mientras (res=1) repetir
        while (res==1)
        {
            // crear q. q no es atributo, es local, hay que declararlo
            Nodo q = new Nodo();

            // leer q.info: 1°Lee alumno, 2°Lo pone en q
            alu = new Alumno(); // crea un nuevo alumno
            System.out.print("\nIngresa número de control:");
            alu.setClave(teclado.nextLine());
            System.out.print("Ingresa nombre:");
            alu.setNombre(teclado.nextLine());
            System.out.print("Ingresa fecha nacimiento(dd/mm/aaaa):");
            alu.setFechaNac(teclado.nextLine());
            System.out.print("¿Tiene beca? (true/false):");
            alu.setTieneBeca(Boolean.parseBoolean(teclado.nextLine()));
            System.out.print("Ingresa calif1:");
            alu.setCalif1(Double.parseDouble(teclado.nextLine()));
            System.out.print("Ingresa calif2:");
            alu.setCalif2(Double.parseDouble(teclado.nextLine()));
            // 2°: poner alumno dentro del nodo q (q.info)
            q.setInfo(alu);
            q.setClave(alu.getClave());

            // hacer q.liga=p y p=q
            q.setLiga(p);
            p=q;

            // escribir "Más nodos?: Si:1, No:0"
            System.out.print("\n¿Más nodos: Sí:1, No:0?:");
            // leer res
            res = Integer.parseInt(teclado.nextLine());
        } // fin mientras
    } // fin crea_inicio

    public void crea_Final()
    {

    }

    // recorre la lista cuyo primer elemento está apuntado por p
    // (p es atributo de la clase)
    public void recorre_Iterativo()
    {
        // 1. q=p
        Nodo q = p;
        // 2. Mientras q<>nill repetir
        while (q!=null)
        {
            // escribir q.info   (q.info es Object y se convierte a Alumno)
            Alumno alu = (Alumno)q.getInfo();
            System.out.println("\nAlumno:");
            System.out.println("\tNúmero de control:"+alu.getClave());
            System.out.println("\tNombre:"+alu.getNombre());
            System.out.println("\tFecha nacimiento:"+alu.getFechaNac());
            System.out.println("\t¿Tiene beca?:"+alu.getTieneBeca());
            System.out.println("\tCalif1:"+alu.getCalif1());
            System.out.println("\tCalif2:"+alu.getCalif2()+"\n");
            // hacer q=q.liga apunta al siguiente nodo
            q = q.getLiga();
        }
    }

    public void inserta_Inicio(Object dato)
    {
        // crear q. q no es atributo, es local, hay que declararlo
        Nodo q = new Nodo();
        Alumno alu = (Alumno)dato;
        q.setInfo(alu);
        q.setClave(alu.getClave());

        // hacer q.liga=p y p=q
        q.setLiga(p);
        p=q;

    }

    public void inserta_Final(Object dato)
    {

    }

    // elimina el primer elemento de la lista ligada.
    // p (atributo) apunta al primer elemento de la lista
    // regresa el elemento elmininado
    public Object elimina_Inicio()
    {
        // 1. hacer q=p
        Nodo q = p;
        // 2. hacer p=q.liga
        p = q.getLiga();
        // 3. quitar q.
        // en algunos lenguajes de programación se libera memoria: dispose(q)
        // regresa el objeto info (alumno en nuestra aplicación)
        // en Java la memoria la libera el recolector de basura
        return q.getInfo();
    }

    public Object elimina_Ultimo()
    {
        return null; // esto hay que revisarlo
    }

    // busca en la lista el alumno con número
    // de control x
    // para comparar si 2 cadenas son iguales
    // cad1 == cad2     == es para tipos simples
    // cad1.equals(cad2)
    // x.equals(q.getClave())
    // q.getClave().equals(x)
    public void busqueda_desordenada(String x)
    {
        // paso 2 del algoritmo de Cairó y Guardati
        // Q.clave!=x
        // paso 4 del algoritmo de Cairó y Guardati
        // sino
        //    escribir la información del alumno encontrado (q.info)

    }

    // COMPARA CLAVE INTERNA DEL OBJETO ALUMNO
    public boolean verificaPrimero(String clave){
        Nodo q = p; // Usa un nodo Auxiliar para proteger los datos del nodo original
        String compara = q.getClave(); // Extrae la clave del NODO para comparala con el argumento ingresado

        return clave.equals(compara); // Retorna TRUE si es igual
    }

    // COMPARA CLAVE (NÚMERO DE CONTRÓL) DEL ALUMNO
    public boolean verificaPrimeroNUMCONTROL(String clave){
        Nodo q = p; // Usa un nodo Auxiliar para proteger los datos del nodo original
        Alumno alumno = (Alumno)q.getInfo(); // Extrae la información del ALUMNO para comparala con el argumento ingresado

        String compara = alumno.getClave(); // Ectrae el número de control del alumno

        return clave.equals(compara); // Retorna TRUE si es igual
    }

    public int verificaaNOBecadod(){
        Nodo q = p;
        Alumno alumno;
        int contador = 0;
        while (q!=null)
        {
            // escribir q.info   (q.info es Object y se convierte a Alumno)
            Alumno alu = (Alumno)q.getInfo();

            if (!alu.getTieneBeca())
                contador = contador+1;

            q = q.getLiga();
        }

        return contador;
    }
}