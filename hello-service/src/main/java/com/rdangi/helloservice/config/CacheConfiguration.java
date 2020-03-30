package com.rdangi.helloservice.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Profile;

@Profile("docker")
@EnableCaching
public class CacheConfiguration {

}
