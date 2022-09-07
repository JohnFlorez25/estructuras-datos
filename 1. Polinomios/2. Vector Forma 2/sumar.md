# Método Sumar

## Implementación en Pseudocódigo

```java
PolF2:PolF2::sumar( PolF2: b)
    entero: i , j,  expA, expB, posC,coeA,coeB
    PolF2: c
     c = nuevo PolF2(“C”)
     i = 2
     j = 2
      mientras i <= Vec[ 1 ]*2+1  and j <= b.obtenreDato( 1) * 2+1  haga
        expA  =  Vec[  i ]
        expB =   b.obtenerDato( j )
        coeA = Vec[ i + 1]
        coeB = b.obtenerDato( j + 1 )
            si  expA = exB  entonces
                c.insertarTermino(  coeA + coeB ,expA )
                i = i + 2
                j= j + 2
            sino
                si  expA >exB entonece
                c. insertarTermino (  coeA ,expA)
                i = i + 2
                si_no
                c. insertarTermino ( coeB, expB )
                j = j + 2
                fin_si
        fin_si
       fin_mientras
      mientras i<= Vec[ i ]*2 + 1 haga
        c. insertarTermino (  Vec[ i + 1] , Vec[ i ])
        i = i + 2
      fin_mientras

      mientras j <= b.obtenerDato( 1 ) * 2 + 1 haga
        c. insertarTermino (  b.obtenerDato( j  + 1) , b.obtenerDato( j ))
        j = j + 2
      fin_mientras
fin método
```