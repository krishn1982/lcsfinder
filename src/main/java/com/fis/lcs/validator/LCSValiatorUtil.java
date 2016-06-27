package com.fis.lcs.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fis.lcs.json.Payload;
import com.fis.lcs.json.SetOfString;

public class LCSValiatorUtil {
	
	public static boolean validateIfPayloadIsEmpty(Payload payload){
		List<SetOfString> values = payload.getSetOfStrings();
		if (values.isEmpty()) {			
			return true;
		}
		
		return false;
		
	
	}
	
	public static boolean validateIfPayloadIsUnique(Payload payload){
		Set<String> valueSet = new HashSet<String>();
		boolean isUnique = true;
		for (SetOfString value : payload.getSetOfStrings()) {
			isUnique = valueSet.add(value.getValue());
			if (!isUnique) {				
				return false;

			}

		}
		
		return true;
	}

}
