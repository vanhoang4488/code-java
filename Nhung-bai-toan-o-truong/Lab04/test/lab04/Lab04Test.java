package lab04;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class Lab04Test {
    
    public Lab04Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of max method, of class Lab04.
     */
    @Test
    public void testMax1() {
        System.out.println("max");
        int a = 1;
        int b = 2;
        int expResult = 2;
        int result = Lab04.max(a, b);
        assertEquals(expResult, result);
    }
    @Test
    public void testMax2() {
        System.out.println("max");
        int a = 1;
        int b = 3;
        int expResult = 3;
        int result = Lab04.max(a, b);
        assertEquals(expResult, result);
    }
    @Test
    public void testMax3() {
        System.out.println("max");
        int a = 5;
        int b = 2;
        int expResult = 5;
        int result = Lab04.max(a, b);
        assertEquals(expResult, result);
    }
    @Test
    public void testMax4() {
        System.out.println("max");
        int a = 10;
        int b = 12;
        int expResult = 12;
        int result = Lab04.max(a, b);
        assertEquals(expResult, result);
    }
    @Test
    public void testMax5() {
        System.out.println("max");
        int a = 21;
        int b = 32;
        int expResult = 32;
        int result = Lab04.max(a, b);
        assertEquals(expResult, result);
    }
    /**
     * Test of minArray method, of class Lab04.
     */
    @Test
    public void testMinArray1() {
        System.out.println("minArray");
        int[] a = {2,3,1,4,5,6};
        int expResult = a[2];
        int result = Lab04.minArray(a);
        assertEquals(expResult, result);
    }
    @Test
    public void testMinArray2() {
        System.out.println("minArray");
        int[] a = {2,1,3,4};
        int expResult = a[1];
        int result = Lab04.minArray(a);
        assertEquals(expResult, result);
    }
    @Test
    public void testMinArray3() {
        System.out.println("minArray");
        int[] a = {3,1,2,3,0,4,5,6,7,8};
        int expResult = a[4];
        int result = Lab04.minArray(a);
        assertEquals(expResult, result);
    }
    @Test
    public void testMinArray4() {
        System.out.println("minArray");
        int[] a = {1,2,3,4,5,6,7};
        int expResult = a[0];
        int result = Lab04.minArray(a);
        assertEquals(expResult, result);
    }
    @Test
    public void testMinArray() {
        System.out.println("minArray");
        int[] a = {4,3,2,1,0};
        int expResult = a[4];
        int result = Lab04.minArray(a);
        assertEquals(expResult, result);
    }
    /**
     * Test of BMI method, of class Lab04.
     */
    @Test
    public void testBMI1() {
        System.out.println("BMI");
        double weigh = 40;
        double high = 1.5;
        String expResult = "Thieu can";
        String result = Lab04.BMI(weigh, high);
        assertEquals(expResult, result);
    }
    @Test
    public void testBMI2() {
        System.out.println("BMI");
        double weigh = 50;
        double high = 1.6;
        String expResult = "Binh thuong";
        String result = Lab04.BMI(weigh, high);
        assertEquals(expResult, result);
    }
    @Test
    public void testBMI3() {
        System.out.println("BMI");
        double weigh = 60;
        double high = 1.7;
        String expResult = "Binh thuong";
        String result = Lab04.BMI(weigh, high);
        assertEquals(expResult, result);
    }
    @Test
    public void testBMI4() {
        System.out.println("BMI");
        double weigh = 70;
        double high = 1.8;
        String expResult = "Binh thuong";
        String result = Lab04.BMI(weigh, high);
        assertEquals(expResult, result);
    }
    @Test
    public void testBMI5() {
        System.out.println("BMI");
        double weigh = 80;
        double high = 1.9;
        String expResult = "Binh thuong";
        String result = Lab04.BMI(weigh, high);
        assertEquals(expResult, result);
    }
}
