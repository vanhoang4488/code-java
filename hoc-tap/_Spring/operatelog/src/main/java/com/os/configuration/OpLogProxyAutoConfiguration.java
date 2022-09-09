package com.os.configuration;

import com.os.annotation.EnableOpLog;
import com.os.aop.OpLogInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.context.annotation.Role;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

@Slf4j
@Configuration
public class OpLogProxyAutoConfiguration implements ImportAware{

    private AnnotationAttributes enableOpLogRecord;

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public OpLogInterceptor logRecordInterceptor(){
        return new OpLogInterceptor();
    }

    @Override
    public void setImportMetadata(AnnotationMetadata annotationMetadata) {
        this.enableOpLogRecord =
                AnnotationAttributes.fromMap(
                        annotationMetadata.getAnnotationAttributes(
                                EnableOpLog.class.getName(), false));
        if(enableOpLogRecord == null)
            log.info("@EnableOpLog is not present on importing class");
    }
}
