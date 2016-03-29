package org.kaakaa.pptmuseum.batch;

import org.kaakaa.pptmuseum.batch.options.UploadOptions;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by kaakaa on 16/03/16.
 */
public class Batch {
    private String url;
    private URI resourceRoot;

    public Batch(UploadOptions option) {
        this.url = option.getPptmusesumURL();
        this.resourceRoot = option.getResourceRoot();
    }

    public void exec() throws URISyntaxException, IOException {
        HttpClient httpClient = new HttpClient(this.url);

        Files.list(Paths.get(this.resourceRoot)).forEach(dir -> {
            try {
                httpClient.upload(dir);
                System.out.println("upload complete: " + dir.toString());
            } catch (Exception e) {
                System.err.println("upload error: " + dir.toString());
                e.printStackTrace();
            }
        });
    }
}
