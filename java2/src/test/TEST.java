package test;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TEST {
@Test
    public void test() {
    String s1="123";
    String s2=new String("123");
    StringBuilder sb=new StringBuilder("123");
    System.out.println(s1.equals(s2));			//true
    System.out.println(s1.contentEquals(s2));	//true
    System.out.println(s1.equals(sb));			//false ,
    System.out.println(s1.contentEquals(sb));

    }
    @Test
    public void test2(){
    char [] s2={'c','b','a'};
        String s1 = String.valueOf(s2);
        System.out.println(s1);
        String s3 = String.copyValueOf(s2);
        String s=String.valueOf('a');
    System.out.println(s);
    try {
        String s4="admin";
        byte[] asciis = s4.getBytes("ASCII");
        System.out.println(asciis.toString());
        String s5=new String(asciis);
        System.out.println(s5);
        System.out.println(s5.hashCode());
    }catch (Exception e){

    }

    }

    @Test
    public void test_System() throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
            char  c;
        do{
            c=(char)bufferedReader.read();
            System.out.println(c);
        }while(c!='q');

    }
    @Test
    public void test_Exeception(){
        //检查异常1.打开文件
        FileReader fr=null;
        try {
            fr=new FileReader("C:\\Users\\dell\\Desktop\\java方法.txt");
            // 在出现异常的地方，下面的代码的就不执行
            System.out.println("aaa");
        } catch (Exception e) {
            System.out.println("进入catch");
            // 文档读取异常
            //System.exit(-1);//这句话加上后就不执行finally语句块而是直接退出程序
            System.out.println("message="+e.getLocalizedMessage());  //没有报哪一行出错
            e.printStackTrace();   // 打印出错异常还出现可以报出错先异常的行
        }
        // 这个语句块不管发生没有发生异常，都会执行
        // 一般来说，把需要关闭的资源，文件，连接，内存等
        finally
        {
            System.out.println("进入finally");
            if(fr!=null);
            {
                try {
                    fr.close();
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        }
        System.out.println("OK");
    }



    // 泛型方法 printArray
    public static < E > void printArray( E[] inputArray )
    {
        // 输出数组元素
        for ( E element : inputArray ){
            System.out.printf( "%s ", element );
        }
        System.out.println();
    }
    @Test
    public void genericity()
    {
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println( "整型数组元素为:" );
        printArray( intArray  ); // 传递一个整型数组

        System.out.println( "\n双精度型数组元素为:" );
        printArray( doubleArray ); // 传递一个双精度型数组

        System.out.println( "\n字符型数组元素为:" );
        printArray( charArray ); // 传递一个字符型数组
    }

    //测试泛型的有界参数类型

    // 比较三个值并返回最大值
    public static <T extends Comparable<T>> T maximum(T x, T y, T z)
    {
        T max = x; // 假设x是初始最大值
        if ( y.compareTo( max ) > 0 ){
            max = y; //y 更大
        }
        if ( z.compareTo( max ) > 0 ){
            max = z; // 现在 z 更大
        }
        return max; // 返回最大对象
    }
    @Test
    public void Bounded_parameter()
    {
        System.out.printf( "%d, %d 和 %d 中最大的数为 %d\n\n",
                3, 4, 5, maximum( 3, 4, 5 ) );

        System.out.printf( "%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n",
                6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ) );

        System.out.printf( "%s, %s 和 %s 中最大的数为 %s\n","pear",
                "apple", "orange", maximum( "pear", "apple", "orange" ) );
    }

    @Test
//测试泛型的类型通配符
    public void test6() {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();

        name.add("icon");
        age.add(18);
        number.add(314);

        getData(name);
        getData(age);
        getData(number);

    }

    public static void getData(List<?> data) {
        System.out.println("data :" + data.get(0));
    }

    //测试泛型的上界类型
    @Test
    public  void test7()
    {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();

        name.add("icon");
        age.add(18);
        number.add(314);

        //getUperNumber(name);//1
        getUperNumber(age);//2
        getUperNumber(number);//3

    }
//  ? super Number 表示参数只接受形如Number和其父类
    private void getUperNumber(List<? extends  Number> data) {
        System.out.println("data :" + data.get(0));
    }


    // T... 可变参数   --->   T[]
    public static <T extends InputStream> void test3(T...a) {
        for (T temp : a) {
            try {
                if (null != temp) {
                    System.out.println(temp.available());
                    temp.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    @Test
    public void test8() throws FileNotFoundException {
        test3(new FileInputStream("C:\\Users\\dell\\Desktop\\java方法.txt"),new FileInputStream("C:\\Users\\dell\\Desktop\\时间函数Date.txt"));
    }


}
