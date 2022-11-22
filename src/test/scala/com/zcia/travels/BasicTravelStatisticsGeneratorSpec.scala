package com.zcia.travels

import com.zcia.SparkSessionSuite
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import com.zcia.travels.BasicTravelStatisticsGenerator
import com.zcia.travels.TravelResourcesFixtures

class BasicTravelStatisticsGeneratorSpec extends AnyFlatSpec with Matchers with SparkSessionSuite with DataSources with TravelResourcesFixtures with BasicTravelStatisticsGenerator {
    "Fligths by user statistics" should "must run" in {               
        this.fligthsByUser.count >0
    }  
}
