package com.andreervilha.evoluum.springboottest.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

class Logger {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

    void log(String msg, String param) {
        String logInstant = simpleDateFormat.format(new Date());
        String logMsg = logInstant
                .concat(" ")
                .concat(msg);

        if (param != null)
            logMsg = logMsg
                    .concat(" ")
                    .concat(param);

        System.out.println(logMsg);
    }

    void log(String msg) {
        this.log(msg, null);
    }
}
