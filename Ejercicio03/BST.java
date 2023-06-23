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
    if(isEmpty()){
      this.root = new Node<T>(data);
    }else{
      insert(data, this.root);
    }
  }
  public Node<T> insert(T data, Node<T> node){
    Node<T> res = node;
    if(res == null){
      res = new Node<T>(data);
    }else if(data.compareTo(res.getData()) < 0){
      res.setLeftNode(insert(data, res.getLeftNode()));
    }else if(data.compareTo(res.getData()) > 0){
      res.setRightNode(insert(data, res.getRightNode()));
    }
    return res;
  }
  
  public String inOrden(){
    if(this.isEmpty())
      return "Vacío";
    return inOrden(this.root);
  }
  public String inOrden(Node<T> node){
    String res = "";
    if(node != null){
      res += inOrden(node.getLeftNode());
      res += node.getData() + " ";
      res += inOrden(node.getRightNode());
    }
    return res;
  }
  public String toString(){
    return inOrden();
  }
}
