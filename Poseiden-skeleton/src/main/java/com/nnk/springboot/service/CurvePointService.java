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

    private static final Logger LOGGER
            = LoggerFactory.getLogger(CurvePointService.class);

    @Autowired
    private CurvePointRepository curvePointR;

    //Service
    @Override
    public void postCurvePoint(final CurvePoint curvePoint) {
        curvePointR.save(curvePoint);
        LOGGER.debug("CurvePoint save");
    }

    @Override
    public CurvePoint getCurvePoint(final int id) {
        LOGGER.debug("CurvePoint found");
        return curvePointR.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid curvePoint Id:" + id));
    }

    @Override
    public List<CurvePoint> getCurvePoints() {
        LOGGER.debug("CurvePoints found");
        return curvePointR.findAll();
    }

    @Override
    public void deleteCurvePoint(final int id) {
        CurvePoint curvePoint = getCurvePoint(id);
        curvePointR.delete(curvePoint);
        LOGGER.debug("CurvePoint remove");
    }
}
