package com.zcia

import com.typesafe.scalalogging.LazyLogging

object Hello extends Greeting with App with LazyLogging {
  logger.info(greeting)
}

trait Greeting {
  lazy val greeting: String = "hello"
}
