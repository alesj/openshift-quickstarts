package org.openshift.quickstarts.decisionserver.hellorules;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class Props {
    private static final Logger log = Logger.getLogger(Props.class.getName());

    private Properties properties;

    public Props() {
    }

    public Props(Properties properties) {
        this.properties = properties;
    }

    public static Props read(String name) {
        Properties properties = new Properties();
        log.info("Trying to read properties: " + name);
        InputStream stream = Props.class.getClassLoader().getResourceAsStream(name);
        if (stream != null) {
            try {
                properties.load(stream);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            } finally {
                try {
                    stream.close();
                } catch (IOException ignored) {
                }
            }
        } else {
            log.warning("No such properties: " + name);
        }
        return new Props(properties);
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
