package org.example.automation_testdemo.util;

import org.apache.commons.io.IOUtils;
import org.example.automation_testdemo.tests.vendorportal.model.VendorPortalTestData;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Demo {
    public static void main(String[] args) {
        VendorPortalTestData testData = JsonUtil.getTestdata("test-data/vendorportal/sam.json");

        System.out.println(Objects.requireNonNull(testData).getMonthlyEarning());
    }
}
