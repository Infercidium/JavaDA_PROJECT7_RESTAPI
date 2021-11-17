package com.nnk.springboot.service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurvePointService implements CurvePointI {

    /**
     * Instantiation of LOGGER in order to inform in console.
     */
    private static final Logger LOGGER
            = LoggerFactory.getLogger(CurvePointService.class);

    /**
     * Instantiation of curvePointRepository.
     */
    @Autowired
    private CurvePointRepository curvePointR;

    //Service

    /**
     * Update a curvePoint in the database.
     * @param curvePoint : to add.
     */
    @Override
    public void postCurvePoint(final CurvePoint curvePoint) {
        curvePointR.save(curvePoint);
        LOGGER.debug("CurvePoint save");
    }

    /**
     * Update a curvePoint in the database.
     * @param curvePoint : to update.
     * @param id : to find origin CurvePoint.
     */
    @Override
    public void updateCurvePoint(final CurvePoint curvePoint,
                                 final Integer id) {
        CurvePoint originCurve = getCurvePoint(id);
        originCurve.setCurveId(curvePoint.getCurveId());
        originCurve.setTerm(curvePoint.getTerm());
        originCurve.setValue(curvePoint.getValue());
        curvePointR.save(originCurve);
        LOGGER.debug("CurvePoint update");
    }

    /**
     * Find the curvePoint which has the given id.
     * @param id : to find.
     * @return the curvePoint.
     */
    @Override
    public CurvePoint getCurvePoint(final int id) {
        LOGGER.debug("CurvePoint found");
        return curvePointR.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid curvePoint Id:" + id));
    }

    /**
     * Find all the curvePoints.
     * @return the list of curvePoints.
     */
    @Override
    public List<CurvePoint> getCurvePoints() {
        LOGGER.debug("CurvePoints found");
        return curvePointR.findAll();
    }

    /**
     * Remove the curvePoint which has the given id.
     * @param id : to delete.
     */
    @Override
    public void deleteCurvePoint(final int id) {
        CurvePoint curvePoint = getCurvePoint(id);
        curvePointR.delete(curvePoint);
        LOGGER.debug("CurvePoint remove");
    }
}
