package com.core.autowired;

import com.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import javax.swing.text.html.Option;
import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutowiredOption() {
        // 스프링 빈으로 등록
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {
        // Member는 스프링 빈이 아니다. => 자동 주입할 대상이 없으면 수정자 메서드 자체가 호출 안됨
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        // 자동 주입할 대상이 없으면 null이 입력된다.
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        // 자동 주입할 대상이 없으면 `Optional.empty` 가 입력된다.
        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }

    }
}
