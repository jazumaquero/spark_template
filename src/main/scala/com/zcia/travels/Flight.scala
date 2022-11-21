package com.zcia.travels

import java.sql.Date

final case class Flight(
    travelCode: Long,
    userCode: Long,
    from: String,
    to: String,
    flightType: String,
    price: Double,
    time: Double,
    distance: Double,
    agency: String,
    date: Date
)
