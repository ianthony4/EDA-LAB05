public class NodeAVL<T> {
    //Datos del nodo
    T date;
    int alt;
    NodeAVL<T> left;
    NodeAVL<T> right;
    NodeAVL<T> father;
    
    //Iniciamos un nodo
    NodeAVL(T dat) {
        this.date = dat;
        this.alt = 1;
    }
    //getters and setters
    T getDate() {
        return date;
    }
    public void setDate(T date) {
        this.date = date;
    }
    public int getAlt() {
        return alt;
    }
    public void setAlt(int alt) {
        this.alt = alt;
    }
    public NodeAVL<T> getLeft() {
        return left;
    }
    public void setLeft(NodeAVL<T> left) {
        this.left = left;
    }
    public NodeAVL<T> getRight() {
        return right;
    }
    public void setRight(NodeAVL<T> right) {
        this.right = right;
    }
    public NodeAVL<T> getFather() {
        return father;
    }
    public void setFather(NodeAVL<T> father) {
        this.father = father;
    }
}
