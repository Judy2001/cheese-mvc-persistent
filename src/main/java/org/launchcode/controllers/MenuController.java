package org.launchcode.controllers;

import org.launchcode.models.Cheese;
import org.launchcode.models.Menu;
import org.launchcode.models.data.CheeseDao;
import org.launchcode.models.data.MenuDao;
import org.launchcode.models.forms.AddMenuItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "menu")
public class MenuController {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private CheeseDao cheeseDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Menus");
        model.addAttribute("menus", menuDao.findAll());
        return "menu/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddMenuForm(Model model) {
        model.addAttribute("title", "Add Menu");
        model.addAttribute(new Menu());
        return "menu/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddMenuForm(Model model, @ModelAttribute @Valid Menu newMenu,
                                     Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Menu");
            return "menu/add";
        }

        menuDao.save(newMenu);

        return "redirect:/menu/view/" + newMenu.getId();
    }

    @RequestMapping(value = "view/{menuId}", method = RequestMethod.GET)
    public String viewMenu(Model model, @ModelAttribute @Valid Menu theMenu,
                           @PathVariable int menuId) {

        theMenu = menuDao.findOne(menuId);
        model.addAttribute("menu", theMenu);

        return "menu/view";
    }

    @RequestMapping(value = "add-item/{menuId}", method = RequestMethod.GET)
    public String addItem(Model model, @PathVariable int menuId) {

        Menu menu = menuDao.findOne(menuId);

        AddMenuItemForm form = new AddMenuItemForm(menu, cheeseDao.findAll());
        model.addAttribute("form", form);
        model.addAttribute("title", "Add item to menu: " + menu.getName());
        System.out.println(form);

        return "menu/add-item";
    }

    @RequestMapping(value = "add-item", method = RequestMethod.POST)
    public String addItem(Model model, @ModelAttribute @Valid AddMenuItemForm form,
                           Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Item");
            return "menu/add-item";
        }

        System.out.println(form);
        int chId = (form.getCheeseId());
        int menId = form.getMenuId();
        Cheese cheese = cheeseDao.findOne(chId);
        Menu theMenu = menuDao.findOne(menId);
        theMenu.addItem(cheese);
        menuDao.save(theMenu);

        return "redirect:/menu/view/" + theMenu.getId();
    }
}