/* Define el comportamiento de cualquier tipo de lista
   mediante una interfaz
*/

interface Lista
{
    public boolean esVacia();
    public void crea_Inicio();
    public void crea_Final();
    public void recorre_Iterativo();
    public void inserta_Inicio(Object dato);
    public void inserta_Final(Object dato);
    public Object elimina_Inicio();
    public Object elimina_Ultimo();
    public void busqueda_desordenada(String x);
}