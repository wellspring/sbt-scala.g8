resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "spray repo" at "http://repo.spray.io"

addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.1")

addSbtPlugin("com.orrsella" % "sbt-sublime" % "1.0.5")

addSbtPlugin("com.orrsella" % "sbt-stats" % "1.0.2")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.9.1")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.3.2")

addSbtPlugin("com.mojolly.scalate" % "xsbt-scalate-generator" % "0.4.2")

addSbtPlugin("com.typesafe.startscript" % "xsbt-start-script-plugin" % "0.5.3")