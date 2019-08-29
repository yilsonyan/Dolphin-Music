package cn.jd.Exception;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionLog {

    public static void main(String[] args) {
        //JDK内置java.util.logging
        java.util.logging.Logger logger = java.util.logging.Logger.getGlobal();
        logger.info("start process...");//信息
        logger.warning("memory is running out...");//警告
        logger.severe("process will be terminated...");//严重

        /**
         * JDK的Logging定义了7个日志级别：默认级别是INFO，INFO级别以下的日志，不会被打印出来。
         * SEVERE
         * WARNING
         * INFO 默认
         * CONFIG
         * FINE
         * FINER
         * FINEST
         */
        logger.fine("ignored.");//未打印
    }


    /**
     * 第三方日志系统
     * Commons Logging和Log4j这一对好基友，它们一个负责充当日志API，一个负责实现日志底层，搭配使用非常便于开发。
     * SLF4J类似于Commons Logging，也是一个日志接口，而Logback类似于Log4j，是一个日志的实现。
     * 使用SLF4J接口和Logback实现：
     */
    @Test
    public void ea() throws Exception {
        Logger logger = LoggerFactory.getLogger(getClass());

        logger.error("nihao");
    }
}
