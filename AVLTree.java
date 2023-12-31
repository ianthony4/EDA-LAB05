
//      Importar la clase grahpstream
//import org.graphstream.graph.Graph;
//import org.graphstream.graph.Node;
//import org.graphstream.graph.implementations.SingleGraph;
public class AVLTree<T extends Comparable<T>> {
    
    NodeAVL<T> root;
    
    //Metodos
    //search(), getMin(), getMax(), parent(), son(), insert(), remove().
    boolean search(T date) {
        NodeAVL<T> result = searchNode(root, date);
        return result != null;
    }
    NodeAVL<T> searchNode(NodeAVL<T> node, T date) {
        if (node == null || date.compareTo(node.date) == 0) {
            return node;
        }
        if (date.compareTo(node.date) < 0) {
            return searchNode(node.left, date);
        }
        return searchNode(node.right, date);
    }

    //getMin()
    //Retornando el valor del nodo
    T getMin() {
        NodeAVL<T> nodeMin = getNodeMin(root);
        return nodeMin.date;
    }
    //Encontramos el nodo Menor
    NodeAVL<T> getNodeMin(NodeAVL<T> node) {
        NodeAVL<T> currentNode = node;
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode;
    }
    
    //getMax()
    //Retornando el valor del nodo mayor
    T getMax() {
        NodeAVL<T> nodeMax = getNodeMax(root);
        return nodeMax.date;
    }
    //Encontramos el nodo Mayor
    NodeAVL<T> getNodeMax(NodeAVL<T> node) {
        NodeAVL<T> currentNode = node;
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }
        return currentNode;
    }

    //Metodo parent()
    //En este metodo debemos encontrar el nodo padre
    //Recordemos que lo tenemos como atributo
    NodeAVL<T> getParent(NodeAVL<T> node) {
        return node.father;
    }
    NodeAVL<T> parent(NodeAVL<T> node) {
        return getParent(node);
    }

    //Metodo Son()
    //Primero encontraremos el hijo izquierdo
    NodeAVL<T> getSonLeft(NodeAVL<T> node) {
        return node.left;
    }

    NodeAVL<T> leftSon(NodeAVL<T> node) {
        return getSonLeft(node);
    }

    //Ahora encontremos al hijo derecho
    NodeAVL<T> getSonRight(NodeAVL<T> node) {
        return node.right;
    }

    NodeAVL<T> rightSon(NodeAVL<T> node) {
        return getSonRight(node);
    }


    //Metodos Adicionales para calcular el factor de equilibrio
    // getAltura
    int getAlt(NodeAVL<T> node) {
        if (node == null) {
            return 0;
        }
        return node.alt;
    }

    // Factor de Equilibrio
    int getFE(NodeAVL<T> node) {
        if (node == null) {
            return 0;
        }
        return getAlt(node.left) - getAlt(node.right);
    }

    // getAlturaMax (entre 2 alturas)
    int getAltMax(int alt1, int alt2) {
        return Math.max(alt1, alt2);
    }

     //Rotaciones
    NodeAVL<T> rotateRight(NodeAVL<T> y) {
        NodeAVL<T> x = y.left;
        NodeAVL<T> aux = x.right;

        // Realizar rotación
        x.right = y;
        y.left = aux;

        // Actualizar alturas
        y.alt = getAltMax(getAlt(y.left), getAlt(y.right)) + 1;
        x.alt = getAltMax(getAlt(x.left), getAlt(x.right)) + 1;

        // Actualizar padre
        if (aux != null) {
            aux.father = y;
        }
        x.father = y.father;
        y.father = x;

        // Devolver nueva raíz
        return x;
    }

    // Rotación a la izquierda
    NodeAVL<T> rotateLeft(NodeAVL<T> x) {
        NodeAVL<T> y = x.right;
        NodeAVL<T> aux = y.left;

        y.left = x;
        x.right = aux;

        x.alt = getAltMax(getAlt(x.left), getAlt(x.right)) + 1;
        y.alt = getAltMax(getAlt(y.left), getAlt(y.right)) + 1;

        if (aux != null) {
            aux.father = x;
        }
        y.father = x.father;
        x.father = y;

        return y;
    }

    //insert()
    // Insertar un nodo
    void insert(T date) {
        root = insertNode(root, date);
    }

    //Inserta un nodo y hace las verificaciones
    NodeAVL<T> insertNode(NodeAVL<T> node, T date) {
        // Realizar la inserción en un árbol binario de búsqueda
        //En caso node este vacio
        if (node == null) {
            return (new NodeAVL<>(date));
        }

        //Si la comparacion es -1 entonces asignamos el nodo al lado IZQUIERDO  
        if (date.compareTo(node.date) < 0) {
            node.left = insertNode(node.left, date);
            //asignando padre
            node.left.father = node;

            //Si el valor del nodo es positivo se inserta en el lado derecho 
        } else if (date.compareTo(node.date) > 0) {
            node.right = insertNode(node.right, date);
            //asignando padre
            node.right.father = node;

        } else {
            // Debido a que no se permiten duplicados
            return node;
        }

        // Actualizar Altura
        node.alt = getAltMax(getAlt(node.left), getAlt(node.right)) + 1;

        // Obtener Factor de equilibrio
        int fe = getFE(node);

        // Rotación hacia la izquierda
        if (fe > 1 && date.compareTo(node.left.date) < 0) {
            return rotateRight(node);
        }

        // Rotación hacia la derecha
        if (fe < -1 && date.compareTo(node.right.date) > 0) {
            return rotateLeft(node);
        }

        // Rotación doble a la izquierda
        if (fe > 1 && date.compareTo(node.left.date) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Rotación doble a la derecha
        if (fe < -1 && date.compareTo(node.right.date) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    //remove()
    void remove(T date) {
        root = removeNode(root, date);
    }

    // Eliminar un nodo del árbol AVL
    NodeAVL<T> removeNode(NodeAVL<T> root, T date) {
        // Realizar la eliminación en un árbol binario de búsqueda
        if (root == null) {
            return root;
        }

        if (date.compareTo(root.date) < 0) {
            root.left = removeNode(root.left, date);
        } else if (date.compareTo(root.date) > 0) {
            root.right = removeNode(root.right, date);
        } else {
            // Nodo encontrado, realizar la eliminación

            // Caso 1 Nodo con uno o ningún hijo
            if ((root.left == null) || (root.right == null)) {
                NodeAVL<T> aux;               //nodo temporal
                if (root.left != null) {
                    aux = root.left;
                } else {
                    aux = root.right;
                }

                // En caso no haya ningun hijo
                if (aux == null) {
                    aux = root;
                    root = null;    
                } else { 
                    root = aux;
                    root.father = aux.father;
                }
                aux = null;
            } else {
                // En este caso para un nodo con 2 hijos
                NodeAVL<T> son = getNodeMin(root.right);
                root.date = son.date;
                // Eliminar el sucesor
                root.right = removeNode(root.right, son.date);
            }
        }

        // Si el árbol tenía solo un nodo, no se necesita hacer más nada
        if (root == null) {
            return root;
        }

        // Actulizamos la altura del nodo
        root.alt = getAltMax(getAlt(root.left), getAlt(root.right)) + 1;

        int fe = getFE(root);
        // Rotacion izquiera-izquierda
        if (fe > 1 && getFE(root.left) >= 0) {
            return rotateRight(root);
        }

        // Rotacion izquierda-derechra
        if (fe > 1 && getFE(root.left) < 0) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        // Rotación derecha-derecha
        if (fe < -1 && getFE(root.right) <= 0) {
            return rotateLeft(root);
        }

        // Rotación derecha-izquierda
        if (fe < -1 && getFE(root.right) > 0) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    public void printTree() {
        printSort(root);
        System.out.println();
    }

    private void printSort(NodeAVL<T> node) {
        if (node != null) {
            printSort(node.left);
            int valor = (Integer) node.date;
            char chart = (char) valor;
            System.out.print(chart + " ");
            printSort(node.right);
        }
    }
}