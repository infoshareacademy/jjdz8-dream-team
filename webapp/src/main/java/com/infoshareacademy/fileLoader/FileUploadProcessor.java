package com.infoshareacademy.fileLoader;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequestScoped
public class FileUploadProcessor {

    @Inject
    private ConfigurationProvider configurationProvider;

    public Path uploadImageFile(Part part) throws IOException {
        String imageDir = configurationProvider.getUploadImageFilesPath();
        String fileName = part.getSubmittedFileName();
        Path path = Paths.get(imageDir, fileName);
        if (Files.exists(path)) {
            Files.delete(path);
        }
        InputStream input = part.getInputStream();
        Files.copy(input, path);
        return path;
    }

}