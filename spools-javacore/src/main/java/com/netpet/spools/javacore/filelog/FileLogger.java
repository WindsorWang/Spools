/*
 * Copyright [2016]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netpet.spools.javacore.filelog;

import org.apache.log4j.PropertyConfigurator;
/**
 * Created with IntelliJ IDEA.
 * User: David
 * Date: 14-1-13
 * Time: 下午3:08
 */
public class FileLogger {


    protected static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("com.test");

    static {
        PropertyConfigurator.configure(FileLogger.class.getResource("/config/log/log4j.properties"));
    }

    /**
     *
     * @param message
     */
    public static void debug(Object message){
        if (log.isDebugEnabled()){
            log.debug(message + " - "+getInvokeInfo());
        }
    }

    /**
     *
     * @param message
     */
    public static void warn(Object message){
        if (log.isDebugEnabled()){
            log.warn(message + " - "+getInvokeInfo());
        }
    }

    /**
     *
     * @param message
     */
    public static void info(Object message){
        if (log.isInfoEnabled()){
            log.info(message + " - "+getInvokeInfo());
        }
    }

    /**
     *
     * @param message
     */
    public static void error(Object message){
        log.error(message + " - "+getInvokeInfo());
    }


    /**
     *
     * @return
     */
    private static String getInvokeInfo(){
        Throwable throwable = new Throwable();
        StringBuffer result=new StringBuffer();
        StackTraceElement[]  stackTraceElement=throwable.getStackTrace();
        if(stackTraceElement!=null&&stackTraceElement.length>2) {
            result.append(stackTraceElement[2].getClassName());
            result.append(".");
            result.append(stackTraceElement[2].getMethodName());
            result.append("(");
            result.append(stackTraceElement[2].getLineNumber());
            result.append(")");
        }
        return result.toString();
    }
}
