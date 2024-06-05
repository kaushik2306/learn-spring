package dev.kc.learnspring.server;

import com.sun.net.httpserver.HttpHandler;

public interface HttpExchangeHandler extends HttpHandler, AutoCloseable{
    String getContextPath();

    @Override
    void close();
}
