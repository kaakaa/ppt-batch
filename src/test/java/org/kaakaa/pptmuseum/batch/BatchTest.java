package org.kaakaa.pptmuseum.batch;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

/**
 * Created by kaakaa on 16/03/16.
 */
public class BatchTest {
    private Batch target;

    @Before
    public void setUp(){
        this.target = new Batch();
    }

    @Test
    public void hoge() throws IOException, URISyntaxException {
        target.exec();
    }

}