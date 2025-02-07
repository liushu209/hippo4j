/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.hippo4j.adapter.web.jetty;

import cn.hippo4j.adapter.web.DefaultAbstractWebThreadPoolService;
import cn.hippo4j.adapter.web.IWebThreadPoolHandlerSupport;
import cn.hippo4j.common.constant.ChangeThreadPoolConstants;
import cn.hippo4j.common.enums.WebContainerEnum;
import cn.hippo4j.common.model.ThreadPoolBaseInfo;
import cn.hippo4j.common.model.ThreadPoolParameter;
import cn.hippo4j.common.model.ThreadPoolParameterInfo;
import cn.hippo4j.common.model.ThreadPoolRunStateInfo;
import cn.hippo4j.common.toolkit.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.springframework.boot.web.embedded.jetty.JettyWebServer;
import org.springframework.boot.web.server.WebServer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

/**
 * Jetty web thread pool handler.
 */
@Slf4j
public class DefaultJettyWebThreadPoolHandler extends DefaultAbstractWebThreadPoolService
        implements
            JettyWebThreadPoolHandlerAdapt {

    public DefaultJettyWebThreadPoolHandler() {
        super(new JettyWebThreadPoolHandlerSupport());
    }

    /**
     * Get the thread pool object of the current web container based on the WebServer.
     * @param webServer current Web-Server.
     * @return Thread pool executor of the current web container.
     */
    @Override
    protected Executor getWebThreadPoolByServer(WebServer webServer) {
        JettyWebServer jettyWebServer = (JettyWebServer) webServer;
        return jettyWebServer.getServer().getThreadPool();
    }

}
