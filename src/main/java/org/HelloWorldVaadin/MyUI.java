package org.HelloWorldVaadin;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import java.util.Iterator;

/**
 *mcn
 */
@Theme("mytheme")
@Widgetset("org.HelloWorldVaadin.MyAppWidgetset")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        final BootstrapPanel panel1 = new BootstrapPanel();
        final BootstrapPanel panel2 = new BootstrapPanel();

        final BootstrapButton button = new BootstrapButton("Efflouresence");
        button.setType(BootstrapButtonType.SUCCESS);
        button.setSize(BootstrapButtonSize.EXTRA_SMALL);

        panel1.addComponent(button);
        panel1.addComponent(panel2);
        setContent(panel1);

        Iterator<Component> iterator = panel1.iterator();
        String children1 = "";
        while (iterator.hasNext())
            children1 += iterator.next().toString() + ", ";
        final String children2 = children1;

        button.addListener(new Listener() {
            @Override
            public void componentEvent(Event event) {
                Notification.show(children2);
            }
        });

        Button button1 = new Button();


    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
