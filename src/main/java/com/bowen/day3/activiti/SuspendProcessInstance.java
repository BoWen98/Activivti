package com.bowen.day3.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;

/**
 * @ProjectName: Activivti
 * @Package: com.bowen.day3.activiti
 * @ClassName: QueryProcessDefinition
 * @Author: Bowen
 * @Description: 全部流程挂起
 * @Date: 2019/8/4 7:21
 * @Version: 1.0.0
 */
public class SuspendProcessInstance {
    public static void main(String[] args) {

        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.创建RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //3.查询流程实例
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("holiday").singleResult();

        //4.得到当前实例是否都为暂停状态
        boolean suspended = processDefinition.isSuspended();
        String processDefinitionId = processDefinition.getId();
        if (suspended) {
            repositoryService.activateProcessDefinitionById(processDefinitionId, true, null);
            System.out.println("实例" + processDefinitionId + "激活");
        } else {
            repositoryService.suspendProcessDefinitionById(processDefinition.getId(), true, null);
            System.out.println("实例" + processDefinitionId + "挂起");
        }


    }

}
