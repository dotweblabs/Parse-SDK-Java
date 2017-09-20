package org.parseplatform.command;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpRequestBase;
import org.parseplatform.Parse;

public class ParseDeleteCommand extends ParseCommand {

	private String endPoint;
	private String objectId;

	public ParseDeleteCommand(String endPoint, String objectId) {
		this.endPoint = endPoint;
		this.objectId = objectId;
	}

	public ParseDeleteCommand(String endPoint) {
		this.endPoint = endPoint;
	}

	@Override
	public HttpRequestBase getRequest() {
		String url = Parse.getParseAPIUrl(endPoint)
				+ (objectId != null ? "/" + objectId : "");
		HttpDelete httpdelete = new HttpDelete(url);
		setupHeaders(httpdelete, false);
		return httpdelete;
	}

}
