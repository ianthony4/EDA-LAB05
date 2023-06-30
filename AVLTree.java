
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

}