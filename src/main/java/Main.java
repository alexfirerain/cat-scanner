import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static final String CAT_SOURCE = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";
    public static ObjectMapper catMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setUserAgent("The Cat-Scanner Service")
                .setDefaultRequestConfig(
                        RequestConfig.custom()
                        .setConnectTimeout(5_000)
                        .setSocketTimeout(30_000)
                        .setRedirectsEnabled(false)
                        .build()
                ).build();

        HttpGet request = new HttpGet(CAT_SOURCE);
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

        CloseableHttpResponse response = httpClient.execute(request);

        List<CatRec> catFacts = catMapper.readValue(response.getEntity().getContent(),
                new TypeReference<>() {});

        System.out.println();
        catFacts.stream()
                .filter(x -> x.getUpvotes() != 0)
                .sorted(Comparator.comparing(CatRec::getUpvotes).reversed())
                .forEach(System.out::println);
    }
}
