# Método Comparar Polinomios Representados de diferentes formas

Antes de comenzar, nótese que "a" es un polinomio representado en la forma 1 y "b" es un polinomio representado en la forma 2.
El método compara cada coeficiente de "b" con los coeficientes de "a" aprovechandose de la siguiente fórmula:

- pos = a[0] + 1 - exp

Y al "b" contener el exponente en su estructura, podemos obtenerlo fácilmente y aplicar la formula de posición para "a".

## Implementación en Pseudocódigo

```
Método sonIguales(Entero a[], Entero b[]) 
    Entero pos, exp
    booleano iguales = Verdadero
    Para(Entero i = 2; i < b[0] * 2 + 1; i += 2)
        // Se recorre los coeficientes de b (forma 2) y se compara con los coeficientes de a (forma 1) usando
        // la formula de posición (a[0] + 1 - exp) y usando el exponente que nos provee b (b[i - 1]).
        exp = b[i - 1]
        pos = a[0] + 1 - exp
        Si (b[i] != a[pos])
            iguales = Falso
        FinSi
    FinPara
    Si (iguales == Verdadero)
        Imprimir "Son iguales."
    SiNo
        Imprimir "Son diferentes."
    FinSi
FinMétodo
```

## Implementación en Java

```java
private static void sonIguales(int[] a, int[] b) {
    boolean iguales = true;
    for(int i = 2; i < b[0] * 2 + 1; i += 2) {
        /* Se recorre los coeficientes de b (forma 2) y se compara con los coeficientes de a (forma 1) usando
        la formula de posición (a[0] + 1 - exp) y usando el exponente que nos provee b (b[i - 1]). */
        if (b[i] != a[a[0] + 1 - (b[i - 1])]) {
            iguales = false;
        }
    }
    if (iguales) {
        System.out.println("Son iguales.");
    } else {
        System.out.println("Son diferentes.");
    }
}
```