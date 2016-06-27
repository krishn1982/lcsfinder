package com.fis.lcs.validator;

import java.util.List;

import com.fis.lcs.json.Error;
import com.fis.lcs.json.Payload;

public interface Validator {

	public List<Error> validate(Payload body);
}
