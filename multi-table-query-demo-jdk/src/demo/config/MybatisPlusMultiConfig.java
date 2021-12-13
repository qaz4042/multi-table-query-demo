package demo.config;


import com.bebetter.mtq.service.multiwrapper.config.MultiConfig;
import com.bebetter.mtq.service.multiwrapper.config.MultiProperties;
import com.bebetter.mtq.service.multiwrapper.executor.sqlexecutor.MultiDbJdbcAdaptor;
import demo.service.MultiTableRelationServiceImpl;

/**
 * @author Administrator
 */
public class MybatisPlusMultiConfig {
    public static void build() {
        MultiConfig.build(
                new MultiProperties(),
                new MultiTableRelationServiceImpl(),
//                new MultiDbJdbcAdaptor(
//                        "org.h2.Driver",
//                        "jdbc:h2:mem:multi_table_query_demo",
//                        "multi_table_query_demo",
//                        ""
//                )
                new MultiDbJdbcAdaptor(
                "com.mysql.jdbc.Driver",
                "jdbc:mysql://127.0.0.1:3306/multi_table_query_demo?useUnicode=true&characterEncoding=utf-8",
                "root",
                "root"
                )
        );
    }
}
