public class LambdaHello {

    interface Printer { void print(); }

    public static void main(String[] args) {
        Printer p = () -> System.out.println("Hallo Welt!");
        p.print();    // "Hallo Welt!"
        Addieren addieren = x ->{x *=5; return x;} ;
        System.out.println(addieren.addiere(5));
    }
}