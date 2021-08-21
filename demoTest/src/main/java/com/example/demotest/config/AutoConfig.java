package com.example.demotest.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoConfig {
    public static void main(String[] args) {



//       成绩代码生成器
        AutoGenerator autoGenerator=new AutoGenerator();

//       1 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setAuthor("狂神说");
        gc.setOpen(false);
        gc.setFileOverride(false); // 是否覆盖
        gc.setServiceName("%sService"); // 去Service的I前缀
        gc.setIdType(IdType.ID_WORKER);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        autoGenerator.setGlobalConfig(gc);

//         2 包的配置
        PackageConfig packageConfig=new PackageConfig();
        packageConfig.setController("controller");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        packageConfig.setParent("com.example.demotest");
        autoGenerator.setPackageInfo(packageConfig);

        autoGenerator.execute();


    }



}
