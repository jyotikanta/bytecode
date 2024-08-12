package immutability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableClass {
    private final int id;
    private final String name;
    private final List<String> items;

    public ImmutableClass(int id, String name, List<String> items) {
        this.id = id;
        this.name = name;
        this.items = Collections.unmodifiableList(new ArrayList<>(items));
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
