package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String displayIndex(Model model) {
        model.addAttribute("title","Home");
        return "user/index";
    }

    @GetMapping ("users")
    public String displayAllUsers(Model model) {
        model.addAttribute("users", UserData.getAll());
        model.addAttribute("title", "All Users");
        return "user/users";
    }



   @GetMapping("add")
   public String displayAddUserForm(Model model) {
      model.addAttribute("title", "Add User");
      model.addAttribute(new User());
      return "user/add";
   }




   @PostMapping ("add")
   public String processAddUserForm(@ModelAttribute @Valid User newUser, Errors errors, Model model) {

      if (errors.hasErrors()) {
            model.addAttribute("title", "Add user -with errors");
            model.addAttribute("user", newUser);
            return "user/add";
      } else {
          UserData.add(newUser);
          return "redirect:";
      }
   }
}


//else if (newUser.getPassword().equals(verify)) {
//        UserData.add(newUser);
//
//        return "redirect:";
//        } else {
//        model.addAttribute("title", "Add user -bad pw");
//        model.addAttribute("error", "Passwords do not match");
//        return "user/add";
//        }





//   @PostMapping
//   public String processAddUserForm(@ModelAttribute @Valid User user, String verify, Errors errors, Model model) {
//      model.addAttribute("verify", verify);
//         model.addAttribute("error", "Passwords do not match");
//      System.out.print(errors);
//      if (errors.hasErrors()) {
//         model.addAttribute("title", "Add User");
//         return "/user/add";
//      }
//      return "/user/index";
//   }



//    @PostMapping
//    public String processAddUserForm(@ModelAttribute @Valid User user, String verify, Errors errors, Model model) {
//       model.addAttribute("verify", verify);
//       if (user.getPassword().equals(verify) == false) {
//          model.addAttribute("error", "Passwords do not match");
//       }
//       if (errors.hasErrors() || user.getPassword().equals(verify) == false) {
//          model.addAttribute("title", "Add User");
//          return "/user/add";
//       }
//       return "/user/index";
//    }

//        if (user.getPassword().equals(verify) == false ){
//           if(errors.hasErrors()){
//              model.addAttribute("title","Add User");
//              return "user/add";
//           }
//           return "user/index";
//        }
//        else {
//            model.addAttribute("error", "Passwords do not match");
//            return "user/add";
//        }
//       model.addAttribute("title","User Index");
//
//       return "user/index";
//    }



