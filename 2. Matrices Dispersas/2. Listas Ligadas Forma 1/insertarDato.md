# Método Insertar Dato

El método inserta el dato creando un nuevo Nodo y enviando este nodo creado como parámetro a asignar y/o actualizar sus ligas de Fila y de Columna.

## Implementación en Pseudocódigo

```
DispersaLista1::insertarDato(Entero: fila, columna, dato)
    Nodo q;
    q = nuevo Nodo(fila, columna, dato);
    ligarFila(q);
    ligarColumna(q);
fin_método
```

## Implementación en Java
```java
public void insertarDato(int fila, int columna, int dato) {
    Nodo q;
    q = new Nodo(fila, columna, dato);
    ligarFila(q);
    ligarColumna(q);
}
```
