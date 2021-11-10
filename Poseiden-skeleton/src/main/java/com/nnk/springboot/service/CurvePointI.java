package com.nnk.springboot.service;

import com.nnk.springboot.domain.CurvePoint;

import java.util.List;

public interface CurvePointI {
    //Service
    void postCurvePoint(CurvePoint curvePoint);

    CurvePoint getCurvePoint(int id);

    List<CurvePoint> getCurvePoints();

    void deleteCurvePoint(int id);
}
