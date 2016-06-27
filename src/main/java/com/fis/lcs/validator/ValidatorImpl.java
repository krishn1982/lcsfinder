package com.fis.lcs.validator;

import java.util.ArrayList;
import java.util.List;

import com.fis.lcs.json.Error;
import com.fis.lcs.json.Payload;

public class ValidatorImpl implements Validator{

	public List<Error> validate(Payload body) {
		List<Error> errors = new ArrayList<Error>();
		if (LCSValiatorUtil.validateIfPayloadIsEmpty(body)) {
			errors.add(Error.EMPTY_PAYLOAD);
		}

		if (!LCSValiatorUtil.validateIfPayloadIsUnique(body)) {			
			errors.add(Error.DUPLICATE_PAYLOAD);
		}

		return errors;
	}

}
