import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * Created by Pranav Jain on 30-Jun-17.
 */
public class GoogleScraper {

    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0";

    public static void main(String[] args) throws IOException {

        final String query = "pranavj1001";

        final Document page = Jsoup.connect("https://www.google.com/search?q=" + URLEncoder.encode(query, "UTF-8")).userAgent(USER_AGENT).get();

        //System.out.println(page.outerHtml());

        final PrintWriter file = new PrintWriter("searchResults.txt");

        for (Element searchResult : page.select("h3.r a")){

            String title = searchResult.text();
            String url = searchResult.attr("href");

            System.out.println(title + " -> " + url);

            file.write(title + " -> " + url + "\n\n");

        }

        file.close();

    }

}
