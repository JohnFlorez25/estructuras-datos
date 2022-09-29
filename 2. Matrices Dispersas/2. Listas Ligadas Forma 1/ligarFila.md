# Método Ligar Fila

El método  inserta el Nodo recibido como parámetro en la lista de la fila correspondiente, **recordar que dentro de la fila debe estar ordenado por columna.**

1. Se ubica la fila a la que pertenece el Nodo que se recibe como parámetro.

2. Con el **nodo z** se recorre la fila para ubicar la posición donde debe ir el **Nodo q**  de manera que quede ordenado por la columna, **recordar que dentro de esta fila está ordenado por columna.**

3. Se verifica que ya no se encuentra un **nodo en la fila y columna** recibidas como parámetros, para luego insertar el Nodo.

## Implementación en Pseudocódigo

```
DispersaLista1::ligarFila( Nodo : q)     
    Nod:  p,z,an
    p= punta.obtenerLiga()
   mientras  p.obtenerFila() < q.obtenerFila() haga
        p = p.obtenerLiga()
   fin mientras
   z = p.obtenerLF()
   ant = p 
   mientras( z <> p  and  z.obtenerColumna()< q.obtenerColumna() haga
              ant = z
             z = z.obtnerLF();
   fin mientras
   ant.asignarLF(  q )
   q.asignarLF( z )   
fin método
```

## Implementación en Java
```java
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
```
