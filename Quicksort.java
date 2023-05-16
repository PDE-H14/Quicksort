import java.util.Arrays;

/**
 * @author porfi
 */
public class Quicksort {
    
     public static int partition(int[] a, int start, int end)
    {
        int temp;
        // Criterio de Lomuto para la elección del pivote (siempre el último valor del arreglo)
        int pivot = a[end];
 
        /*
        Los elementos menores que el pivote serán repocisionados a la izquierda de `start`,
        elementos mayores que el pivote serán repocisionados a la derecha de `start`
        elementos iguales pueden ir en cualquier lado
        */ 
 
        /*
        Cada vez que encontramos un elemento menor o igual que el pivote,
        `start` se incrementa, y ese elemento se colocará
        antes del pivote.
        */
        for (int i = start; i < end; i++)
        {
            if (a[i] <= pivot)
            {
                temp = a[i];
                a[i] = a[start];
                a[start] = temp;
                start++;
            }
        }
        // Intercambiar `start` con pivote
        temp = a[end];
        a[end] = a[start];
        a[start] = temp;
        // Devuelve `start` (índice del elemento pivote)
        return start;
    }
     
    public static void quicksort(int[] a, int start, int end)
    {
        // Condición base
        if (start >= end) {
            return;
        }
        // Particiona el arreglo en dos subarreglos, uno de menores y otro de mayores al pivote
        int pivot = partition(a, start, end);
        // Recurre en un subarreglo que contiene elementos menores que el pivote
        quicksort(a, start, pivot - 1);
        // se repite en el subarreglo que contiene elementos mayores que el pivote
        quicksort(a, pivot + 1, end);
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
