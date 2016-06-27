package com.fis.lcs.core;

import java.util.ArrayList;
import java.util.List;

import com.fis.lcs.json.SetOfString;

public class LcsServiceImpl implements LcsService{
	private LcsCalculator lcsCalculator;
	
	public void setLcsCalculator(LcsCalculator lcsCalculator) {
		this.lcsCalculator = lcsCalculator;
	}

	

	public LcsCalculator getLcsCalculator() {
		return lcsCalculator;
	}


	public String getLongestCommonSubstring(List<SetOfString> values) {
		List<String> stringList = new ArrayList<String>();
		for(SetOfString str : values){
			stringList.add(str.getValue());
		}
		return lcsCalculator.getLongestCommonSubstring(stringList);
	}

}
