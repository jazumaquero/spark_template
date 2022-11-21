package com.zcia

import org.scalatest.{SuiteMixin, Suite}
import org.apache.spark.sql.SparkSession

trait SparkSessionSuite extends SuiteMixin { this: Suite =>
  def spark: SparkSession=  SparkSession
    .builder()
    .appName(this.getClass().getCanonicalName())
    .master("local[*]")
    .getOrCreate()
}
