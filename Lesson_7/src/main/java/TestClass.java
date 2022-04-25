public class TestClass {

    @Test(value = 1)
    public static void number1() {
        System.out.println("number1");
    }

    @Test(value = 3)
    public static void number2() {
        System.out.println("number2");
    }

    @BeforeSuite
    public static void number3() {
        System.out.println("number3");
    }

    @Test(value = 2)
    public static void number4() {
        System.out.println("number4");
    }

    @AfterSuite
    public static void number5() {
        System.out.println("number5");
    }
}
