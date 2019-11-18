package com.ederrafo.component;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

// With this annotation Spring store in you memory
// And  give it name
@Component("logComponent")
public class LogComponent {

    private static final Log LOG = LogFactory.getLog(LogComponent.class);

    public void info(){
        LOG.info("Hello from info method in Logcomponent");
    }
}
