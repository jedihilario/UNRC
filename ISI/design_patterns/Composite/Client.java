public class Client {
    public static void main (String[] args) {
        Leaf leaf1 = new Leaf();
        Leaf leaf2 = new Leaf();
        Composite comp1 = new Composite();
        comp1.addComponent(leaf1);
        comp1.addComponent(leaf2);

        Leaf leaf3 = new Leaf();
        Composite comp2 = new Composite();
        comp2.addComponent(comp1);
        comp2.addComponent(leaf3);

        comp2.operation();
    }
}
