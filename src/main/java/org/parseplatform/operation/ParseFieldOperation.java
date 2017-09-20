package org.parseplatform.operation;

import org.json.JSONException;
import org.parseplatform.ParseObject;
import org.parseplatform.encode.ParseObjectEncodingStrategy;

public interface ParseFieldOperation {
	
	abstract Object apply(Object oldValue, ParseObject parseObject, String key);
	
	abstract Object encode(ParseObjectEncodingStrategy objectEncoder) throws JSONException;

}
