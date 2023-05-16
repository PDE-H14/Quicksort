# Quicksort
## Análisis de Algoritmos

>[!TIP]
>
>Instale las extenciones
>* Better Comments
>* mathover
>
>en visual studio code para poder visualizar de mejor manera los comentarios del código en java (Quicsort.java)

## Análisis del algoritmo Quicksort en Java

### Análisis de la función partition()

Sea P(n) el tiempo de ejecución de partition() 
* El mejor caso está dado por
  $P(n) = 2 + \left(1+1+\sum^{n}{2+2}\right) + 2 + 3 + 2 + 1= 10 + 2 + \sum^{n}4 = 4n+12$
  Sucede cuando el pivote es el valor más pequeño, entonces solo compara dentro del bucle y
  termina por cambiar su pocisión con el primer elemento.

* Un caso medio está dado por
  $P(n) = 2 + \left(1+1+\sum^{n}{2 + 2 + \frac{2 + 3 + 2 + 2}{2}}\right) + 2 + 3 + 2 + 1 = 10 + 2 + \sum^{n}\frac{17}{2} = \frac{17}{2}n+12$
  Sucede cuando el pivote ocupa una pocisión media y solo se compara con la mitad del arreglo, aplicamos piso een caso de que # Math: n = 2k+1

* El peor caso está dado por 
  $P(n) = 2 + \left(1+1+\sum^{n}{2 + 2 + 2 + 3 + 2 + 2}\right) + 2 + 3 + 2 + 1 = 10 + (2 + \sum^{n}13) = 13n+12$
  Sucede cuando el pivote es el mayor valor del arreglo y en cada iteración se entra al condicional.
