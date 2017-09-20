package org.parseplatform.callback;

import org.parseplatform.ParseException;

public abstract class FunctionCallback<T> extends ParseCallback<T> {

    public abstract void done(T result, ParseException parseException);
	
	@Override
	void internalDone(T result, ParseException parseException) {
		done(result, parseException);
	}
	
}
