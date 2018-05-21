package com.interview.thread.part3;

public class FinalDemo extends FinalDemoParent{
    private final int a=6;
    private final String str;
    private final static boolean b;
    private final double c;
    //没有在构造器中，初始化代码块，声明时赋值，所以报错
    //private final char ch;

    {
        //实例变量可以在初始化代码块赋值
        str = "初始化代码库赋值";
    }

    static {
        //类变量（静态变量）可以在静态初始化块中赋值
        b = true;
        //非静态变量不可以在静态初始化代码块中赋值
        //str="非静态变量不可以在静态初始化代码块中赋值";
    }

    public FinalDemo(){
        //实例变量可以在构造器中赋初值
        c = 1.0;
        //final变量已经赋值了就不能再改变
        //a = 1;
    }

    public void a(){
        //实例方法不能为final变量赋值
        //ch = 'a';
    }

    public void test(final int a){
        final int b;
        b = 1;
        //上面已经进行一次赋值，再赋值就会报错
        //b = 2;
        //由于调用方法的入参已经进行了一次赋值，再次赋值就会报错
        //a = 3;
    }

//    @Override
//    public void test(){
//        super.test();
//    }
}
