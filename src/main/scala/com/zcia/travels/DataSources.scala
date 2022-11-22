package com.zcia.travels

import org.apache.spark.sql.{SparkSession, DataFrame, Dataset, Encoder, Encoders}
import java.sql.Date
import com.zcia.travels.{Flight, Hotel, User}
import org.apache.spark.sql.types.StructType
import scala.reflect.api.TypeTags
import scala.reflect.runtime.universe.TypeTag

trait DataSources {
  final val DATE_FORMAT: String = "MM/dd/yyyy"

  implicit val fligthsPath: String
  implicit val hotelsPath: String
  implicit val usersPath: String

  implicit val spark: SparkSession
  import spark.implicits._

  protected def loadDatasetFromCsv[T <: Product: TypeTag](path: String): Dataset[T] = {
    val schema: StructType = Encoders.product[T].schema
    val ds: Dataset[T] = spark.read
      .schema(schema)
      .option("header", "true")
      .option("dateFormat", DATE_FORMAT)
      .csv(path)
      .as[T]
    ds
  }

  def fligths: Dataset[Flight] = loadDatasetFromCsv(path = fligthsPath)
  def hotels: Dataset[Hotel]   = loadDatasetFromCsv(path = hotelsPath)
  def users: Dataset[User]     = loadDatasetFromCsv(path = usersPath)
}
