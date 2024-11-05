package dtcc.itn262;

public class HashMap<K extends Comparable<K>, V> implements Map<K, V> {

	private static final int SIZE = 10007; // Choose a prime number for better distribution
	private final Entry<K, V>[] table;
	private int collisions = 0;

	@SuppressWarnings("unchecked")
	public HashMap() {
		table = new Entry[SIZE];
	}

	private int hash(K key) {
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
		int index = hash(key);
		if (table[index] != null && table[index].getKey().equals(key)) {
			return table[index].getValue();
		}
		return null;
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
		int index = hash(key);
		if (table[index] != null) {
			collisions++;
			return null; // Collision, do not insert duplicate key
		}
		table[index] = new Entry<>(key, value);
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

	public void displayHashTable() {
		System.out.println("Hash Table Contents (Non-empty indices):");
		for (int i = 0; i < SIZE; i++) {
			if (table[i] != null) {
				System.out.println("Index " + i + ": " + table[i].getKey() + " -> " + table[i].getValue());
			}
		}
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

