package com.bowen.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * @ProjectName: Activivti
 * @Package: com.bowen.activiti
 * @ClassName: ActivitiDeployment
 * @Author: Bowen
 * @Description: 流程定义部署
 * @Date: 2019/8/3 13:12
 * @Version: 1.0.0
 */
public class ActivitiDeployment {

    //流程定义部署
    public static void main(String[] args) {
        ProcessEngine pProcessEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到RepositoryService实例
        RepositoryService repositoryService = pProcessEngine.getRepositoryService();
        //3.进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday3.bpmn")//添加bpmn资源
                .addClasspathResource("diagram/holiday3.png")//添加图片文件
                .name("请假流程")
                .deploy();
        //4.输出部署信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());
    }

   /* //Zip流程化部署
    public static void main(String[] args) {
        ProcessEngine pProcessEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到RepositoryService实例
        RepositoryService repositoryService = pProcessEngine.getRepositoryService();
        //3.转化出zipInputStream流对象
        InputStream resourceAsStream = ActivitiDeployment.class.getClassLoader().getResourceAsStream("diagram/holiday.zip");

        ZipInputStream zipInputStream = new ZipInputStream(resourceAsStream);

        //4.进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addZipInputStream(zipInputStream)
                //.addClasspathResource("diagram/holiday.bpmn")//添加bpmn资源
                //.addClasspathResource("diagram/holiday.png")//添加图片文件
                .name("请假流程")
                .deploy();

        //5.输出部署信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());
    }*/

}
