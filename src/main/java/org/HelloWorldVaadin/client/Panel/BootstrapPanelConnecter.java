package org.HelloWorldVaadin.client.Panel;

import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.annotations.OnStateChange;
import com.vaadin.client.ui.AbstractComponentContainerConnector;
import com.vaadin.shared.Connector;
import com.vaadin.shared.ui.Connect;
import org.HelloWorldVaadin.server.BootstrapPanel;

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

    @OnStateChange("children")
    private void onChildrenChange() {

        for (Connector child: getState().children)
            getWidget().add(((ComponentConnector) child).getWidget());
    }

    @Override
    public void onConnectorHierarchyChange(ConnectorHierarchyChangeEvent connectorHierarchyChangeEvent) {}

    @Override
    public void updateCaption(ComponentConnector componentConnector) {}
}
