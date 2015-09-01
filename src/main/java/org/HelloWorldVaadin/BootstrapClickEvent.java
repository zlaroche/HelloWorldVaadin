package org.HelloWorldVaadin;

import com.vaadin.ui.Component;
import com.vaadin.ui.Component.Event;

@SuppressWarnings("serial")
public class BootstrapClickEvent extends Event {

    public BootstrapClickEvent(Component source) {

        super(source);
    }
}