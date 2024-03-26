package com.business.common.enums;

import lombok.Getter;

/**
 * @Author: yxf
 * @Description: 广告触发类型枚举类
 */
@Getter
public enum TriggerTypeEnums {

    SHOW(1, "1","广告展示"),

    PLAY(2, "2","广告播放"),

    CLICK(3,"3", "广告点击");

    private final Integer code;
    private final String codeStr;
    private final String msg;

    TriggerTypeEnums(int code, String codeStr , String msg) {
        this.code = code;
        this.codeStr = codeStr;
        this.msg = msg;
    }
}
