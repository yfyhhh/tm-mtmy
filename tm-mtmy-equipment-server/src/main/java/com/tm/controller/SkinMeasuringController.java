package com.tm.controller;

import com.tm.entity.SkinMeasuringRecord;
import com.tm.result.Result;
import com.tm.service.SkinMeasuringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/skinMeasuring")
public class SkinMeasuringController {
    @Autowired
    private SkinMeasuringService skinMeasuringService;

    /**
     * 上传检测数据
     * @param record
     * @return
     */
    @PostMapping("uploadSkinMeasuring")
    public Result uploadSkinMeasuring(@RequestBody SkinMeasuringRecord record){
        return skinMeasuringService.uploadSkinMeasuring(record);
    }

    /**
     * 查询美容师的检测结果列表
     * @param beauticianId
     * @return
     */
    public Result allBeauticianSkinRecord(@RequestBody Long beauticianId){
        return skinMeasuringService.allBeauticianSkinRecord(beauticianId);
    }
}
