/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.complex.svntools.config;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import java.util.ArrayList;

/**
 * @author Andreas Kunkel
 */
public class ConfigValidationEventHandler implements ValidationEventHandler {
    ArrayList<ValidationEvent> events = new ArrayList<>();

    @Override
    public boolean handleEvent(ValidationEvent event) {

        events.add(event);

//		
//		System.out.println("\nEVENT");
//		System.out.println("SEVERITY:  " + event.getSeverity());
//		System.out.println("MESSAGE:  " + event.getMessage());
//		System.out.println("LINKED EXCEPTION:  " + event.getLinkedException());
//		System.out.println("LOCATOR");
//		System.out.println("    LINE NUMBER:  " + event.getLocator().getLineNumber());
//		System.out.println("    COLUMN NUMBER:  " + event.getLocator().getColumnNumber());
//		System.out.println("    OFFSET:  " + event.getLocator().getOffset());
//		System.out.println("    OBJECT:  " + event.getLocator().getObject());
//		System.out.println("    NODE:  " + event.getLocator().getNode());
//		System.out.println("    URL:  " + event.getLocator().getURL());
        return true;
    }

    public boolean hasEvents() {
        return !events.isEmpty();
    }

    public ArrayList<ValidationEvent> getEvents() {
        return events;
    }

    public String getMessages() {

        StringBuilder sb = new StringBuilder("");
        events.forEach((event) -> {
            if (sb.length() == 0) {
                sb.append(event.getMessage());
            } else {
                sb.append("\n").append(event.getMessage());
            }
        });

        return sb.toString();
    }
}
