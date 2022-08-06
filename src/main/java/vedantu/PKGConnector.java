package vedantu;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PKGConnector {

    private String urlEndPoint;
    private final CloseableHttpClient client;
    private final RequestConfig requestConfig;

    private PKGConnector() {
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(3);
        client = HttpClients.custom().setConnectionManager(connManager).build();
        requestConfig = RequestConfig.custom().setConnectionRequestTimeout(60 * 1000).setConnectTimeout(60 * 1000).setSocketTimeout(120 * 1000).build();
    }

    private static class RestClientHolder {
        private static final PKGConnector instance = new PKGConnector();
    }

    public static PKGConnector getInstance() {
        return RestClientHolder.instance;
    }

    public void setUrlEndPoint(String urlEndPoint) {
        this.urlEndPoint = urlEndPoint;
    }
    public  String getJson(String urlEndPoint) {
        try {
            HttpGet httpPost = new HttpGet(urlEndPoint);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setHeader("Cookie", "JSESSIONID=656951FBEB444AE6B76253FDC4757B2C; _fbp=fb.1.1655192709254.1476714330; _gcl_au=1.1.1468085487.1655192709; _cc_id=345e32c6ecd07985845d811316da69f8; _gid=GA1.2.1705552358.1655306340; _clck=1l8tlzj|1|f2c|0; panoramaId_expiry=1655392740500; _uetsid=7b433650ecbe11ec91db8b86f67aab5d; _uetvid=eaa80130ebb511ec9709216e90334d75; _ga=GA1.2.1001533178.1655192710; _clsk=sdodvb|1655306520630|4|0|b.clarity.ms/collect; amp_832ba5=x8fNe2eIFKMqJxAn3arhgI...1g5jv4iot.1g5jva2ti.f.0.f; X-Ved-Token=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYW5hc2hyaS5iZXJhQHZlZGFudHUuY29tIiwiZXhwIjoxNjU1MzkyOTIxLCJpc3MiOiJ2ZWRhbnR1LmNvbSIsInNlc3Npb25EYXRhIjoie1wiZmlyc3ROYW1lXCI6XCJCYW5hc2hyaVwiLFwibGFzdE5hbWVcIjpcIkJlcmFcIixcImZ1bGxOYW1lXCI6XCJCYW5hc2hyaSBCZXJhXCIsXCJ1c2VySWRcIjo0MTAyMzk1NDE4MjgyNTIzLFwiZW1haWxcIjpcImJhbmFzaHJpLmJlcmFAdmVkYW50dS5jb21cIixcInJvbGVcIjpcIkFETUlOXCIsXCJjb250YWN0TnVtYmVyXCI6XCI5MzgyMTE2MTI4XCIsXCJwaG9uZUNvZGVcIjpcIjkxXCIsXCJjcmVhdGlvblRpbWVcIjoxNjU1MzA2NTIxOTg1LFwiZXhwaXJ5VGltZVwiOjE2NTUzOTI5MjE5ODUsXCJpc0VtYWlsVmVyaWZpZWRcIjpmYWxzZSxcImlzQ29udGFjdE51bWJlclZlcmlmaWVkXCI6dHJ1ZSxcImlzQ29udGFjdE51bWJlckRORFwiOmZhbHNlLFwiaXNDb250YWN0TnVtYmVyV2hpdGVsaXN0ZWRcIjpmYWxzZSxcInJlZmVycmFsQ29kZVwiOlwiYmFuYWVhNWFcIixcInRuY1ZlcnNpb25cIjpcInY4XCIsXCJkZXZpY2VcIjpcIldFQlwiLFwicGFzc3dvcmRBdXRvZ2VuZXJhdGVkXCI6dHJ1ZSxcInVzZXJJblByb2Nlc3NPZk9uYm9hcmRpbmdcIjpmYWxzZSxcInN0dWRlbnRJbmZvXCI6e1wiZXhhbVRhcmdldHNcIjpbXSxcInVwZGF0ZU5lZWRlZFwiOmZhbHNlfX0ifQ.hUgK975CBpK7LjXb7yOQ-jRGrTATu9lh0PF8AUurlQoR3k1Zu8MZSVvQIRU8tMDlZAncBC6YbWa8NzYKPGwugg; _ga_35N6JBZRVC=GS1.1.1655306339.3.1.1655306522.57");
            CloseableHttpResponse httpResponse = client.execute(httpPost);
            int httpStatus = httpResponse.getStatusLine().getStatusCode();
            if (httpStatus == 200) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();
                    while ((inputLine = reader.readLine()) != null) {
                        response.append(inputLine);
                    }
                    httpResponse.close();
                    response.trimToSize();
                    return response.toString().trim();
                }
            } else {
                System.out.println("Error");
                return "";
            }
        } catch (Exception e) {
            return "";
        }
    }
}
