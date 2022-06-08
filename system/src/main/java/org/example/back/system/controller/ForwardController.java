package org.example.back.system.controller;

import org.example.back.system.service.data.insertion.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 页面转发
 *
 * @author cyan
 * @since 2022/5/13
 */
@Controller
public class ForwardController {

    @Autowired
    private MallService mallService;

    @GetMapping("/index")
    public String test0(Model model) {
        model.addAttribute("welcome", "Test Hello");
        return "login";
    }

    @GetMapping("/reip_menu_list.html")
    public String menuList(Model model) {
        model.addAttribute("welcome", "Test Hello");
        return "reip_menu_list";
    }

    @GetMapping("/reip_detail.html")
    public String test2(Model model) {
        model.addAttribute("welcome", "Test Hello");
        return "reip_detail";
    }


    @GetMapping("/root_li.html")
    public String test4(Model model) {
        model.addAttribute("welcome", "Test Hello");
        return "root_li";
    }

}
