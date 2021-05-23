package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("user")
public class UserController {

   @GetMapping("add")
   public String displayAddUserForm(){
      System.out.println("GetMapping - load the form by going to add.html in user/add");
      return "user/add";
}

   @PostMapping ("add")
   public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
      System.out.println("Fucking Test");

      if(verify.equals(user.getPassword())){
         System.out.println("The big if");
         model.addAttribute("welcomeMessage","Welcome " + user.getUsername() + " !");
         return "user/index";
      }
         return "user/add";
   }


}
