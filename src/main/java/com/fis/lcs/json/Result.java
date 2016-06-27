package com.fis.lcs.json;

import java.util.ArrayList;
import java.util.List;


public class Result {

	
	private List<Lc> lcs = new ArrayList<Lc>();

	/**
	 * 
	 * @return The lcs
	 */
	public List<Lc> getLcs() {
		return lcs;
	}

	/**
	 * 
	 * @param lcs
	 *            The lcs
	 */
	public void setLcs(List<Lc> lcs) {
		this.lcs = lcs;
	}

}
