package com.example.mybatisplusmultitabledemo.model;


import com.example.mybatisplusmultitabledemo.enums.TestConst;
import com.lzb.mpmt.service.multiwrapper.annotations.MultiTableField;
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
