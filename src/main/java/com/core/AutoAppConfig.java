package com.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @Component 가 붙은 것들을 모두 찾아서 스프링 빈으로 자동 등록
@ComponentScan (
        // : 탐색할 패키지의 시작 위치를 지정한다. 이 패키지를 포함해서 하위 패키지를 모두 탐색한다.
        basePackages = "com.core",
        // 기존에 제외된 Configuration 은 제외!
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)

public class AutoAppConfig {
}
