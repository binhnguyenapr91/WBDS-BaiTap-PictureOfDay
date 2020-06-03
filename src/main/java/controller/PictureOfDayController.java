package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.PictureOfDayService;

@Controller
public class PictureOfDayController {
    @Autowired
    private PictureOfDayService pictureOfDayService;
    @RequestMapping("/")
    ModelAndView getHome(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("feedbacks",pictureOfDayService.getAllFeedback());
        return modelAndView;
    }
}
