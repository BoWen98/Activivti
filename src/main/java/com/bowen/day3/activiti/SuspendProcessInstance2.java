package com.bowen.day3.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * @ProjectName: Activivti
 * @Package: com.bowen.day3.activiti
 * @ClassName: QueryProcessDefinition
 * @Author: Bowen
 * @Description: 单个流程挂起
 * @Date: 2019/8/4 7:21
 * @Version: 1.0.0
 */
public class SuspendProcessInstance2 {
    public static void main(String[] args) {

        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.创建RuntimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();


        //3.查询流程实例
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId("2501").singleResult();

        //4.得到当前实例是否都为暂停状态
        boolean suspended = processInstance.isSuspended();
        String processInstanceId = processInstance.getId();
        if (suspended) {
            runtimeService.activateProcessInstanceById(processInstanceId);
            System.out.println("实例" + processInstanceId + "激活");
        } else {
            runtimeService.suspendProcessInstanceById(processInstanceId);
            System.out.println("实例" + processInstanceId + "挂起");
        }


    }

}
