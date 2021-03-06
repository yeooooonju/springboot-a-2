package com.study.springboota2.discount;

import com.study.springboota2.member.Grade;
import com.study.springboota2.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 한다")
    void VIP_O() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.dicount(member, 20000);

        //then
        assertThat(discount).isEqualTo(2000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void VIP_X() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.BASIC);

        //when
        int discount = discountPolicy.dicount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);
    }
}