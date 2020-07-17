package com.song.fastjson_demo.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.*;
import com.song.fastjson_demo.domain.Person;
import org.springframework.boot.jackson.JsonComponent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestFastJson {
    public static void main(String[] args) {
//        objectToJson();
        jsonToObject();
    }

    //Json字符串转换成Java对象
    private static void jsonToObject() {
        Person person = new Person("xiaokong",22,new Date());
        String jsonOutput = JSON.toJSONString(person);
        System.out.println("before convert:" + jsonOutput);
        Person newPerson = JSON.parseObject(jsonOutput,Person.class);
        System.out.println("after convert:" + newPerson.toString());
    }

    //java对象转换成json字符串
    private static void objectToJson(){
        List<Person> listPersons = new ArrayList<Person>();
        listPersons.add(new Person("xiaosong",21,new Date()));
        listPersons.add(new Person("xiaocheng",20,new Date()));
//        String personOutput = JSON.toJSONString(listPersons, SerializerFeature.BeanToArray);
        String jsonOutput = JSON.toJSONString(listPersons);
        System.out.println("not handle:" + jsonOutput);

        //对Value进行过滤
        ContextValueFilter contextValueFilter = new ContextValueFilter() {
            public Object process(BeanContext beanContext, Object o, String s, Object o1) {
                if(s.equals("DATE OF BIRTH")){
                    return "CAN NOT SHOW";
                }
                if(o1.equals("xiaosong")){
                    return ((String) o1).toUpperCase();
                }else {
                    return null;
                }
            }
        };

        String filteredJsonOutPut = JSON.toJSONString(listPersons,contextValueFilter);
        System.out.println("after filter:" + filteredJsonOutPut);

        //序列化时修改key
        NameFilter nameFilter = new NameFilter() {
            public String process(Object o, String s, Object o1) {
                return s.toLowerCase().replace(" ","-");
            }
        };
        SerializeConfig.getGlobalInstance().addFilter(Person.class,nameFilter);
        String updatedJsonOutput = JSON.toJSONStringWithDateFormat(listPersons,"yyyy-MM-dd");
        System.out.println("after updated" + updatedJsonOutput);
    }
}
