package com.lyg.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 基于注解使用定时任务，基于注解的定时器
 * @author Administrator
 *
 */
@Component
public class MyTask2 {
	
	/**
	 * Cron表达式是一个字符串，字符串以5或6个空格隔开，分为6或7个域，每一个域代表一个含义，Cron有如下两种语法格式：
		•Seconds Minutes Hours DayofMonth Month DayofWeek Year
		•Seconds Minutes Hours DayofMonth Month DayofWeek
     *  依次表示  ： 秒    分钟    小时     天     月份     星期（1表示星期天，2表示星期一）  年
	 */
	
	/**
	 *定时， 每天凌晨 01:00 执行一次
	 */
	@Scheduled(cron = "0 00 1 * * *")
	public void show(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(new Date())+"调用了show()方法");
	}
	
	/**
	 * 启动时执行一次，之后每隔60秒执行一次
	 */
/*	
	@Scheduled(fixedRate = 1000*60)
	public void print(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(new Date())+"执行了print()方法");
	}*/
	
	
	

}
