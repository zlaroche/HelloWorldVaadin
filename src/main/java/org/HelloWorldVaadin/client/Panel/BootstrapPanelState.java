package org.HelloWorldVaadin.client.Panel;

import com.vaadin.client.ComponentConnector;
import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.Connector;

import java.util.ArrayList;
import java.util.List;


public class BootstrapPanelState extends AbstractComponentState {

   public List<Connector> children = new ArrayList<Connector>();
}
