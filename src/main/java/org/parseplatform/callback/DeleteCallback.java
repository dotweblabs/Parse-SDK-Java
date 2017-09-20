package org.parseplatform.callback;

import org.parseplatform.ParseException;

public abstract class DeleteCallback extends ParseCallback<Void> {
	
	public abstract void done(ParseException parseException);
	
	@Override
	void internalDone(Void paramT, ParseException parseException) {
		done(parseException);
	}

}