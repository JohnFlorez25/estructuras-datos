public class Nodo {

    private int fila;
    private int columna;
    private int dato;
    private Nodo L;
    private Nodo LF;
    private Nodo LC;

    public Nodo( int fila, int columna, int dato){
        this.fila = fila;
        this.columna = columna;
        this.dato = dato;
        LF = null;
        LC = null;
        L = null;
    }

    public int obtenerFila()
    {
        return fila;
    }
    public int obtenerColumna()
    {
        return columna;
    }
    //***********************************************
    // METODO QUE ASIGNA EL DATO DEL NODO          *
    //***********************************************
    public void asignarDato(int d)
    {
        dato=d;
    }
    //***********************************************
    // METODO QUE REGRESA EL DATO DEL NODO          *
    //***********************************************
    public int obtenerDato()
    {
        return dato;
    }
    //***********************************************
    // METODO QUE REGRESA LA LIGA FILA DEL NODO     *
    //***********************************************
    public Nodo obtenerLF()
    {
        return LF;
    }
    //************************************************
    // METODO QUE ASIGNA UN NUEVO VALOR A  LIGA FILA *
    //************************************************
    public void  asignarLF(Nodo x)
    {
        LF=x;
    }
    //***********************************************
    // METODO QUE REGRESA LA LIGA COLUMNA DEL NODO     *
    //************************************************
    public Nodo obtenerLC()
    {
        return LC;
    }
    //************************************************
    // METODO QUE ASIGNA UN NUEVO VALOR A  LIGA COLUMNA *
    //************************************************
    public void  asignarLC(Nodo x)
    {
        LC=x;
    }
    //***********************************************
    // METODO QUE REGRESA LA LIGA DATO DEL NODO     *
    //************************************************
    public Nodo obtenerLiga()
    {
        return L;
    }
    //************************************************
    // METODO QUE ASIGNA UN NUEVO VALOR A  LIGAA DATO*
    //************************************************
    public void  asignarLiga(Nodo x)
    {
        L=x;
    }
}
