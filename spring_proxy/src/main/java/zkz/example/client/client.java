package zkz.example.client;


import zkz.example.Iproduct;
import zkz.example.product;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * create by: zkz
 * description: 模拟一个消费者
 * create time: 8:47 2019/9/18
 * param :
 */
public class client {
    public static void main(String[] args) {
      final product product=new product();
        /**
         * create by: zkz
         * description: 动态代理
         * 会出现的问题:如果不实现任何的接口会报异常

         /**
         * 动态代理：
         *  特点：字节码随用随创建，随用随加载
         *  作用：不修改源码的基础上对方法增强
         *  分类：
         *      基于接口的动态代理
         *      基于子类的动态代理
         *  基于接口的动态代理：
         *      涉及的类：Proxy
         *      提供者：JDK官方
         *  如何创建代理对象：
         *      使用Proxy类中的newProxyInstance方法
         *  创建代理对象的要求：
         *      被代理类最少实现一个接口，如果没有则不能使用
         *  newProxyInstance方法的参数：
         *      ClassLoader：类加载器
         *          它是用于加载代理对象字节码的。和被代理对象使用相同的类加载器。固定写法。
         *      Class[]：字节码数组
         *          它是用于让代理对象和被代理对象有相同方法。固定写法。
         *      InvocationHandler：用于提供增强的代码
         *          它是让我们写如何代理。我们一般都是些一个该接口的实现类，通常情况下都是匿名内部类，但不是必须的。
         *          此接口的实现类都是谁用谁写。

         *Exception in thread "main" java.lang.ClassCastException: com.sun.proxy.$Proxy0 cannot be cast to zkz.example.product
         * 	at zkz.example.client.client.main(client.java:29)
         * create time: 8:49 2019/9/18
         * param :
         */

        Iproduct iproduct=(Iproduct) Proxy.newProxyInstance(product.getClass().getClassLoader(), product.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 作用：执行被代理对象的任何接口方法都会经过该方法
             * 方法参数的含义
             * @param proxy   代理对象的引用
             * @param method  当前执行的方法
             * @param args    当前执行方法所需的参数
             * @return        和被代理对象方法有相同的返回值
             * @throws Throwable
             */
         @Override
         public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
             //增强的代码
                //获取方法执行的的参数
             Object returnValue=null;
             float money=(float) args[0];
             //判断当前方法是否是不是销售
             if("saleProduct".equals(method.getName())){
                 returnValue=method.invoke(product,money*0.8f);/*float类型相乘 argument type mismatch  不是类型的大小写就是运算格式不符合*/
             }
             return returnValue;
         }
     });
        //执行返回的代理的对象的方法
        iproduct.saleProduct(10000f);


    }

}
