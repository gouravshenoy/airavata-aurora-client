package org.apache.airavata.cloud.aurora.client;

import org.apache.airavata.cloud.aurora.client.sdk.ReadOnlyScheduler;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuroraSchedulerClientFactory {
	
	private final static Logger logger = LoggerFactory.getLogger(AuroraSchedulerClientFactory.class);
	
	public static ReadOnlyScheduler.Client createAuroraClient(String connectionUrl) throws Exception {
		try {
			TTransport transport = new THttpClient(connectionUrl);
			transport.open();
			TProtocol protocol = new TJSONProtocol(transport);
			return new ReadOnlyScheduler.Client(protocol);
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw ex;
		}
	}

}
