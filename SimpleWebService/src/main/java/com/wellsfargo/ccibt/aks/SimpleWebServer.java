package com.wellsfargo.ccibt.aks;


import java.io.IOException;

import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.impl.bootstrap.ServerBootstrap;
import org.apache.http.protocol.UriHttpRequestHandlerMapper;

import com.wellsfargo.ccibt.aks.handler.ExceptionHandler;
import com.wellsfargo.ccibt.aks.handler.GoodByeHandler;
import com.wellsfargo.ccibt.aks.handler.HelloHandler;
import com.wellsfargo.ccibt.aks.handler.RandomHandler;

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
        handlerMapper.register("/goodbye", new GoodByeHandler());
        handlerMapper.register("/exception", new ExceptionHandler());
        handlerMapper.register("/random", new RandomHandler());



        // Set the request handler mapper
        serverBootstrap.setHandlerMapper(handlerMapper);

        // Create the HTTP server
        return serverBootstrap.create();
    }

}
