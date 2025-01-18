package org.example.automation_testdemo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class ResourceLoader {

    private static Logger LOG = LoggerFactory.getLogger(ResourceLoader.class);

    public static InputStream getResource(String path) throws IOException {
        LOG.info("Loading resource from location: {}", path);
        InputStream resourceStream = ResourceLoader.class.getClassLoader().getResourceAsStream(path);
        if(Objects.nonNull(resourceStream)){
            return resourceStream;
        }
        return Files.newInputStream(Path.of(path));
    }
}
