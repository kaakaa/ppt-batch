package org.kaakaa.pptmuseum.batch.options;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by kaakaa on 16/03/17.
 */
public class UploadOptionsTest {
    private UploadOptions target;

    @Before
    public void setUp(){
        this.target = new UploadOptions();
    }

    @Test
    public void testParse() throws Exception {
        // setup
        String[] args = new String[]{"-h", "localhost", "-p", "8080", "-d", "./resources"};

        // when
        target.parse(args);

        // then
        assertThat(target.getHost(), is("localhost"));
        assertThat(target.getPort(), is(8080));
        assertThat(target.getPath(), is("./resources"));
    }
}