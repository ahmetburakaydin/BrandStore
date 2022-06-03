package utils;
import org.apache.log4j.*;


public class Logger1 {

    private static Logger logger = LogManager.getLogger(Logger1.class); // getLogger(className.class);


    public static Logger getLogger() {
        return logger;
    }



}
