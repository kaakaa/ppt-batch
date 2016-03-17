package org.kaakaa.pptmuseum.batch;

import org.kaakaa.pptmuseum.batch.options.UploadOptions;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by kaakaa on 16/03/17.
 */
public class Main {
    public static void main(String[] args) {
        UploadOptions option = new UploadOptions();
        option.parse(args);

        Batch batch = new Batch(option);
        try {
            batch.exec();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Upload All complete");
    }
}
