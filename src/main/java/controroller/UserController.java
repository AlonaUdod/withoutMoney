package controroller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import source.UserSource;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserSource userSource;

   @Autowired
    public UserController(UserSource userSource) {
        this.userSource = userSource;
    }

    @GetMapping("/new")
    public String newUser() {

        return "new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user")@Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";

        userSource.save(user);
//        return "redirect:/user";
        return null;
    }
}