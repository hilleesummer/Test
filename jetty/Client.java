import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpMethod;

// https://zetcode.com/java/jetty/httpclient/
public class HttpClientGetMethod {

    public static void main(String[] args) throws Exception {
        
        HttpClient client = new HttpClient();
        client.start();

        //ContentResponse res = client.GET("http://www.something.com");
        ContentResponse res = client.newRequest("http://www.something.com/mypath").method(HttpMethod.GET).send();
        
        System.out.println(res.getContentAsString());
        
        client.stop();
    }
}
