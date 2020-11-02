package com.hung.common.enums;

import com.hung.ecoshop.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  DateTimeFormat implements CodeEnum {
    YYYYMMDD("yyyyMMdd", "")
    , SLASH_YYYYMMDD("yyyy/MM/dd", "")
    , YYYY_MM_DD("yyyy-MM-dd", "")
    , JP_MMDD("MM月dd日", "")
    , YYYYMMDDHHMMSS("yyyyMMddHHmmss", "")
    , SLASH_YYYY_MM_DD_HH_MM_SS("yyyy/MM/dd HH:mm:ss", "")
    , YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss.SSS", "")
    , YYYY_MM_DD_HH_MM_SS_FF("yyyy-MM-dd HH:mm:ss.SSS", "")
    , HHMM("HHmm", "")
    , HH_MM("HH:mm", "")
    , H_MM("H:mm", "")
    , YYYYMM("yyyyMM", "")
    , YYYYMMDDHHMM("yyyyMMddHHmm", "")
    , JP_MD("M月d日(E)", "")
    ;
    private final String value;
    private final String name;
}
