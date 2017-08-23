import java.util.*;

/**
 * Resizabel vector (array) implementation
 */
public class RVector<T> {
	private Object[] array;
	private int size;
	private int maxSize;

	public RVector(int initSize) {
		size = 0;
		maxSize = initSize;
		array = new Object[maxSize];
	}

	public RVector() {
		this(10); // default initial max size as 10
	}

	/**
	 * get the size of the vector (number of elements)
	 * @return the size of the vector
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Check if the array is empty
	 * @return true if the array is empty and false otherwise
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * Append an element to the end of the array
	 * @param value the value we want to append
	 */
	public void add(T value) {
		if(this.size >= maxSize) {
			this.resize();
		}

		array[size++] = value;
	}

	/**
	 * Add element at index i into the array
	 * @param value the value we want to add
	 * @param index the index we want to insert into
	 */
	public void add(T value, int index)  throws Exception{
		checkIndex(index);
		if(this.size >= maxSize) {
			this.resizeAndAdd(value, index);
			return;
		}

		for(int i = size++; i > index; --i) {
			array[i] = array[i-1];
		}

		array[index] = value;
	}

	/**
	 * Resize the array and add an element at the given index
	 * Note : we can resize the whole array then call add at index again 
	 * 		  but this is a bit faster if we want to insert into the beginning or the middle 
	 * @param value the value we want to add
	 * @param index the index we want to insert into 
	 */
	private void resizeAndAdd(T value, int index) {
		maxSize <<= 1;
		Object[] newArray = new Object[maxSize];
		for(int i = 0; i < index; ++i) {
			newArray[i] = array[i];
		} 

		newArray[index] = value;

		for(int i = index + 1; i <= size; ++i) {
			newArray[i] = array[i - 1];
		}

		array = newArray;
	}

	public T get(int index) throws Exception {
		checkIndex(index);

		return (T) this.array[index];
	}

	/**
	 * clear the array (remove all elements and set Size to 0)
	 */
	public void clear() {
		this.maxSize = 10;
		this.size = 0;
		this.array = new Object[maxSize];
	}

	public void removeAtIndex(int index) throws Exception{
		checkIndex(index);
		for(int i = index; i < size - 1; ++i) {
			array[i] = array[i + 1];
		}


		array[--size] = null;
	}

	/**
	 * remove the element given as param
	 * @param  element the element we want to delete
	 * @return true if the element has been deleted (exists) false otherwise
	 */
	public boolean remove(T element) {
		
		for(int i = 0; i < size; ++i) {
			if(array[i].equals(element)) { 
				try {
					this.removeAtIndex(i);
					return true;
				}catch(Exception e) {
					return false;
				}
			}
		}

		return false; // element not existing
	}

	public boolean exisits(T element) {
		for(int i = 0; i < size; ++i) {
			if(array[i].equals(element)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Resize the array and copy the existing elements into the new Array
	 * The new maxSize is twice the current maxSize;
	 */
	private void resize() {
		maxSize <<= 1;
		Object[] newArray = new Object[maxSize];
		for(int i = 0; i < size; ++i) {
			newArray[i] = array[i];
		}

		array = newArray;
	}

	private void checkIndex(int index) throws Exception {
		if(index < 0 || index >= size)
			throw new Exception("INDEX OUT BOUNDARY");
	}

}
