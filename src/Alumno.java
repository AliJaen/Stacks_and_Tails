/* Define la clase alumno */

class Alumno{

    // declara atributos
    private String clave;
    private String nombre;
    private String fechaNac;
    private boolean tieneBeca;
    private double calif1;
    private double calif2;

    // declara constructores
    public Alumno(String c, String n, String f, boolean t, double c1, double c2)
    {
        clave=c;
        nombre=n;
        fechaNac=f;
        tieneBeca=t;
        calif1=c1;
        calif2=c2;
    }

    public Alumno()
    {
        this("","","",false,0,0);
    }

    // declara accesores
    public void setClave (String c){clave=c;}
    public void setNombre(String n){nombre=n;}
    public void setFechaNac (String f) {fechaNac=f;}
    public void setTieneBeca(boolean t){tieneBeca=t;}
    public void setCalif1(double c){calif1=c;}
    public void setCalif2(double c){calif2=c;}
    public String getClave() {return clave;}
    public String getNombre(){return nombre;}
    public String getFechaNac(){return fechaNac;}
    public boolean getTieneBeca(){return tieneBeca;}
    public double getCalif1(){return calif1;}
    public double getCalif2(){return calif2;}
}