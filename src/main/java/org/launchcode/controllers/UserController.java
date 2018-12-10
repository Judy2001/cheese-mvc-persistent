package org.launchcode.controllers;

import org.launchcode.models.User;
import org.launchcode.models.data.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;


@Controller
@RequestMapping(value = "user")
public class UserController {

/*    @Autowired
    private UserData userDao;*/


    @RequestMapping(value="")
    public String index(Model model) {

        model.addAttribute("title", "Users");
        model.addAttribute("users", UserData.getAll());

        return "user/index";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model) {

        model.addAttribute("title", "Add User");
        model.addAttribute(new User());
        //model.addAttribute("users", userDao.findAll());

        return "user/add";
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddUserForm(@ModelAttribute @Valid User newUser, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            return "user/add";
        }



        UserData.add(newUser);
        //model.addAttribute("user", user);

/*        if(user.getUsername().isEmpty()) {
            ;
            return "user/add";
        }*/

/*              if (user.getPassword().equals(verify)) {
            return "user/index";
        } else {
            return "user/add";
        }*/

/*        User aUser = User.createAUser();
        userDao.save(aUser);*/



        return "redirect:";

    }


    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveUserForm(Model model) {
        model.addAttribute("title", "Remove User");
        model.addAttribute("users", UserData.getAll());
        return "user/remove";
    }


    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveUserForm(@RequestParam int[] userIds) {

        for (int userId : userIds) {
            UserData.remove(userId);
        }

        return "redirect:";
    }

}