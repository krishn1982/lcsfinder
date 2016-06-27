package com.fis.lcs.core;

import java.util.List;

import com.googlecode.concurrenttrees.radix.node.concrete.DefaultCharSequenceNodeFactory;
import com.googlecode.concurrenttrees.solver.LCSubstringSolver;

public class LcsCalculatorImpl implements LcsCalculator{
	LCSubstringSolver solver; 

	public LCSubstringSolver getSolver() {
		return solver;
	}

	public LcsCalculatorImpl() {
		super();
		this.solver = new LCSubstringSolver(new DefaultCharSequenceNodeFactory());;
	}

	public String getLongestCommonSubstring(List<String> values) {
		for (String value : values) {			
			solver.add(value);
		}
		return solver.getLongestCommonSubstring().toString();
	}

}
