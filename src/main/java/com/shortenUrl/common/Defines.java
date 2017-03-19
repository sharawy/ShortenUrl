
package com.shortenUrl.common;

/**
 *
 * @author abdalrahman.sharawy
 */
public class Defines {

    public static class Statics {

        public static final String PROP_FILE_PATH = "classpath:appllication.properties";
        public static final String APPLICATION_PROPERTIES = "appllicationProperties";
        public static final String RESOURCES_CACHE_PERIOD = "resources_cache_period";
        public static final String CHAR_SET = "123456789bcdfghjkmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ!@#$%&*()[]{}";
        
    }
    public static class ResourceHandler {
        public static final String RESOURCE_HANDLER = "resources_handler";
        public static final String RESOURCE_LOCATIONS = "resources_locations";
        public static final String RESOURCES_CACHE_PERIOD = "resources_cache_period";
    }
    public static class ViewResolver {
        public static final String PREFIX = "resolver_prefix";
        public static final String SUFIX = "resolver_sufix";
    }
  public static class Packages {

        public static final String REPOISTORY_PACKAGE = "com.shortenUrl.repositories";
        public static final String BASE_PACKAGE = "com";
        public static final String MODEL_PACKAGE = "com.shortenUrl.models";
       

    }

    public static class DataSource {

        public static String DB_DRIVER_CLASS = "driverClass";
        public static String DB_URL = "url";
        public static String DB_USERNAME = "username";
        public static String DB_PASSWORD = "password";

    }

    public static class Hibernate {

        public static final String DIALECT = "hibernate.dialect";
        public static final String CONN_POOL_SIZE = "hibernate.connection.pool_size";
        public static final String SHOW_SQL = "hibernate.show_sql";
        public static final String HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
        public static final String SESSION_CONTEX_CLASS = "hibernate.current_session_context_class";
    }
}
