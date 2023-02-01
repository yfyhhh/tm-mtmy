package com.tm.service;

import com.tm.entity.SkinMeasuringRecord;
import com.tm.result.Result;

public interface SkinMeasuringService {
    Result uploadSkinMeasuring(SkinMeasuringRecord record);

    Result allBeauticianSkinRecord(Long beauticianId);
}
