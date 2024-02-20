package com.mysite.sbb.global.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;


@Target({ElementType.TYPE}) // 클래스 레벨에서 사용될 수 있도록 지정합니다.
@Retention(RetentionPolicy.RUNTIME) // 런타임에 이 어노테이션 정보가 유지되어야 함을 나타냅니다.
@Documented // 이 어노테이션이 문서화되어 JavaDoc 등에 포함될 수 있도록 합니다.
@Component // 이 커스텀 어노테이션이 Spring 컴포넌트로 인식될 수 있도록 @Component 어노테이션을 사용합니다.
public @interface Util {
    // @Component의 value 속성과 연동되어 이 어노테이션에 이름을 제공할 수 있습니다.
    // 이는 Spring 컨테이너에서 관리되는 bean의 이름을 지정하는 데 사용될 수 있습니다.
    @AliasFor(annotation = Component.class)
    String value() default "";
}