package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("user")
public class UserController {

   @GetMapping
   public String displayAllEvents(Model model){
      model.addAttribute("title","All Users");
      model.addAttribute("users", UserData.getAll());
      return "user/index";
   }

   @GetMapping("add")
   public String displayAddUserForm(Model model){
      model.addAttribute("title","add User");
      return "user/add";
}

   @PostMapping ("add")
   public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {

      if(verify.equals(user.getPassword())){
         UserData.add(user);
         model.addAttribute("welcomeMessage","Welcome " + user.getUsername() + " !");
         return "user/index";
      }
         model.addAttribute("systemMessage",user.getUsername() +
                 " , The passwords do not match!");
         model.addAttribute("userName",user.getUsername());
         model.addAttribute("email",user.getEmail());
         return "user/add";
   }

   @GetMapping ("/details/{userId}")
   public String displayEditForm(Model model, @PathVariable int userId) {
      User user = UserData.getId(userId);
      model.addAttribute("userName", userId);
      model.addAttribute("user", user);

      return "user/details";
   }
}
