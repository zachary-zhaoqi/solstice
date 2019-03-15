package pers.zhaoqi.solstice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.zhaoqi.solstice.entity.Merchandise;
import pers.zhaoqi.solstice.service.MerchandiseService;

import java.util.List;

@RestController
@RequestMapping("/merchandise")
public class MerchandiseController {

    @Autowired
    private MerchandiseService merchandiseService;

    @GetMapping("")
    public Merchandise getMerchandise() {
        Merchandise merchandise = merchandiseService.selectById(1);
        return merchandise;
    }

    @GetMapping("list")
    public List<Merchandise> getMerchandiseList() {
        List<Merchandise> merchandise = merchandiseService.selectList();
        return merchandise;
    }
}
