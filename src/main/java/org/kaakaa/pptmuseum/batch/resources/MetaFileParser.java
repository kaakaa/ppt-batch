package org.kaakaa.pptmuseum.batch.resources;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

/**
 * Created by kaakaa on 16/03/16.
 */
public class MetaFileParser {
    private static ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");

    public static Map parse(Path path) throws IOException, ScriptException {
        String json = new String(Files.readAllBytes(path));
        String script = String.format("Java.asJSONCompatible(%s)", json);
        return (Map)engine.eval(script);
    }
}
