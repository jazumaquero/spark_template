package com.zcia

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.apache.spark.sql.{SparkSession, DataFrame}
import com.zcia.SparkSessionSuite

class TransformerExampleSpec extends AnyFlatSpec with Matchers with SparkSessionSuite {

  "Spark session fixture" should "run in local mode" in {
    spark.close()
  }

}
