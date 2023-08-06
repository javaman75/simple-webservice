package com.wellsfargo.ccibt.aks;


import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.impl.bootstrap.ServerBootstrap;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.apache.http.protocol.UriHttpRequestHandlerMapper;

public class SimpleWebServer {

    public static void main(String[] args) {
        // Set up the server
        HttpServer server = createWebServer(8080);

        // Start the server
        try {
            server.start();
            System.out.println("Server started on port 8080");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static HttpServer createWebServer(int port) {
        // Create HTTP server using ServerBootstrap
        ServerBootstrap serverBootstrap = ServerBootstrap.bootstrap();
        serverBootstrap.setListenerPort(port);

        // Create the registry for request handlers
        UriHttpRequestHandlerMapper handlerMapper = new UriHttpRequestHandlerMapper();
        handlerMapper.register("/hello", new HelloHandler());

        // Set the request handler mapper
        serverBootstrap.setHandlerMapper(handlerMapper);

        // Create the HTTP server
        return serverBootstrap.create();
    }

    static class HelloHandler implements HttpRequestHandler {
        @Override
        public void handle(org.apache.http.HttpRequest request, HttpResponse response, HttpContext context)
                throws HttpException, IOException {
            // Set response content type
            response.setHeader("Content-Type", "text/plain");
            // Set response status code
            response.setStatusCode(HttpStatus.SC_OK);
            // Set response content
            StringEntity entity = new StringEntity("Hello, World!");
            response.setEntity(entity);
        }
    }
}
