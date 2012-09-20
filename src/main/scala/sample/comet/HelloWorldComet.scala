package sample
package comet

import scala.xml.Text
import net.liftweb.util.Helpers._
import net.liftweb.http._
import net.liftweb.http.js.JsCmds._

import actor._
import akka.actor._

import snippet.successMsg

class HelloWorldComet extends AkkaCometActor {
  def render =
    "#button [onclick]" #> SHtml.ajaxInvoke(() => doRequest)

  private def doRequest = {
    HelloWorldActorCaller.actor ! Hello("'Comet Lift Snippet'")
    Noop
  }

  override def lowPriority = {
    case value: String =>
      partialUpdate(
        SetHtml("message", successMsg(value)))
  }
}

trait AkkaCometActor extends CometActor {
  val system = ActorSystem("Sample")

  implicit val akkaProxy: ActorRef =
    system.actorOf(
      Props(new Actor{
        def receive = {
          case a =>
            AkkaCometActor.this ! a
        }
    }))

  override def localShutdown {
    super.localShutdown
    system.stop(akkaProxy)
  }
}