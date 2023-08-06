package com.wellsfargo.ccibt.aks.handler;

import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

public class GoodByeHandler implements HttpRequestHandler {
    @Override
    public void handle(org.apache.http.HttpRequest request, HttpResponse response, HttpContext context)
            throws HttpException, IOException {

        // Set response content type
        response.setHeader("Content-Type", "text/plain");

        // Set response status code
        response.setStatusCode(HttpStatus.SC_OK);

        // Set response content
        StringEntity entity = new StringEntity("GoodBye, World!");
        response.setEntity(entity);
    }
}
