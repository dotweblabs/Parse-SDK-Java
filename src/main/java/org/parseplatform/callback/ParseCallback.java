package org.parseplatform.callback;

import org.parseplatform.ParseException;

public abstract class ParseCallback<T> {
	
	abstract void internalDone(T paramT, ParseException parseException);
	
}
