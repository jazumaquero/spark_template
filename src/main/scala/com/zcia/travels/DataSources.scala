package com.zcia.travels

import org.apache.spark.sql.{SparkSession, DataFrame, Dataset, Encoder, Encoders}
import java.sql.Date
import com.zcia.travels.{Flight, Hotel, User}
import org.apache.spark.sql.types.StructType
import scala.reflect.api.TypeTags
import scala.reflect.runtime.universe.TypeTag

trait DataSources {
  implicit val spark: SparkSession
  import spark.implicits._

  protected val dateFormat: String = "MM/dd/yyyy"

  protected def loadDatasetFromCsv[T <: Product: TypeTag](path: String): Dataset[T] = {
    val schema: StructType = Encoders.product[T].schema
    val ds: Dataset[T] = spark.read
      .schema(schema)
      .option("header", "true")
      .option("dateFormat", dateFormat)
      .csv(path)
      .as[T]
    ds
  }

  def fligths(path: String): Dataset[Flight] = loadDatasetFromCsv(path = path)
  def hotels(path: String): Dataset[Hotel]   = loadDatasetFromCsv(path = path)
  def users(path: String): Dataset[User]     = loadDatasetFromCsv(path = path)
}
