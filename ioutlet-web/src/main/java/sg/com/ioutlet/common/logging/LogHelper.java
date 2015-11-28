package sg.com.ioutlet.common.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogHelper implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Log log;
	private final String PREFIX = "";

	private final String BIZ_ERROR_PREFIX = "(BE)";

	private final String TRACE_PREFIX = "(T) ";

	private final String INTERFACE_PREFIX = "(I) ";

	private final String PERFORMANCE_PREFIX = "(P) ";

	private final String STACK_TRACE = "[Exception Caught Caused By:]";

	private LogHelper(String className, boolean logenable) {
		log = LogFactory.getLog(className);
	}
	
    public static LogHelper getInstance(String className)
    {
    	return new LogHelper(className,true);
    }
    /**
     * Check the debug level is enabled for logging
     * @return true if debug level is enable
     */
    public boolean isDebugEnabled()
    {
        return log.isDebugEnabled();
    }
    
    
    /**
     * Make a banner
     */
    public void banner()
    {
        if(log.isDebugEnabled())
        {
            log.debug("\n==================================================================\n");
        }
    }
    
    /**
     * Log at debug level
     * 
     * @param debugMsg
     */
    public void debug(String debugMsg)
    {
        if (log.isDebugEnabled())
        {
            log.debug(PREFIX + debugMsg);
        }
    }
    /**
     * Log at error level
     * 
     * @param errorMsg
     * @return String the error reference code
     */
    public synchronized String error(String errorMsg)
    {
        String errorRef = "" + System.currentTimeMillis();
        //if(log.isErrorEnabled())
        {
            log.error(PREFIX + "error ref: " + errorRef);
            log.error(PREFIX + errorMsg);
        }
        return errorRef;
    }
    
    public synchronized String error(String errorMsg, Throwable e)
    {
        String errorRef = "" + System.currentTimeMillis();

        //if(log.isErrorEnabled())
        {
            log.error(errorRef);
            log.error(PREFIX + errorMsg);
            log.error(STACK_TRACE, e);
        }
        return errorRef;
    }
    
    /**
     * Log at error level
     * 
     * @param errorMsg
     * @param e
     *            Throwable. The stack trace will be logged
     * @return String the error reference code
     */
    public synchronized String bizError(String errorMsg, Throwable e)
    {
        String errorRef = "" + System.currentTimeMillis();
        
        if(log.isInfoEnabled())
        {
            log.debug(errorRef);
            log.debug(BIZ_ERROR_PREFIX + errorMsg);
            log.debug(STACK_TRACE, e);
        }
        return errorRef;
    }

    
    /**
     * Log at info level
     * 
     * @param infoMsg
     */
    public synchronized void info(String infoMsg)
    {
        if (log.isInfoEnabled())
        {
            log.info(PREFIX + infoMsg);
        }
    }
    /**
     * Log at TRACE level. Entry of every method should call this method
     * 
     * @param traceMsg
     */
    public void trace(String traceMsg)
    {
    	if(log.isTraceEnabled())
    		log.trace(TRACE_PREFIX + traceMsg);
    }

    
    
    
    /**
     * Log the performance at INFO level. Entry and exit timing of every layer, sub-system or third party system. 
     * @param performanceMsg
     * @param start
     * @param end
     */
    public void performance(String performanceMsg, long start, long end)
    {
        if (log.isInfoEnabled())
        {
            log.info(PERFORMANCE_PREFIX + performanceMsg + " duration[" + (end - start) + " ms]");
        }
    }

    /**
     * Log the input to third party system or input from third party system. 
     * This is to use in the interface programs. 
     * @param data
     */
    public void input(String data)
    {
        if (log.isInfoEnabled())
        {
            log.info(INTERFACE_PREFIX + " input: " + data);
        }
    }

    /**
     * Log the output to third party system or output to third party system.
     * This is to use in the interface programs.
     * @param data
     */
    public void output(String data)
    {
        if (log.isInfoEnabled())
        {
            log.info(INTERFACE_PREFIX + " output: " + data);
        }
    }

    /**
     * Log at WARN level
     * 
     * @param warnMsg
     */
    public void warn(String warnMsg)
    {
            log.warn(PREFIX + warnMsg);
    }
}
