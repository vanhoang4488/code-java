package com.os.annotation;

import com.os.configuration.OpLogConfigureSelector;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(OpLogConfigureSelector.class)
public @interface EnableOpLog {

    AdviceMode mode() default AdviceMode.PROXY;
}
