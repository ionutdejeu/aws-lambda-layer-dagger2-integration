package com.ionutdejeu.utils;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import io.symphonia.lambda.logging.DefaultConsoleAppender;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.*;

import static io.symphonia.lambda.logging.DefaultConsoleAppender.NO_REQUEST_ID;

public class CustomLogger {

    private static final String LOG_FORMAT_PREFIX = "[%d{yyyy-MM-dd HH:mm:ss.SSS}] %X{AWSRequestId:-" + NO_REQUEST_ID + "} %.-6level";

    static {
        org.slf4j.Logger rootLogger = LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        ch.qos.logback.classic.Logger logbackRootLogger = (ch.qos.logback.classic.Logger) rootLogger;
        LoggerContext loggerContext = logbackRootLogger.getLoggerContext();
        loggerContext.reset();

        PatternLayoutEncoder encoder = new PatternLayoutEncoder();

        logbackRootLogger.setLevel(Level.DEBUG);
        encoder.setPattern(LOG_FORMAT_PREFIX + " %logger{10} - %msg%n");
        encoder.setContext(loggerContext);
        encoder.start();
        ConsoleAppender<ILoggingEvent> appender = new DefaultConsoleAppender();
        appender.setContext(loggerContext);
        appender.setEncoder(encoder);
        appender.start();

        logbackRootLogger.addAppender(appender);
    }
}
