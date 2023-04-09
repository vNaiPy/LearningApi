package com.students.knowledge.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URL {
    public static String decodeParam (String txt) { return URLDecoder.decode(txt, StandardCharsets.UTF_8); }
}
