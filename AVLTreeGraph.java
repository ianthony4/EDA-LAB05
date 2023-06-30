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
        System.setProperty("org.graphstream.ui", "swing");
    }
    
    private void addNode(NodeAVL<Integer> node, Node padreNode, double x, double y, double separacion) {
        //creando nodo actual a trabajar
        Node nodoActual = graph.addNode(String.valueOf((char) node.date.intValue())); 
        //ASCII A CHAR
        nodoActual.setAttribute("ui.label", Character.toString((char) node.date.intValue()));
        nodoActual.setAttribute("ui.style", "text-size: 50px;");
        nodoActual.setAttribute("layout.weight",0);
        //Si el nodo actual sera padre
        if (padreNode != null) {
            graph.addEdge(padreNode.getId() + nodoActual.getId(), padreNode.getId(), nodoActual.getId());
        }

        nodoActual.setAttribute("xy", x, y);

        if (node.right != null) {
            addNode(node.right, nodoActual, x + separacion, y - 1.0, separacion / 2);
        }

        if (node.left != null) {
            addNode(node.left, nodoActual, x - separacion, y - 1.0, separacion / 2);
        }
    }

    public void printTree() {
        addNode(tree.root, null, 0.0, 0.0, 4.0);
        Viewer viewer = graph.display();

        Node nodoRaiz = graph.getNode(0);
        nodoRaiz.setAttribute("ui.style", "fill-color: red;");
        graph.setAttribute("layout.force", 1);
        viewer.disableAutoLayout();
    }
    
}
