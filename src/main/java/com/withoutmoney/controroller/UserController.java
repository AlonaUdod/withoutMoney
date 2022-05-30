package com.withoutmoney.controroller;

import com.withoutmoney.entity.User;
import com.withoutmoney.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getPersonList")
    public String getPersonList(Model model) throws SQLException {
        model.addAttribute("users", userService.getPersonList());
        return "getPersonList";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("user", userService.getUserById(id));
        return "show";
    }

    @GetMapping("/{email}")
    public String show(@PathVariable("email") String mail, Model model) throws SQLException {
        model.addAttribute("user", userService.show(mail));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {

        return "new";
    }

    @PostMapping("/new")
    public String create(@Valid User user,
                         BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors())
            return "new";

        userService.save(user);
        return "redirect:/getPersonList";
    }

    @GetMapping("/{mail}/edit")
    public String edit(Model model, @PathVariable("mail") String mail) throws SQLException {
        model.addAttribute("person", userService.show(mail));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") int id) throws SQLException {
        if (bindingResult.hasErrors())
            return "edit";

        userService.update(id, user);
        return "redirect:/show";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) throws SQLException {
        userService.delete(id);
        return "redirect:/show";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }
}