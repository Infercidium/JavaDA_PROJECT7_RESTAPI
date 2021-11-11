package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.CurvePointI;
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

    @Autowired
    private CurvePointI curvePointS;

    @RequestMapping("/curvePoint/list")
    public String home(final Model model) {
        model.addAttribute("curvePoints", curvePointS.getCurvePoints());
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addBidForm(final CurvePoint bid) {
        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/validate")
    public String validate(@Valid final CurvePoint curvePoint, final BindingResult result, final Model model) {
        if (!result.hasErrors()) {
            curvePointS.postCurvePoint(curvePoint);
            model.addAttribute("curvePoints", curvePointS.getCurvePoints());
            return "redirect:/curvePoint/list";
        }
        return "curvePoint/add";
    }

    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") final Integer id, final Model model) {
        CurvePoint curvePoint = curvePointS.getCurvePoint(id);
        model.addAttribute("curvePoint", curvePoint);
        return "curvePoint/update";
    }

    @PostMapping("/curvePoint/update/{id}")
    public String updateBid(@PathVariable("id") final Integer id, @Valid final CurvePoint curvePoint,
                             final BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "curvePoint/update";
        }
        curvePoint.setId(id);
        curvePointS.postCurvePoint(curvePoint);
        model.addAttribute("curvePoints", curvePointS.getCurvePoints());
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/delete/{id}")
    public String deleteBid(@PathVariable("id") final Integer id, final Model model) {
        curvePointS.deleteCurvePoint(id);
        model.addAttribute("curvePoints", curvePointS.getCurvePoints());
        return "redirect:/curvePoint/list";
    }
}
