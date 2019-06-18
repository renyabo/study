public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        context.setA("a")
                .setB("b")
                .setC("c");
        System.out.println(context);
    }
}

class Context {
    String a;
    String b;
    String c;

    public Context setA(String a) {
        this.a = a;
        return this;

    }

    public Context setB(String b) {
        this.b = b;
        return this;

    }

    public Context setC(String c) {
        if (a != null && b != null) {
            this.c = c;
        }
        return this;
    }

    @Override
    public String toString() {
        return "Context{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                '}';
    }
}