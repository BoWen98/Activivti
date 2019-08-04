package com.bowen.day3.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;

/**
 * @ProjectName: Activivti
 * @Package: com.bowen.day3.activiti
 * @ClassName: QueryProcessDefinition
 * @Author: Bowen
 * @Description: 删除已经部署流程信息,
 *                1.注意当前流程没有完全结束此时要删除流程定义信息就会失败!
 *                2.强制删除怎么办?
 *                   参数true代表级联删除,此时会删除没有完成的流程节点,
 *                   最后删除流程定义!repositoryService.deleteDeployment("1",true);
 * @Date: 2019/8/4 7:21
 * @Version: 1.0.0
 */
public class DeleteProcessDefinition {
    public static void main(String[] args) {

        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.创建RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //3.得到ProcessDefinitionQuery对象
        repositoryService.deleteDeployment("1");

    }

}
