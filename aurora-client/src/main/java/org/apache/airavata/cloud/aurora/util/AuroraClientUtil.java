package org.apache.airavata.cloud.aurora.util;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

import org.apache.airavata.cloud.aurora.client.bean.IdentityBean;
import org.apache.airavata.cloud.aurora.client.bean.JobConfigBean;
import org.apache.airavata.cloud.aurora.client.bean.JobKeyBean;
import org.apache.airavata.cloud.aurora.client.bean.ProcessBean;
import org.apache.airavata.cloud.aurora.client.bean.ResourceBean;
import org.apache.airavata.cloud.aurora.client.bean.TaskConfigBean;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class AuroraClientUtil {

	public static String executorConfigJson(JobConfigBean jobConfig) {
		String exeConfigJson = null;
		try {
			String template = IOUtils.toString(AuroraClientUtil.class.getClassLoader()
					.getResourceAsStream("executor-config-template.json"), Charset.defaultCharset());
			
			JSONObject exeConfig = new JSONObject(template);
			if(exeConfig != null) {
				exeConfig.put("environment", jobConfig.getJob().getEnvironment());
				exeConfig.put("name", jobConfig.getJob().getName());
				exeConfig.put("role", jobConfig.getJob().getRole());
				exeConfig.put("cluster", jobConfig.getCluster());
				exeConfig.put("max_task_failures", jobConfig.getMaxTaskFailures());
				exeConfig.put("service", jobConfig.isService());
				
				exeConfig.getJSONObject("task").put("name", jobConfig.getTaskConfig().getTaskName());
				
				// add task resources
				exeConfig.getJSONObject("task").getJSONObject("resources")
					.put("cpu", jobConfig.getTaskConfig().getResources().getNumCpus());
				
				exeConfig.getJSONObject("task").getJSONObject("resources")
				.put("disk", jobConfig.getTaskConfig().getResources().getDiskMb());
				
				exeConfig.getJSONObject("task").getJSONObject("resources")
				.put("ram", jobConfig.getTaskConfig().getResources().getRamMb());
				
				// iterate over all processes
				for(ProcessBean process : jobConfig.getTaskConfig().getProcesses()) {
					// add process to constraints
					exeConfig.getJSONObject("task")
						.getJSONArray("constraints")
						.getJSONObject(0)
						.getJSONArray("order").put(process.getName());
					
					// define the process json
					JSONObject processJson = new JSONObject();
					processJson.put("final", process.isFinal())
						.put("daemon", process.isDaemon())
						.put("name", process.getName())
						.put("ephemeral", process.isEphemeral())
						.put("max_failures", process.getMax_failures())
						.put("min_duration", process.getMin_duration())
						.put("cmdline", process.getCmdLine());
					
					// add process json to list
					exeConfig.getJSONObject("task")
					.getJSONArray("processes").put(processJson);
				}
				
				// convert json object to string
				exeConfigJson = exeConfig.toString();
			}
 		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return exeConfigJson;
	}
	
	public static void main(String[] args) {
		JobKeyBean jobKey = new JobKeyBean("devel", "centos", "test_job");
		IdentityBean owner = new IdentityBean("centos");
		
		ProcessBean proc1 = new ProcessBean("process_1", "echo hello_world_1", false);
		ProcessBean proc2 = new ProcessBean("process_2", "echo hello_world_2", false);
		Set<ProcessBean> processes = new HashSet<>();
		processes.add(proc1);
		processes.add(proc2);
		
		ResourceBean resources = new ResourceBean(0.25, 8388608, 1048576);
		
		TaskConfigBean taskConfig = new TaskConfigBean("task_hello_world", processes, resources);
		JobConfigBean jobConfig = new JobConfigBean(jobKey, owner, taskConfig, "example");
		
		String executorConfigJson = executorConfigJson(jobConfig);
		System.out.println(executorConfigJson);
	}
}
