package exceptionDemo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hashcode is: " );

        // calling the garbage collector using gc()
        System.gc();
        System.out.println("End of the garbage collection");
    }

    @Override
    protected void finalize() {
        System.out.println("object destroyed");
    }
}
