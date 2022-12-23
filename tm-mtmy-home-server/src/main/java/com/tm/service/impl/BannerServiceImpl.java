package com.tm.service.impl;

import com.tm.mapper.BannerMapper;
import com.tm.result.Result;
import com.tm.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public Result bannerList() {
        return Result.SUCCESS(bannerMapper.bannerList());
    }
}
