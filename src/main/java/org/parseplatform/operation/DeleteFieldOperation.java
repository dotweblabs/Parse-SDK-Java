package org.parseplatform.operation;

import org.json.JSONException;
import org.json.JSONObject;
import org.parseplatform.ParseObject;
import org.parseplatform.encode.ParseObjectEncodingStrategy;

public class DeleteFieldOperation implements ParseFieldOperation {

	@Override
	public Object apply(Object oldValue, ParseObject paramParseObject, String key) {
		return null;
	}

	@Override
	public Object encode(ParseObjectEncodingStrategy objectEncoder)
			throws JSONException {
		JSONObject output = new JSONObject();
	    output.put("__op", "Delete");
	    return output;
	}

}
