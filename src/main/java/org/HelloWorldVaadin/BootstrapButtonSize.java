package org.HelloWorldVaadin;

public enum BootstrapButtonSize {
    LARGE("lg"),
    DEFAULT((String)null),
    SMALL("sm"),
    EXTRA_SMALL("xs");

    private final String size;

    private BootstrapButtonSize(String size) { this.size = size; }

    public String toCssName() {
        return (size == null)? null : "btn-" + size;
    }
}
