package org.HelloWorldVaadin;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.AbstractComponent;
import org.HelloWorldVaadin.client.Button.BootstrapButtonRpc;
import org.HelloWorldVaadin.client.Button.BootstrapButtonState;

public class BootstrapButton extends AbstractComponent {

    private final BootstrapButtonRpc rpc = new BootstrapButtonRpc() {

        @Override
        public void click(MouseEventDetails details) {
            fireEvent(new BootstrapClickEvent(BootstrapButton.this));
        }
    };

    public BootstrapButton() {
        registerRpc(rpc);
    }

    public BootstrapButton(String text) {

        this();
        setText(text);
}

    protected BootstrapButtonState getState() {
        return (BootstrapButtonState) super.getState();
    }

    public String getText() {
        return getState().text;
    }

    public void setText(String text) {
        getState().text = text;
    }

    public boolean isEnabled() {
        return getState().isEnabled;
    }

    public void setEnabled(boolean enabled) {
        getState().isEnabled = enabled;
    }

    public BootstrapButtonSize getSize() {
        return BootstrapButtonSize.valueOf(getState().size);
    }

    public void setSize(BootstrapButtonSize size) {
        getState().size = size.toString();
    }

    public BootstrapButtonType getType() {
        return BootstrapButtonType.valueOf(getState().type);
    }

    public void setType(BootstrapButtonType type) {
        getState().type = type.toString();
    }
}
