package org.HelloWorldVaadin.client.Button;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.vaadin.client.MouseEventDetailsBuilder;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.ui.Connect;
import org.HelloWorldVaadin.BootstrapButton;
import org.gwtbootstrap3.client.ui.constants.ButtonSize;
import org.gwtbootstrap3.client.ui.constants.ButtonType;

@Connect(BootstrapButton.class)
public class BootstrapButtonConnector extends AbstractComponentConnector implements ClickHandler {

    private BootstrapButtonRpc rpc = RpcProxy.create(BootstrapButtonRpc.class, this);

    public BootstrapButtonConnector() { getWidget().addClickHandler(this); }

    @Override
    public VBootstrapButton getWidget() { return (VBootstrapButton)super.getWidget(); }

    @Override
    public BootstrapButtonState getState() { return (BootstrapButtonState)super.getState(); }

    @Override
    public void onClick(ClickEvent event) {
        MouseEventDetails details = MouseEventDetailsBuilder.buildMouseEventDetails(
                event.getNativeEvent(), getWidget().getElement());

        rpc.click(details);
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        BootstrapButtonState state = getState();
        VBootstrapButton button = getWidget();
        button.setSize(ButtonSize.fromStyleName(state.buttonSize));
        button.setText(state.text);
        button.setType(ButtonType.fromStyleName(state.buttonType));
        button.setEnabled(state.isEnabled);
    }
}
