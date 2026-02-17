package org.example.burgerprime.controllers;

import lombok.RequiredArgsConstructor;
import org.example.burgerprime.interfaces.AccountRepository;
import org.example.burgerprime.interfaces.FeedbackRepository;
import org.example.burgerprime.models.Account;
import org.example.burgerprime.models.Feedback;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackRepository feedbackRepository;
    private final AccountRepository accountRepository;
    @GetMapping("/feedback")
    public String feedback() {
        return "feedback";
    }
    @PostMapping("/feedback")
    public String submitFeedback(Integer rating, String feedback, Authentication authentication) {
        String username = authentication.getName();
        Account account = accountRepository.findByName(username);
        Feedback new_feedback = new Feedback();
        new_feedback.setRating(rating);
        new_feedback.setFeedback(feedback);
        new_feedback.setAccount(account);
        feedbackRepository.save(new_feedback);
        return "redirect:/profile";
    }
}
