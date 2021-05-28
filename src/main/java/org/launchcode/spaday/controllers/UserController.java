package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

   @GetMapping("/add")
   public String displayAddUserForm(Model model) {
      model.addAttribute("title", "Add User");
      model.addAttribute(new User());
      return "user/add";
   }


   @PostMapping ("/add")
   public String processAddUserForm(@ModelAttribute @Valid User user, String verify, Errors errors, Model model) {
      model.addAttribute("verify", verify);
      if (errors.hasErrors()) {
            model.addAttribute("title", "Add user -with errors");
            return "user/add";
      } else if (user.getPassword().equals(verify)) {
            return "user/index";
      } else {
            model.addAttribute("title", "Add user -bad pw");
            model.addAttribute("error", "Passwords do not match");
            return "user/add";
      }
   }
}
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



