package bootstrap.liftweb

import net.liftweb.http._
import net.liftweb.sitemap._

object SiteMapConfig {
  def initFromBoot {
    LiftRules.setSiteMap(
      SiteMap(
        Menu("hello") / "hello_sync",
        Menu("hello comet") / "hello_comet",
        Menu("hello remote") / "hello_remote"
      ))
  }
}