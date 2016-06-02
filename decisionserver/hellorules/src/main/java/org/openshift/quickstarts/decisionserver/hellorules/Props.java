package org.openshift.quickstarts.decisionserver.hellorules;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Props {
    private Properties properties;

    public Props() {
    }

    public Props(Properties properties) {
        this.properties = properties;
    }

    public static Props read(String name) {
        Properties properties = new Properties();
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
