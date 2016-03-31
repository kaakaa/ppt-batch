package org.kaakaa.pptmuseum.batch;

import org.kaakaa.pptmuseum.batch.options.UploadOptions;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by kaakaa on 16/03/17.
 */
public class Main {
    public static void main(String[] args) {
        UploadOptions option = new UploadOptions();
        CmdLineParser parser = new CmdLineParser(option);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            e.printStackTrace();
            return;
        }

        if(!option.isHelpOption()){
            System.out.println("Usage:");
            parser.printUsage(System.out);
            return;
        }

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
