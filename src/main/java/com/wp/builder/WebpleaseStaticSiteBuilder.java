package com.wp.builder;

import java.io.IOException;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import com.wp.site.config.WebsiteConfiguration;

public class WebpleaseStaticSiteBuilder {
	
	private WebsiteConfiguration config;
	private ClassLoaderTemplateResolver resolver;
	private TemplateEngine engine;

	public WebpleaseStaticSiteBuilder() {
		try {
			config = new WebsiteConfiguration();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Couldn't read configuration!");
			System.exit(1);
		}
	}
	
	private void configureTemplateResolver() {
		resolver = new ClassLoaderTemplateResolver();
		resolver.setTemplateMode("XHTML");
		resolver.setSuffix(".html");
		engine = new TemplateEngine();
		engine.setTemplateResolver(resolver);
	}
	
	public WebsiteConfiguration getConfig() {
		return config;
	}
	
	public static void main(String[] args) {
		WebpleaseStaticSiteBuilder builder = new WebpleaseStaticSiteBuilder();
		System.out.println(builder.getConfig().get("site.live.url")); 
	}

}
