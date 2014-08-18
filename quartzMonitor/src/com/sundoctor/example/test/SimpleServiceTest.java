package com.sundoctor.example.test;

import java.util.Date;

import javax.annotation.Resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sundoctor.quartz.service.SchedulerService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml",
		"classpath:spring/applicationContext-quartz.xml"}) 

public class SimpleServiceTest {

	@Resource
	private SchedulerService schedulerService;

	public void setSchedulerService(SchedulerService schedulerService) {
		this.schedulerService = schedulerService;
	}
	
	@Test
	public void test(){
		//ִ��ҵ���߼�...
		
		//���ø߶�����
		//ÿ10����ִ�е���һ��
		//schedulerService.schedule("0/10 * * ? * * *"); 
		
		Date startTime = this.parse("2009-06-01 21:50:00");
		Date endTime =  this.parse("2009-06-01 21:55:00");
        
		//2009-06-01 21:50:00��ʼִ�е���
		schedulerService.schedule(startTime);

		//2009-06-01 21:50:00��ʼִ�е��ȣ�2009-06-01 21:55:00����ִ�е���
		schedulerService.schedule(startTime,endTime);
		
		//2009-06-01 21:50:00��ʼִ�е��ȣ�ִ��5�ν���
		schedulerService.schedule(startTime,null,5);

		//2009-06-01 21:50:00��ʼִ�е��ȣ�ÿ��20��ִ��һ�Σ�ִ��5�ν���
		schedulerService.schedule(startTime,null,5,20);
		
		//�ȵȣ��鿴com.sundoctor.quartz.service.SchedulerService
	}
	
	private Date parse(String dateStr){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return format.parse(dateStr);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
