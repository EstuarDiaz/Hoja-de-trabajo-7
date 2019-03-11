import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinaryTreeTest {
	@Test
	void testGet() {
		BinaryTree<String> diccionario = new BinaryTree<String>("A","root");
		assertEquals(diccionario.get("A"),"root");
	}
	
	@Test
	void testPut() {
		BinaryTree<String> diccionario = new BinaryTree<String>("A","root");
		diccionario.put("B", "prueba");
		assertEquals(diccionario.get("B"),"prueba");
	}
}
