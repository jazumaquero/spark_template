package com.zcia.travels

import com.zcia.SparkSessionSuite
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import com.zcia.travels.DataSources


class DataSourcesSpec extends AnyFlatSpec with Matchers with SparkSessionSuite with DataSources {
    protected def testResourcePath(resource: String) : String = getClass.getResource(f"/traveldataset/$resource").toString
    
    val fligthsPath : String = testResourcePath("fligths")
    val hotelsPath : String = testResourcePath("hotels")
    val usersPath : String = testResourcePath("users")
    
    val fligthsCount: Integer= 271888
    val hotelsCount: Integer= 40552
    val usersCount: Integer= 1340   

    "Fligths data source" should f"must include $fligthsCount rows" in {               
        this.fligths.count shouldEqual fligthsCount
    }
    "Hotesls data source" should f"must include $hotelsCount rows" in {               
        this.hotels.count shouldEqual hotelsCount
    }
    "Users data source" should f"must include $usersCount rows" in {               
        this.users.count shouldEqual usersCount
    }
}
