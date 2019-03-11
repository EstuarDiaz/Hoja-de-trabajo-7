/*
 * Clase implementada por Steve Claridge.
 * Modificada por Estuardo Diaz
 */
public class BinaryTree<E>
{
    private Association<E,E> node;
    private BinaryTree<E> left, right;

    public BinaryTree( E key, E value ){
        this.node = new Association<E,E>(key,value);
    }

    //if key not found in BST then it is added. If jey already exists then that node's value
    //is updated.
    public void put( E key, E value ){
        if ( this.node.compareTo(key) < 0 ){
            if ( left != null ){                 
                left.put( key, value );             
            }             
            else{                 
            	left = new BinaryTree<E>( key, value );             
            }         
        }         
        else if ( this.node.compareTo(key) > 0 ){
            if ( right != null ){
                right.put( key, value );
            }
            else{
                right = new BinaryTree<E>( key, value );
            }
        }
        else{
            //update this one
            this.node.setValue(value);
        }
    }

    //find Node with given key and return it's value
    public E get( E key ){
        if ( this.node.compareTo(key) == 0){
            return this.node.getValue();
        }
        if ( this.node.compareTo(key) < 0 ){
            return left == null ? null : left.get( key );
        }
        else{
            return right == null ? null : right.get( key );
        }
    }
    
    public Boolean isKey(E key) {
    	return this.get(key) != null;
    }
    
	public void InOrder() {
		if(this.left != null) this.left.InOrder();
	   	 System.out.println("(" + this.node.getKey() + ", " + this.node.getValue() + ")");
	   	if(this.right != null) this.right.InOrder();
    }
}