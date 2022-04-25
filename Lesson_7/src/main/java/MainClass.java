import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;


public class MainClass {
    public static void main(String[] args) {
    run(TestClass.class);
}

    private static void run(Class testClass)  {
        Method[] methods = testClass.getDeclaredMethods();
        int a = 0;

        for (Method o : methods) {
            if(o.getAnnotation(BeforeSuite.class) != null) {
                a++;
                try {
                    o.invoke(testClass.getClasses());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                if (a > 1){
                    throw new RuntimeException();
                }
            }

        }
        for (int i = 1; i <= 10; i++){
            for (Method o : methods) {
                if(o.getAnnotation(Test.class) != null && o.getAnnotation(Test.class).value() == i) {
                    try {
                        o.invoke(testClass.getClasses());
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        a = 0;
        for (Method o : methods) {
            if(o.getAnnotation(AfterSuite.class) != null) {
                a++;
                try {
                    o.invoke(testClass.getClasses());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                if (a > 1){
                    throw new RuntimeException();
                }
            }
        }

    }
}
