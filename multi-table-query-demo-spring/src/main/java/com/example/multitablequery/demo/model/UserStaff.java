package com.example.multitablequery.demo.model;

import com.example.multitablequery.demo.enums.TestConst;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class UserStaff extends BaseModel {
    private String staffName;
    private TestConst.SexEnum sex;
    private Long adminUserId;

    private User userAndUserStaff;
}
