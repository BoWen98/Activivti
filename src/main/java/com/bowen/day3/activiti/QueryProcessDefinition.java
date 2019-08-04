package com.bowen.day3.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * @ProjectName: Activivti
 * @Package: com.bowen.day3.activiti
 * @ClassName: QueryProcessDefinition
 * @Author: Bowen
 * @Description: 查询流程信息信息
 * @Date: 2019/8/4 7:21
 * @Version: 1.0.0
 */
public class QueryProcessDefinition {
    public static void main(String[] args) {

        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.创建RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //3.得到ProcessDefinitionQuery对象
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();

        //4.设置条件,并查询出当前所有流程定义
        //orderByProcessDefinitionVersion() 设置排序,根据流程版本号
        List<ProcessDefinition> list = processDefinitionQuery.processDefinitionKey("holiday")
                .orderByProcessDefinitionVersion()
                .desc().list();

        //5.输出流程定义
        for (ProcessDefinition processDefinition : list) {
            System.out.println(processDefinition.getId());
            System.out.println(processDefinition.getName());
            System.out.println(processDefinition.getKey());
            System.out.println(processDefinition.getVersion());
            System.out.println(processDefinition.getDeploymentId());
        }
    }

}
