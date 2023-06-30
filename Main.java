import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        AVLTree<Integer> tree = new AVLTree<>();
        

        //Insertar valores en el árbol AVL
        //Convertimos los caracteres a su entero ASCII usando el casteo hacia int
        System.out.println("Ingrese la palabra: ");
        String str = read.nextLine().toUpperCase();
        
        //Almacenamos los caracteres en un array
        int strSize = str.length();
        int[] arrayChar = new int[strSize];

        for (int i = 0; i < strSize; i++) {
            arrayChar[i] = str.charAt(i);
        }
        for (int i = 0; i < arrayChar.length; i++) {
            System.out.println(arrayChar[i]);
        }

        for (int i = 0; i < arrayChar.length; i++) {
            tree.insert((int) arrayChar[i]);
        }
        
        //Buscar un valor (Esto se puede cambiar)
        char charsearch = 'D';

        boolean result = tree.search((int) charsearch);
        System.out.println("Busqueda del nodo " + charsearch + " : " + result);

        int minimo = tree.getMin();
        System.out.println("Nodo de menor valor: " + (char) minimo);

        int maximo = tree.getMax();
        System.out.println("Nodo de mayor valor: " + (char) maximo);

//      Obtener el PADRE
        // NodeAVL<Integer> node = tree.searchNode(tree.root, (int) charsearch);
        // NodeAVL<Integer> padre = tree.parent(node);
        // System.out.println("Nodo Padre de " + charsearch + " : " + (char) padre.date.intValue());

//      Eliminar un valor
//      tree.remove((int) charsearch);
//      result = tree.search((int) charsearch);
        
        //Dibujo del arbol
        tree.printTree();
        AVLTreeGraph graph = new AVLTreeGraph(tree);
        graph.printTree();
    }
}
