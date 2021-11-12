package com.nnk.springboot.service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {CurvePointService.class})
class CurvePointServiceTest {

    @MockBean
    private CurvePointRepository curvePointR;

    @Autowired
    private CurvePointService curvePointS;

    private CurvePoint curvePoint = new CurvePoint(1,1.00,1.00);

    @BeforeEach
    void setUp() {
        when(curvePointR.findById(isA(Integer.class))).thenReturn(java.util.Optional.ofNullable(curvePoint));
    }

    @Test
    void postCurvePoint() {
        curvePointS.postCurvePoint(curvePoint);
        verify(curvePointR, times(1)).save(curvePoint);
    }

    @Test
    void getCurvePoint() {
        CurvePoint curvePointResult = curvePointS.getCurvePoint(isA(Integer.class));
        assertEquals(curvePoint, curvePointResult);
    }

    @Test
    void getCurvePoints() {
        when(curvePointR.findAll()).thenReturn(Collections.singletonList(curvePoint));
        List<CurvePoint> curvePointList = curvePointS.getCurvePoints();
        assertEquals(Collections.singletonList(curvePoint), curvePointList);
    }

    @Test
    void deleteCurvePoint() {
        curvePointS.deleteCurvePoint(isA(Integer.class));
        verify(curvePointR, times(1)).delete(curvePoint);
    }
}