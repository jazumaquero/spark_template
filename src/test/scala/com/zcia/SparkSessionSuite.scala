package com.zcia

import org.scalatest.{SuiteMixin, Suite}
import org.apache.spark.sql.SparkSession

trait SparkSessionSuite extends SuiteMixin { this: Suite =>
  val spark: SparkSession = SparkSession
    .builder()
    .appName(this.getClass().getCanonicalName())
    .master("local[*]")
    .getOrCreate()

}
