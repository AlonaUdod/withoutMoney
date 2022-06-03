package com.withoutmoney.controroller;

import com.withoutmoney.entity.Goods;
import com.withoutmoney.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@Controller
public class GoodsController {

    private final GoodsService goodsService;

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping("/getGoodsList")
    public String getGoodsList(Model model) throws SQLException{
        model.addAttribute("goodsList", goodsService.getGoodsList());
        return "getGoodsList";
    }


    @GetMapping("/getGoodsById/{id}")
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
                         BindingResult bindingResult, @RequestParam("file") MultipartFile file)
            throws SQLException, IOException {

        if (file != null && !file.getOriginalFilename().isEmpty()) {

            String uuidFile = UUID.randomUUID().toString();
            String resultPhoto = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultPhoto));

            goods.setPhoto(resultPhoto);
        }

        if (bindingResult.hasErrors())
            return "newGoods";

       goodsService.save(goods);
        return "redirect:/getGoodsList";
    }

    @GetMapping("/goodsEdit/{id}/editGoods")
    public String edit(Model model, @PathVariable("id") int id) throws SQLException {
        model.addAttribute("goods", goodsService.show(id));
        return "editGoods";
    }

    @PatchMapping("/goodsUpdate/{id}")
    public String update(@ModelAttribute("goods") @Valid Goods goods, BindingResult bindingResult,
                         @PathVariable("id") int id) throws SQLException {
        if (bindingResult.hasErrors())
            return "editGoods";

        goodsService.update(id, goods);
        return "redirect:/showGoods";
    }

    @DeleteMapping("/goodsDelete/{id}")
    public String delete(@PathVariable("id") int id) throws SQLException {
        goodsService.delete(id);
        return "redirect:/getGoodsList";
    }


//    private void savePhoto(Goods goods, @RequestParam("file") MultipartFile file) throws IOException {
//        if (file != null && !file.getOriginalFilename().isEmpty()) {
//
//            String uuidFile = UUID.randomUUID().toString();
//            String resultPhoto = uuidFile + "." + file.getOriginalFilename();
//
//            file.transferTo(new File(uploadPath + "/" + resultPhoto));
//
//            goods.setPhoto(resultPhoto);
//        }
//    }

}
