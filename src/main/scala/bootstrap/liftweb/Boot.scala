package bootstrap.liftweb

import net.liftweb.common._
import net.liftweb.http._

class Boot extends LazyLoggable {

  def boot {
    LiftRules.addToPackages("sample")
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))

    SiteMapConfig.initFromBoot
    ActorConfig.initFromBoot
  }
}