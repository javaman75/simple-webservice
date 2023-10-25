package com.wellsfargo.ccibt.aks.handler;

import java.io.IOException;
import java.util.Random;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;



public class RandomHandler implements HttpRequestHandler {
    @Override
    public void handle(org.apache.http.HttpRequest request, HttpResponse response, HttpContext context)
            throws HttpException, IOException {

        // Set response content type
        response.setHeader("Content-Type", "text/plain");

        // Set response status code
        response.setStatusCode(HttpStatus.SC_OK);

        Random r = new Random();
        int low = 200;
        int high = 2000;
        int millis = r.nextInt(high-low) + low;
        
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("I was interrupted!");
            e.printStackTrace();
        }        

        // Set response content
        final String msg = "Random delay of " + millis + " millis";
        StringEntity entity = new StringEntity(msg);
        response.setEntity(entity);
    }
}
