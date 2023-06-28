package com.b2iapi.api;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;


public class asdtest {
    public static void main(String [] args) throws IOException {
        URL url = new URL("http://localhost:8080/play?explain=true");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("POST"); // PUT is another valid option
        http.setDoOutput(true);

        byte[] out = "{\"move\":\"Rock\"}" .getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        http.connect();
        System.out.println("asd");
        try(OutputStream os = http.getOutputStream()) {
            os.write(out);
        }
        System.out.println(new String(out,StandardCharsets.UTF_8));
    }
}
