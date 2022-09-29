# Método Ligar Columna
El método  inserta el Nodo recibido como parámetro en la lista de la columna correspondiente, **recordar que dentro de la columna debe estar ordenado por fila.** 

1. Se ubica la columna a la que pertenece el Nodo que se recibe como parámetro.

2. Con el **nodo z** se recorre la columna para ubicar la posición donde debe ir el **Nodo q**  de manera que quede ordenado por la fila, **recordar que dentro de esta columna está ordenado por fila.**

3. Se verifica que ya no se encuentra un **nodo en la fila y columna** recibidas como parámetros, para luego insertar el Nodo.

## Implementación en Pseudocódigo

```
DispersaLista1::ligarColumna( Nodo : q)     
   Nod:  p,z,ant
   p= punta.obtenerLiga()
   mientras  p.obtenerColumna() < q.obtenerColumna() haga
          p = p.obtenerLiga()
   fin mientras
   z = p.obtenerLC()
   ant = p
   mientras( z <> p  and  z.obtenerFila()< q.obtenerFila() haga
             ant = z
             z = z.obtnerLC()
   fin mientras     
   ant.asignarLC(  q )
   q.asignarLC( z )     
fin método
```

## Implementación en Java
```java
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
```
