package com.example.multitablequery.demo.enums;

import com.bebetter.mtq.service.multiwrapper.entity.IMultiEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class TestConst {
    @Getter
    @AllArgsConstructor
    public enum SexEnum implements IMultiEnum<Integer> {
        /***/
        man(0, "男"),
        woman(1, "女"),
        ;
        Integer value;
        String label;
    }

}
