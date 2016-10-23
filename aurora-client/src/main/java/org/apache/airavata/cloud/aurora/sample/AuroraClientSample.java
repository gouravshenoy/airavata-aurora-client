package org.apache.airavata.cloud.aurora.sample;

import java.text.MessageFormat;
import java.util.Properties;
import java.util.Set;

import org.apache.airavata.cloud.aurora.client.AuroraSchedulerClientFactory;
import org.apache.airavata.cloud.aurora.client.sdk.ExecutorConfig;
import org.apache.airavata.cloud.aurora.client.sdk.GetJobsResult;
import org.apache.airavata.cloud.aurora.client.sdk.Identity;
import org.apache.airavata.cloud.aurora.client.sdk.JobConfiguration;
import org.apache.airavata.cloud.aurora.client.sdk.JobKey;
import org.apache.airavata.cloud.aurora.client.sdk.ReadOnlyScheduler;
import org.apache.airavata.cloud.aurora.client.sdk.Response;
import org.apache.airavata.cloud.aurora.client.sdk.TaskConfig;
import org.apache.airavata.cloud.aurora.util.Constants;
import org.apache.thrift.TException;

public class AuroraClientSample {
	
	private static ReadOnlyScheduler.Client auroraSchedulerClient;
	private static Properties properties = new Properties();
	
	public static void getJobSummary(ReadOnlyScheduler.Client client) {
		try {
			Response response = client.getJobs("centos");
			System.out.println("Response status: " + response.getResponseCode().name());
			if(response.getResult().isSetGetJobsResult()) {
				GetJobsResult result = response.getResult().getGetJobsResult();
				System.out.println(result);
				Set<JobConfiguration> jobConfigs = result.getConfigs();
				for(JobConfiguration jobConfig : jobConfigs) {
					System.out.println(jobConfig);
					JobKey jobKey = jobConfig.getKey();
					Identity owner = jobConfig.getOwner();
					TaskConfig taskConfig = jobConfig.getTaskConfig();
					ExecutorConfig exeConfig = taskConfig.getExecutorConfig();
					
					System.out.println("\n**** JOB CONFIG ****");
						System.out.println("\t # instanceCount: " + jobConfig.getInstanceCount());
						
						System.out.println("\t >> Job Key <<");
							System.out.println("\t\t # name: " + jobKey.getName());
							System.out.println("\t\t # role: " + jobKey.getRole());
							System.out.println("\t\t # environment: " + jobKey.getEnvironment());
							
						System.out.println("\t >> Identity <<");
							System.out.println("\t\t # owner: " + owner.getUser());
							
						System.out.println("\t >> Task Config <<");
							System.out.println("\t\t # numCPUs: " + taskConfig.getNumCpus());
							System.out.println("\t\t # diskMb: " + taskConfig.getDiskMb());
							System.out.println("\t\t # ramMb: " + taskConfig.getRamMb());
							System.out.println("\t\t # priority: " + taskConfig.getPriority());
							
							
						System.out.println("\t >> Executor Config <<");
							System.out.println("\t\t # name: " + exeConfig.getName());
							System.out.println("\t\t # data: " + exeConfig.getData());
				}
				
			}
		} catch (TException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		 try {
			properties.load(AuroraClientSample.class.getClassLoader().getResourceAsStream(Constants.AURORA_SCHEDULER_PROP_FILE));
			String auroraHost = properties.getProperty(Constants.AURORA_SCHEDULER_HOST);
			String auroraPort = properties.getProperty(Constants.AURORA_SCHEDULER_PORT);
			auroraSchedulerClient = AuroraSchedulerClientFactory.createAuroraClient(MessageFormat.format(Constants.AURORA_SCHEDULER_CONNECTION_URL, auroraHost, auroraPort));
			
			// get jobs summary
			AuroraClientSample.getJobSummary(auroraSchedulerClient);
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}

}
