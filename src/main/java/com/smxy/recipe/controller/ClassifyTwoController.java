/**
 * Copyright © 2018 eSunny Info. Developer Stu. All rights reserved.
 *
 * @Package:
 * @author: zpx
 * Build File @date: 2018/8/25 14:21
 * @Description TODO
 * @version 1.0
 */
package com.smxy.recipe.controller;

import com.smxy.recipe.entity.Classify;
import com.smxy.recipe.entity.ClassifyTwo;
import com.smxy.recipe.service.ClassifyTwoService;
import com.smxy.recipe.utils.ResApi;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/claTwo")
public class ClassifyTwoController {

    @Autowired
    ClassifyTwoService classifyTwoService;

    @RequiresPermissions("recipeClassify:select")
    @GetMapping("/info")
    public String list(Model model){
        model.addAttribute("list",classifyTwoService.getInfoAll());
        return "admin/classify/classTwo/list";
    }

    @RequiresPermissions("recipeClassify:select")
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("item",classifyTwoService.getClassifyOne());
        return "admin/classify/classTwo/add";
    }

    @RequiresPermissions("recipeClassify:insert")
    @ResponseBody
    @PostMapping("/info")
    public ResApi<Object> saveInfo(@RequestParam("file") MultipartFile multipartFile, ClassifyTwo classifyTwo){
        return classifyTwoService.saveInfo(multipartFile, classifyTwo);
    }

    @RequiresPermissions("recipeClassify:delete")
    @ResponseBody
    @DeleteMapping("/info/{id}")
    public ResApi<Object> deleteInfo(@PathVariable("id") Integer id){
        return classifyTwoService.deleteInfo(id);
    }

    @RequiresPermissions("recipeClassify:select")
    @GetMapping("/editor/{id}")
    public String toEditor(@PathVariable("id") Integer id, Model model){
        model.addAttribute("item",classifyTwoService.getInfoOne(id));
        return "admin/classify/classTwo/editor";
    }

    @RequiresPermissions("recipeClassify:update")
    @ResponseBody
    @PutMapping("/info/{id}")
    public ResApi<Object> updateInfo(@RequestParam(value = "file", required = false) MultipartFile multipartFile,
            @PathVariable("id") Integer id,ClassifyTwo classifyTwo){
        return classifyTwoService.updateInfo(multipartFile,id,classifyTwo);
    }

    @RequiresPermissions("recipeClassify:select")
    @ResponseBody
    @PostMapping("/getbyoid/{id}")
    public ResApi<Object> getByOid(@PathVariable("id") Integer fOid){
        return classifyTwoService.getInfoByOid(fOid);
    }

}
