package com.nnk.springboot.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(classes = {CurvePoint.class})
class CurvePointTest {

    private final CurvePoint curvePoint = new CurvePoint(1,1.00,1.00);
    private final CurvePoint curvePoint1 = new CurvePoint(1,1.00,1.00);
    private final CurvePoint curvePoint2 = new CurvePoint(1,1.00,1.00);

    @Test
    void testToString() {
        assertEquals("CurvePoint{id = null, curveId = 1, asOfDate = null, term = 1.0, value = 1.0, creationDate = null}", curvePoint.toString());
    }

    @Test
    void testEquals() {
        curvePoint.setId(1);
        curvePoint1.setId(1);
        curvePoint2.setId(2);
        assertEquals(curvePoint, curvePoint1);
        assertNotEquals(curvePoint, curvePoint2);
    }
}