package com.bowen.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * @ProjectName: Activivti
 * @Package: com.bowen.activiti
 * @ClassName: ActitvitiStartInstance
 * @Author: Bowen
 * @Description: 启动流程实例, 前提完成流程定义和部署
 * @Date: 2019/8/3 13:44
 * @Version: 1.0.0
 */
public class ActitvitiStartInstance {

    public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到RunService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //3.创建流程实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday2");
        //4.输出实例相关对象
        System.out.println("流程部署ID" + processInstance.getDeploymentId());
        System.out.println("流程实例ID" + processInstance.getId());
        System.out.println("活动ID" + processInstance.getActivityId());
    }
}
