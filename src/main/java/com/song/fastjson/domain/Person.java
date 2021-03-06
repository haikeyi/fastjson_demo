package com.song.fastjson.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Person实体类
 * @author songchengkang
 * @date 2020/7/17
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @JSONField(name = "NAME",ordinal = 1)
    private String name;

    @JSONField(name = "AGE",ordinal = 2)
    private int age;

    @JSONField(name = "DATE OF BIRTH",format = "yyyy/MM/dd",ordinal = 3,deserialize = false)
    private Date dateOfBirth;
}
