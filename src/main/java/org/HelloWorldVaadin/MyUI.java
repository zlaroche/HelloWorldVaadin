package org.HelloWorldVaadin;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *mcn
 */
@Theme("mytheme")
@Widgetset("org.HelloWorldVaadin.MyAppWidgetset")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        final BootstrapButton button = new BootstrapButton("Efflouresence");
        button.setType(BootstrapButtonType.SUCCESS);
        button.setSize(BootstrapButtonSize.EXTRA_SMALL);

        button.addListener(new Listener() {
            @Override
            public void componentEvent(Event event) {
                Notification.show("happenings");
            }
        });

        layout.addComponent(button);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
