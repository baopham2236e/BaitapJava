package bai1_3;

public class MainRetangle {
    public static void main(String[] args) {
        Retangle h1 = new Retangle(1.3f,3.4f);
        System.out.println(h1);
        Retangle hinh = new Retangle();
        System.out.println(hinh);
        Retangle h2 = new Retangle(5.6f,7.8f);
        System.out.println(h2);

        System.out.println("length is: "+h2.getLength());
        System.out.println("width is: "+h2.getWidth());
        System.out.println("Area= "+h2.area());
        System.out.println("Primeter= "+h2.primeter());
        Retangle Retangle = new Retangle();
        System.out.println(Retangle);
    }
}
