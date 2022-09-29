# Método Construir Cabezas

El método crea los nodos registro cabeza de cada fila y columna, utilizando una lista simplemente ligada circular.


```
DispersasLista1::construirCabezas(entero: n, m) {
    punta = nuevo Nodo(n, m, 0);
    Nodo ant = punta;
    Entero mayor = mayor(n, m);

    Para (Entero i = 0; i < mayor; i++) entonces
        q = new Nodo(i, i, 0);
        q.asignarLF(q);
        q.asignarLC(q);
        ant.asignarLiga(q);
        ant = q;
    fin_para
    ant.asignarLiga(punta);
fin_método
```

## Implementación en Java
```java
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
```
