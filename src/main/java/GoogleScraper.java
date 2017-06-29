import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by Pranav Jain on 30-Jun-17.
 */
public class GoogleScraper {

    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0";

    public static void main(String[] args) throws IOException {

        final String query = "Sony";

        final Document page = Jsoup.connect("https://www.google.com/?q=" + URLEncoder.encode(query, "UTF-8")).userAgent(USER_AGENT).get();

        //System.out.println(page.outerHtml());

    }

}
