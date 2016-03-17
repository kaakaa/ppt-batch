package org.kaakaa.pptmuseum.batch;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.kaakaa.pptmuseum.batch.resources.SlideResource;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by kaakaa on 16/03/16.
 */
public class HttpClient {
    private final OkHttpClient client = new OkHttpClient();
    private final String host;

    public HttpClient(String host) {
        this.host = host;
    }

    public void upload(Path root) throws Exception {
        Request request;
        try {
            RequestBody requestBody = new SlideResource(root).makeRequestBody();

            request = new Request.Builder()
                    .url("http://" + host + "/ppt-museum/upload")
                    .post(requestBody)
                    .build();
        } catch (Exception e) {
            throw e;
        }

        final Response response = client.newCall(request).execute();
        if(!response.isSuccessful()){
            throw new IOException("Unexpected code " + response);
        }
    }
}
