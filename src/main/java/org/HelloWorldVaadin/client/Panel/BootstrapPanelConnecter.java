package org.HelloWorldVaadin.client.Panel;

import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentContainerConnector;
import com.vaadin.shared.Connector;
import com.vaadin.shared.ui.Connect;
import org.HelloWorldVaadin.BootstrapPanel;

@Connect(BootstrapPanel.class)
public class BootstrapPanelConnecter extends AbstractComponentContainerConnector {

    @Override
    public BootstrapPanelState getState() {
        return (BootstrapPanelState) super.getState();
    }

    @Override
    public VBootstrapPanel getWidget() {
        return (VBootstrapPanel) super.getWidget();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {

        super.onStateChanged(stateChangeEvent);

        VBootstrapPanel panel = getWidget();
        BootstrapPanelState state = getState();
        for (Connector child: state.children)
            panel.add(((ComponentConnector)child).getWidget());
    }

    @Override
    public void onConnectorHierarchyChange(ConnectorHierarchyChangeEvent connectorHierarchyChangeEvent) {}

    @Override
    public void updateCaption(ComponentConnector componentConnector) {}
}
