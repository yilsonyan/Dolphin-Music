package cn.yan;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CrawlerThread {

	static final String BASE_URL = "http://music.163.com/#/discover/playlist/?order=hot&cat=%E5%85%A8%E9%83%A8&limit=35&offset=0";

	/**
	 * 获取html
	 */
	private boolean fetchHtml(WebPage webPage) throws IOException {
		Connection.Response response = Jsoup.connect(webPage.getUrl()).timeout(3000).execute();
		String body = response.body();
		webPage.setHtml(body);
		return response.statusCode() / 100 == 2 ? true : false;
	}
	public static void main1(String[] args) throws Exception {
		WebPage playlists = new WebPage(BASE_URL, WebPage.PageType.playlists);
		CrawlerThread crawlerThread = new CrawlerThread();
		crawlerThread.fetchHtml(playlists);
		System.out.println(playlists.getHtml());
	}


	/**
	 * 解析歌单列表页面
	 */
	public List<WebPage> parsePlaylist(WebPage webPage) {
		Elements songs = Jsoup.parse(webPage.getHtml()).select("ul.f-hide li a");
		return songs.stream().map(e -> new WebPage(BASE_URL + e.attr("href"), WebPage.PageType.song, e.html())).collect(Collectors.toList());
	}

	public static void main2(String[] args) throws Exception {
		WebPage playlists = new WebPage("http://music.163.com/discover/playlist/?order=hot&cat=%E5%85%A8%E9%83%A8&limit=35&offset=0", WebPage.PageType.playlists);
		CrawlerThread crawlerThread = new CrawlerThread();
		crawlerThread.fetchHtml(playlists);
		List<WebPage> webPages = crawlerThread.parsePlaylist(playlists);
		System.out.println(webPages);
	}



	private Song parseSong(WebPage webPage) throws Exception {
		//getCommentCount(webPage.getUrl().split("=")[1]);
		return new Song(webPage.getUrl(), webPage.getTitle(), 0L);
	}

	public static void main(String[] args) throws Exception {
		WebPage song = new WebPage("http://music.163.com/song?id=29999506", WebPage.PageType.song, "test");
		CrawlerThread crawlerThread = new CrawlerThread();
		crawlerThread.fetchHtml(song);
		System.out.println(crawlerThread.parseSong(song));
	}




}
