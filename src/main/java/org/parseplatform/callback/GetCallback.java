package org.parseplatform.callback;

import org.parseplatform.ParseException;
import org.parseplatform.ParseObject;

public abstract class GetCallback<T extends ParseObject> extends ParseCallback<T> {

    public abstract void done(T t, ParseException parseException);
	
	@Override
	void internalDone(T t, ParseException parseException) {
		done(t, parseException);
	}
	
}
