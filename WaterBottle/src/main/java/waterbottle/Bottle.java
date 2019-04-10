package waterbottle;

public class Bottle {
	
	private int size;
	private int volume;

	/**
	 * Create a new bottle, where size is the maximum volume the bottle can hold.
	 * @param size - int
	 */
	public Bottle(int size) {
		this.size = size;
	}

	/**
	 * Completly fills the bottle from the endless bath tub.
	 * Sets volume equal to size.
	 */
	public void fill() {
		volume = size;
	}
	
	public boolean isFull() {
		return volume == size;
	}
	
	public boolean isEmpty() {
		return volume == 0;
	}

	public void emptyBottle() {
		volume = 0;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @return the volume
	 */
	public int getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Bottle " + size + "L currently holds " + volume + "L of water";
	}

}
