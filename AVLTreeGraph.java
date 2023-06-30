//Para graficar
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
//import org.graphstream.ui.view.Viewer;
//import org.graphstream.ui.*;
public class AVLTreeGraph<T extends Comparable<T>> {
    private AVLTree<T> tree;
    private Graph graph;

    public AVLTreeGraph() {
        graph = new SingleGraph("AVL tree");
        graph.setAttribute("ui.stylesheet", styleSheet);
        System.setProperty("org.graphstream.ui", "swing");
        
    }

    public AVLTreeGraph(AVLTree<T> tree) {
        this.AVLTreeGraph()
        this.setValues(tree)
    }

    private void setNodes(AVLTree<T> tree) {
        if(tree.root == null){
            return;
        }
        alt = tree.root.alt;
        System.out.print(alt);

        
    }

    private void setValues(NodeAVL<T> node) {

    }

    protected void sleep() {
      try { Thread.sleep(1000); } catch (Exception e) {}
  	}

    protected String styleSheet =
		"node {"+
			"	shape: circle;"+
			"	size: 40px;"+
			" text-size: 12;"+
			"	fill-mode: plain;"+
			"	fill-color: skyblue;"+
			"	stroke-mode: plain;"+
			"	stroke-color: black;"+
			"	stroke-width: 1px;"+
		"}"+
		"edge { arrow-shape: arrow; arrow-size: 20px, 4px; }"+
		"node.root { fill-color: yellow; }";
    
    
}
