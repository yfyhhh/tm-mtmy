package com.tm.service.impl;

import com.tm.entity.SkinMeasuringRecord;
import com.tm.entity.bo.DimensionBo;
import com.tm.entity.vo.SkinRecordVo;
import com.tm.mapper.SkinMeasuringMapper;
import com.tm.result.Result;
import com.tm.service.SkinMeasuringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SkinMeasuringServiceImpl implements SkinMeasuringService {

    @Autowired
    private SkinMeasuringMapper skinMeasuringMapper;

    /**
     * 上传检测数据
     * @param record
     * @return
     */
    public Result uploadSkinMeasuring(SkinMeasuringRecord record) {
        // 先查出被检测人的手机号
        record.setMemberPhone(skinMeasuringMapper.queryPhoneById(record.getMemberId()));
        // 将检测记录存入数据库
        Long id = skinMeasuringMapper.addSkinmiRecord(record);
        // 先查出数据库中所有维度对应ID，得到一个集合
        List<DimensionBo> list = skinMeasuringMapper.queryAllDimension();
        // 将list转为map
        Map<String,Long> dimensionIdMap = new HashMap<String, Long>();
        // 遍历
        list.forEach(a->{
            dimensionIdMap.put(a.getDimensionName(),a.getDimensionId());
        });
        // 写一个方法，将名称对应分数转化为ID对应分数
        List<Map<String,String>> mapList = nameGradeToGrade(dimensionIdMap,record);
        skinMeasuringMapper.addUserSkinDimensionRecord(record.getSkinId(),mapList);
        return Result.SUCCESS(record.getSkinId());
    }

    @Override
    public Result allBeauticianSkinRecord(Long beauticianId) {
        List<SkinRecordVo> list = skinMeasuringMapper.allBeauticianSkinRecord(beauticianId);
        List<SkinRecordVo> newList = new ArrayList<>();
        Map<Long, List<SkinRecordVo>> collect = list.stream().collect(Collectors.groupingBy(SkinRecordVo::getSkinId));
        // set中是所有的检测结果id
        Set<Long> longs = collect.keySet();
        // 遍历所有的检测结果id，依次取得每个结果对应的所有维度数据
        longs.forEach(a->{
            List<SkinRecordVo> skinRecordVos = collect.get(a);
            // 排序后取第一个
            List<SkinRecordVo> collect1 = skinRecordVos.stream().sorted(Comparator.comparing(SkinRecordVo::getDimensionSkinGrade)).collect(Collectors.toList());
            SkinRecordVo skinRecordVo = collect1.get(0);
            newList.add(skinRecordVo);

        });
        // 排序后取第一个结果
        // newList.stream().sorted().collect(Collectors.toList());
        return null;
    }

    /**
     * 名称对应分数转化为ID对应分数
     * @param dimensionIdMap
     * @param record
     * @return
     */
    private List<Map<String,String>> nameGradeToGrade(Map<String,Long> dimensionIdMap, SkinMeasuringRecord record) {
        // 新建集合存放结果集
        List<Map<String,String>> list = new ArrayList<>();
        // 获取检测记录类的class类
        Class<SkinMeasuringRecord> skinMeasuringRecordClass = SkinMeasuringRecord.class;
        // 获取检测记录类的所有属性
        Field[] fields = skinMeasuringRecordClass.getDeclaredFields();
        // 循环
        for (int i = 0; i < fields.length; i++) {
            // 获得该属性的类型，从而获得属性的全类名
            Class<?> type = fields[i].getType();
            if (type.getName().contains("com.tm")){
                // 获取当前循环的属性名
                String fieldName = fields[i].getName();
                // 通过属性名查到对应ID
                Long dimensionId = dimensionIdMap.get(fieldName);
                try {
                    // 获取record对象的class对象
                    Class clazz = record.getClass();
                    // 通过属性名得到属性对象
                    Field declaredField = clazz.getDeclaredField(fieldName);
                    // 开启访问权限
                    declaredField.setAccessible(true);
                    // 获得属性值对象
                    Object o = declaredField.get(record);
                    // 再通过反射获得属性值对象的class对象，进入内层
                    Class clazz1 = o.getClass();
                    // 获得内层的所有属性
                    Field[] declaredFields = clazz1.getDeclaredFields();
                    // 再次循环
                    for (int j = 0; j < declaredFields.length; j++) {
                        // 每层循环创建一个Map来接受数据
                        Map<String,String> dimensionIdGrade = new HashMap<>();
                        // 开启访问权限
                        declaredFields[j].setAccessible(true);
                        // 拿到外层ID对应的分数
                        if (j == 0){
                            // 赋值并添加到list集合
                            dimensionIdGrade.put("dimensionId",dimensionId.toString());
                            dimensionIdGrade.put("grade",declaredFields[j].get(o).toString());
                            list.add(dimensionIdGrade);
                        }else {
                            // 获得属性名
                            String name = declaredFields[j].getName();
                            // 通过属性名查到对应ID
                            Long dimensionId2 = dimensionIdMap.get(name);
                            // 赋值并添加到list集合
                            dimensionIdGrade.put("dimensionId", dimensionId2.toString());
                            dimensionIdGrade.put("grade", declaredFields[j].get(o).toString());
                            list.add(dimensionIdGrade);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }


}
