package com.nnk.springboot.service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    private final CurvePoint curvePoint = new CurvePoint(1,1.00,1.00);

    @BeforeEach
    void setUp() {
        curvePoint.setId(2);

        when(curvePointR.findById(isA(Integer.class))).thenAnswer(new Answer<Optional<CurvePoint>>() {
            /**
             * @param invocation the invocation on the mock.
             * @return the value to be returned
             */
            @Override
            public Optional<CurvePoint> answer(InvocationOnMock invocation) {
                Integer integer = invocation.getArgument(0, Integer.class);
                if (integer == 0) {
                    return Optional.empty();
                }
                return Optional.of(curvePoint);
            }
        });
    }

    @Test
    void postCurvePoint() {
        curvePointS.postCurvePoint(curvePoint);
        verify(curvePointR, times(1)).save(curvePoint);
    }

    @Test
    void updateCurvePoint() {
        curvePointS.updateCurvePoint(curvePoint, 2);
        verify(curvePointR, times(1)).save(curvePoint);
        assertEquals(2, curvePoint.getId());
    }

    @Test
    void getCurvePoint() {
        CurvePoint curvePointResult = curvePointS.getCurvePoint(1);
        assertEquals(curvePoint, curvePointResult);
    }

    @Test
    void getCurvePointFail() {
        assertThrows(IllegalArgumentException.class, ()->curvePointS.getCurvePoint(0));
    }

    @Test
    void getCurvePoints() {
        when(curvePointR.findAll()).thenReturn(Collections.singletonList(curvePoint));
        List<CurvePoint> curvePointList = curvePointS.getCurvePoints();
        assertEquals(Collections.singletonList(curvePoint), curvePointList);
    }

    @Test
    void deleteCurvePoint() {
        curvePointS.deleteCurvePoint(1);
        verify(curvePointR, times(1)).delete(curvePoint);
    }
}