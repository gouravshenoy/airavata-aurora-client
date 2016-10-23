package org.apache.airavata.cloud.aurora.client;

import java.text.MessageFormat;
import java.util.Properties;

import org.apache.airavata.cloud.aurora.client.bean.JobConfigBean;
import org.apache.airavata.cloud.aurora.client.bean.ResponseBean;
import org.apache.airavata.cloud.aurora.client.sdk.AuroraSchedulerManager;
import org.apache.airavata.cloud.aurora.client.sdk.JobConfiguration;
import org.apache.airavata.cloud.aurora.client.sdk.ReadOnlyScheduler;
import org.apache.airavata.cloud.aurora.client.sdk.Response;
import org.apache.airavata.cloud.aurora.sample.AuroraClientSample;
import org.apache.airavata.cloud.aurora.util.AuroraThriftClientUtil;
import org.apache.airavata.cloud.aurora.util.Constants;
import org.apache.airavata.cloud.aurora.util.ResponseResultType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class AuroraThriftClient.
 */
public class AuroraThriftClient {
	
	/** The Constant logger. */
	private final static Logger logger = LoggerFactory.getLogger(AuroraThriftClient.class);
	
	/** The properties. */
	private static Properties properties = new Properties();
	
	/** The read only scheduler client. */
	private ReadOnlyScheduler.Client readOnlySchedulerClient = null;
	
	/** The aurora scheduler manager client. */
	private AuroraSchedulerManager.Client auroraSchedulerManagerClient = null;
	
	/** The thrift client. */
	private static AuroraThriftClient thriftClient = null;
	
	/**
	 * Instantiates a new aurora thrift client.
	 */
	private AuroraThriftClient() {}
	
	/**
	 * Gets the aurora thrift client.
	 *
	 * @param auroraSchedulerPropFile the aurora scheduler prop file
	 * @return the aurora thrift client
	 * @throws Exception the exception
	 */
	public static AuroraThriftClient getAuroraThriftClient(String auroraSchedulerPropFile) throws Exception {
		try {
			if(thriftClient == null) {
				thriftClient = new AuroraThriftClient();
				
				// construct connection url for scheduler
				properties.load(AuroraClientSample.class.getClassLoader().getResourceAsStream(auroraSchedulerPropFile));
				String auroraHost = properties.getProperty(Constants.AURORA_SCHEDULER_HOST);
				String auroraPort = properties.getProperty(Constants.AURORA_SCHEDULER_PORT);
				String connectionUrl = MessageFormat.format(Constants.AURORA_SCHEDULER_CONNECTION_URL, auroraHost, auroraPort);
				
				thriftClient.readOnlySchedulerClient = AuroraSchedulerClientFactory.createReadOnlySchedulerClient(connectionUrl);
				thriftClient.auroraSchedulerManagerClient = AuroraSchedulerClientFactory.createSchedulerManagerClient(connectionUrl);
			}
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw ex;
		}
		return thriftClient;
	}
	
	/**
	 * Creates the job.
	 *
	 * @param jobConfigBean the job config bean
	 * @return the response bean
	 * @throws Exception the exception
	 */
	public ResponseBean createJob(JobConfigBean jobConfigBean) throws Exception {
		ResponseBean response = null;
		try {
			if(jobConfigBean != null) {
				JobConfiguration jobConfig = AuroraThriftClientUtil.getAuroraJobConfig(jobConfigBean);
				Response createJobResponse = this.auroraSchedulerManagerClient.createJob(jobConfig);
				response = AuroraThriftClientUtil.getResponseBean(createJobResponse, ResponseResultType.CREATE_JOB);
			}
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw ex;
		}
		
		return response;
	}
}
