package com.zcia

import com.typesafe.scalalogging.LazyLogging
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.lit

object SparkJobExample extends TransformerMixin {
  final val constantColumnName: String   = "foo"
  final val constantColumnValue: Integer = 3
  def transform(df: DataFrame): DataFrame = {
    df.withColumn(constantColumnName, lit(constantColumnValue))
  }
}
