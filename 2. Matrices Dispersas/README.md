# Matrices Dispersas

Una **Matriz** es un objeto matemático que sirve para representar sistemas de ecuaciones lineales.

Una **Matriz dispersa** es una **matriz de gran tamaño** en la que la mayor parte de sus elementos **tienen valor cero**, de tal forma que los diferentes de cero se encuentran **muy dispersos** y sin relación entre sí, se puede presentar dos tipos de matrices dispersas:

- **Matriz dispersa estructurada**: cuando los elementos diferentes de cero siguen un patrón de agrupamiento, generalmente en diagonales.

- **Matriz dispersa no estructurada**: cuando los elementos diferentes de cero se distribuyen de forma irregular.

## Desventajas de las Matrices Dispersas

-   Desperdicio de memoria.
-	Mayor consumo de tiempo de ejecución. 
-	Podría dificultar las operaciones.

En aras de preservar los principios de economía: mínimo consumo de memoria y uso de procesador, tiempo de acceso y localización de los datos. Se proponen otras formas alternas de almacenamiento de matrices dispersas.

### Representación de Matrices Dispersas

1. [Listas de Tripletas](https://github.com/JohnFlorez25/estructuras-datos/tree/main/2.%20Matrices%20Dispersas/1.%20Lista%20de%20Tripletas)
2. [Listas Ligadas Forma 1]()
3. [Listas Ligadas Forma 2]()

# Tipos de Matrices Dispersas (Sparse Matrices) en Python

## Introducción

Una **matriz dispersa** es una matriz mayoritariamente compuesta por ceros. Estas matrices son comunes en problemas de ingeniería informática, como procesamiento de gráficos, machine learning, y análisis de redes. Almacenar y operar matrices dispersas utilizando estructuras de datos densas (matrices completas) puede ser ineficiente en términos de espacio y tiempo. Las librerías como `scipy` en Python proporcionan estructuras optimizadas para trabajar con matrices dispersas.

Este documento describe los tipos más comunes de matrices dispersas, cómo implementarlas con `scipy`, sus ventajas y desventajas, y la complejidad algorítmica de las operaciones clave.

## Librería `scipy.sparse`

La librería `scipy.sparse` en Python proporciona diferentes tipos de matrices dispersas que optimizan el almacenamiento y las operaciones con matrices de este tipo.

### Tipos de Matrices Dispersas

1. ### Matriz Dispersa en Formato COOrdinate (COO)
   - **Descripción**: Utiliza tres arreglos: uno para las coordenadas de fila, uno para las coordenadas de columna, y otro para los valores no nulos. Es ideal para construir matrices dispersas de forma incremental.
   - **Complejidad Algorítmica**:
     - **Acceso**: O(n) (búsqueda de coordenadas específicas).
     - **Inserción**: O(1) (en caso de expansión, O(n)).
   - **Ejemplo en Python**:
     ```python
     import numpy as np
     from scipy.sparse import coo_matrix

     row = np.array([0, 1, 2])
     col = np.array([1, 2, 0])
     data = np.array([4, 5, 6])
     coo = coo_matrix((data, (row, col)), shape=(3, 3))
     print(coo.toarray())
     ```
   - **Uso**: Ideal cuando necesitas construir una matriz dispersa paso a paso.

2. ### Matriz Comprimida por Filas (CSR - Compressed Sparse Row)
   - **Descripción**: Almacena los valores no nulos y sus índices de columna en dos arreglos, junto con un tercer arreglo que indica los límites de cada fila. Es eficiente para realizar operaciones por filas, como multiplicación de matrices.
   - **Complejidad Algorítmica**:
     - **Acceso**: O(1) por fila.
     - **Inserción**: O(n) (necesita reordenar los elementos).
     - **Multiplicación Matricial**: O(n).
   - **Ejemplo en Python**:
     ```python
     from scipy.sparse import csr_matrix

     data = np.array([1, 2, 3, 4])
     indices = np.array([0, 2, 2, 0])
     indptr = np.array([0, 2, 3, 4])
     csr = csr_matrix((data, indices, indptr), shape=(3, 3))
     print(csr.toarray())
     ```
   - **Uso**: Ideal para operaciones rápidas de acceso a filas y multiplicación de matrices.

3. ### Matriz Comprimida por Columnas (CSC - Compressed Sparse Column)
   - **Descripción**: Similar a CSR, pero con las operaciones optimizadas para el acceso por columnas en lugar de filas.
   - **Complejidad Algorítmica**:
     - **Acceso**: O(1) por columna.
     - **Inserción**: O(n).
     - **Multiplicación Matricial**: O(n).
   - **Ejemplo en Python**:
     ```python
     from scipy.sparse import csc_matrix

     data = np.array([5, 8, 3])
     indices = np.array([0, 2, 2])
     indptr = np.array([0, 1, 2, 3])
     csc = csc_matrix((data, indices, indptr), shape=(3, 3))
     print(csc.toarray())
     ```
   - **Uso**: Útil para operaciones por columnas o cuando se necesita acceder a las columnas rápidamente.

4. ### Matriz Dispersa Diagonal (DIA)
   - **Descripción**: Almacena las diagonales de la matriz, lo que la hace muy eficiente para matrices que tienen la mayoría de sus valores no nulos en o cerca de la diagonal principal.
   - **Complejidad Algorítmica**:
     - **Acceso**: O(1) para valores diagonales.
     - **Inserción**: O(n).
   - **Ejemplo en Python**:
     ```python
     from scipy.sparse import dia_matrix

     data = np.array([[1, 2, 3], [4, 5, 6]])
     offsets = np.array([0, 1])
     dia = dia_matrix((data, offsets), shape=(3, 3))
     print(dia.toarray())
     ```
   - **Uso**: Ideal para matrices donde los elementos no nulos están cercanos a las diagonales.

5. ### Matriz Dispersa en Formato LIL (List of Lists)
   - **Descripción**: Representa la matriz como una lista de listas, donde cada lista contiene los índices y valores no nulos de cada fila. Este formato es eficiente para la construcción incremental de matrices.
   - **Complejidad Algorítmica**:
     - **Acceso**: O(n) (en promedio).
     - **Inserción**: O(1) (para cada fila).
   - **Ejemplo en Python**:
     ```python
     from scipy.sparse import lil_matrix

     lil = lil_matrix((3, 3))
     lil[0, 1] = 10
     lil[1, 2] = 20
     print(lil.toarray())
     ```
   - **Uso**: Ideal para modificar matrices dispersas antes de convertirlas a otro formato más eficiente para la computación.

6. ### Matriz Dispersa en Formato DOK (Dictionary of Keys)
   - **Descripción**: Almacena los valores no nulos en un diccionario, donde las llaves son pares de coordenadas `(i, j)` y los valores son los elementos no nulos. Es eficiente para la construcción incremental, pero no tanto para operaciones algebraicas.
   - **Complejidad Algorítmica**:
     - **Acceso**: O(1).
     - **Inserción**: O(1).
   - **Ejemplo en Python**:
     ```python
     from scipy.sparse import dok_matrix

     dok = dok_matrix((3, 3))
     dok[0, 1] = 50
     dok[2, 2] = 100
     print(dok.toarray())
     ```
   - **Uso**: Ideal para inserciones rápidas y estructuras dispersas de tamaño pequeño.

## Complejidad Algorítmica Resumida

| Formato | Acceso | Inserción | Multiplicación Matricial |
|---------|--------|-----------|--------------------------|
| COO     | O(n)   | O(1)      | O(n)                     |
| CSR     | O(1)   | O(n)      | O(n)                     |
| CSC     | O(1)   | O(n)      | O(n)                     |
| DIA     | O(1)   | O(n)      | O(n)                     |
| LIL     | O(n)   | O(1)      | O(n)                     |
| DOK     | O(1)   | O(1)      | O(n)                     |

## Conclusión

El uso de matrices dispersas es esencial cuando trabajamos con grandes volúmenes de datos que contienen muchos ceros. `scipy.sparse` proporciona una amplia gama de formatos que optimizan el almacenamiento y las operaciones. La selección del formato adecuado depende de las operaciones que se necesiten realizar y de la estructura de la matriz. 

Para operaciones algebraicas, `CSR` y `CSC` son generalmente los más eficientes, mientras que `LIL` y `DOK` son preferibles para construir matrices dispersas de manera incremental.

