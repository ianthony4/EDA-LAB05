public class Node<T> {
  private T data;
  private Node rightNode;
  private Node leftNode;
  private int balanceFactor;
  public Node(){
    this.data = null;
    this.leftNode = null;
    this.rightNode = null;
    this.balanceFactor = 0;
  }
  public Node(T data){
    this.data = data;
    this.leftNode = null;
    this.rightNode = null;
    this.balanceFactor = 0;
  }
  public Node(T data, Node<T> lefttNode){
    this.data = data;
    this.leftNode = leftNode;
    this.rightNode = null;
    this.balanceFactor = 0;
  }
  public Node(T data, Node<T> leftNode, Node<T> rightNode){
    this.data = data;
    this.leftNode = leftNode;
    this.rightNode = rightNode;
    this.balanceFactor = 0;
  }
}
