package org.kaakaa.pptmuseum.batch.options;

import org.kohsuke.args4j.Option;

import java.io.File;
import java.net.URI;

/**
 * Created by kaakaa on 16/03/17.
 */
public class UploadOptions {
    @Option(name = "--ip", aliases="-i", usage = "ppt-museum host name")
    private String host = "127.0.0.1";

    @Option(name = "--port", aliases="-p", usage = "ppt-museum port")
    private int port = 4567;

    @Option(name = "--directory", aliases="-d",usage = "root directory for uploads")
    private String path = new File("./uploads").getAbsolutePath();

    @Option(name="--help", aliases="-h", usage="print usage message and exit")
    private boolean helpOption;
    
    private static final String UPLOAD_PATH = "/ppt-museum/upload";

    public void parse(String[] args) {
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

    public boolean isHelpOption() {
        return this.helpOption;
    }
}
