package demo.service;

import com.bebetter.mtq.service.multiwrapper.MultiTableRelationService;
import com.bebetter.mtq.service.multiwrapper.constant.MultiConstant;
import com.bebetter.mtq.service.multiwrapper.entity.MultiClassRelation;

import java.util.Arrays;
import java.util.List;

public class MultiTableRelationServiceImpl implements MultiTableRelationService {

    @Override
    public List<MultiClassRelation> loadRelation() {
        //todo可以查询数据库/枚举信息
        return Arrays.asList(MultiClassRelation.builder()
                        .code("userAndUserStaff")
                        .className1("user")
                        .class1KeyProp("id")
                        .class1OneOrMany(MultiConstant.ClassRelationOneOrManyEnum.ONE)
                        .class1Require(true)
                        .className2("userStaff")
                        .class2KeyProp("adminUserId")
                        .class2OneOrMany(MultiConstant.ClassRelationOneOrManyEnum.MANY)
                        .class2Require(false)
                        .build(),
                MultiClassRelation.builder()
                        .code("userAndUserAddress")
                        .className1("user")
                        .class1KeyProp("id")
                        .class1OneOrMany(MultiConstant.ClassRelationOneOrManyEnum.ONE)
                        .class1Require(true)
                        .className2("userAddress")
                        .class2KeyProp("userId")
                        .class2OneOrMany(MultiConstant.ClassRelationOneOrManyEnum.MANY)
                        .class2Require(false)
                        .build(),
                MultiClassRelation.builder()
                        .code("addressUserAddress")
                        .className1("userAddress")
                        .class1KeyProp("streetCode")
                        .class1OneOrMany(MultiConstant.ClassRelationOneOrManyEnum.ONE)
                        .class1Require(true)
                        .className2("address")
                        .class2KeyProp("code")
                        .class2OneOrMany(MultiConstant.ClassRelationOneOrManyEnum.ONE)
                        .class2Require(false)
                        .build()
        );
    }


}
