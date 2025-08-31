public class Caja <T> {
    private T content;

    public T getContent () {
        return this.content;
    }

    public void save (T item) {
        assert item != null;

        this.content = item;
    }

    public void showInfo () {
        System.out.println("El objeto guardado en esta caja es: " + this.content);
    }
}
