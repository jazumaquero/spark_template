package com.zcia.travels

trait TravelResourcesFixtures {
    protected def testResourcePath(resource: String) : String = getClass.getResource(f"/traveldataset/$resource").toString

    final val fligthsPath : String = testResourcePath("fligths")
    final val hotelsPath : String = testResourcePath("hotels")
    final val usersPath : String = testResourcePath("users")
}
