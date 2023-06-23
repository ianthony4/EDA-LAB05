public class Test{
  public static void main(String[] args){
    BST<Integer> bst = new BST<Integer>();
    bst.insert(18);
    bst.insert(14);
    bst.insert(13);
    bst.insert(9);
    bst.insert(2);
    bst.insert(20);
    System.out.println(bst);
  }
}
