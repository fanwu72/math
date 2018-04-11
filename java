    interface MySupplier<T> {
        T supply();
    }

    interface MyFunction<T, R> {
        R supply(T r);
    }

    interface MyTriFunction<T, R, E, W> {
        W supply(T t, R r, E e);
    }


    private Clients()
    {
        MySupplier<Integer> mySupplier = () -> 1;
        Supplier<Integer> supplier = () -> 1;
        Stream<String> stream = new ArrayList<String>().stream();
        Function<String, String> lowerFunction = a -> a.toLowerCase();
        stream.reduce((a, b) -> a + b);
        stream.map(lowerFunction);
        stream.map(MyFunctionTest::one);
        MyFunction<String, Integer> myFunc = MyFunctionTest::one;
        Function<String, Integer> f = MyFunctionTest::one;
        //not work
        //f = myFunc;
        //myFunc = f;
        //new ArrayList<String>().stream().map(f).map(myFunc);
        Arrays.stream(new int[5]);
        new ArrayList<Integer>().stream().mapToInt(a -> a).unordered().forEach((a) -> {});

        MyTriFunction<String, String, String, Integer> func = MyFunctionTest::three;

        Map<String, String> m = new HashMap<String, String>();
        m.compute("a", (k, v) -> v != null ? v + "hehe" : "hehe");
        m.forEach((k, v) -> {System.out.printf("k: %s, v: %s", k, v);});
        new ArrayList<String>().stream().flatMap(s -> new ArrayList<String>().stream());
        new ArrayList<String>().parallelStream();
        List<Integer> list1 = new ArrayList<>();
        IntStream.range(0, 10000).forEach(list1::add);
        //https://www.cnblogs.com/puyangsky/p/7608741.html
        //https://blog.csdn.net/u011001723/article/details/52794455
        ForkJoinPool.commonPool();

        //http://ifeve.com/java-fork-join-framework/#more-35602

    }
}

class MyFunctionTest {
    static int zero() {
        return 0;
    }
    static int one(String a) {
        return 1;
    }
    static int two(String a, String b) {
        return 2;
    }

    static int three(String a, String b, String c) {
        return 2;
    }

 //   public static Object three(Object o, Object o1, Object o2) {
//        return null;
//    }
}
