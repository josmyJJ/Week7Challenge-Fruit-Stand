package com.example.challenge7;

import com.cloudinary.utils.ObjectUtils;
import com.example.challenge7.config.CloudinaryConfig;
import com.example.challenge7.config.DaysRepository;
import com.example.challenge7.config.FruitsRepository;
import com.example.challenge7.model.Days;
import com.example.challenge7.model.Fruits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    FruitsRepository fruitsRepository;

    @Autowired
    DaysRepository daysRepository;

    @Autowired
    CloudinaryConfig cloudc;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("fruits", fruitsRepository.findAll());
//        model.addAttribute("fruits",fruitsRepository.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String courseForm(Model model) {
        model.addAttribute("fruit", new Fruits());
        return "furitupdate";
    }

    @PostMapping("/process")
    public String processForm(@Valid Fruits fruits, @RequestParam("file") MultipartFile file,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "furitupdate";
        }

        if (file.isEmpty()) {
            System.out.println("File is empty...");
            return "redirect:/add";
        }

        try {
            Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));
            fruits.setImg(uploadResult.get("url").toString());

            fruitsRepository.save(fruits);
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/add";
        }

//        fruitsRepository.save(fruits);
        return "redirect:/";
    }


//    @RequestMapping("/addDay")
//    public String addDay(Model model){
//        model.addAttribute("days",new Days());
//        model.addAttribute("frutRepo", fruitsRepository.findAll());
//        model.addAttribute("addDay","");
//        return "adminday";
//    }
//
//    @PostMapping("/processDay")
//    public String processDay(@ModelAttribute("days") Days days, Model model){
//        daysRepository.save(days);
//        model.addAttribute("frutRepo", fruitsRepository.findAll());
//        model.addAttribute("addDay","You added "+ days.getDayname()+ " to the days table.");
//        return "adminpage";
//    }
//
//    @RequestMapping("/addFruit")
//    public String addFruit(Model model){
//        model.addAttribute("fruits", new Fruits());
//        model.addAttribute("dayRepo", daysRepository.findAll());
//        model.addAttribute("fruitAdd", "");
//        return "adminpage";
//    }
//
//    @PostMapping("/processFruit")
//    public String processFruit(@ModelAttribute Fruits fruits, Model model){
//        fruitsRepository.save(fruits);
//        model.addAttribute("dayRepo", daysRepository.findAll());
//        model.addAttribute("fruitAdd", "You added "+ fruits.getFuritname() + " to the Fruit table");
//        return "redirect:/";
//    }


    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model) {
        model.addAttribute("fruit", fruitsRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") long id, Model model) {
        model.addAttribute("fruit", fruitsRepository.findById(id));
        return "furitupdate";
    }

    @RequestMapping("/delete/{id}")
    public String delCourse(@PathVariable("id") long id){
        fruitsRepository.deleteById(id);
        return "redirect:/";
    }


}
