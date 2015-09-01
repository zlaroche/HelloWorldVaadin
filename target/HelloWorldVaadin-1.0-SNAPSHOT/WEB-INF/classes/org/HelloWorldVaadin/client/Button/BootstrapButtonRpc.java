package org.HelloWorldVaadin.client.Button;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.communication.ServerRpc;

public interface BootstrapButtonRpc extends ServerRpc {
    void click(MouseEventDetails mouseEventDetails);
}
