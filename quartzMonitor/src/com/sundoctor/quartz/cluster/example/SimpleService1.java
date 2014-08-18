package com.sundoctor.quartz.cluster.example;


import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service("simpleService1")
public class SimpleService1 implements Serializable{
	
	private static final long serialVersionUID = 122323233244334343L;
	private static final Logger logger = LoggerFactory.getLogger(SimpleService1.class);
	
	public void testMethod1(){
		Date lastalivetime=new Date();
		logger.info("testMethod1.......1"+lastalivetime);
	}
	
	public void testMethod2(){
		Date lastalivetime=new Date();
		logger.info("testMethod2.......2"+lastalivetime);	
	}
}
