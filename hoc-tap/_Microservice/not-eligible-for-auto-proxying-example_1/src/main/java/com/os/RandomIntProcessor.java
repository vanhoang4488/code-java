package com.os;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

@Configuration
public class RandomIntProcessor implements BeanPostProcessor {

    private final RandomIntGenerator randomIntGenerator;

    @Lazy
    public RandomIntProcessor(RandomIntGenerator randomIntGenerator){
        this.randomIntGenerator = randomIntGenerator;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException{
        Field[] fields = bean.getClass().getDeclaredFields();
        for(Field field : fields){

            if(field.isAnnotationPresent(RandomInt.class)){
                RandomInt randomInt = field.getAnnotation(RandomInt.class);
                int min = randomInt.min();
                int max = randomInt.max();
                int randomValue = randomIntGenerator.generator(min, max);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, randomValue);
            }
        }
        return bean;
    }
}
