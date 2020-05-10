package com.infoshareacademy.freemaker;

public class ConfigProvider {
    @ApplicationScoped
    public class ConfigProvider {
        private Configuration configuration;
        public Configuration getConfiguration() {
            if (configuration == null) {
                configuration = new Configuration(Configuration.VERSION_2_3_30);
                configuration.setDefaultEncoding("UTF-8");
                configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
                configuration.setLogTemplateExceptions(false);
                configuration.setWrapUncheckedExceptions(true);
            }
            return configuration;
        }
    }
}
