package com.test.quartz


import org.quartz.impl.StdSchedulerFactory
import org.quartz.{CronScheduleBuilder, JobBuilder, Trigger, TriggerBuilder}

/**
  * Created by ranand on 5/15/2017 AD.
  */
object Main {
  def main(args: Array[String]): Unit = {

    println(" A Hello from quartz !")
    //System.setSecurityManager(new SecurityManager)
    lazy val quartz = new StdSchedulerFactory().getScheduler


    val job1 = JobBuilder.newJob(classOf[MyJob1])
      .withIdentity("Job1", "Group1")
      .build

    val job2 = JobBuilder.newJob(classOf[MyJob2])
      .withIdentity("Job2", "Group1")
      .build

    val trigger1: Trigger = TriggerBuilder
      .newTrigger
      .withIdentity("Trigger1", "Group2")
      .startNow()
      .withSchedule(
        CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
      .build

    val trigger2: Trigger = TriggerBuilder
      .newTrigger
      .withIdentity("Trigger2", "Group2")
      .startNow()
      .withSchedule(
        CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
      .build

    quartz.start
    quartz.scheduleJob(job1, trigger1)
    quartz.scheduleJob(job2, trigger2)


  }
}