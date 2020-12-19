package com.lw.utils;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 *     https://blog.csdn.net/weixin_43671737/article/details/106551387
 *     <br/>
 *     https://blog.csdn.net/m0_37968982/article/details/90580145
 * </p>
 * @author yujun.wu
 * @version 1.0
 * @create date 2020/12/18 22:37
 * @Description:mybatis-plus 代码生成工具类
 */
public class MPCodeGenerator {
    /**
     * @param tip
     * @return
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        // 全局配置
        GlobalConfig gc = new GlobalConfig()
                .setOutputDir(projectPath + "/src/main/java")
                .setAuthor("yujun.wu")
                .setSwagger2(true)//实体属性 Swagger2 注解
                .setOpen(false)//是否打开输出目录
                .setBaseColumnList(true)//mapper.xml中生成通用查询结果列
                .setFileOverride(true)//文件覆盖
                .setBaseResultMap(true);//mapper.xml中生成通用查询映射结果

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig()
                .setUrl("jdbc:mysql://localhost:3306/studentManager?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("root")
                .setPassword("123456");

        // 包配置
        PackageConfig packageConfig = new PackageConfig()
                //.setModuleName(scanner("模板名"))//单个模块中可以设置
                .setParent("com.lw")
                .setEntity("bean");

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        /**
         * 将xml生成到resource下面
         */
        String templatePath = "/templates/mapper.xml.ftl"; // framemark
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/"
//                        + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
         // 自定义配置会被优先输出
        cfg.setFileOutConfigList(focList);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController("templates/controller.java");// /templates/entity.java 模板路径配置，默认再templates
        templateConfig.setXml("");

        // 策略配置
        StrategyConfig strategy = new StrategyConfig()
                .setNaming(NamingStrategy.underline_to_camel)//数据库表映射到实体的命名策略
                .setColumnNaming(NamingStrategy.underline_to_camel)//数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
                .setEntityLombokModel(true)//是否为lombok模型，默认false
                .setRestControllerStyle(true)//生成 @RestController 控制器
                .setInclude(scanner("表名，多个英文逗号分割").split(","))
                .setTablePrefix("lw_")//去除表前缀
                .setFieldPrefix("T_")//去除字段前缀
                .setControllerMappingHyphenStyle(true);////驼峰转连字符

        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator()
                .setGlobalConfig(gc)
                .setDataSource(dataSourceConfig)
                .setPackageInfo(packageConfig)
                .setCfg(cfg)
                .setStrategy(strategy)
                .setTemplate(templateConfig)
                .setTemplateEngine(new FreemarkerTemplateEngine());

        autoGenerator.execute();
    }

}
