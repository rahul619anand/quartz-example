package com.test.quartz

import java.util.UUID

import com.typesafe.scalalogging.{LazyLogging, Logger}
import org.quartz.{Job, JobExecutionContext}

/**
  * Created by ranand on 5/15/2017 AD.
  */
class MyJob1 extends Job with LazyLogging {
  override lazy val logger = Logger(classOf[MyJob1])
  override def execute(jobExecutionContext: JobExecutionContext) = {
    logger.info ("Job 1 %%%%%%%%%%%%%%%%%%  " + UUID.randomUUID());
  }
}
