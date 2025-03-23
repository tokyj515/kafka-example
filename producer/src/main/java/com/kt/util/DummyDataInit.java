package com.kt.util;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 개발 환경에서 더미 데이터를 넣을 때 사용하는 annotation
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Profile({"local", "dev", "prod"})
@Transactional
@Component
public @interface DummyDataInit {
}
