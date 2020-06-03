package service;

import model.Feedback;

import java.util.List;

public interface PictureOfDayService {
    List<Feedback> getAllFeedback();
    Feedback addFeedback(Feedback feedback);
    void updateById(int id,Feedback feedback);
    Feedback getById(int id);
}
