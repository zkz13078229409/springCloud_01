package test;
/**
 * 泛型继承
 *
 * 保留父类泛型 ----》泛型子类
 * 不保留父类泛型 -----》子类按需实现
 *
 * 子类重写父类的方法，泛型类型随父类而定 子类使用父类的属性，该属性类型随父类定义的泛型
 *
 * @author Administrator
 *
 * @param <T1>
 * @param <T2>
 */
public abstract class Father<T1, T2> {
    T1 age;

    public abstract void test(T2 name);
}

// 保留父类泛型 ----》泛型子类
// 1）全部保留
class C1<T1, T2> extends Father<T1, T2> {

    @Override
    public void test(T2 name) {
    }
}

// 2) 部分保留
class C2<T1> extends Father<T1, Integer> {

    @Override
    public void test(Integer name) {

    }
}

// 不保留父类泛型 -----》子类按需实现
// 1)具体类型
class C3 extends Father<String, Integer> {

    @Override
    public void test(Integer name) {

    }
}

// 2)没有具体类型
// 泛型擦除：实现或继承父类的子类，没有指定类型，类似于Object
class C4 extends Father {

    @Override
    public void test(Object name) {

    }

}
