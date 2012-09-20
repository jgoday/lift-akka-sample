package sample
package object snippet {
  import scala.xml.NodeSeq
  import net.liftweb.http.Templates
  import net.liftweb.util.BindHelpers._

  def successMsg(value: String): NodeSeq = {
    def render = "span *" #> value
    val template =
      Templates("templates-hidden" :: "success_message" :: Nil) openOr <p/>

    render(template)
  }
}