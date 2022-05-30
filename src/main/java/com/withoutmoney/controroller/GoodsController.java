package com.withoutmoney.controroller;

import com.withoutmoney.entity.Goods;
import com.withoutmoney.entity.User;
import com.withoutmoney.service.GoodsService;
import com.withoutmoney.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
public class GoodsController {

    private final GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping("/getGoodsList")
    public String getGoodsList(Model model) throws SQLException{
        model.addAttribute("goods", goodsService.getGoodsList());
        return "getGoodsList";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) throws SQLException {
        model.addAttribute("goods", goodsService.getGoodsById(id));
        return "showGoods";
    }

    @GetMapping("/newGoods")
    public String newGoods(@ModelAttribute("goods")Goods goods) {

        return "newGoods";
    }

    @PostMapping("/newGoods")
    public String create(@Valid Goods goods,
                         BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors())
            return "newGoods";

       goodsService.save(goods);
        return "redirect:/getGoodsList";
    }

    @GetMapping("/{id}/editGoods")
    public String edit(Model model, @PathVariable("id") int id) throws SQLException {
        model.addAttribute("goods", goodsService.show(id));
        return "editGoods";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("goods") @Valid Goods goods, BindingResult bindingResult,
                         @PathVariable("id") int id) throws SQLException {
        if (bindingResult.hasErrors())
            return "editGoods";

        goodsService.update(id, goods);
        return "redirect:/showGoods";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) throws SQLException {
        goodsService.delete(id);
        return "redirect:/showGoods";
    }

}
