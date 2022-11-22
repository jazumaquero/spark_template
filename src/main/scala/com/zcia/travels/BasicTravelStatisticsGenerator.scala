package com.zcia.travels

import org.apache.spark.sql.{DataFrame, Dataset}
import org.apache.spark.sql.functions.{avg, collect_set, count, lit, min, max}
import com.zcia.travels.{Flight, Hotel, User}

trait BasicTravelStatisticsGenerator {
  implicit def fligths: Dataset[Flight]
  implicit def hotels: Dataset[Hotel]
  implicit def users: Dataset[User]

  def fligthsByUser: DataFrame = {
    val aggregatedFligthsByUser = fligths
      .groupBy("userCode")
      .agg(
        count(lit(1)).alias("num_fligths"),
        min("price").alias("min_price"),
        avg("price").alias("mean_price"),
        max("price").alias("max_price"),
        min("time").alias("min_time"),
        avg("time").alias("mean_time"),
        max("time").alias("max_time"),
        min("distance").alias("min_distance"),
        avg("distance").alias("mean_distance"),
        max("distance").alias("max_distance"),
        collect_set("from").alias("sources"),
        collect_set("to").alias("destinations"),
        collect_set("agency").alias("agencies")
      )
    // Fix join issues due to ambigous column naming issue raised on following tickets
    // https://issues.apache.org/jira/browse/SPARK-10925
    // https://issues.apache.org/jira/browse/SPARK-14948
    val rightDF = aggregatedFligthsByUser.toDF
    val leftDF  = users.toDF
    leftDF.join(rightDF, leftDF.col("code") === rightDF.col("userCode")).drop("userCode")
  }
  def hotelsByUser: DataFrame = {
    val aggregatedHotelsByUser = hotels
      .groupBy("userCode")
      .agg(
        count(lit(1)).alias("num_visits"),
        min("price").alias("min_price"),
        avg("price").alias("mean_price"),
        max("price").alias("max_price"),
        min("days").alias("min_days"),
        avg("days").alias("mean_days"),
        max("days").alias("max_days"),
        min("total").alias("min_total"),
        avg("total").alias("mean_total"),
        max("total").alias("max_total"),
        min("date").alias("min_date"),
        max("date").alias("max_date"),
        collect_set("place").alias("places")
      )
    // Fix join issues due to ambigous column naming issue raised on following tickets
    // https://issues.apache.org/jira/browse/SPARK-10925
    // https://issues.apache.org/jira/browse/SPARK-14948
    val rightDF = aggregatedHotelsByUser.toDF
    val leftDF  = users.toDF
    leftDF
      .join(
        rightDF,
        leftDF.col("code") === rightDF.col("userCode")
      )
      .drop("userCode")
  }
}
