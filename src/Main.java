import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		String texto = "";
		//Scanner input = new Scanner(System.in);
		
        /* Leer archivos */
		File file = new File("diccionario.txt");
        Scanner scanner = new Scanner(file);
        if(scanner.hasNextLine()) {
        	/* Leer diccionario */
        	String[] palabras = scanner.nextLine().split(",");
        	BinaryTree<String> diccionario = new BinaryTree<String>(palabras[0].trim(),palabras[1].trim());
        	while (scanner.hasNextLine()){
	            palabras = scanner.nextLine().split(",");
	        	diccionario.put(palabras[0].trim(),palabras[1].trim());
	        }
	        scanner.close();
	        
	        /* Leer texto */
	        file = new File("texto.txt");
	        scanner = new Scanner(file);
	        while (scanner.hasNextLine()){
	        	texto += scanner.nextLine() + "\n";
	        }
	        texto = texto.substring(0, texto.length() - 1);
	        scanner.close();
	        
	        /* Limpiar texto*/
	        texto = texto.replace(".", " . ");
	        texto = texto.replace(",", " , ");
	        texto = texto.replace("(", " ( ");
	        texto = texto.replace(")", " ) ");
	        
	        /* Traducir */
	        String[] words = texto.split(" ");
	        String traduccion = "";
	        for(int i = 0; i < words.length; i++) {
	        	if(words[i] != null) {
	        		if(words[i].chars().allMatch(Character::isLetter)) {
	        			Object palabra = diccionario.get(words[i]);
			        	if(palabra != null) {
			        		traduccion += palabra + " ";
			        	}
			        	else {
			        		traduccion += "*" + words[i] + "* ";
			        	}
		        	}
	        		else {
	        			traduccion += words[i];
	        		}
	        	}
	        }
	        
	        /* Limpiar traduccion de regreso*/
	        traduccion = traduccion.replace(" .", ".");
	        traduccion = traduccion.replace(" ,", ",");
	        traduccion = traduccion.replace(" (", "(");
	        traduccion = traduccion.replace(" )", ")");
	        
	        /* Mostrar resultado*/
	        System.out.println("Texto Original: \n" + texto);
	        System.out.println("\nTraduccion: \n" + traduccion);
	        System.out.println("\nDiccionario ordenado:");
	        diccionario.InOrder();
        }
        else {
        	System.out.println("El diccionario esta vacio.");
        	scanner.close();
        }
	}
}