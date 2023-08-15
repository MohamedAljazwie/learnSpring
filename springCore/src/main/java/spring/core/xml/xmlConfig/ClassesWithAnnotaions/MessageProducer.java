/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.xml.xmlConfig.ClassesWithAnnotaions;

import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author mohamed.aljazwiee
 */
@Component
public class MessageProducer {
      private static final Logger logger = Logger.getLogger(MessageProducer.class.toString());

    @Autowired
    @Qualifier("info")
    private IMessage infoMessage;

    @Autowired
    @Qualifier("warning")
    private IMessage warningMessage;

    public void produce() {

        logger.info("{}"+ infoMessage.getMessage());
        logger.warning("{}"+ warningMessage.getMessage());
    }
}
