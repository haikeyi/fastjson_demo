package com.song.fastjson.enums;

/**
 * 一些常量
 *  @author songchengkang
 * @date 2020/7/17
 *
 */
public enum GeneralEnum {

    /**
     * 名字
     */
    MY_NAME("xiaosong","我的第一个名字"),

    /**
     * 第二个名字
     */
    MY_SECOND_NAME("xiaocheng","我的第二个名字"),

    /**
     * 第三个名字
     */
    MY_THIRD_NAME("xiaokong","我的第三个名字"),

    /**
     * 出生日期
     */
    DATE_OF_BIRTH("DATE OF BIRTH","出生日期"),

    ;

    /**
     * 值
     */
    private String desc;

    /**
     * 中文描述
     */
    private String value;

    GeneralEnum(String value,String desc){
        this.desc = desc;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
