package crawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

public class Crawler {
    public static void main(String[] args) {
        String url = "https://www.flipkart.com/samsung-galaxy-tab-s7-stylus-6-gb-ram-128-rom-12-4-inch-wi-fi-only-tablet-mystic-black/p/itm80b9d6447fa7c?pid=TABFXMJEH5QEFKG6&marketplace=FLIPKART";
        List<String> visited = new ArrayList<>();
        crawl(1, url, visited);
    }

    static void crawl(int level, String url, List<String> visited) {
        if (level <= 5) {
            Document doc = request(url, visited);
            if (doc != null) {
                for (Element el : doc.select("div[aMaAEs]")) {
                    String next_url = el.absUrl("href");
                    if (!visited.contains(next_url)) {
                        crawl(level++, next_url, visited);
                    }
                }
            }
        }
    }

    static Document request(String url, List<String> visited) {
        try {
            Connection con = Jsoup.connect(url);
            Document doc = con.get();
            if (con.response().statusCode() == 200) {
                System.out.println(doc.title() + " : " + url);

                visited.add(url);
                return doc;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }


}
