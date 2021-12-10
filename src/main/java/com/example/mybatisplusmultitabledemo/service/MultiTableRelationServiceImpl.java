package com.example.mybatisplusmultitabledemo.service;

import com.example.mybatisplusmultitabledemo.model.Address;
import com.example.mybatisplusmultitabledemo.model.User;
import com.example.mybatisplusmultitabledemo.model.UserAddress;
import com.example.mybatisplusmultitabledemo.model.UserStaff;
import com.lzb.mpmt.service.multiwrapper.MultiTableRelationService;
import com.lzb.mpmt.service.multiwrapper.constant.MultiConstant.ClassRelationOneOrManyEnum;
import com.lzb.mpmt.service.multiwrapper.entity.MultiClassRelation;

import java.util.Arrays;
import java.util.List;

public class MultiTableRelationServiceImpl implements MultiTableRelationService {

    @Override
    public List<MultiClassRelation> loadRelation() {
        //todo可以查询数据库/枚举信息
        return Arrays.asList(MultiClassRelation.builder()
                        .code("userAndUserStaff")
                        .class1(User.class)
                        .className1("user")
                        .class1KeyProp("id")
                        .class1OneOrMany(ClassRelationOneOrManyEnum.ONE)
                        .class1Require(true)
                        .class2(UserStaff.class)
                        .className2("userStaff")
                        .class2KeyProp("adminUserId")
                        .class2OneOrMany(ClassRelationOneOrManyEnum.MANY)
                        .class2Require(false)
                        .build(),
                MultiClassRelation.builder()
                        .code("userAndUserAddress")
                        .class1(User.class)
                        .className1("user")
                        .class1KeyProp("id")
                        .class1OneOrMany(ClassRelationOneOrManyEnum.ONE)
                        .class1Require(true)
                        .class2(UserAddress.class)
                        .className2("userAddress")
                        .class2KeyProp("userId")
                        .class2OneOrMany(ClassRelationOneOrManyEnum.MANY)
                        .class2Require(false)
                        .build(),
                MultiClassRelation.builder()
                        .code("addressUserAddress")
                        .class1(UserAddress.class)
                        .className1("userAddress")
                        .class1KeyProp("streetCode")
                        .class1OneOrMany(ClassRelationOneOrManyEnum.ONE)
                        .class1Require(true)
                        .class2(Address.class)
                        .className2("address")
                        .class2KeyProp("code")
                        .class2OneOrMany(ClassRelationOneOrManyEnum.ONE)
                        .class2Require(false)
                        .build()
        );
    }


}
