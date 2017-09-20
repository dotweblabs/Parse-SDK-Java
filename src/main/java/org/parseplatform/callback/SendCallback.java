package org.parseplatform.callback;

import org.parseplatform.ParseException;

public abstract class SendCallback extends ParseCallback<Void> {
	
	abstract void done(ParseException parseException);
	
	@Override
	void internalDone(Void paramT, ParseException parseException) {
		done(parseException);
	}

}
