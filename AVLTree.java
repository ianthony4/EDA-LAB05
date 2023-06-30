
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
    NodeAVL<T> getNodeMin(NodeAVL<T> nodo) {
        NodeAVL<T> currentNode = nodo;
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode;
    }
    
}