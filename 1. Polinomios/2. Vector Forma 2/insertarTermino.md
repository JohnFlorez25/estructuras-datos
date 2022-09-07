# Método Insertar Término

El método realiza las siguientes tareas:
 
Determina la ubicación del exponente a insertar.

Si ya existe en el polinomio un término con el mismo exponente a insertar.
- Si la  suma de los coeficientes de estos términos  es cero se elimina del polinomio.
- Si la  suma de los coeficientes de estos términos  es diferente de cero se actualiza en el  polinomio.

>NOTA: Si no existe en el polinomio un término con el mismo exponente a insertar. Se debe **aumentar el tamaño del vector en dos posiciones**, se mueven todos los datos dos posiciones  y finalmente se inserta el termino.

## Implementación en Pseudocódigo

```
método insertarTermino(Entero vec[], Entero coef, Entero exp)
  entero: i,j, suma
      i = 2
      
     mientras i < Vec[ 0 ]*2+1  and  Vec[  i ]> exp haga
             i = i + 2
     fin_mientras

      si  i < Vec[ 0 ]*2+1  and  Vec[ i ] =  exp entoces
               suma  = Vec[i+1]+ coe
               si suma <> 0 entonces
                     Vec[ i + 1] = suma
               si_no
                      para j = i + 2 hasta  Vec[ 0 ] * 2+1   , 1  haga
                            Vec[ j - 2] = Vec[ j ]
                       fin_para
                      Vec[ 0 ] = Vec[ 0 ] - 1
               fin_si

     si_no
           Imprima "El exponente no éxiste en el vector"
     fin
fin método
```

## Implementación en Java
```java
public static void insertarTermino(int vec[], int coef, int exp){
        int i, j, suma = 0;

        i = 1;
        while ((i < vec[0] * 2 + 1) && (vec[i] > exp)){
            i = i + 2;
        }
        if ((i < vec[0] * 2 + 1) && (vec[i] == exp)){
            suma = vec[i+1] + coef;
            if (suma != 0){
                vec[i+1] = suma;
            }else{
                for (j = i+2; j < vec[0] * 2 + 1 ; j++) {
                    vec[j-2] = vec[j];
                }
                vec[0] = vec[0] - 1;
            }
        }else {
            System.out.println("El exponente no éxiste en el vector");
        }
    }
```
