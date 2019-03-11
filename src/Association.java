public class Association<K,V> 
{
	protected K theKey; // the key of the key-value pair
	protected V theValue; // the value of the key-value pair
	
	public Association(K key, V value) {
		theKey = key;
		theValue = value;
	}
	// pre: key is non-null
	// post: constructs a key-value pair
	public V getValue() {
		return theValue;
	}
	// post: returns value from association
	public K getKey() {
		return theKey;
	}
	// post: returns key from association
	public V setValue(V value) {
		V oldValue = theValue;
		theValue = value;
		return oldValue;
	}
	// post: sets association's value to value
	public int compareTo(K key) {
		return ((String) key).toUpperCase().compareTo( ((String) theKey).toUpperCase() );
	}
}