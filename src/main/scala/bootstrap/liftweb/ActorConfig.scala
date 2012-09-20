package bootstrap.liftweb

import akka.actor._
import net.liftweb.http.LiftRules

import sample.actor._

object ActorConfig {
  def initFromBoot {
    val system = ActorSystem("Sample")
    val actor = system.actorOf(
      Props(
        new HelloWorldActor),
      name = "hello-service")
    actor ! Start

//    remote.start("localhost", 2552)
//1    remote.register("hello-service", actorOf[HelloWorldActor])

    LiftRules.unloadHooks.append(() => {
      actor ! Stop
      system.shutdown
    })

    /**
    Supervisor(
      SupervisorConfig(
        OneForOneStrategy(List(classOf[Throwable]), 3, 1000),
        Supervise(
          actorOf[sample.actor.IntTransformer],
          Permanent,
          true) ::
        Supervise(
          actorOf[sample.comet.Calculator],
          Permanent) ::
        Nil))*/
  }
}