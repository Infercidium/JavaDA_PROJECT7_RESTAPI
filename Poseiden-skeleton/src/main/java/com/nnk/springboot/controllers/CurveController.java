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

    /**
     * Instantiation of LOGGER in order to inform in console.
     */
    private static final Logger LOGGER
            = LoggerFactory.getLogger(CurveController.class);

    /**
     * Instantiation of curvePointInterface.
     */
    @Autowired
    private CurvePointI curvePointS;

    /**
     * Displays the list of curvePoint on the relevant page.
     * @param model : the list to display on the page.
     * @return the html page.
     */
    @RequestMapping("/curvePoint/list")
    public String home(final Model model) {
        model.addAttribute("curvePoints", curvePointS.getCurvePoints());
        LOGGER.info("List of Curve displayed");
        return "curvePoint/list";
    }

    /**
     * Displays the curvePoint add page.
     * @param curve : to add.
     * @return the html page.
     */
    @GetMapping("/curvePoint/add")
    public String addCurveForm(final CurvePoint curve) {
        LOGGER.debug("Entering the new Curve");
        return "curvePoint/add";
    }

    /**
     * Adds the entered Curve to the database.
     * @param curvePoint : to add.
     * @param result : check if there is an error.
     * @param model : the list to display on the next page.
     * @return the curvePoint list if no error, otherwise the add page.
     */
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

    /**
     * Displays the curvePoint edit page.
     * @param id : curve to modify.
     * @param model : displays the concerned curve.
     * @return the html page.
     */
    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") final Integer id,
                                 final Model model) {
        CurvePoint curvePoint = curvePointS.getCurvePoint(id);
        model.addAttribute("curvePoint", curvePoint);
        LOGGER.debug("Changing the Curve");
        return "curvePoint/update";
    }

    /**
     * Modifies the Curve entered the database.
     * @param id : curve to modify.
     * @param curvePoint : modified curve.
     * @param result : check if there is an error.
     * @param model : the list to display on the next page.
     * @return the curvePoint list if no error, otherwise the modification page.
     */
    @PostMapping("/curvePoint/update/{id}")
    public String updateCurve(@PathVariable("id") final Integer id,
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

    /**
     * Removes the selected Curve from the database.
     * @param id : curve to delete.
     * @param model : the list to display on the next page.
     * @return the list of curvePoint.
     */
    @GetMapping("/curvePoint/delete/{id}")
    public String deleteCurve(@PathVariable("id") final Integer id,
                            final Model model) {
        curvePointS.deleteCurvePoint(id);
        model.addAttribute("curvePoints", curvePointS.getCurvePoints());
        LOGGER.info("Curve deleted");
        return "redirect:/curvePoint/list";
    }
}
