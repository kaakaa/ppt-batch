package org.kaakaa.pptmuseum.batch.resources;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;

/**
 * Created by kaakaa on 16/03/15.
 */
public class SlideResource {
    private final Path dir;

    public SlideResource(Path dir) {
        this.dir = dir;
    }

    public RequestBody makeRequestBody() throws IOException, ScriptException {
        Map meta = MetaFileParser.parse(dir.resolve(".meta"));
        RequestBody requestBody = getMediaFile(dir);

        return new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("title", String.valueOf(getString(meta, "title").orElse(getString(meta, "filename").orElse("NoTitle"))))
                .addFormDataPart("desc", String.valueOf(getString(meta, "desc").orElse("No Description")))
                .addFormDataPart("tags", String.valueOf(getString(meta, "tags").orElse("")))
                .addFormDataPart("file", "uploadfile", requestBody)
                .build();
    }

    private Optional<Object> getString(Map map, String key) {
        return Optional.ofNullable(map.get(key));
    }

    private RequestBody getMediaFile(Path dir) {
        File[] ppt = dir.toFile().listFiles(f -> f.getName().endsWith(".ppt"));
        if (ppt.length == 1) {
            return RequestBody.create(MediaType.parse("application/vnd.ms-powerpoint"), ppt[0]);
        }

        File[] pptx = dir.toFile().listFiles(f -> f.getName().endsWith(".ppt"));
        if (pptx.length == 1) {
            return RequestBody.create(MediaType.parse("application/vnd.openxmlformats-officedocument.presentationml.presentation"), pptx[0]);
        }

        File[] pdf = dir.toFile().listFiles(f -> f.getName().endsWith(".pdf"));
        if(pdf.length == 1){
            return RequestBody.create(MediaType.parse("application/pdf"), pdf[0]);
        }

        throw new IllegalStateException("Resource file status is illegal: " + dir);
    }
}
