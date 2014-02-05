package utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.BreakingNew;

public class NewsParser {
	
	private static String  URL="http://news247.gr/eidiseis/oikonomia/";
	private static int NUM_OF_NEWS=5;
	
	public static List<BreakingNew> getBreakingNews(){
		try {
			Document doc = Jsoup.connect(URL).get();
			Element content = doc.getElementById("section-stories-container");
			List<String> images = getImages(content);
			List<String> titles = getTitles(content);
			List<String> subtitles = getSubTitles(content);
			List<String> urls = getUrls(content);
			List<BreakingNew> news = new ArrayList<BreakingNew>();
			for(int i=0;i<NUM_OF_NEWS;i++){
				BreakingNew breakingNew = new BreakingNew(titles.get(i), subtitles.get(i), images.get(i),urls.get(i)); 
				news.add(breakingNew);
			}
			return news;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private static List<String> getImages(Element content){
		Elements links = content.getElementsByTag("img");
		int i=0;
		List<String> images = new ArrayList<String>();
		for (Element link : links) {
		  String imageUrl = link.attr("src");
		  images.add(imageUrl);
		  if(i==NUM_OF_NEWS-1){
			  break;
		  }
		  i++;
		}
		return images;
	}
	
	private static List<String> getUrls(Element content){
		Elements links = content.getElementsByClass("article-image");
		int i=0;
		List<String> urls = new ArrayList<String>();
		for (Element link : links) {
		  String imageUrl = link.attr("href");
		  if(!urls.contains(imageUrl)){
			  urls.add(imageUrl);
			  if(i==NUM_OF_NEWS-1){
				  break;
			  }
			  i++;
			}
		}
		return urls;
	}
	
	private static List<String> getTitles(Element content){
		Elements titlesElements = content.getElementsByClass("title");
		int i=0;
		List<String> titles = new ArrayList<String>();
		for (Element titlesElement : titlesElements) {
			  String text = titlesElement.text();
			  titles.add(text);
			  if(i==NUM_OF_NEWS-1){
				  break;
			  }
			  i++;
			}
			return titles;
	}
	
	private static List<String> getSubTitles(Element content){
		Elements titlesElements = content.getElementsByClass("summary");
		int i=0;
		List<String> titles = new ArrayList<String>();
		for (Element titlesElement : titlesElements) {
			  String text = titlesElement.text();
			  titles.add(text);
			  if(i==NUM_OF_NEWS-1){
				  break;
			  }
			  i++;
			}
		return titles;
	}

}
