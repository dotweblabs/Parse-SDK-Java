package org.parseplatform.callback;

import java.util.List;

import org.parseplatform.ParseException;
import org.parseplatform.ParseObject;

public abstract class FindCallback<T extends ParseObject> extends ParseCallback<List<T>> {

	public abstract void done(List<T> list, ParseException parseException);
	
	@Override
	void internalDone(List<T> list, ParseException parseException) {
		done(list, parseException);
	}
	
}
