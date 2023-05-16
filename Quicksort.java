import java.util.Arrays;

/*
 ? ¿Cómo puedo leer los comentarios?
 ! En visual studio code instala las siguientes extensiones
 ! * Better Coments
 ! * mathover
 */

/**
 * @author porfi
 */
public class Quicksort {
    
     public static int partition(int[] a, int start, int end)
    {
        int temp;
        // * Criterio de Lomuto para la elección del pivote (siempre el último valor del arreglo)
        int pivot = a[end]; // ! OEx2 | asignación y acceso
 
        /*
        * Los elementos menores que el pivote serán repocisionados a la izquierda de `start`,
        * elementos mayores que el pivote serán repocisionados a la derecha de `start`
        * elementos iguales pueden ir en cualquier lado
        */ 
 
        /*
        * Cada vez que encontramos un elemento menor o igual que el pivote,
        * `start` se incrementa, y ese elemento se colocará
        * antes del pivote.
        */
        for (int i = start; i < end; i++) // ! OEx4 | 2 assignaciones, comparación, suma
        {
            if (a[i] <= pivot) // ! OEx2 | comparación y acceso
            {
                temp = a[i]; // ! OEx2 | asignación y acceso
                a[i] = a[start]; // ! OEx3 | asignación y 2 accesos
                a[start] = temp; // ! OEx2 | asignación y acceso
                start++; // ! OEx2 | asignación y suma
            }
        }
        // * Intercambiar `start` con pivote
        temp = a[end]; // ! OEx2 | asignación y acceso
        a[end] = a[start]; // ! OEx3 | asignación y 2 accesos
        a[start] = temp; // ! OEx2 | asignación y acceso
        // * Devuelve `start` (índice del elemento pivote)
        return start; // ! OEx1 | retorno
        
        /*
        * Sea P(n) el tiempo de ejecución de partition() 
        
        * El mejor caso está dado por
        * # Math: P(n) = 2 + \left(1+1+\sum^{n}{2+2}\right) + 2 + 3 + 2 + 1= 10 + 2 + \sum^{n}4 = 4n+12
        * Sucede cuando el pivote es el valor más pequeño, entonces solo compara dentro del for y
        * termina por cambiar su pocisión con el primer elemento.

        * Un caso medio está dado por
        * # Math: P(n) = 2 + \left(1+1+\sum^{n}{2 + 2 + \frac{2 + 3 + 2 + 2}{2}}\right) + 2 + 3 + 2 + 1 = 10 + 2 + \sum^{n}\frac{17}{2} = \frac{17}{2}n+12
        *  Sucede cuando el pivote ocupa una pocisión media y solo se compara con la mitad del arreglo, aplicamos piso een caso de que # Math: n = 2k+1

        * El peor caso está dado por 
        * # Math: P(n) = 2 + \left(1+1+\sum^{n}{2 + 2 + 2 + 3 + 2 + 2}\right) + 2 + 3 + 2 + 1 = 10 + (2 + \sum^{n}13) = 13n+12
        * Sucede cuando el pivote es el mayor valor del arreglo y en cada iteración se entra al condicional.
         */
    }
     
    public static void quicksort(int[] a, int start, int end)
    {
        // * Condición base
        if (start >= end) { // ! OEx1 | comparación
            return; // ! OEx1 | retorno
        }
        // * Particiona el arreglo en dos subarreglos, uno de menores y otro de mayores al pivote
        int pivot = partition(a, start, end); // ! OEx2 | Llamada a una función y asignación
        // * Recurre en un subarreglo que contiene elementos menores que el pivote
        quicksort(a, start, pivot - 1); // ! OEx2 | Llamada a una función y suma
        // * se repite en el subarreglo que contiene elementos mayores que el pivote
        quicksort(a, pivot + 1, end); // ! OEx2 | Llamada a una función y suma

        /*
         * Observemos que en el caso base, que sucede cuando la longitud del arreglo es menor igual que 1 y 
         * ejecuta dos operaciones elementales por lo que si Q(n) es el tiempo de ejecución de quicksort()
         * # Math: Q(n)=\left\{\begin{array}{cr}2 & \text{caso base}\\ \dotso & \dotso\end{array}\right.
         
         * Ahora, la parte recursiva:
         
         * El mejor caso está dado por
         * # Math: 2 + 1 + P(n)_{\text{caso medio}} + 2Q(n/2) + 2 = 5 + P(n)+2Q(n)
         * Sucede cuando el arreglo se divide dos arreglos de la misma longitud
         * Obteniendo # Math:  Q(n)=\left\{\begin{array}{cr}2 & n\leq1\text{ caso base}\\ 5 + P(n)_{cm}+2Q(n) & n>1\text{ mejor caso}\end{array}\right.
         
         * El peor caso está dado por
         * # Math: 2 + 1 + P(n)_{\text{mejor o peor caso}} + Q(n-1) + Q(0) = 5 + P(n)_{pc} + Q(n-1)+Q(0)
         * sucede cuado el pivote es el último o el primero, ocacionando que obtengamos un arreglo de n-1 elementos 
         * y un arreglo con un solo valor.
         * Obteniendo # Math:  Q(n)=\left\{\begin{array}{cr}2 & n\leq1\text{ caso base}\\ 5 + P(n)_{pc} + Q(n-1)+Q(0) & n>1\text{ peor caso}\end{array}\right.
         */
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] a = {0, 9, -3, 5, 2, 6, 8, -6, 1, 3 , -18, -6};
        quicksort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
    
}
