package com.zcia

import com.typesafe.scalalogging.LazyLogging
import org.apache.spark.sql.SparkSession

object Hello extends Greeting with App with LazyLogging {
  logger.info(greeting)
  val spark: SparkSession = SparkSession
    .builder()
    .appName("Spark SQL Hellos template")
    .getOrCreate()
  spark.stop()
}

trait Greeting {
  lazy val greeting: String = "hello"
}
