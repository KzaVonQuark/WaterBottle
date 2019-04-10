package waterbottle;

public class BottleSequence {

	private int[] sequence;
	private int finalVolumeSmallBottle;
	private int finalVolumeLargeBottle;
	
	public BottleSequence(int ... sequence) {
		this.sequence = sequence;
	}

	@Override
	public String toString() {
		String strSequence = "The Small Bottle holds: " + finalVolumeSmallBottle + "L\n"
				+ "The Large Bottle holds: " + finalVolumeLargeBottle + "L\n";
		strSequence += "This sequence:\n";
		strSequence = appendStep(strSequence);
		return strSequence + "Total number of steps: " + sequence.length;
	}

	/**
	 * Will append the sequence step to the given string.
	 */
	private String appendStep(String strSequence) {
		for (Integer operation : sequence) {
			switch (operation) {
			case 1:
				strSequence += "Fill the small bottle\n";
				break;
				
			case 2:
				strSequence += "Fill the large bottle\n";
				break;
				
			case 3:
				strSequence += "Pour the small bottle into the large bottle\n";
				break;
				
			case 4:
				strSequence += "Pour the large bottle into the small bottle\n";
				break;
				
			case 5:
				strSequence  += "Empty the small bottle\n";
				break;
				
			case 6:
				strSequence  += "Empty the large bottle\n";
				break;

			default:
				break;
			}
		}
		return strSequence;
	}

	/**
	 * @return the sequence
	 */
	public int[] getSequence() {
		return sequence;
	}

	/**
	 * @param smallVolume the volume in the small bottle at the end of the sequence.
	 */
	public void setFinalVolumeSmallBottle(int smallVolume) {
		this.finalVolumeSmallBottle = smallVolume;
	}

	/**
	 * @param largeVolume the volume in the large bottle at the end of the sequence.
	 */
	public void setFinalVolumeLargeBottle(int largeVolume) {
		this.finalVolumeLargeBottle = largeVolume;
	}

	/**
	 * @return the finalVolumeSmallBottle
	 */
	public int getFinalVolumeSmallBottle() {
		return finalVolumeSmallBottle;
	}

	/**
	 * @return the finalVolumeLargeBottle
	 */
	public int getFinalVolumeLargeBottle() {
		return finalVolumeLargeBottle;
	}
	
	
}
