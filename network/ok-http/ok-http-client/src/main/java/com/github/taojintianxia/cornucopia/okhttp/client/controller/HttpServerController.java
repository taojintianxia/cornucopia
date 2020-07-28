package com.github.taojintianxia.cornucopia.okhttp.client.controller;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Nianjun Sun
 */
@RestController
public class HttpServerController {

    private ConnectionPool pool = new ConnectionPool(20, 10, TimeUnit.MINUTES);

    private OkHttpClient client = new OkHttpClient.Builder().connectTimeout(3, TimeUnit.MINUTES).followRedirects(true)
            .readTimeout(3, TimeUnit.MINUTES).retryOnConnectionFailure(false).writeTimeout(3, TimeUnit.MINUTES).
                    connectionPool(pool).build();
    private Request request = new Request.Builder().url("http://localhost:18080/server/sayHello").build();


    @GetMapping("/client/sayHello")
    public void sayHello() throws IOException {
        Response response = client.newCall(request).execute();
        response.close();
    }
}
