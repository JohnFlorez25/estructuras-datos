public class DispersasF1 {

    //**************************************************
    // ATRIBUTO QUE GUARDA LA REFERENCIA AL PRIMER NODO
    //**************************************************
    private Nodo punta;
    Nodo q;

    public DispersasF1(int n, int m) {
        construirCabezas(n, m);
    }

    public void construirCabezas(int n, int m) {

        punta = new Nodo(n, m, 0);
        Nodo ant = punta;
        int mayor = Math.max(n, m);

        for (int i = 0; i < mayor; i++) {
            q = new Nodo(i, i, 0);
            q.asignarLF(q);
            q.asignarLC(q);
            ant.asignarLiga(q);
            ant = q;
        }
        ant.asignarLiga(punta);
    }

    public void ligarFila(Nodo q) {
        Nodo p, z, ant;
        p = punta.obtenerLiga();
        while (p.obtenerFila() < q.obtenerFila()) {
            p = p.obtenerLiga();
        }
        z = p.obtenerLF();
        ant = p;
        while (z != p && z.obtenerColumna() < q.obtenerColumna()) {
            ant = z;
            z = z.obtenerLF();
        }
        ant.asignarLF(q);
        q.asignarLF(z);
    }

    public void ligarColumna(Nodo q) {
        Nodo p, z, ant;
        p = punta.obtenerLiga();
        while (p.obtenerColumna() < q.obtenerColumna()) {
            p = p.obtenerLiga();
        }
        z = p.obtenerLC();
        ant = p;
        while (z != p && z.obtenerFila() < q.obtenerFila()) {
            ant = z;
            z = z.obtenerLC();
        }
        ant.asignarLC(q);
        q.asignarLC(z);
    }

    public void insertarDato(int fila, int columna, int dato) {
        Nodo q;
        q = new Nodo(fila, columna, dato);
        ligarFila(q);
        ligarColumna(q);
    }

    public void mostrar() {
        Nodo p = punta.obtenerLiga();
        Nodo q = null;
        while (p != punta) {
            q = p.obtenerLF();
            while (q != p) {
                System.out.println("Fila: " + q.obtenerFila() + "\t" + "Columna: " + q.obtenerColumna() + "\t"
                        + "Dato: " + q.obtenerDato());
                q = q.obtenerLF();
            }
            p = p.obtenerLiga();
        }
    }
}
