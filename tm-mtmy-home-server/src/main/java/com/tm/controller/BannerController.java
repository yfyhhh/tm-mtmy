package com.tm.controller;

import com.tm.result.Result;
import com.tm.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @PostMapping("bannerList")
    public Result bannerList(){
        return bannerService.bannerList();
    }
}
