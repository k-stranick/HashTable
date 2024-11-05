package dtcc.itn262;

public interface Map<K extends Comparable<K>, V> {
	/**
	 * Returns the value to which the specified key is mapped,
	 * or {@code null} if this map contains no mapping for the key.
	 *
	 * @param key the key whose associated value is to be returned
	 * @return the value to which the specified key is mapped, or
	 *         {@code null} if this map contains no mapping for the key
	 */
	public V get(K key);


	/**
	 * Associates the specified value with the specified key in this map
	 * If the map previously contained a mapping for
	 * the key, the old value is replaced by the specified value.
	 *
	 * @param key key with which the specified value is to be associated
	 * @param value value to be associated with the specified key
	 */
	public V put(K key, V value);

	/**
	 * Returns the number of collisions that have taken place while attempting
	 * to insert key/value mappings
	 *
	 * @return the number of collisions that have occurred
	 */
	public int getCollisions();
}