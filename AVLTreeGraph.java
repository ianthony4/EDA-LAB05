//Para graficar
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;
public class AVLTreeGraph {
    private AVLTree<Integer> tree;
    private Graph graph;

    public AVLTreeGraph(AVLTree<Integer> tree) {
        this.tree = tree;
        this.graph = new SingleGraph("AVL TREE");
    }
    
    private void addNode(NodeAVL<Integer> node, Node fatherNode) {
        //creando nodo actual a trabajar
        Node currentNode = graph.addNode(String.valueOf((char) node.date.intValue())); 
        //ASCII A CHAR
        currentNode.setAttribute("ui.label", Character.toString((char) node.date.intValue()));
        currentNode.setAttribute("ui.style", "text-size: 60px;");
        currentNode.setAttribute("layout.weight",0);
        //Si el nodo actual sera padre
        if (fatherNode != null) {
            graph.addEdge(fatherNode.getId() + currentNode.getId(), fatherNode.getId(), currentNode.getId());
            currentNode.setAttribute("xy", 0, -1); //posicion xy
            currentNode.setAttribute("layout.frozen");//estabilidad en el grafico 
        }
        //Si el nodo actual sera hijo izquierdo
        if (node.left != null) {
            addNode(node.left, currentNode);
            currentNode.setAttribute("xy", 1, 0);
            currentNode.setAttribute("layout.frozen");
        }
        //Si el nodo actual sera hijo derecho
        if (node.right != null) {
            addNode(node.right, currentNode);
            currentNode.setAttribute("xy", -1, 0);
            currentNode.setAttribute("layout.frozen");
        }
    }

    public void printTree() {
        System.setProperty("org.graphstream.ui", "swing");
        addNode(tree.root, null);
        Viewer viewer = graph.display();
        viewer.disableAutoLayout();
    }
    
}
