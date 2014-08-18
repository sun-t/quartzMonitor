package com.sundoctor.quartz.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.quartz.CronExpression;

public interface SchedulerService {
	/**
	 * ���� Quartz Cron Expression ��������
	 * @param cronExpression  Quartz Cron ���ʽ���� "0/10 * * ? * * *"��
	 */
	//void schedule(String cronExpression);
	
	/**
	 * ���� Quartz Cron Expression ��������
	 * @param name  Quartz CronTrigger����
	 * @param cronExpression Quartz Cron ���ʽ���� "0/10 * * ? * * *"��
	 */
	//void schedule(String name,String cronExpression);
	
	/**
	 * ���� Quartz Cron Expression ��������
	 * @param name  Quartz CronTrigger����
	 * @param cronExpression Quartz Cron ���ʽ���� "0/10 * * ? * * *"��
	   * @param group Quartz CronExpression Group
	 */
	 //void schedule(String name, String cronExpression,String group);
	
	/**
	 * ���� Quartz Cron Expression ��������
	 * @param cronExpression Quartz CronExpression
	 */
	//void schedule(CronExpression cronExpression);
	
	/**
	 * ���� Quartz Cron Expression ��������
	 * @param name Quartz CronTrigger����
	 * @param cronExpression Quartz CronExpression
	 */
	//void schedule(String name,CronExpression cronExpression);
	
	/**
	 * ���� Quartz Cron Expression ��������
	 * @param name Quartz CronTrigger����
	 * @param cronExpression Quartz CronExpression
	   * @param group Quartz CronExpression Group
	 */
	//void schedule(String name, CronExpression cronExpression,String group);
	
	/**
	 * ��startTimeʱִ�е���һ��
	 * @param startTime ���ȿ�ʼʱ��
	 */
	void schedule(Date startTime);	
	
	/**
	 * ��startTimeʱִ�е���һ��
	 * @param startTime ���ȿ�ʼʱ��
	  * @param group Quartz SimpleTrigger Group
	 */
	void schedule(Date startTime,String group);
	
	/**
	 * ��startTimeʱִ�е���һ��
	 * @param name Quartz SimpleTrigger ����
	 * @param startTime ���ȿ�ʼʱ��
	 */
	void schedule(String name,Date startTime);
	
	/**
	 * ��startTimeʱִ�е���һ��
	 * @param name Quartz SimpleTrigger ����
	 * @param startTime ���ȿ�ʼʱ��
	  * @param group Quartz SimpleTrigger Group
	 */
	void schedule(String name, Date startTime,String group);
	
	/**
	 * ��startTimeʱִ�е��ԣ�endTime����ִ�е���
	 * @param startTime ���ȿ�ʼʱ��
	 * @param endTime ���Ƚ���ʱ��
	 */
	void schedule(Date startTime,Date endTime);	

	/**
	 * ��startTimeʱִ�е��ԣ�endTime����ִ�е���
	 * @param startTime ���ȿ�ʼʱ��
	 * @param endTime ���Ƚ���ʱ��
	 * @param group Quartz SimpleTrigger Group
	 */
	void schedule(Date startTime, Date endTime,String group) ;
	
	/**
	 * ��startTimeʱִ�е��ԣ�endTime����ִ�е���
	 * @param name Quartz SimpleTrigger ����
	 * @param startTime ���ȿ�ʼʱ��
	 * @param endTime ���Ƚ���ʱ��
	 */
	void schedule(String name,Date startTime,Date endTime);
	
	/**
	 * ��startTimeʱִ�е��ԣ�endTime����ִ�е���
	 * @param name Quartz SimpleTrigger ����
	 * @param startTime ���ȿ�ʼʱ��
	 * @param endTime ���Ƚ���ʱ��
	 * @param group Quartz SimpleTrigger Group
	 */
	void schedule(String name, Date startTime, Date endTime,String group) ;
	
	/**
	 * ��startTimeʱִ�е��ԣ�endTime����ִ�е��ȣ��ظ�ִ��repeatCount��
	 * @param startTime ���ȿ�ʼʱ��
	 * @param endTime ���Ƚ���ʱ��
	 * @param repeatCount �ظ�ִ�д���
	 */
	void schedule(Date startTime,Date endTime,int repeatCount);	
	
	/**
	 * ��startTimeʱִ�е��ԣ�endTime����ִ�е��ȣ��ظ�ִ��repeatCount��
	 * @param startTime ���ȿ�ʼʱ��
	 * @param endTime ���Ƚ���ʱ��
	 * @param repeatCount �ظ�ִ�д���
	 * @param group Quartz SimpleTrigger Group
	 */
	void schedule(Date startTime, Date endTime, int repeatCount,String group);
	
	/**
	 * ��startTimeʱִ�е��ԣ�endTime����ִ�е��ȣ��ظ�ִ��repeatCount��
	 * @param name Quartz SimpleTrigger ����
	 * @param startTime ���ȿ�ʼʱ��
	 * @param endTime ���Ƚ���ʱ��
	 * @param repeatCount �ظ�ִ�д���
	 */
	void schedule(String name,Date startTime,Date endTime,int repeatCount);
	
	/**
	 * ��startTimeʱִ�е��ԣ�endTime����ִ�е��ȣ��ظ�ִ��repeatCount��
	 * @param name Quartz SimpleTrigger ����
	 * @param startTime ���ȿ�ʼʱ��
	 * @param endTime ���Ƚ���ʱ��
	 * @param repeatCount �ظ�ִ�д���
	 * @param group Quartz SimpleTrigger Group
	 */
	void schedule(String name, Date startTime, Date endTime, int repeatCount,String group);
	
	/**
	 * ��startTimeʱִ�е��ԣ�endTime����ִ�е��ȣ��ظ�ִ��repeatCount�Σ�ÿ��repeatInterval��ִ��һ��
	 * @param startTime ���ȿ�ʼʱ��
	 * @param endTime ���Ƚ���ʱ��
	 * @param repeatCount �ظ�ִ�д���
	 * @param repeatInterval ִ��ʱ�����
	 */
	void schedule(Date startTime,Date endTime,int repeatCount,long repeatInterval) ;
	
	/**
	 * ��startTimeʱִ�е��ԣ�endTime����ִ�е��ȣ��ظ�ִ��repeatCount�Σ�ÿ��repeatInterval��ִ��һ��
	 * @param startTime ���ȿ�ʼʱ��
	 * @param endTime ���Ƚ���ʱ��
	 * @param repeatCount �ظ�ִ�д���
	 * @param repeatInterval ִ��ʱ�����
	 *  @param group Quartz SimpleTrigger Group
	 */
	void schedule(Date startTime, Date endTime, int repeatCount, long repeatInterval,String group);
	
	/**
	 * ��startTimeʱִ�е��ԣ�endTime����ִ�е��ȣ��ظ�ִ��repeatCount�Σ�ÿ��repeatInterval��ִ��һ��
	 * @param name Quartz SimpleTrigger ����
	 * @param startTime ���ȿ�ʼʱ��
	 * @param endTime ���Ƚ���ʱ��
	 * @param repeatCount �ظ�ִ�д���
	 * @param repeatInterval ִ��ʱ�����
	 */
	void schedule(String name,Date startTime,Date endTime,int repeatCount,long repeatInterval);
	
	/**
	 * ��startTimeʱִ�е��ԣ�endTime����ִ�е��ȣ��ظ�ִ��repeatCount�Σ�ÿ��repeatInterval��ִ��һ��
	 * @param name Quartz SimpleTrigger ����
	 * @param startTime ���ȿ�ʼʱ��
	 * @param endTime ���Ƚ���ʱ��
	 * @param repeatCount �ظ�ִ�д���
	 * @param repeatInterval ִ��ʱ�����
	 *  @param group Quartz SimpleTrigger Group
	 */
	void schedule(String name ,Date startTime, Date endTime, int repeatCount, long repeatInterval, String group);
	
	/**
	 * Trigger ����,��com.sundoctor.example.Constant����Ϊ����װ��Map
	 * @param map
	 */
	void schedule(Map<String,String> map) ;
	
	/**
	 * ȡ�����е���Triggers
	 * @return
	 */
	List<Map<String, Object>> getQrtzTriggers();
	
	/**
	 * �������ƺ������ͣTigger
	 * @param triggerName
	 * @param group
	 */
	void pauseTrigger(String triggerName,String group);
	
	/**
	 * �ָ�Trigger
	 * @param triggerName
	 * @param group
	 */
	void resumeTrigger(String triggerName,String group);
	
	/**
	 * ɾ��Trigger
	 * @param triggerName
	 * @param group
	 */
	boolean removeTrigdger(String triggerName,String group);
}
