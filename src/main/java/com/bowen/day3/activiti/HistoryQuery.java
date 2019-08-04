package com.bowen.day3.activiti;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;

import java.util.List;

/**
 * @ProjectName: Activivti
 * @Package: com.bowen.day3.activiti
 * @ClassName: QueryProcessDefinition
 * @Author: Bowen
 * @Description: 查询历史记录
 * @Date: 2019/8/4 7:21
 * @Version: 1.0.0
 */
public class HistoryQuery {
    public static void main(String[] args) {

        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.创建HistoryService对象
        HistoryService historyService = processEngine.getHistoryService();

        //3.得到HistoricActivityInstanceQuery对象
        HistoricActivityInstanceQuery historicActivityInstanceQuery = historyService.createHistoricActivityInstanceQuery();
        //设置实例流程ID
        historicActivityInstanceQuery.processInstanceId("2501");

        //4.执行查询
        //List<HistoricActivityInstance> list = historicActivityInstanceQuery.list();
        //排序StartTime
        List<HistoricActivityInstance> list = historicActivityInstanceQuery
                .orderByHistoricActivityInstanceStartTime()
                .asc()
                .list();
        //5.遍历结果
        for (HistoricActivityInstance historicActivityInstance : list) {
            System.out.println(historicActivityInstance.getActivityId());
            System.out.println(historicActivityInstance.getActivityName());
            System.out.println("============================");
        }

    }

}
