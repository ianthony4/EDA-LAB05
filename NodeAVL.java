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
}
