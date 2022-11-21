package com.zcia.travels

import com.zcia.SparkSessionSuite
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import com.zcia.travels.DataSources


class DataSourcesSpec extends AnyFlatSpec with Matchers with SparkSessionSuite {    
    protected def testResourcePath(resource: String) : String = getClass.getResource(f"/traveldataset/$resource").toString
    
    protected final val fligthsPath : String = testResourcePath("fligths")
    protected final val hotelsPath : String = testResourcePath("hotels")
    protected final val usersPath : String = testResourcePath("users")
    
    protected final val fligthsCount: Integer= 271888
    protected final val hotelsCount: Integer= 40552
    protected final val usersCount: Integer= 1340
    
    protected val datasources = new DataSources(spark)

    "Fligths data source" should f"must include $fligthsCount rows" in {               
        datasources.fligths(fligthsPath).count shouldEqual fligthsCount
    }
    "Hotesls data source" should f"must include $hotelsCount rows" in {               
        datasources.hotels(hotelsPath).count shouldEqual hotelsCount
    }
    "Users data source" should f"must include $usersCount rows" in {               
        datasources.users(usersPath).count shouldEqual usersCount
    }
}
