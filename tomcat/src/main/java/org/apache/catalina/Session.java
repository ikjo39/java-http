package org.apache.catalina;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Session {

    private final String id;
    private final Map<String, Object> values = new HashMap<>();

    public Session() {
        this(UUID.randomUUID().toString());
    }

    public Session(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Object getAttribute(String name) {
        return values.get(name);
    }

    public void setAttribute(String name, Object value) {
        values.put(name, value);
    }

    public void removeAttribute(String name) {
        values.remove(name);
    }

    public void invalidate() {
        values.clear();
    }
}
