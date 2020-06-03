package controller;

import model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.PictureOfDayService;

@Controller
public class PictureOfDayController {
    @Autowired
    private PictureOfDayService pictureOfDayService;

    @GetMapping("/")
    String getHome(){
        return "index";
    }
    @GetMapping("/feedbackListing")
    ModelAndView getLising(){
        ModelAndView modelAndView = new ModelAndView("feedbackListing");
        modelAndView.addObject("feedbacks",pictureOfDayService.getAllFeedback());
        return modelAndView;
    }

    @PostMapping("/addFeedBack")
    ModelAndView addFeedback(@ModelAttribute ("feedBack") Feedback feedback){

        ModelAndView modelAndView = new ModelAndView("feedbackListing");
        pictureOfDayService.addFeedback(feedback);
        modelAndView.addObject("feedbacks",pictureOfDayService.getAllFeedback());
        return modelAndView;
    }

    @GetMapping("/addFeedBack")
    ModelAndView getHome(Model model){
        ModelAndView modelAndView = new ModelAndView("addFeedBack");
        modelAndView.addObject("feedback",new Feedback());
        return modelAndView;
    }

    @GetMapping("/like/{id}")
    ModelAndView like(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("feedbackListing");
        Feedback holder = pictureOfDayService.getById(id);
        pictureOfDayService.updateById(holder.getId(),holder);
        modelAndView.addObject("feedbacks",pictureOfDayService.getAllFeedback());
        return modelAndView;
    }



}
