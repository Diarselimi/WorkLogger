package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    public static final String getProp(String key)
    {
        String out = null;
        InputStream input;
        try {

            input = new FileInputStream("./config/config.properties");
            Properties props = new Properties();
            props.load(input);
            out = props.getProperty(key);


        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return out;
    }

}
