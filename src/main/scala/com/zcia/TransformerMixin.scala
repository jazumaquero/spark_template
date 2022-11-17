package com.zcia

import org.apache.spark.sql.DataFrame

trait TransformerMixin {
  def transform(df: DataFrame) : DataFrame
}
