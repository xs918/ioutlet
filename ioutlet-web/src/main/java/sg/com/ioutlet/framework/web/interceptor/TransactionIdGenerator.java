package sg.com.ioutlet.framework.web.interceptor;

import java.util.UUID;

public final  class TransactionIdGenerator {
	public static String getUniversallyUniqueID()
	{
	return UUID.randomUUID().toString();
	}
}
