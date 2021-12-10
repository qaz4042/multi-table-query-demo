package com.example.mybatisplusmultitabledemo;

import com.example.mybatisplusmultitabledemo.model.*;
import com.lzb.mpmt.MultiTableApplication;
import com.lzb.mpmt.service.multiwrapper.constant.MultiConstant;
import com.lzb.mpmt.service.multiwrapper.dto.IMultiPage;
import com.lzb.mpmt.service.multiwrapper.dto.MultiAggregateResult;
import com.lzb.mpmt.service.multiwrapper.dto.MultiPage;
import com.lzb.mpmt.service.multiwrapper.executor.MultiExecutorInner;
import com.lzb.mpmt.service.multiwrapper.util.json.jackson.JsonUtil;
import com.lzb.mpmt.service.multiwrapper.wrapper.inner.MultiWrapperInner;
import com.lzb.mpmt.service.multiwrapper.wrapper.inner.MultiWrapperMainInner;
import com.lzb.mpmt.service.multiwrapper.wrapper.inner.MultiWrapperSubInner;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@SpringBootTest(classes = MybatisPlusMultiTableDemoApplication.class)
class MultiTableApplicationInnerTests {

    /**
     * 简单list查询
     */
    @Test
    @SneakyThrows
    void testQuerySimple() {
        List<UserStaff> userStaffsSimple = MultiExecutorInner.list(new MultiWrapperInner<>(MultiWrapperMainInner.lambda(UserStaff.class), User.class, UserAddress.class, Address.class));
        System.out.println("testQuerySimple=" + JsonUtil.toString(userStaffsSimple));
    }

    /**
     * 分页查询
     */
    @Test
    @SneakyThrows
    void testQueryPage() {
        IMultiPage<UserStaff> page = MultiExecutorInner.page(new MultiPage<>(1, 10),
                new MultiWrapperInner<>(MultiWrapperMainInner.lambda(UserStaff.class)
                        .desc(BaseModel::getCreateTime)
                        , User.class, UserAddress.class, Address.class));
        System.out.println("testQueryPage=" + JsonUtil.toString(page));
    }

    /**
     * 统一map构造参数 list查询
     */
    @Test
    @SneakyThrows
    void testQueryParamMap() {
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("userStaff_sex", "#lr#1");
        List<UserStaff> userStaffsSimple = MultiExecutorInner.list(new MultiWrapperInner<>(MultiWrapperMainInner.lambda(UserStaff.class), User.class, UserAddress.class, Address.class).extendParams(paramMap));
        System.out.println("testQueryParamMap=" + JsonUtil.toString(userStaffsSimple));
    }

    /**
     * 基本聚合查询
     */
    @Test
    @SneakyThrows
    void testQueryAggregate() {
        MultiAggregateResult aggregateSumAll = MultiExecutorInner.aggregate(new MultiWrapperInner<>(MultiWrapperMainInner.lambda(UserStaff.class).aggregateAll(MultiConstant.MultiAggregateTypeEnum.SUM),
                MultiWrapperSubInner.lambda(User.class)
        ));
        System.out.println("aggregateSumAll=" + aggregateSumAll.getSum());

        MultiAggregateResult aggregateSpecific = MultiExecutorInner.aggregate(new MultiWrapperInner<>(MultiWrapperMainInner.lambda(UserStaff.class),
                MultiWrapperSubInner.lambda(User.class).sum(User::getBalance).sum(User::getBalance, "balanceAlia")
        ));
        System.out.println("aggregateSpecific=" + aggregateSpecific.getSum().getValue("userAndUserStaff", User::getBalance));
        System.out.println("aggregateSpecificBalanceAlia=" + aggregateSpecific.getSum().get("balanceAlia"));
        Thread.sleep(3600 * 1000);
    }

    /**
     * 复杂查询
     */
    @Test
    void testQueryComplex() throws InterruptedException {

        //1.复杂查询
        List<UserStaff> userStaffsComplex = MultiExecutorInner.list(MultiWrapperInner
                .main(
                        MultiWrapperMainInner.lambda(UserStaff.class)
                                .select(UserStaff::getSex, UserStaff::getStaffName)
                                .and(w ->
                                        w.eq(true, UserStaff::getStaffName, "StaffName3")
                                                .or()
                                                .and(w2 -> w2.eq(true, UserStaff::getStaffName, "StaffName4")
                                                        .eq(true, UserStaff::getStaffName, "StaffName4"))

                                )
                                .eq(true, UserStaff::getSex, 1)
                                .likeAll(true, UserStaff::getStaffName, "111")
                                .notIn(true, UserStaff::getStaffName, "111", "11122", "1112")
                                .limit(0, 20, Collections.singletonList("create_time desc"))

                )
                .leftJoin(MultiWrapperSubInner.lambda(User.class)
                        .select(User::getUsername)
                        .gt(BaseModel::getCreateTime, new Date())
                        .gt(BaseModel::getUpdateTime, LocalDateTime.now())
                        .in(BaseModel::getId, "1", "1", "3")
                        .likeAll(User::getUsername, "1")
                        .mainWhere(mainWhere ->
                                mainWhere.eq(User::getSex, 1)
                        )
                )
                .leftJoin(MultiWrapperSubInner.lambda(UserAddress.class)
                        .select(UserAddress::getProvince)
                        .gt(UserAddress::getId, "1")
                ));
        System.out.println("testQueryComplex=" + JsonUtil.toString(userStaffsComplex));
    }
}
