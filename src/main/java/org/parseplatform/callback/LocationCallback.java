package org.parseplatform.callback;

import org.parseplatform.ParseException;
import org.parseplatform.ParseGeoPoint;

public abstract class LocationCallback extends ParseCallback<ParseGeoPoint> {

	abstract void done(ParseGeoPoint parseGeoPoint, ParseException parseException);

	@Override
	void internalDone(ParseGeoPoint parseGeoPoint, ParseException parseException) {
		done(parseGeoPoint, parseException);
	}
	
}
