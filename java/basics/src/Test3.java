public class Test3 {
    static int x;
    static int y;
    void add(int a,int b){
        x=a+b;
        y=x+b;
    }

    public static void main(String[] args) {
        Test3 obj1=new Test3();
        Test3 obj2=new Test3();
        int a=2;
        obj1.add(a,a+1);
        obj2.add(5,a);
        System.out.println(obj1.x+" "+obj2.y);
    }
}
