package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.service.RatingI;
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
public class RatingController {

    @Autowired
    private RatingI ratingS;

    @RequestMapping("/rating/list")
    public String home(final Model model) {
        model.addAttribute("ratings", ratingS.getRatings());
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(final Rating rating) {
        return "rating/add";
    }

    @PostMapping("/rating/validate")
    public String validate(@Valid final Rating rating, final BindingResult result, final Model model) {
        if (!result.hasErrors()) {
            ratingS.postRating(rating);
            model.addAttribute("ratings", ratingS.getRatings());
            return "redirect:/rating/list";
        }
        return "rating/add";
    }

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") final Integer id, final Model model) {
        Rating rating = ratingS.getRating(id);
        model.addAttribute("rating", rating);
        return "rating/update";
    }

    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") final Integer id, @Valid final Rating rating,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "rating/update";
        }
        rating.setId(id);
        ratingS.postRating(rating);
        model.addAttribute("ratings", ratingS.getRatings());
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") final Integer id, final Model model) {
        ratingS.deleteRating(id);
        model.addAttribute("ratings", ratingS.getRatings());
        return "redirect:/rating/list";
    }
}
