package com.fis.lcs.json;

import java.util.ArrayList;
import java.util.List;

public class Payload {

	private List<SetOfString> setOfStrings = new ArrayList<SetOfString>();

	/**
	 * 
	 * @return The setOfStrings
	 */
	public List<SetOfString> getSetOfStrings() {
		return setOfStrings;
	}

	/**
	 * 
	 * @param setOfStrings
	 *            The setOfStrings
	 */
	public void setSetOfStrings(List<SetOfString> setOfStrings) {
		this.setOfStrings = setOfStrings;
	}

}
