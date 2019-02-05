package com.wp.site.config;

import java.io.IOException;
import java.util.Properties;

public class WebsiteConfiguration {
	
	private Properties siteProperties;

	public WebsiteConfiguration() throws IOException {
		initProperties();
	}
	
	private void initProperties() throws IOException {
		siteProperties = new Properties();
		siteProperties.load(WebsiteConfiguration.class.getResourceAsStream("/website.properties"));
	}
	
	public String get(String key) {
		return (String)this.getSiteProperties().get(key);
	}
	
	public Properties getSiteProperties() {
		return siteProperties;
	}
	
}
