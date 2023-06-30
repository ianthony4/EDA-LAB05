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
    }
}
