package org.example.automation_testdemo.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.automation_testdemo.tests.vendorportal.VendorPortalTest;
import org.example.automation_testdemo.tests.vendorportal.model.VendorPortalTestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class JsonUtil {
    private static Logger LOG = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static VendorPortalTestData getTestdata(String path){
        try (InputStream inputStream = ResourceLoader.getResource(path)) {
            return objectMapper.readValue(ResourceLoader.getResource(path), VendorPortalTestData.class);
        } catch (Exception e) {
            LOG.error("Error loading test data", e);
            return null;
        }
    }
}
