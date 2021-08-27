package com.navi.springmongo.resources.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URL {
    public static String decodeParam(String texto){
        return URLDecoder.decode(texto, StandardCharsets.UTF_8);
    }
}
