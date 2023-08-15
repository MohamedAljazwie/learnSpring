/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.xml.xmlConfig.ClassesWithAnnotaions;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author mohamed.aljazwiee
 */
@Component
public class Info implements IMessage {

    @Override
    public String getMessage() {

        return "This is an information message";
    }
}
