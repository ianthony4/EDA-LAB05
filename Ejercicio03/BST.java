public class BST<T extends Comparable<T>>{
  public Node<T> root;

  // constructor
  public BST(){
    this.root = null;
  }
  public boolean isEmpty(){
    return this.root == null;
  }
  public void insert(T data){
    this.root = new Node<T>(data);
  }

}
