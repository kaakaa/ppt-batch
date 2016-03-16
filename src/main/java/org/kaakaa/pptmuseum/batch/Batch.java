package org.kaakaa.pptmuseum.batch;

import javax.script.ScriptException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by kaakaa on 16/03/16.
 */
public class Batch {
    public void exec() throws URISyntaxException, IOException {
        HttpClient httpClient = new HttpClient("localhost:4567");

        URL url = Batch.class.getClassLoader().getResource("test");
        Files.list(Paths.get(url.toURI())).forEach(dir -> {
            try {
                httpClient.upload(dir);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        });
    }
}
