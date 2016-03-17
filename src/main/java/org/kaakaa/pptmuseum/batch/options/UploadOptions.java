package org.kaakaa.pptmuseum.batch.options;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.net.URI;

/**
 * Created by kaakaa on 16/03/17.
 */
public class UploadOptions {
    @Option(name = "-h", usage = "ppt-museum host name")
    private String host = "127.0.0.1";

    @Option(name = "-p", usage = "ppt-museum port")
    private int port = 4567;

    @Option(name = "-d", usage = "root directory for uploads")
    private String path = new File("./uploads").getAbsolutePath();

    private static final String UPLOAD_PATH = "/ppt-museum/upload";

    public void parse(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            e.printStackTrace();
        }
    }

    public String getPath() {
        return path;
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getPptmusesumURL() {
        if(port == 0){
            return String.format("http://%s/%s", this.host, UPLOAD_PATH);
        }
        return String.format("http://%s:%s/%s", this.host, String.valueOf(this.port), UPLOAD_PATH);
    }

    public URI getResourceRoot() {
        return new File(this.path).toURI();
    }
}
