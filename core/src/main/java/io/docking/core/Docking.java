package io.docking.core;

/**
 * 
 * @author sascha
 *
 */
public class Docking {

	private WagonBatch destinationBatch;
	private WagonBatch sourceBatch;
	private int sourceBatchIndex;

	public Docking(WagonBatch destinationBatch, WagonBatch sourceBatch,
			int sourceBatchIndex) {
		this.destinationBatch = destinationBatch;
		this.sourceBatch = sourceBatch;
		this.sourceBatchIndex = sourceBatchIndex;
	}

	public WagonBatch getDestinationBatch() {
		return destinationBatch;
	}

	public void setDestinationBatch(WagonBatch destinationBatch) {
		this.destinationBatch = destinationBatch;
	}

	public WagonBatch getSourceBatch() {
		return sourceBatch;
	}

	public void setSourceBatch(WagonBatch sourceBatch) {
		this.sourceBatch = sourceBatch;
	}

	public int getSourceBatchIndex() {
		return sourceBatchIndex;
	}

	public void setSourceBatchIndex(int sourceBatchIndex) {
		this.sourceBatchIndex = sourceBatchIndex;
	}

	@Override
	public String toString() {
		return "";
	}

}
