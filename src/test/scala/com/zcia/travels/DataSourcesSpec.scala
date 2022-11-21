package com.zcia.travels

import com.zcia.SparkSessionSuite
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import com.zcia.travels.DataSources
import com.zcia.travels.TravelResourcesFixtures

class DataSourcesSpec extends AnyFlatSpec with Matchers with SparkSessionSuite with DataSources with TravelResourcesFixtures {
    val FLIGTHS_COUNT: Integer= 271888
    val HOTELS_COUNT: Integer= 40552
    val USERS_COUNT: Integer= 1340   

    "Fligths data source" should f"must include $FLIGTHS_COUNT rows" in {               
        this.fligths.count shouldEqual FLIGTHS_COUNT
    }
    "Hotesls data source" should f"must include $HOTELS_COUNT rows" in {               
        this.hotels.count shouldEqual HOTELS_COUNT
    }
    "Users data source" should f"must include $USERS_COUNT rows" in {               
        this.users.count shouldEqual USERS_COUNT
    }
}
