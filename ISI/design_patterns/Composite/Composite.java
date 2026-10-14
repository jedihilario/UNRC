import java.util.List;
import java.util.ArrayList;

public class Composite implements Component {
    private List<Component> components;

    public Composite () {
        this.components = new ArrayList<>();
    }

    @Override
    public void operation () {
        System.out.println("Composite operation!");
        for (Component i : components) {
            i.operation();
        }
    }

    public void addComponent (Component c) {
        this.components.add(c);
    }
}

