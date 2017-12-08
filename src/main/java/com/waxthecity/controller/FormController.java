package com.waxthecity.controller;

import com.waxthecity.model.RegBean;
import com.waxthecity.service.PdfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Balaji on 7/12/17.
 */
@Controller
public class FormController {
    private static final Logger LOGGER= LoggerFactory.getLogger(FormController.class.getName());
    @Autowired
    private PdfService pdfService;
    @RequestMapping("/")
    public String showForm() {
        LOGGER.info("Showing waxing the city form");
        return "waxingTheCityForm";
    }

    @RequestMapping(value = "generate" , method = RequestMethod.POST)
    public String generatePdf(@ModelAttribute RegBean regBean){
        LOGGER.info("Generating pdf {}", regBean);
        pdfService.generatePdf(regBean);
        return "redirect:/";
    }
}
