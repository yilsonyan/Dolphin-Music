package cn.yan;


import lombok.Data;

@Data

public class WebPage {

	public enum PageType {
		song, playlist, playlists;
	}

	public enum Status {
		crawled, uncrawl;
	}

	private String url;
	private String title;
	private PageType type;
	private Status status;
	private String html;

	public WebPage(String url, PageType type) {
		this.url = url;
		this.type = type;
	}


	public WebPage(String url, PageType type, String html) {
		this.url = url;
		this.type = type;
		this.html = html;
	}
}
