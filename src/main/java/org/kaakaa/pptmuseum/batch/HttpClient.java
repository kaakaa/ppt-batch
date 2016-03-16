package org.kaakaa.pptmuseum.batch;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.kaakaa.pptmuseum.batch.resources.SlideResource;

import javax.script.ScriptException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by kaakaa on 16/03/16.
 */
public class HttpClient {
    private final OkHttpClient client = new OkHttpClient();
    private final String host;

    public HttpClient(String host) {
        this.host = host;
    }

    public void upload(Path root) throws IOException, ScriptException {
        RequestBody requestBody = new SlideResource(root).makeRequestBody();

        Request request = new Request.Builder()
                .url("http://" + host + "/ppt-museum/upload")
                .post(requestBody)
                .build();

        final Response response = client.newCall(request).execute();
        if(!response.isSuccessful()){
            throw new IOException("Unexpected code " + response);
        }
    }
}
