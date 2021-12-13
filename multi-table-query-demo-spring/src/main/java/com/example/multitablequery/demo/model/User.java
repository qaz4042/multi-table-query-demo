package com.example.multitablequery.demo.model;


import com.bebetter.mtq.service.multiwrapper.annotations.MultiTableField;
import com.example.multitablequery.demo.enums.TestConst;
import com.example.multitablequery.demo.model.BaseModel;
import com.example.multitablequery.demo.model.UserAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class User extends BaseModel {
    private String username;
    private TestConst.SexEnum sex;
    private BigDecimal balance;
    private Integer numbers;
    @MultiTableField(exist = false)
    private Long parentId;

    private List<UserAddress> userAndUserAddress;

}
