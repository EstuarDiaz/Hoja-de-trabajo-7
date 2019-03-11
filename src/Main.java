import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
        /* Leer diccionario */
		File file = new File("diccionario.txt");
        Scanner scanner = new Scanner(file);
        System.out.println("Diccionario:");
        int n = 0;
        BSTNode diccionario = new BSTNode("middle","mitad");
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] palabras = line.split(",");
        	System.out.println("[" + Integer.toString(++n) + "]: " + line);
        	diccionario.put(palabras[0],palabras[1]);
        }
        scanner.close();
        /* Leer texto */
        n = 0;
        System.out.println("\nResultado:");
        diccionario.printData();
	}
}