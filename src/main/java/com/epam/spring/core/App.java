package com.epam.spring.core;

public class App {
    Client client;
    EventLogger eventLogger;


    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public void logEvent(String msg) {
        String message = msg.replaceAll(client.getId().toString(), client.getFullName());
        eventLogger.logEvent(message);
    }

    public static void main(String[] args) {
        App app = new App();

        app.client = new Client(1L, "John Smith");
        app.eventLogger = new ConsoleEventLogger();

        app.logEvent("Some event for user 1");
    }
}
