package org.apache.airavata.cloud.aurora.util;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.apache.airavata.cloud.aurora.client.bean.IdentityBean;
import org.apache.airavata.cloud.aurora.client.bean.JobConfigBean;
import org.apache.airavata.cloud.aurora.client.bean.JobKeyBean;
import org.apache.airavata.cloud.aurora.client.bean.ProcessBean;
import org.apache.airavata.cloud.aurora.client.bean.ResourceBean;
import org.apache.airavata.cloud.aurora.client.bean.TaskConfigBean;
import org.apache.airavata.cloud.aurora.client.sdk.ExecutorConfig;
import org.apache.airavata.cloud.aurora.client.sdk.Identity;
import org.apache.airavata.cloud.aurora.client.sdk.JobConfiguration;
import org.apache.airavata.cloud.aurora.client.sdk.JobKey;
import org.apache.airavata.cloud.aurora.client.sdk.Resource;
import org.apache.airavata.cloud.aurora.client.sdk.TaskConfig;
import org.apache.airavata.cloud.aurora.sample.AuroraClientSample;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuroraThriftClientUtil {

	private final static Logger logger = LoggerFactory.getLogger(AuroraThriftClientUtil.class);
	
	private static Properties properties = new Properties();
	
	public static String getExecutorConfigJson(JobConfigBean jobConfig) throws Exception {
		String exeConfigJson = null;
		try {
			String template = IOUtils.toString(AuroraThriftClientUtil.class.getClassLoader()
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
			logger.error(ex.getMessage(), ex);
			throw ex;
		}
		return exeConfigJson;
	}
	
	public static Set<Resource> getResourceSet(ResourceBean resources) throws Exception {
		Set<Resource> resourceSet = new HashSet<>();
		
		try {
			if(resources != null) {
				// add numCpus
				Resource resource = new Resource();
				resource.setNumCpus(resources.getNumCpus());
				resourceSet.add(resource);
				
				// add diskMb
				resource = new Resource();
				resource.setDiskMb(resources.getDiskMb());
				resourceSet.add(resource);
				
				// add ramMb
				resource = new Resource();
				resource.setRamMb(resources.getRamMb());
				resourceSet.add(resource);
			} else {
				throw new Exception("Resource Bean is NULL!");
			}
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw ex;
		}
		
		return resourceSet;
	}
	
	public static ExecutorConfig getExecutorConfig(String exeConfigJson) throws Exception {
		ExecutorConfig exeConfig = null;
		
		try {
			properties.load(AuroraClientSample.class.getClassLoader().getResourceAsStream(Constants.AURORA_SCHEDULER_PROP_FILE));
			String executorName = properties.getProperty(Constants.AURORA_EXECUTOR_NAME);
			
			// create the executor config
			if(exeConfigJson != null) {
				exeConfig = new ExecutorConfig(executorName, exeConfigJson);
			} else {
				throw new Exception("Aurora Executor Config Data is NULL!");
			}
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw ex;
		}
		
		return exeConfig;
	}
	
	public static JobKey getAuroraJobKey(JobKeyBean jobKeyBean) throws Exception {
		JobKey jobKey = null;
		
		try {
			if(jobKeyBean != null) {
				jobKey = new JobKey(jobKeyBean.getRole(), 
						jobKeyBean.getEnvironment(), 
						jobKeyBean.getName());
			} else {
				throw new Exception("JobKey Bean is NULL!");
			}
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw ex;
		}
		
		return jobKey;
	}
	
	public static Identity getAuroraIdentity(IdentityBean identityBean) throws Exception {
		Identity owner = null;
		
		try {
			if(identityBean != null) {
				owner = new Identity(identityBean.getUser());
			} else {
				throw new Exception("Identity Bean is NULL!");
			}
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw ex;
		}
		
		return owner;
	}
	
	public static JobConfiguration getAuroraJobConfig(JobConfigBean jobConfigBean) throws Exception {
		JobConfiguration jobConfig = null;
		
		try {
			if(jobConfigBean != null && 
					jobConfigBean.getTaskConfig() != null) {
				
				JobKey jobKey = getAuroraJobKey(jobConfigBean.getJob());
				Identity owner = getAuroraIdentity(jobConfigBean.getOwner());
				// Construct the task config
				TaskConfig taskConfig = new TaskConfig();
				taskConfig.setJob(jobKey);
				taskConfig.setOwner(owner);
				taskConfig.setIsService(jobConfigBean.isService()); 
				taskConfig.setNumCpus(jobConfigBean.getTaskConfig().getResources().getNumCpus()); 
				taskConfig.setRamMb(jobConfigBean.getTaskConfig().getResources().getRamMb());
				taskConfig.setDiskMb(jobConfigBean.getTaskConfig().getResources().getDiskMb()); 
				taskConfig.setPriority(jobConfigBean.getPriority());
				taskConfig.setMaxTaskFailures(jobConfigBean.getMaxTaskFailures()); 
				taskConfig.setResources(getResourceSet(jobConfigBean.getTaskConfig().getResources()));
				
				// construct the executor config for this job
				taskConfig.setExecutorConfig(getExecutorConfig(getExecutorConfigJson(jobConfigBean)));
				
				// construct the job configuration
				jobConfig = new JobConfiguration(jobKey, 
						owner, null, taskConfig, jobConfigBean.getInstances());
				
			} else {
				throw new Exception("JobConfig, TaskConfig Bean is/are NULL!");
			}
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw ex;
		}
		
		return jobConfig;
	}
	
	public static void main(String[] args) throws Exception {
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
		
		String executorConfigJson = getExecutorConfigJson(jobConfig);
		System.out.println(executorConfigJson);
	}
}
