package org.example.automation_testdemo.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class JsonUtil {
    private static Logger LOG = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T getTestdata(String path, Class<T> type) {
        try (InputStream inputStream = ResourceLoader.getResource(path)) {
            return objectMapper.readValue(ResourceLoader.getResource(path), type);
        } catch (Exception e) {
            LOG.error("Error loading test data", e);
            return null;
        }
    }
}
