/**
 * Copyright © 2018 eSunny Info. Developer Stu. All rights reserved.
 *
 * @Package:
 * @author: zpx
 * Build File @date: 2018/8/23 22:29
 * @Description TODO
 * @version 1.0
 */
package com.smxy.recipe.controller;

import com.smxy.recipe.entity.Classify;
import com.smxy.recipe.service.ClassifyService;
import com.smxy.recipe.utils.ResApi;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cla")
public class ClassifyController {

    @Autowired
    ClassifyService classifyService;

    @RequiresPermissions("recipeClassify:select")
    @GetMapping("/info")
    public String info(Model model){
        model.addAttribute("list",classifyService.getAllInfo());
        return "admin/classify/list";
    }

    @RequiresPermissions("recipeClassify:select")
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("data", classifyService.getClaOneAllInfo());
        return "admin/classify/add";
    }

    @RequiresPermissions("recipeClassify:insert")
    @ResponseBody
    @PostMapping("/info")
    public ResApi<Object> saveInfo(Classify classify){
        return classifyService.saveInfo(classify);
    }

    @RequiresPermissions("recipeClassify:delete")
    @ResponseBody
    @DeleteMapping("/info/{id}")
    public ResApi<Object> deleteInfo(@PathVariable("id") Integer id){
        return classifyService.deleteInfo(id);
    }

    @RequiresPermissions("recipeClassify:select")
    @GetMapping("/editor/{id}")
    public String editor(@PathVariable("id") Integer id, Model model){
        model.addAttribute("item",classifyService.getInfoById(id));
        return "admin/classify/editor";
    }

    @RequiresPermissions("recipeClassify:update")
    @ResponseBody
    @PutMapping("/info/{id}")
    public ResApi<Object> updateInfo(@PathVariable("id")Integer id, Classify classify){
        return classifyService.updateInfo(id, classify);
    }


}
