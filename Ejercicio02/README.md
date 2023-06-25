# 5.2 Operaciones de árbol AVL

- Simule las siguientes operaciones de un árbol AVL
  1. Inserción: 100 - 200 - 300 - 400 - 500 - 50 - 25 - 350 - 375 - 360 - 355 - 150 - 175 - 120 - 190.
  2. Después de crear un árbol AVL, realice la eliminación: 100 - 200 - 300 - 400 - 500 - 50 - 25 - 350 - 375 - 360 - 355 - 150 - 175 - 120 - 190.
- Para este ejercicio tienes que escribir el paso a paso del desarrollo de cada operación donde se muestra gráficamente el estado del árbol así como el factor de equilibrio para cada nodo y el tipo de operación que se está realizando, es decir, inserción, eliminación, rotación.
- Este ejercicio no requiere implementación, solo escribe el desarrollo de cada uno operación paso a paso e incluirlo en el informe.

# Resolución - Inserción

Se insertará en el siguiente orden: 100 - 200 - 300 - 400 - 500 - 50 - 25 - 350 - 375 - 360 - 355 - 150 - 175 - 120 - 190.

## 1. Elementos insertados: 100 - 200 - 300

Para empezar se insertó los primeros elementos, tras hacerlo según un BST, nos damos cuenta el factor de equilibrio del nodo raíz está en crítico, por lo tanto requerimos de hacer un RSL, una rotación simple a la izquierda.

![Inserción de 100 - 200 - 300](01.png)

## 2. Elementos insertados: 400 - 500

Tras insertarlos hasta que algún factor de equilibrio este en crítico, observamos que el nodo desequilibrado es el 300, por lo tanto hacemos un RSL en este.

![Inserción de 400 - 500](02.png)

## 3. Elementos insertados: 50 - 25

Tras insertarlos, observamos que el nodo desequilibrado es el 100, por lo tanto hacemos un RSR, una rotación simple derecha.

![Inserción de 50 - 25](03.png)

## 4. Elementos insertados: 350 - 375

Tras insertarlos, el nodo desequilibrado resulta ser el 300 en su nueva posición al cual haremos un RSL.

![Inserción de 350 - 375](04.png)

## 5. Elementos insertados: 360

Tras insertarlo, el nodo desequilibrado pasa a ser el 400, al cuál haremos un RDR, una rotación doble derecha, que sería un RSL en el nodo 350 y luego un RSR en el nodo 400, o podemos hacerlo de forma directa.

![Inserción de 360](05.png)

## 6. Elementos insertados: 355

Su inserción ocasiona que la raíz sea el nodo desequilibrado, por tanto haremos un RDL, una rotación doble izquierda, es decir un RSR en 375 y luego un RSL en 200, o tambien ir por la forma directa.

![Inserción de 355](06.png)

## 7. Elementos insertados: 150

Tras insertarlo nos muestra que el nodo 200 está desequilibrado, por tanto haremos un RDR, un RSL en 50 y después un RSR en 200, o de forma directa.

![Inserción de 150](07.png)

## 8. Elementos insertados: 175 - 120 -190

Tras insertarlos el nodo desquelibrado es 200 y aplicamos un RDR, un RSL en 150 y un RSD en 200, o de forma directa.

![Inserción de 400 - 500](08.png)
