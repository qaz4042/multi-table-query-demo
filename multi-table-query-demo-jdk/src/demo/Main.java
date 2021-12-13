package demo;


import demo.config.MybatisPlusMultiConfig;

public class Main {

    public static void main(String[] args) {
        //初始配置
        MybatisPlusMultiConfig.build();

        Test test = new Test();
        test.testQuerySimple();
        test.testQueryPage();
        test.testQueryParamMap();
        test.testQueryAggregate();
        test.testQueryComplex();
    }

}
