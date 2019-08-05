package com.bowen.day4.activiti.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
 * @ProjectName: Activivti
 * @Package: com.bowen.day4.activiti.test
 * @ClassName: VariableTest
 * @Author: Bowen
 * @Description: 流程变量的测试
 * @Date: 2019/8/5 12:33
 * @Version: 1.0.0
 */
public class VariableTest {

    //完成任务
    public static void main(String[] args) {

        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.TaskService
        TaskService taskService = processEngine.getTaskService();
        //3.流程定义key,负责人assignee来实现人物列表查询
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday3")
                //.taskAssignee("张三")
                //.taskAssignee("李四")
                //.taskAssignee("王五")
                .taskAssignee("赵六")
                .singleResult();
        if (task != null) {
            //4.处理任务,结合当前任务查询操作,任务ID:7505
            taskService.complete(task.getId());
            System.out.println("任务执行完毕");
        }

    }


    //启动流程实例,设置流程变量值
   /* public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到RunService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //3.创建流程实例
        String key = "holiday3";
        HashMap<String, Object> map = new HashMap<>();

        Holiday holiday = new Holiday();
        holiday.setNum(5F);
        map.put("holiday", holiday);


        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, map);

        //4.输出实例相关对象
        System.out.println("流程部署ID" + processInstance.getName());
        System.out.println("流程实例ID" + processInstance.getId());
        System.out.println("活动ID" + processInstance.getActivityId());


    }*/





   /* //新的请假流程定义的部署
    public static void main(String[] args) {

        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到RepositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3.进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday3.bpmn")//添加bpmn资源
                .addClasspathResource("diagram/holiday3.png")//添加图片文件
                .name("请假流程")
                .deploy();
        //4.输出部署信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());
    }*/
}
