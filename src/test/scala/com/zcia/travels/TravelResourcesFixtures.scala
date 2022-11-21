package com.zcia.travels

trait TravelResourcesFixtures {
    protected def testResourcePath(resource: String) : String = getClass.getResource(f"/traveldataset/$resource").toString

    val fligthsPath : String = testResourcePath("fligths")
    val hotelsPath : String = testResourcePath("hotels")
    val usersPath : String = testResourcePath("users")
}
