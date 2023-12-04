/* declara un nodo que será parte de
   una lista ligada simple o circular */

class Nodo
{
    // declara atributos
    private String clave;
    private Object info;
    private Nodo liga;

    // declara constructores
    public Nodo(String c, Object i, Nodo l)
    {
        clave=c;
        info=i;
        liga=l;
    }

    public Nodo()
    {
        this("",null,null);
    }

    // declara accesores
    public void setClave(String c){clave=c;}
    public void setInfo(Object o){info=o;}
    public void setLiga(Nodo l){liga=l;}
    public String getClave(){return clave;}
    public Object getInfo(){return info;}
    public Nodo getLiga(){return liga;}
}