public class Main {
    public static void main(String[] args) {
        //Todo el procedemiento para ejecutar el programa
        //Ingresar la palabra
        //Testear
        //ETC
        AVLTree<Integer> nums = new AVLTree<Integer>();
        int[] arr = {4, 2, 6, 2, 8, 5, 1, 3}
        for(int i = 0; i < arr.length; i++){
            nums.insert(arr[i]);
        }
        nums.printTree();
        // AVLTreeGraph<Integer> tree = 
    }
}
