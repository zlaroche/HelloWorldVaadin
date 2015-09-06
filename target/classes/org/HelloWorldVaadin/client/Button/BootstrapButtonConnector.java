package org.HelloWorldVaadin.client.Button;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.vaadin.client.MouseEventDetailsBuilder;
import com.vaadin.client.annotations.OnStateChange;
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

    private final BootstrapButtonRpc rpc = RpcProxy.create(BootstrapButtonRpc.class, this);

    public BootstrapButtonConnector() {
        getWidget().addClickHandler(this);
    }

    @Override
    public VBootstrapButton getWidget() {
        return (VBootstrapButton) super.getWidget();
    }

    @Override
    public BootstrapButtonState getState() {
        return (BootstrapButtonState) super.getState(); }


    @Override
    public void onClick(ClickEvent event) {

        MouseEventDetails details = MouseEventDetailsBuilder.buildMouseEventDetails(
                event.getNativeEvent(), getWidget().getElement());

        rpc.click(details);
    }

    @OnStateChange("text")
    private void onTextChange() {
        getWidget().setText(getState().text);
    }

    @OnStateChange("size")
    private void onSizeChange() {
        getWidget().setSize(ButtonSize.valueOf(getState().size));
    }

    @OnStateChange("type")
    private void onTypeChange() {
        getWidget().setType(ButtonType.valueOf(getState().type));
    }
}
