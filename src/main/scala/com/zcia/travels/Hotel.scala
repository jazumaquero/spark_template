package com.zcia.travels

import java.sql.Date

final case class Hotel(
    travelCode: Long,
    userCode: Long,
    name: String,
    place: String,
    days: Integer,
    price: Double,
    total: Double,
    date: Date
)
