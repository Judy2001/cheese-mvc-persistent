/*
package org.launchcode.controllers;

import org.launchcode.models.User;
import org.launchcode.models.data.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "user")
public class UserController {

    //@Autowired
    private UserDao userDao;


    @RequestMapping(value="")
    public String index(Model model) {

        model.addAttribute("title", "Users");
        model.addAttribute("users", userDao.findAll());

        return "user/index";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model) {

        model.addAttribute("title", "Add User");
        model.addAttribute(new User());
        model.addAttribute("users", userDao.findAll());

        return "user/add";
    }


*/
/*    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddUserForm(@ModelAttribute @Valid User newUser, Errors errors,
                                     @RequestParam int userId, String verify, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add User");
            return "food/add";
        }

        User user = userDao.findOne(userId);
        newUser.setUsername(user);
        userDao.save(newUser);

        return "redirect:";
    }*//*



    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveUserForm(Model model) {
        model.addAttribute("title", "Remove User");
        model.addAttribute("users", userDao.findAll());
        return "user/remove";
    }


    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveUserForm(@RequestParam int[] userIds) {

        for (int userId : userIds) {
            userDao.delete(userId);
        }

        return "redirect:";
    }

}*/
