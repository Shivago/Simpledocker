package io.docking.core;

/**
 *
 * A simple Docking step providing informations. If destinationBatch or
 * sourceBatch null it means the source or destination is the bufferrail.
 *
 * @author Jean-Philippe Quéméner
 *
 */
public class Docking {

	private final WagonBatch destinationBatch;
	private final WagonBatch sourceBatch;
	private final int sourceBatchIndex;

	/**
     * @param destinationBatch - batch to append the sliced part
     * @param sourceBatch - batch to slice from
     * @param sourceBatchIndex - index for the slice
	 */
	public Docking(WagonBatch destinationBatch, WagonBatch sourceBatch,
			int sourceBatchIndex) {
		this.destinationBatch = destinationBatch;
		this.sourceBatch = sourceBatch;
		this.sourceBatchIndex = sourceBatchIndex;
	}

	public WagonBatch getDestinationBatch() {
		return destinationBatch;
	}

	public WagonBatch getSourceBatch() {
		return sourceBatch;
	}

	public int getSourceBatchIndex() {
		return sourceBatchIndex;
	}

	@Override
	public String toString() {
		return "Slice " + sourceBatch + " at index " + sourceBatchIndex +
			" and append to " + destinationBatch;
	}

}
