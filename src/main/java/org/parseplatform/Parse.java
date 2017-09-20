package org.parseplatform;

import org.json.JSONArray;
import org.json.JSONObject;
import org.parseplatform.operation.ParseFieldOperations;
import org.parseplatform.util.ParseRegistry;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Parse {

	private static String mApplicationId;
	private static String mRestAPIKey;
	private static String mMasterKey;
	private static final DateFormat dateFormat;
	private static boolean isRootMode;
	private static String sServerPath;
	private static boolean bCustomServer;

	static {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		format.setTimeZone(new SimpleTimeZone(0, "GMT"));
		dateFormat = format;
		ParseRegistry.registerDefaultSubClasses();
		ParseFieldOperations.registerDefaultDecoders();
	}

	static public void initialize(String applicationId, String restAPIKey) {
		mApplicationId = applicationId;
		mRestAPIKey = restAPIKey;
		isRootMode = false;
		bCustomServer = false;
	}

	static public void initialize(String applicationId, String restAPIKey, String serverPath) {
		mApplicationId = applicationId;
		mRestAPIKey = restAPIKey;
		isRootMode = false;
		sServerPath = serverPath;
		bCustomServer = true;
	}

	/**
	 * Don't use it in client app! Use it only if know what you are doing.
	 * If someone get your master key he can bypass all of your app's security!
	 *
	 * @param applicationId your app id
	 * @param masterKey your master key
	 */
	static public void initializeAsRoot (String applicationId, String masterKey) {
		mApplicationId = applicationId;
		mMasterKey = masterKey;
		isRootMode = true;
	}

	static public String getApplicationId() {
		return mApplicationId;
	}

	static public String getRestAPIKey() {
		return mRestAPIKey;
	}

	public static boolean isIsRootMode() {
		return isRootMode;
	}

	static public String getParseAPIUrl(String context) {
		if(bCustomServer){
			return sServerPath + "/" + context;
		}else{
			return ParseConstants.API_ENDPOINT + "/" + ParseConstants.API_VERSION
					+ "/" + context;
		}
	}

	public static synchronized String encodeDate(Date date) {
		return dateFormat.format(date);
	}

	public static synchronized Date parseDate(String dateString) {
		try {
			return dateFormat.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String getMasterKey() {
		return mMasterKey;
	}

	public static boolean isInvalidKey(String key) {
		return "objectId".equals(key) || "createdAt".equals(key)
				|| "updatedAt".equals(key);
	}

	public static boolean isValidType(Object value) {
		return ((value instanceof JSONObject))
				|| ((value instanceof JSONArray))
				|| ((value instanceof String))
				|| ((value instanceof Number))
				|| ((value instanceof Boolean))
				|| (value == JSONObject.NULL)
				|| ((value instanceof ParseObject))
				// || ((value instanceof ParseACL))
				|| ((value instanceof ParseFile))
				|| ((value instanceof ParseRelation))
				|| ((value instanceof ParseGeoPoint))
				|| ((value instanceof Date))
				|| ((value instanceof byte[]))
				|| ((value instanceof List))
				|| ((value instanceof Map));
	}

	@SuppressWarnings("rawtypes")
	public static String join(Collection<String> items, String delimiter) {
		StringBuffer buffer = new StringBuffer();
		Iterator iter = items.iterator();
		if (iter.hasNext()) {
			buffer.append((String) iter.next());
			while (iter.hasNext()) {
				buffer.append(delimiter);
				buffer.append((String) iter.next());
			}
		}
		return buffer.toString();
	}


}
