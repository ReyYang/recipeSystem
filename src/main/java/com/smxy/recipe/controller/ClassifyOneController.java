/**
 * Copyright © 2018 eSunny Info. Developer Stu. All rights reserved.
 *
 * @Package:
 * @author: zpx
 * Build File @date: 2018/8/24 15:31
 * @Description TODO
 * @version 1.0
 */
package com.smxy.recipe.controller;

import com.smxy.recipe.entity.Classify;
import com.smxy.recipe.entity.ClassifyOne;
import com.smxy.recipe.service.ClassifyOneService;
import com.smxy.recipe.utils.ResApi;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/claOne")
public class ClassifyOneController {

    @Autowired
    ClassifyOneService classifyOneService;

    @RequiresPermissions("recipeClassify:select")
    @GetMapping("/info")
    public String getAllInfo(Model model){
        model.addAttribute("list",classifyOneService.getAllInfo());
        return "admin/classify/classOne/list";
    }

    @RequiresPermissions("recipeClassify:select")
    @GetMapping("/add")
    public String add(){
        return "admin/classify/classOne/add";
    }

    @RequiresPermissions("recipeClassify:insert")
    @ResponseBody
    @PostMapping("/info")
    public ResApi<Object> saveInfo(String fName){
        return classifyOneService.saveInfo(fName);
    }

    @RequiresPermissions("recipeClassify:delete")
    @ResponseBody
    @DeleteMapping("/info/{id}")
    public ResApi<Object> deleteInfo(@PathVariable("id") Integer id){
        return classifyOneService.deleteInfo(id);
    }

    @RequiresPermissions("recipeClassify:select")
    @GetMapping("/editor/{id}")
    public String toEditor(@PathVariable("id") Integer id,Model model){
        model.addAttribute("cla",classifyOneService.getInfoById(id));
        return "admin/classify/classOne/editor";
    }

    @RequiresPermissions("recipeClassify:update")
    @ResponseBody
    @PutMapping("/info/{id}")
    public ResApi<Object> updateInfo(Classify classify){
        return classifyOneService.updateInfo(classify);
    }
}
