package com.bowen.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @ProjectName: Activivti
 * @Package: com.bowen.activiti
 * @ClassName: ActivitiTaskQuery
 * @Author: Bowen
 * @Description: 查询用户任务列表
 * @Date: 2019/8/3 13:57
 * @Version: 1.0.0
 */
public class ActivitiTaskQuery {

    public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.TaskService

        TaskService taskService = processEngine.getTaskService();

        //3.流程定义key,负责人assignee来实现人物列表查询
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee("张三")
                .list();

        //4.任务列表展示
        for (Task task : taskList) {
            System.out.println("流程实例ID:" + task.getProcessInstanceId());
            System.out.println("任务ID:" + task.getId());
            System.out.println("任务负责人:" + task.getAssignee());
            System.out.println("任务名称:" + task.getName());
        }
    }

    /*public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.TaskService

        TaskService taskService = processEngine.getTaskService();

        //3.流程定义key,负责人assignee来实现人物列表查询
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee("李四")
                .list();

        //4.任务列表展示
        for (Task task : taskList) {
            System.out.println("流程实例ID:" + task.getProcessInstanceId());
            System.out.println("任务ID:" + task.getId());
            System.out.println("任务负责人:" + task.getAssignee());
            System.out.println("任务名称:" + task.getName());
        }
    }*/
   /* public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.TaskService

        TaskService taskService = processEngine.getTaskService();

        //3.流程定义key,负责人assignee来实现人物列表查询
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee("王五")
                .list();

        //4.任务列表展示
        for (Task task : taskList) {
            System.out.println("流程实例ID:" + task.getProcessInstanceId());
            System.out.println("任务ID:" + task.getId());
            System.out.println("任务负责人:" + task.getAssignee());
            System.out.println("任务名称:" + task.getName());
        }
    }*/
}
