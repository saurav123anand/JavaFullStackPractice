package genericsdemo;

public class Fruit<T> {
    private T name;

    public T getName() {
        return name;
    }


    public void setName(T name) {
        this.name = name;
    }
}
