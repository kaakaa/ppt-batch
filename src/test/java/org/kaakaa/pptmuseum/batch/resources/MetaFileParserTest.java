package org.kaakaa.pptmuseum.batch.resources;

import org.junit.Before;
import org.junit.Test;
import org.kaakaa.pptmuseum.db.document.Slide;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by kaakaa on 16/03/16.
 */
public class MetaFileParserTest {

    private MetaFileParser target;

    @Before
    public void setUp(){
        this.target = new MetaFileParser();
    }

    @Test
    public void testParse() throws Exception {
        // setup
        URL url = MetaFileParserTest.class.getClassLoader().getResource("MetaFile/test.meta");
        Path path = Paths.get(url.toURI());

        // when
        Map map = target.parse(path);

        // then
        assertThat(map.size(), is(3));
        assertThat(map.get("title"), is("test"));
        assertThat(map.get("description"), is("test description"));
        assertThat(map.get("tags"), is("java"));
    }
}