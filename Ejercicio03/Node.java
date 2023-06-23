public class Node<T> {
  private T data;
  private Node rightNode;
  private Node leftNode;
  private int balanceFactor;
  public Node(){
    this.data = null;
    this.rightNode = null;
    this.leftNode = null;
    this.balanceFactor = 0
  }
}
