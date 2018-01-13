package br.com.gopromos.android.graphapi.dtos;

public class FacebookPicture {
	private String id;
	private String picture;
	private FacebookPictureUrl data;

	public FacebookPictureUrl getData() {
		return data;
	}

	public String getId() {
		return id;
	}

	public String getPicture() {
		return picture;
	}
}
