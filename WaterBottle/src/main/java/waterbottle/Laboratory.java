package waterbottle;

public class Laboratory {
	
	/**
	 * 1 = Fill 3L Bottle
	 * 2 = Fill 5L Bottle
	 * 3 = Pour 3L Bottle into 5L Bottle
	 * 4 = Pour 5L Bottle into 3L Bottle
	 * 5 = Empty 3L Bottle
	 * 6 = Empty 5L Bottle
	 */
	private static final int OPERATIONS = 6;
	
	private Bottle smallBottle;
	private Bottle largeBottle;
	private int targetVolume;
	private BottleSequence winner;
	private boolean weHaveAWinner;

	public Laboratory(Bottle smallBottle, Bottle largeBottle, int targetVolume) {
		this.smallBottle = smallBottle;
		this.largeBottle = largeBottle;
		this.targetVolume = targetVolume;
	}

	/**
	 * Start the generation of sequences, to find the target volume. 
	 */
	public BottleSequence findTargetVolume() {
		int[] emptySequence;
		int steps = 1;
		do {
			emptySequence = new int[steps];
			//Initializing the generate sequence method every time number of steps increase.
			generateSequence(emptySequence, steps, 0);
			steps++;
		} while (!doWeHaveAWinner());
		return winner;
	}
	
	/**
	 * Will generate and call runSequence() on all possible sequences, of the current array length.
	 * @param sequence
	 * @param steps
	 * @param index
	 */
	public void generateSequence(int[] sequence, int steps, int index) {
		if (steps == 0) {
			runSequence(sequence);
			if(weHaveAWinner && winner == null) {
				winner = new BottleSequence(sequence.clone());
				winner.setFinalVolumeSmallBottle(smallBottle.getVolume());
				winner.setFinalVolumeLargeBottle(largeBottle.getVolume());
			}
		}
		
		if (steps > 0) {
			for (int i = 1; i <= OPERATIONS; ++i) {
				sequence[index] = i;
				generateSequence(sequence, steps - 1, index + 1);
			}
		}
	}
	
	/**
	 * Runs the sequence and if any bottle meet the target volume "we have a winner" set to true
	 * @param sequence
	 */
	public void runSequence(int ...sequence) {
	smallBottle.emptyBottle();
	largeBottle.emptyBottle();

	for (Integer operation : sequence) {
		switch (operation) {
		case 1:
			smallBottle.fill();
			break;

		case 2:
			largeBottle.fill();
			break;

		case 3:
			transfer(smallBottle, largeBottle);
			break;

		case 4:
			transfer(largeBottle, smallBottle);
			break;

		case 5:
			smallBottle.emptyBottle();
			break;

		case 6:
			largeBottle.emptyBottle();
			break;

		default:
			break;
		}
	}
	
	if(smallBottle.getVolume() == targetVolume || largeBottle.getVolume() == targetVolume) {
		weHaveAWinner = true;
	}
}
	
	public void transfer(Bottle from, Bottle to) {
		
		int availableVolume = to.getSize() - to.getVolume();
		int volumeToTransfer = 0;
		
		if (availableVolume > from.getVolume()) {
			volumeToTransfer = from.getVolume();
			from.setVolume(0);
		} else {
			volumeToTransfer = availableVolume;
			from.setVolume(from.getVolume() - volumeToTransfer);
		}
		
		to.setVolume(to.getVolume() + volumeToTransfer);
	}
	
	/**
	 * @return the weHaveAWinner
	 */
	public boolean doWeHaveAWinner() {
		return weHaveAWinner;
	}

	/**
	 * @return the smallBottle
	 */
	public Bottle getSmallBottle() {
		return smallBottle;
	}

	/**
	 * @return the largeBottle
	 */
	public Bottle getLargeBottle() {
		return largeBottle;
	}

	/**
	 * @param targetVolume the targetVolume to set
	 */
	public void setTargetVolume(int targetVolume) {
		this.targetVolume = targetVolume;
	}
}
