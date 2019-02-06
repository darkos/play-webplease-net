package com.wp.builder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class BuilderTest {
	
	public static void main(String[] args) throws IOException {
		ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
		resolver.setTemplateMode("XHTML");
		resolver.setSuffix(".thyme");
//		resolver.setPrefix("/templates/webplease.net/");
		TemplateEngine engine = new TemplateEngine();
		engine.setTemplateResolver(resolver);
		
		Context context = new Context();
		Map content = new HashMap<String, Object>();
		content.put("title", "WebPlease.net");
		
		context.setVariable("content", content);
		
		StringWriter writer = new StringWriter();
		
		engine.process("index", context, writer);
		System.out.println("StringWriter:---------------------------------------");
		System.out.println(writer.getBuffer().toString());
		System.out.println("StringWriter:---------------------------------------");
		File outputDir = new File("output");
		outputDir.mkdirs();
		System.out.println("FileWriter:---------------------------------------");
		Writer fileWriter = new FileWriter(new File(outputDir, "output.html"));
		engine.process("index", context, fileWriter);
		System.out.println("FileWriter:---------------------------------------");
	}

}
