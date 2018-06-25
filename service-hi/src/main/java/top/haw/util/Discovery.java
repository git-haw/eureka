package top.haw.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by haw on 18-6-23.
 */
@Component
public class Discovery {
    @Autowired
    private DiscoveryClient discoveryClient;

    public String serviceUrl(String applicationName){
        List<ServiceInstance> list = discoveryClient.getInstances(applicationName);
        ServiceInstance serviceInstance = null;
        if (list != null && list.size() > 0 ) {
            serviceInstance = list.get(0);
        }
        return serviceInstance.getUri().toString();
    }
}
