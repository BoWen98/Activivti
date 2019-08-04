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
 * @Description: 启动流程实例, 添加businessKEy
 * @Date: 2019/8/4 7:21
 * @Version: 1.0.0
 */
public class BusinessKeyAdd {
    public static void main(String[] args) {

        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.创建RuntimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();

        //3.启动流程实例,同时要制定业务标识BusinessKey,它本身请假单ID
        //第一个参数:指定流程key
        //第二个参数:业务标识 同时要制定业务标识BusinessKey
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday", "1001");

        //4.输出processInstance相关属性
        System.out.println(processInstance.getBusinessKey());


    }

}
