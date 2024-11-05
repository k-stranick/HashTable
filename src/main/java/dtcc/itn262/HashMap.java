package dtcc.itn262;

/**
 * A simple hash map implementation that uses a simple hash function to store key/value pairs
 * in an array of Entry objects. Collisions are handled by skipping the insertion of duplicate keys.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class HashMap<K extends Comparable<K>, V> implements Map<K, V> {

	private static final int SIZE = 10007; // Choose a prime number for better distribution
	private final Entry<K, V>[] hashTable;
	private int collisions = 0;

	/**
	 * Constructs a new, empty HashMap with a default size of 10007
	 */
	@SuppressWarnings("unchecked")
	public HashMap() {
		hashTable = new Entry[SIZE];
	}

	/**
	 * A simple hash function that sums the ASCII values of the characters in the key
	 * and returns the sum modulo the size of the hash table
	 *
	 * @param key the key to hash
	 * @return the hash value
	 */
	private int simpleHashFunction(K key) {
		String keyString = key.toString();
		int hash = 0;
		for (char c : keyString.toCharArray()) {
			hash += c;
		}
		return hash % SIZE;
	}

	/**
	 * Returns the value to which the specified key is mapped,
	 * or {@code null} if this map contains no mapping for the key.
	 *
	 * @param key the key whose associated value is to be returned
	 * @return the value to which the specified key is mapped, or
	 * {@code null} if this map contains no mapping for the key
	 */
	@Override
	public V get(K key) {
		int index = simpleHashFunction(key);
		if (hashTable[index] != null && hashTable[index].getKey().equals(key)) {
			return hashTable[index].getValue();
		}
		return null;
	}

	public void displayHashTable() {
		System.out.println("Hash Table Contents (Non-empty indices):");
		for (int i = 0; i < SIZE; i++) {
			if (hashTable[i] != null) {
				System.out.println("Index " + i + ": " + hashTable[i].getKey() + " -> " + hashTable[i].getValue());
			}
		}
	}

	/**
	 * Associates the specified value with the specified key in this map
	 * If the map previously contained a mapping for
	 * the key, the old value is replaced by the specified value.
	 *
	 * @param key   key with which the specified value is to be associated
	 * @param value value to be associated with the specified key
	 */
	@Override
	public V put(K key, V value) {
		int index = simpleHashFunction(key);
		if (hashTable[index] != null) {
			collisions++;
			return null; // Collision, do not insert duplicate key
		}
		hashTable[index] = new Entry<>(key, value);
		return value;
	}

	/**
	 * Returns the number of collisions that have taken place while attempting
	 * to insert key/value mappings
	 *
	 * @return the number of collisions that have occurred
	 */
	@Override
	public int getCollisions() {
		return collisions;
	}



	private static class Entry<K, V> {
		private final K key;
		private final V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}
	}




}

