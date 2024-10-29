package com.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public final class JsonUtils {

    private JsonUtils() {}

    public static HashMap<String, Object> readFile(String filePath) {
        HashMap<String, Object> map = null;

        try {
            map = new ObjectMapper()
                    .readValue(new File(filePath), new TypeReference<HashMap<String, Object>>() {});
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return map;
    }
}
