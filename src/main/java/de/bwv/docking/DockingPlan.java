package de.bwv.docking;

import java.util.List;

/**
 * 
 * @author ormanns_sas
 *
 */
public class DockingPlan {

	private List<Docking> dockings;

	public DockingPlan(List<Docking> dockings) {
		this.dockings = dockings;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Docking docking: dockings) {
			stringBuilder.append(docking);
		}
		return stringBuilder.toString();
	}

	public List<Docking> getDockings() {
		return dockings;
	}

	public void setDockings(List<Docking> dockings) {
		this.dockings = dockings;
	}

}
