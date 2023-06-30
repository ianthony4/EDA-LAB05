
//      Importar la clase grahpstream
//import org.graphstream.graph.Graph;
//import org.graphstream.graph.Node;
//import org.graphstream.graph.implementations.SingleGraph;
public class AVLTree<T extends Comparable<T>> {
    
    NodeAVL<T> root;
    
    //Metodos
    //search(), getMin(), getMax(), parent(), son(), insert(), remove().
    NodeAVL<T> search(NodeAVL<T> node, T date){
        if(node == null || date.compareTo(node.date)==0){
            return node;
        }
        if(date.compareTo(node.date)<0){
            return search(node.left, date);
        }
        return search(node.right, date);
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
}