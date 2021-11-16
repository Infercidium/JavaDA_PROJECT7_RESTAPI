package com.nnk.springboot.service;

import com.nnk.springboot.domain.CurvePoint;

import java.util.List;

public interface CurvePointI {
    //Service
    /**
     * Add / Update a curvePoint in the database.
     * @param curvePoint : to add / update.
     */
    void postCurvePoint(CurvePoint curvePoint);

    /**
     * Find the curvePoint which has the given id.
     * @param id : to find.
     * @return the curvePoint.
     */
    CurvePoint getCurvePoint(int id);

    /**
     * Find all the curvePoints.
     * @return the list of curvePoints.
     */
    List<CurvePoint> getCurvePoints();

    /**
     * Remove the curvePoint which has the given id.
     * @param id : to delete.
     */
    void deleteCurvePoint(int id);
}
