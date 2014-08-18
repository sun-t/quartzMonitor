package com.sundoctor.example.service;

import org.apache.commons.lang.StringUtils;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyQuartzJobBean extends QuartzJobBean {

	private SimpleService simpleService;

	public void setSimpleService(SimpleService simpleService) {
		this.simpleService = simpleService;
	}

	@Override
	protected void executeInternal(JobExecutionContext jobexecutioncontext) throws JobExecutionException {
		Trigger trigger = jobexecutioncontext.getTrigger();
		JobDataMap  map=jobexecutioncontext.getJobDetail().getJobDataMap();
		String triggerName = trigger.getName();
		String group = trigger.getGroup();
		
		//鏍规嵁Trigger缁勫埆璋冪敤涓嶅悓鐨勪笟鍔￠�杈戞柟娉�
		if (StringUtils.equals(group, Scheduler.DEFAULT_GROUP)) {
			simpleService.testMethod(triggerName, group,map);
		} else {
			simpleService.testMethod2(triggerName, group,map);
		}
	}

}
