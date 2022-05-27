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

    @GetMapping()
    public String getPersonList(Model model) {
        model.addAttribute("people", userService.getPersonList());
        return "getPersonList";
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
    public String create(@ModelAttribute("user")@Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";

        userService.save(user);
        return "redirect:/show";
       // return null;
    }

    @GetMapping("/{mail}/edit")
    public String edit(Model model, @PathVariable("mail") String mail) throws SQLException {
        model.addAttribute("person", userService.show(mail));
        return "edit";
    }

    @PatchMapping("/{mail}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @PathVariable("mail") String mail) {
        if (bindingResult.hasErrors())
            return "edit";

        userService.update(mail, user);
        return "redirect:/people";
    }

    @DeleteMapping("/{mail}")
    public String delete(@PathVariable("mail") String mail) throws SQLException {
        userService.delete(mail);
        return "redirect:/show";
    }
}