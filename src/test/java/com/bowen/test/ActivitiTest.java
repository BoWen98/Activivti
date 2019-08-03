package com.bowen.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

/**
 * @ProjectName: Activivti
 * @Package: com.bowen.test
 * @ClassName: ActivitiTest
 * @Author: Bowen
 * @Description: 测试activiti生成数据库
 * @Date: 2019/8/2 11:16
 * @Version: 1.0.0
 */
public class ActivitiTest {

    @Test
    public void testGenTable() {
        //1.创建ProcessEngineConfiguration对象
        ProcessEngineConfiguration configurationFromResource = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        //2.创建ProcessEngine对象
        ProcessEngine processEngine = configurationFromResource.buildProcessEngine();
        //3.输出ProcessEngine对象
        System.out.println(processEngine);
    }
}
