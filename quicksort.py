#Función para intercambiar valores
def swap(A, i, j):
    temp = A[i]
    A[i] = A[j]
    A[j] = temp
 
#=============================================================================================#
# Partición 
# utilizando el esquema de partición Lomuto (Se toma al último valor del arreglo como pivote)
#==============================================================================================#
def partition(a, start, end):
 
    # Declaración y asignación del pivote
    pivot = a[end] 
 
    # Los elementos 
    # menores que el pivote serán empujados a la izquierda del elemento en `pIndex`
    # Los elementos 
    # mayores que el pivote se empujarán a la derecha del elemento en `pIndex`
    # elementos iguales pueden ir en cualquier lado
    pIndex = start
 
    # cada vez que encontramos un elemento menor o igual que el pivote,
    # `pIndex` se incrementa, y ese elemento se colocaría
    # antes del pivote.
    for i in range(start, end):
        if a[i] <= pivot:
            swap(a, i, pIndex)
            pIndex = pIndex + 1
 
    # Intercambiar `pIndex` con pivote
    swap(a, end, pIndex)
 
    # devuelve `pIndex` (índice del elemento pivote)
    return pIndex
 
 
# Clasificación rápida
def quicksort(a, start, end):
 
    # Condición base
    if start >= end:
        return
 
    # reorganizar elementos a través de pivote
    pivot = partition(a, start, end)
 
    # recurre en la sublista que contiene elementos menores que el pivote
    quicksort(a, start, pivot - 1)
 
    # recurre en la sublista que contiene más elementos que el pivote
    quicksort(a, pivot + 1, end)
 
 
# Implementación en Python del algoritmo Quicksort
if __name__ == '__main__':
 
    a = [9, -3, 5, 2, 6, 8, -6, 1, 3]
 
    quicksort(a, 0, len(a) - 1)
 
    # imprime la lista ordenada
    print(a)
