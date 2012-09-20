package sample
package actor

import akka.actor._
import net.liftweb.common.Logger

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

  def actor =
    system.actorOf(Props[HelloWorldActor])
}