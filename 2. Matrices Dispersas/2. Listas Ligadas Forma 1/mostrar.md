# Método Mostrar

El método realiza las siguientes tareas:
 
- Ubicar al **Nodo p** en el primer nodo registro cabeza de la fila 0 y columna 0.
- Ubicar al **Nodo q** en el nodo con la liga de la fila.
- Recorrer hasta que el **Nodo p** sea diferente del **Nodo punta**
- Mostrar los datos que están en la fila hasta que el **Nodo q** sea diferente al **Nodo p** 

>NOTA: Para recorrer por columna solo se debe cambiar por **obtenerLC()**

## Implementación en Pseudocódigo

```
DispersaLista1::ligarColumna mostrar() {
    Nodo p = punta.obtenerLiga();
    Nodo q = null;
    mientras (p != punta) haga {
        q = p.obtenerLF();
        mientras (q != p) haga
            Imprimir(q.obtenerFila() , q.obtenerColumna() , q.obtenerDato());
            q = q.obtenerLF();
        fin_mientras
        p = p.obtenerLiga();
    fin_mientras
fin método
```

## Implementación en Java
```java
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
```
