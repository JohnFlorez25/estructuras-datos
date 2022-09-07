# Método Mostrar

El método recorre los elementos que hay en el vector desde la primera posición más uno, de esta manera úbica el exponente del termino, y en la posición siguiente úbica el coeficiente del termino.

> NOTA: Los incrementos del recorrido serían de a 2.

## Implementación en Pseudocódigo
```
método mostrar( Entero vec[] )
  Entero k 
  Para( k=1; k < vec[0] * 2 + 1 ); k=k+2) 
    Si(vec[k+1]>0)
            polinomio = polinomio + " + " + vec[k+1] + "X^" + vec[k]
        si_no
            polinomio = polinomio + " - " + ( vec[k+1] * (-1) ) + "X^" + vec[k]
    Fin_si
  Fin_para
  imprima(polinomio)
Fin_método
```
## Implementación en Java

```java
public void mostrar(int vec[]){
        String polinomio = "";
        for (int i = 1; i < vec[0] * 2 + 1; i+=2) {
            if(vec[i+1]>0){
                polinomio = polinomio + " + "+ vec[i+1] + "X^" + vec[i] ;
            }else{
                polinomio = polinomio + " - " + (vec[i+1]*(-1)) + "X^" + vec[i];
            }
        }
        System.out.println(polinomio);
    }
```