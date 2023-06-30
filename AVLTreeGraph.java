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
        graph = new SingleGraph("AVL tree");
        graph.setAttribute("ui.stylesheet", styleSheet);
        System.setProperty("org.graphstream.ui", "swing");
        this.setNodes(tree);
    }

    private void setNodes(AVLTree<T> tree) {
        
        int alt = tree.root.alt;
        int anc = 0;
        setValues(tree.root, alt, anc);
        System.out.println();

        
    }

    private void setValues(NodeAVL<T> node, int x, int y) {
        if(node != null){
            String valor = node.date.toString();
            graph.addNode(valor);
            graph.getNode(valor).setAttribute("xy", x, y);
            x--;
            if(node.father != null){
                graph.addEdge(node.father.value + node.value, node.father.value, node.value);
            }
            setValues(node.left, x, y - 1);
            setValues(node.right, x, y + 1);
        }
    }

    protected void sleep() {
      try { Thread.sleep(1000); } catch (Exception e) {}
  	}

    public void imprimirArbol() {
        agregarNodo(arbol.raiz, null);
        Viewer viewer =graph.display();
        // Colorear el nodo raíz
        Node nodoRaiz = graph.getNode(0);
        nodoRaiz.setAttribute("ui.style", "fill-color: red;");
        nodoRaiz.setAttribute("layout.frozen");
        graph.setAttribute("layout.force",1);                  
        viewer.disableAutoLayout();
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
