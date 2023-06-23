public class Node<T> {
  private T data;
  private Node<T> leftNode;
  private Node<T> rightNode;
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
  //getter and setters
  public T getData(){
    return this.data;
  }
  public void setData(T data){
    this.data = data;
  }
  public Node<T> getLeftNode(){
    return this.leftNode;
  }
  public void setLeftNode(Node<T> leftNode){
    this.leftNode = leftNode;
  }
  public Node<T> getRightNode(){
    return this.rightNode;
  }
  public void setRightNode(Node<T> rightNode){
    this.rightNode = rightNode;
  }
  public int getBalanceFactor(){
    return this.balanceFactor;
  }
  public void setBalanceFactor(int balanceFactor){
    this.balanceFactor = balanceFactor;
  }

}
