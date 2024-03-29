/*
 * Developed by Mona Fawzy on 4/23/19 9:32 PM
 * Last modified 3/17/19 1:52 AM
 * Copyright (c) CXN Fashion 2019. All rights reserved.
 */

package services

import java.time.{Clock, Instant}
import javax.inject._
import play.api.Logger
import play.api.inject.ApplicationLifecycle
import scala.concurrent.Future

/**
 * This class demonstrates how to run code when the
 * application starts and stops. It starts a timer when the
 * application starts. When the application stops it prints out how
 * long the application was running for.
 *
 * This class is registered for Guice dependency injection in the
 * [[Module]] class. We want the class to start when the application
 * starts, so it is registered as an "eager singleton". See the code
 * in the [[Module]] class to see how this happens.
 *
 * This class needs to run code when the server stops. It uses the
 * application's [[ApplicationLifecycle]] to register a stop hook.
 */
@Singleton
class ApplicationTimer @Inject() (clock: Clock, appLifecycle: ApplicationLifecycle) {

  private val logger = org.slf4j.LoggerFactory.getLogger(classOf[ApplicationTimer])

  // This code is called when the application starts.
  private val start: Instant = clock.instant

  logger.info("ApplicationTimer demo: Starting application at %s".format(start))

  // When the application starts, register a stop hook with the
  // ApplicationLifecycle object. The code inside the stop hook will
  // be run when the application stops.
  appLifecycle.addStopHook { () =>
    val stop: Instant = clock.instant
    val runningTime: Long = stop.getEpochSecond - start.getEpochSecond
    logger.info("ApplicationTimer demo: Stopping application at %s after %s s.".format(clock.instant, runningTime))
    Future.successful(())
  }
}
