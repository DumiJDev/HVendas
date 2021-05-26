package com.tecnoheli.hvendas.util;

import java.time.LocalTime;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class UpdateService extends Service<Void> {

    private LocalTime time;

    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                while (true) {
                    time = LocalTime.now();
                    updateMessage(String.format("%02d:%02d", time.getHour(), time.getMinute()));
                    Thread.sleep(1000);
                }
            }
        };

    }
}
