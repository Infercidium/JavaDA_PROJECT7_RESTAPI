package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.CurvePointService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {CurveController.class})
class CurveControllerTest {

    @MockBean
    private CurvePointService curvePointS;

    @MockBean
    private Model model;

    @MockBean
    private BindingResult result;

    @Autowired
    private CurveController curveC;

    private final CurvePoint curvePoint = new CurvePoint(1,1.00,1.00);

    @BeforeEach
    void setUp() {
        when(curvePointS.getCurvePoint(isA(Integer.class))).thenReturn(curvePoint);
    }

    @Test
    void home() {
        String result1 = curveC.home(model);
        assertEquals("curvePoint/list", result1);
    }

    @Test
    void addCurveForm() {
        String result2 = curveC.addCurveForm(curvePoint);
        assertEquals("curvePoint/add", result2);
    }

    @Test
    void validate() {
        when(result.hasErrors()).thenReturn(false);
        String result3 = curveC.validate(curvePoint, result, model);
        assertEquals("redirect:/curvePoint/list", result3);
    }

    @Test
    void validateFail() {
        when(result.hasErrors()).thenReturn(true);
        String result32 = curveC.validate(curvePoint, result, model);
        assertEquals("curvePoint/add", result32);
    }

    @Test
    void showUpdateForm() {
        String result4 = curveC.showUpdateForm(isA(Integer.class), model);
        assertEquals("curvePoint/update", result4);
    }

    @Test
    void updateCurve() {
        when(result.hasErrors()).thenReturn(false);
        String result5 = curveC.updateCurve(1, curvePoint, result, model);
        assertEquals("redirect:/curvePoint/list", result5);
    }

    @Test
    void updateCurveFail() {
        when(result.hasErrors()).thenReturn(true);
        String result52 = curveC.updateCurve(1, curvePoint, result, model);
        assertEquals("curvePoint/update", result52);
    }

    @Test
    void deleteCurve() {
        String result6 = curveC.deleteCurve(isA(Integer.class), model);
        assertEquals("redirect:/curvePoint/list", result6);
    }
}