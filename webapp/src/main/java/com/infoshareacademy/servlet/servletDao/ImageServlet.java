package com.infoshareacademy.servlet.servletDao;

import com.infoshareacademy.fileLoader.ConfigurationProvider;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {

    @Inject
    private ConfigurationProvider configurationProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imageDir = configurationProvider.getUploadImageFilesPath();
        System.out.println("image directory" + imageDir);
        String fileName = URLDecoder.decode(req.getPathInfo(), "UTF-8");
        System.out.println("url decode file name " + fileName);
        Path path = Paths.get(imageDir, fileName);
        Files.copy(path, resp.getOutputStream());
    }
}
