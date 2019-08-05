package com.bowen.day4.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;

/**
 * @ProjectName: Activivti
 * @Package: com.bowen.day4.activiti
 * @ClassName: AssigneeUEL
 * @Author: Bowen
 * @Description: 启动流程, 设置assignee
 * @Date: 2019/8/5 10:37
 * @Version: 1.0.0
 */
public class AssigneeUEL {
    public static void main(String[] args) {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.创建RuntimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();

        //3.设置assignee的取值,用户可以在界面上设置流程执行人
        HashMap<String, Object> map = new HashMap<>();
        map.put("assignee0", "张三");
        map.put("assignee1", "李四");
        map.put("assignee2", "王五");

        //4.启动流程实例,同时设置assignee的值
        ProcessInstance holiday2 = runtimeService.startProcessInstanceByKey("holiday2", map);

        //5.输出
        System.out.println(holiday2.getName());
    }
}
