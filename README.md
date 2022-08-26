# ESTRUCTURA DE DATOS

En este repositorio se van a encontrar distintos algoritmos relacionados a las estructuras de datos representadas bajo el paradígma de Programación Orientada a Objetos.
## Objetivo:

Desarrollar estructuras del pensamiento analítico por medio de la identificación de problemas de un entorno determinado
considerando sus diferentes variables, empleando técnicas y herramientas que le permitan hallar las posibles soluciones y
optar por la más apropiada, mediante el uso de algoritmos y lenguajes de programación.

## Contenido del curso:

[Módulo 1. Polinomios](https://github.com/JohnFlorez25/estructuras-datos/tree/main/1.%20Polinomios) <br>
[Módulo 2. Matrices Dispersas]() <br>
[Módulo 3. Árboles]() <br>
[Módulo 4. Grafos]() <br>
## ¿Qué son las estructuras de Datos?

Consiste en la organización de los datos en la memoria de un computador para establecer como se manipulan y manejan estos de tal forma que el uso de la memoria sea más eficiente, las operaciones o procesos se ejecuten más rápido y se minimice el tiempo de manejo del procesador.

Una estructura de datos es una forma particular de organizar y almacenar datos en un ordenador para que puedan accederse y modificarse de forma eficiente.

Más concretamente, una estructura de datos es un conjunto de valores de datos, las relaciones entre ellos y las funciones u operaciones que se pueden aplicar a los datos.

Un computador maneja los datos como:

- Datos Simples.
- Datos Estructurados.

## Datos Estructurados

- Arreglos.
- Registros.
- Listas Ligadas.
- Pilas,
- Colas (Filas).
- Árboles.
- Grafos.

## Información Útil

### Notación O Grande

Orden de crecimiento de los algoritmos especificados en la notación O grande.

![Gráficas de Notación O grande ](./assets/big-o-graph.png)

Fuente: [Big O Cheat Sheet](http://bigocheatsheet.com/).

A continuación se muestra la lista de algunas de las notaciones de Big O más utilizadas y sus comparaciones de rendimiento
frente a diferentes tamaños de los datos de entrada.

| Notación O grande | Cálculos para 10 elementos | Cálculos para 100 elementos | Cálculos para 1000 elementos |
| ----------------- | -------------------------- | --------------------------- | ---------------------------- |
| **O(1)**          | 1                          | 1                           | 1                            |
| **O(log N)**      | 3                          | 6                           | 9                            |
| **O(N)**          | 10                         | 100                         | 1000                         |
| **O(N log N)**    | 30                         | 600                         | 9000                         |
| **O(N^2)**        | 100                        | 10000                       | 1000000                      |
| **O(2^N)**        | 1024                       | 1.26e+29                    | 1.07e+301                    |
| **O(N!)**         | 3628800                    | 9.3e+157                    | 4.02e+2567                   |

### Complejidad de las operaciones de estructuras de datos

| Estructura de Datos            | Accesso | Busqueda | Inserción | Borrado | Comentarios                                                     |
| ------------------------------ | :-----: | :------: | :-------: | :-----: | :-------------------------------------------------------------- |
| **Colección**                  |    1    |    n     |     n     |    n    |                                                                 |
| **Stack**                      |    n    |    n     |     1     |    1    |                                                                 |
| **Cola**                       |    n    |    n     |     1     |    1    |                                                                 |
| **Lista enlazada**             |    n    |    n     |     1     |    1    |                                                                 |
| **Tabla hash**                 |    -    |    n     |     n     |    n    | En caso de función hash perfecta los costos serían O(1)         |
| **Búsqueda por Árbol binario** |    n    |    n     |     n     |    n    | En el caso de un árbol equilibrado, los costos serían O(log(n)) |
| **Árbol B**                    | log(n)  |  log(n)  |  log(n)   | log(n)  |                                                                 |
| **Árbol Rojo-Negro**           | log(n)  |  log(n)  |  log(n)   | log(n)  |                                                                 |
| **Árbol AVL**                  | log(n)  |  log(n)  |  log(n)   | log(n)  |                                                                 |
| **Filtro de Bloom**            |    -    |    1     |     1     |    -    | Falsos positivos son posibles durante la búsqueda               |

### Complejidad de algoritmos de ordenamiento de arreglos

| Nombre                           | Mejor         | Promedio                | Pero                        | Memorya | Estable | Comentarios                                                   |
| -------------------------------- | :-----------: | :---------------------: | :-------------------------: | :-----: | :-----: | :------------------------------------------------------------ |
| **Ordenamiento de burbuja**      |       n       |      n<sup>2</sup>      |        n<sup>2</sup>        |   1     |  Si     |                                                               |
| **Ordenamiento por inserción**   |       n       |      n<sup>2</sup>      |        n<sup>2</sup>        |   1     |  Si     |                                                               |
| **Ordenamiento por selección**   | n<sup>2</sup> |      n<sup>2</sup>      |        n<sup>2</sup>        |   1     |   No    |                                                               |
| **Ordenamiento por Heap**        | n&nbsp;log(n) |      n&nbsp;log(n)      |        n&nbsp;log(n)        |   1     |   No    |                                                               |
| **Ordenamiento por mezcla**      | n&nbsp;log(n) |      n&nbsp;log(n)      |        n&nbsp;log(n)        |   n     |  Si     |                                                               |
| **Quicksort**                    | n&nbsp;log(n) |      n&nbsp;log(n)      |        n<sup>2</sup>        | log(n)  |   No    | Quicksort utiliza O(log(n)) de espacio en el stack         |
| **Shellsort**                    | n&nbsp;log(n) | depende de la secuencia de huecos | n&nbsp;(log(n))<sup>2</sup> |   1   |   No   |                                                               |
| **Ordenamiento por cuentas**     |     n + r     |          n + r          |            n + r            | n + r   |  Si     | r - mayor número en el arreglo                                |
| **Ordenamiento Radix**           |    n \* k     |         n \* k          |           n \* k            | n + k   |  Si     | k - largo de la llave más larga  

