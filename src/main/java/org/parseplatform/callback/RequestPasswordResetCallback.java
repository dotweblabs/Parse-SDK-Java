package org.parseplatform.callback;

import org.parseplatform.ParseException;

public abstract class RequestPasswordResetCallback extends ParseCallback<Void> {

	public abstract void done(ParseException parseException);

	final void internalDone(Void paramVoid, ParseException parseException) {
		done(parseException);
	}

}
