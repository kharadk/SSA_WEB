package com.ssa.props;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "app")
@EnableConfigurationProperties

@Data
public class AppProperties {

	private Map<String, String> msg = new HashMap<String, String>();

}
