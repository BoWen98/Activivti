package com.bowen.day3.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ProjectName: Activivti
 * @Package: com.bowen.day3.activiti
 * @ClassName: QueryBpmnFile
 * @Author: Bowen
 * @Description: 查询bpmn文件
 * 从Activiti的act_ge_bytearray表中两个资源文件
 * 保存到本地路径
 * 技术方案:
 * 1.第一种方式activiti的api实现
 * 2.第二种方式:其实就是原理层面,可以使用jdbc的对blod类型,clob类型数据的读取,并保存
 * 3.IO流转换,最好commonx-io.jar     轻松解决IO操作
 * @Date: 2019/8/4 8:23
 * @Version: 1.0.0
 */
public class QueryBpmnFile {

    public static void main(String[] args) throws IOException {
        //1.得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.创建RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //3.得到查询器:ProcessDefinitionQuery对象
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();

        //4.设置查询条件
        processDefinitionQuery.processDefinitionKey("holiday");//参数定义key

        //5.执行查询操作,查询出流程定义
        ProcessDefinition processDefinition = processDefinitionQuery.singleResult();

        //6.通过流程定义信息,得到部署ID
        String deploymentId = processDefinition.getDeploymentId();

        //7.通过repositoryService的方法,实现读取图片信息及bpmn文件信息(输入流)
        //getResourceAsStream方法说明,第一个参数部署id,第二个参数待变资源名称
        //processDefinition.getDiagramResourceName()代表获取pnd图片资源
        // processDefinition.getResourceName()代表获取bpmn文件名称
        InputStream pngIs = repositoryService
                .getResourceAsStream(deploymentId, processDefinition.getDiagramResourceName());
        InputStream bpmnIs = repositoryService
                .getResourceAsStream(deploymentId, processDefinition.getResourceName());

        //8.构建出OutputStream流
        FileOutputStream pngOs =
                new FileOutputStream("C:\\Users\\Bowen\\Desktop\\blog\\" + processDefinition.getDiagramResourceName());
        FileOutputStream bpmnOs =
                new FileOutputStream("C:\\Users\\Bowen\\Desktop\\blog\\" + processDefinition.getResourceName());

        //9.输入输出流转换 commons-io-xx.jar的方法
        IOUtils.copy(pngIs, pngOs);
        IOUtils.copy(bpmnIs, bpmnOs);

        //10.关闭流
        pngOs.close();
        bpmnOs.close();
        pngIs.close();
        bpmnIs.close();
    }

}
