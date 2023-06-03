package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@IndicativeSentencesGeneration
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoUtilsTest {


    DemoUtils demoUtils;

    @BeforeAll
    void setUpBeforeAll() {
        demoUtils = new DemoUtils();
        System.out.println("@BeforeAll set up before calling individual test methods");
    }

    @AfterAll
    void setUpAfterAll() {
        System.out.println("@AfterAll executing once the Test method finishes execution");
    }

    @Test
    @Order(1)
    void testEqualsAndNotEquals() {
        assertEquals(5, demoUtils.add(2,3),"2+3 should be 5");
        assertNotEquals(6,demoUtils.add(2,5),"2+3 should not be equal to 6");
    }

    @Test
    @Order(1)
    void testNullAndNotNull() {
        String s1 = "Hello";
        assertNotNull(demoUtils.checkNull(s1));
        assertNull(demoUtils.checkNull(null));
    }

    @Test
    void testSameAndNotSame() {
        String str = "Hello";
        System.out.println(str);
        System.out.println(demoUtils.getAcademy());
        System.out.println(demoUtils.getAcademyDuplicate());
        assertSame(demoUtils.getAcademy(),demoUtils.getAcademyDuplicate());
        assertNotSame(str, demoUtils.getAcademy());
    }

    @Test
    void testTrueAndFalse() {
        assertTrue(demoUtils.isGreater(2,1));
        assertFalse(demoUtils.isGreater(3,9));
    }

    @Test
    void testArrayEquals() {
        String[] stringArray = {"A","B","C"};
        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(),"Arrays should be same");

    }

    @Test
    void testIterableEquals() {
        List<String> testList = List.of("luv", "2", "code");
        assertIterableEquals(testList, demoUtils.getAcademyInList());
    }

    @Test
    void testThrowsException() {
        assertThrows(Exception.class, () -> {demoUtils.throwException(-1);});
        assertDoesNotThrow(() -> {demoUtils.throwException(2);});
    }

    @Test
    void testTimeOut() {
        assertTimeoutPreemptively(Duration.ofMillis(3000), () -> {demoUtils.checkTimeout();});
    }

    @Test
    void testMultiply() {
        assertEquals(6, demoUtils.multiply(2,3));
        assertNotEquals(6, demoUtils.multiply(2,2));
    }

}
