package org.HelloWorldVaadin;

import com.vaadin.shared.Connector;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.Component;
import org.HelloWorldVaadin.client.Panel.BootstrapPanelState;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class BootstrapPanel extends AbstractComponentContainer {

    private final List<Component> children = new ArrayList<Component>();

    @Override
    protected BootstrapPanelState getState() {
        return (BootstrapPanelState) super.getState();
    }

    @Override
    public void addComponent(Component child) {

        super.addComponent(child);
        children.add(child);
        getState().children.add(child);
    }

    @Override
    public void replaceComponent(Component out, Component in) {

        if (children.contains(out))
            children.set(children.indexOf(out),in);
    }

    @Override
    public int getComponentCount() {
        return children.size();
    }

    @Override
    public Iterator<Component> iterator() {
        return children.iterator();
    }
}
