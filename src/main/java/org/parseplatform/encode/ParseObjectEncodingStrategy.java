package org.parseplatform.encode;

import org.json.JSONObject;
import org.parseplatform.ParseObject;

public interface ParseObjectEncodingStrategy {
	
	public abstract JSONObject encodeRelatedObject(ParseObject parseObject);

}
