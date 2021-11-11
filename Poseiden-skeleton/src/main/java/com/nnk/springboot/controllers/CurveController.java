package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.CurvePointI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class CurveController {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(CurveController.class);

    @Autowired
    private CurvePointI curvePointS;

    @RequestMapping("/curvePoint/list")
    public String home(final Model model) {
        model.addAttribute("curvePoints", curvePointS.getCurvePoints());
        LOGGER.info("List of Curve displayed");
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addBidForm(final CurvePoint bid) {
        LOGGER.debug("Entering the new Curve");
        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/validate")
    public String validate(@Valid final CurvePoint curvePoint,
                           final BindingResult result, final Model model) {
        if (!result.hasErrors()) {
            curvePointS.postCurvePoint(curvePoint);
            model.addAttribute("curvePoints", curvePointS.getCurvePoints());
            LOGGER.info("Curve added");
            return "redirect:/curvePoint/list";
        }
        LOGGER.error("Entry error");
        return "curvePoint/add";
    }

    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") final Integer id,
                                 final Model model) {
        CurvePoint curvePoint = curvePointS.getCurvePoint(id);
        model.addAttribute("curvePoint", curvePoint);
        LOGGER.debug("Changing the Curve");
        return "curvePoint/update";
    }

    @PostMapping("/curvePoint/update/{id}")
    public String updateBid(@PathVariable("id") final Integer id,
                            @Valid final CurvePoint curvePoint,
                             final BindingResult result, final Model model) {
        if (result.hasErrors()) {
            LOGGER.error("Entry error");
            return "curvePoint/update";
        }
        curvePoint.setId(id);
        curvePointS.postCurvePoint(curvePoint);
        model.addAttribute("curvePoints", curvePointS.getCurvePoints());
        LOGGER.info("Modified curve");
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/delete/{id}")
    public String deleteBid(@PathVariable("id") final Integer id,
                            final Model model) {
        curvePointS.deleteCurvePoint(id);
        model.addAttribute("curvePoints", curvePointS.getCurvePoints());
        LOGGER.info("Curve deleted");
        return "redirect:/curvePoint/list";
    }
}
