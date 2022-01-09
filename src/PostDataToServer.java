import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;

public class PostDataToServer {

    private String postUrl = "https://api.cublick.com/v1/clothings";
    private HttpClient httpClient;
    private HttpPost post;

    private Gson gson;

    public PostDataToServer(){
        httpClient = HttpClientBuilder.create().build();
        post = new HttpPost(postUrl);

        gson = new Gson();

    }

    public void post(Product product){

        StringEntity postingString = null;
        try {
            postingString = new StringEntity(gson.toJson(product));
            post.setEntity(postingString);
            post.setHeader("Content-type", "application/json");
            HttpResponse response = httpClient.execute(post);

            if (response != null) {
                InputStream in = response.getEntity().getContent();
                System.out.println(convertInputStream(in));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String convertInputStream(InputStream in){
        BufferedInputStream bis = new BufferedInputStream(in);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int result = 0;
        String data = null;
        try {
            result = bis.read();
            while(result != -1) {
                buf.write((byte) result);
                result = bis.read();
            }
            data = buf.toString("UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
