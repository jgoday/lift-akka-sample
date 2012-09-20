package sample
package remote

import akka.kernel.Bootable
import akka.actor.{ Props, Actor, ActorSystem }
import com.typesafe.config.ConfigFactory

class HelloService extends Actor {
  def receive = {
    case str =>
      println("HelloService -> receive message : " + str)
      sender ! "Hi, i'm a remote akka actor !"
  }
}

class HelloServiceApplication extends Bootable {
  //#setup
  val system = ActorSystem(
    "HelloService",
    ConfigFactory.load.getConfig("helloService"))
  val actor = system.actorOf(Props[HelloService], "hello")

  def startup() {
  }

  def shutdown() {
    system.shutdown()
  }
}

object App {
  def main(args: Array[String]) {
    new HelloServiceApplication
    println("Started Calculator Application - waiting for messages")
  }
}
