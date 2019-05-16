package org.yabo.java.test;

import com.alibaba.fastjson.JSON;

enum Type {
    A("A"), B("B"), C("C");

    Type(String label) {
        this.label = label;
    }

    String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

public class Father {
    Type type;

    public Type getType() {
        throw new UnsupportedOperationException("unsss");
    }

    public void setType(Type type) {
        this.type = type;
    }

    public static void main(String[] args) {
//        Son1 s1 = new Son1();
////        Son2 s2 = new Son2();
//        String string = JSON.toJSONString(s1);
//        System.out.println(string);
////        JSONObject jsonObject = JSON.parseObject(string);
////        System.out.println(jsonObject.getClass());
//        Class sonClass = Son1.class;
//        String cla=JSON.toJSONString(sonClass);
//        System.out.println(cla);
//        Class aClass = JSON.parseObject(cla, Class.class);
//        System.out.println(aClass);
//        System.out.println(aClass==Son1.class);
//
//        f1.type = 1;
////        Father f2=new Son2();
////        f2.type=2;
//
        Son1 son1 = new Son1();
        String string = JSON.toJSONString(son1);
        Father father = JSON.parseObject(string, Father.class);
        if (father.type == Type.A) {
            Son1 son2 = JSON.parseObject(string, Son1.class);
            System.out.println(son2.n);
        }
        System.out.println(father);

    }
}

class Data {
    Class clazz;
    Object data;

    public Data(Object data) {
        this.data = data;
        this.clazz = data.getClass();
    }
}

class Son1 extends Father {
    Integer n = 1;

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    @Override
    public Type getType() {
        return Type.A;
    }
}

class Son2 extends Father {
    String string = "xxx";

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public Type getType() {
        return Type.B;
    }
}

