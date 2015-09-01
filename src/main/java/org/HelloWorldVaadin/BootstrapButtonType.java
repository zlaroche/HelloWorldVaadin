package org.HelloWorldVaadin;

public enum BootstrapButtonType {
        DEFAULT("default"),
        PRIMARY("primary"),
        SUCCESS("success"),
        INFO("info"),
        WARNING("warning"),
        DANGER("danger"),
        LINK("link");

        private final String type;

        private BootstrapButtonType(String type) { this.type = type; }

        public String toCssName() { return "btn-" + type; }
}
