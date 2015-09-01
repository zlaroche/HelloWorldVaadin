package org.HelloWorldVaadin.client.Button;

import com.vaadin.shared.AbstractComponentState;

public class BootstrapButtonState extends AbstractComponentState {
    public String text;
    public String buttonType = "btn-default"; //css classname
    public boolean isEnabled = true;
    public String buttonSize = "btn-default"; //css classname
}
