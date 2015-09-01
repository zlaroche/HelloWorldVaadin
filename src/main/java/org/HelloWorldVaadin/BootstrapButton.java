package org.HelloWorldVaadin;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.AbstractComponent;
import org.HelloWorldVaadin.client.Button.BootstrapButtonRpc;
import org.HelloWorldVaadin.client.Button.BootstrapButtonState;

public class BootstrapButton extends AbstractComponent {

    private BootstrapButtonRpc rpc = new BootstrapButtonRpc() {

        @Override
        public void click(MouseEventDetails details) {
                      fireEvent(new BootstrapClickEvent(BootstrapButton.this));
        }
    };

    public BootstrapButton(String caption) {
        setText(caption);
        setImmediate(true);
        registerRpc(rpc);
    }

    public BootstrapButtonState getState() { return (BootstrapButtonState)super.getState(); }

    public void setType(BootstrapButtonType type) { getState().buttonType = type.toCssName();}

    public void setText(String text) {
        getState().text = text;
    }

    public String getText() { return getState().text; }

    public void setEnabled(boolean enabled) { getState().isEnabled = enabled; }

    public void setSize(BootstrapButtonSize size) {

        getState().buttonSize = size.toCssName();
        markAsDirty();
    }

    public String getSize() { return getState().buttonSize; }
}
