package br.com.gopromos.android.graphapi.dtos;

public class FacebookPaging {
	private final FacebookCursor cursors;

	public FacebookPaging(FacebookCursor cursors) {
		this.cursors = cursors;
	}

	public FacebookCursor getCursors() {
		return cursors;
	}
}
