package sample
package snippet

import net.liftweb.common.Logger
import net.liftweb.util.BindHelpers._
import net.liftweb.http._
import net.liftweb.http.js.JsCmds._

import actor._

import akka.pattern.ask
import akka.dispatch.Await
import akka.util.Timeout
import akka.util.duration._

class HelloWorldRemote extends Logger {
  def hello =
    "#button [onclick]" #> SHtml.ajaxInvoke(() => doHelloWorld)

  private def doHelloWorld = {
    implicit val timeout = Timeout(5 seconds)
    val future = HelloWorldActorCaller.remoteActor ? "'Lift snippet'"
    val msg = Await.result[String](
      future.mapTo[String], 5 seconds)

    SetHtml("message", successMsg(msg))
  }
}