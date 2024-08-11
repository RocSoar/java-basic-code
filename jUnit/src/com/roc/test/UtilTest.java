package com.roc.test;

import org.junit.*;

public class UtilTest {
    @Test
    public void testReverseNumber() {
        int res = Util.reverseNumber(1234);
        Assert.assertEquals(4321, res);
    }

    @Test
    public void testConcatToNumber() {
        int res = Util.concatToNumber(new int[]{1, 2, 3, 4});
        Assert.assertEquals(1234, res);
    }

    @Test
    public void testSeparateToArray() {
        int[] res = Util.separateToArray(1234);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, res);
    }

    @Before
    public void beforeEach() {
        System.out.println("在每一个测试方法执行前都要运行一次");
    }

    @After
    public void afterEach() {
        System.out.println("在每一个测试方法执行后都要运行一次");
    }

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("在本类的所有测试方法执行前只运行一次");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("在本类的所有测试方法全部执行完后只运行一次");
    }
}
