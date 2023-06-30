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
    
    
}
