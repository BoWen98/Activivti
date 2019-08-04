package com.bowen.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;

/**
 * @ProjectName: Activivti
 * @Package: com.bowen.activiti
 * @ClassName: ActivitiTaskQuery
 * @Author: Bowen
 * @Description: 处理当前用户任务
 * @Date: 2019/8/3 13:57
 * @Version: 1.0.0
 */
public class ActivitiCompleteTask {
    //张三
    public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.TaskService

        TaskService taskService = processEngine.getTaskService();

        //3.处理任务,结合当前任务查询操作,任务ID:7505
        taskService.complete("2505");

    }

   /* //李四
    public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.TaskService

        TaskService taskService = processEngine.getTaskService();

        //3.处理任务,结合当前任务查询操作,任务ID:10002
        taskService.complete("10002");

    }*/

    /*//王五
    public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.TaskService

        TaskService taskService = processEngine.getTaskService();

        //3.流程定义key,负责人assignee来实现人物列表查询
        List<Task> taskList = taskService.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee("王五")
                .list();

        for (Task task : taskList) {
            //3.处理任务,结合当前任务查询操作,任务ID:10002
            taskService.complete(task.getId());
        }
    }*/
}
