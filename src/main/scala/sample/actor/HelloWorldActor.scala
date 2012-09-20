package sample
package actor

import net.liftweb.common.Logger

import akka.actor._
import com.typesafe.config.ConfigFactory

case object Start
case object Stop
case class Hello(val name: String)

class HelloWorldActor extends Actor with Logger {
  def receive = {
    case Start =>
      debug("start")
    case Stop =>
      debug("stop")
    case Hello(name) =>
      sender ! "Hi " + name + ", i'm an Akka Actor !"
  }
}

object HelloWorldActorCaller {
  val system = ActorSystem("Sample")
  val remoteSystem = ActorSystem("LookupHelloService",
      ConfigFactory.load.getConfig("remotelookup"))

  def remoteActor =
    remoteSystem.actorFor(
      "akka://HelloService@127.0.1.1:2552/user/hello")

  def actor =
    system.actorOf(Props[HelloWorldActor])
}