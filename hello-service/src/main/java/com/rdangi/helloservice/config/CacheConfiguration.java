package com.rdangi.helloservice.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Profile;

/**
 * Cache configuration. This is only enabled while running on docker
 */
@Profile("docker")
@EnableCaching
public class CacheConfiguration {

}
