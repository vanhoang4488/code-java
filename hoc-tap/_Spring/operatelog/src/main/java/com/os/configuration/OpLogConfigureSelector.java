package com.os.configuration;

import com.os.annotation.EnableOpLog;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;

public class OpLogConfigureSelector extends AdviceModeImportSelector<EnableOpLog> {

    private static final String OP_LOG_PROXY = "com.os.configuration.OpLogProxyAutoConfiguration";

    @Override
    protected String[] selectImports(AdviceMode adviceMode) {
        if(adviceMode == AdviceMode.PROXY) {
            return new String[]{OpLogProxyAutoConfiguration.class.getName()};
        }else
            return new String[]{OP_LOG_PROXY};
    }
}
