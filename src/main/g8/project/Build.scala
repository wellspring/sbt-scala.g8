import sbt._
import Keys._
import com.typesafe.startscript.StartScriptPlugin
import classpath.ClasspathUtilities.isArchive
import org.scalastyle.sbt.ScalastylePlugin
import spray.revolver.RevolverPlugin._
import java.io.FileOutputStream
import sbtassembly.Plugin._
import AssemblyKeys._

object $name;format="Camel"$Build extends Build {

  lazy val $name;format="camel"$ = Project(
    id = "$name;format="lower,hyphen"$",
    base = file("."),
    settings = Project.defaultSettings ++
               Revolver.settings ++
               assemblySettings ++
               ScalastylePlugin.Settings ++
               StartScriptPlugin.startScriptForJarSettings ++
    Seq(
      name := "$name$",
      organization := "$organization$",
      version := "$version$",
      scalaVersion := "$scala_version$",
      fork in test := true,
      //scalacOptions ++= Seq("-encoding", "UTF-8", "-Xlint","-deprecation", "-unchecked", "-feature"),
      //javacOptions ++= Seq("-source","1.7","-target","1.7", "-encoding", "UTF-8")
      //crossScalaVersions := Seq("2.8.0", "2.8.1", "2.9.0", "2.9.1", "2.9.2"),
      //calacOptions ++= Seq("-unchecked", "-deprecation"),
      //unmanagedBase <<= baseDirectory / "modules",
      //unmanagedJars <<= baseDirectory map { base => (base / "modules" ** "*.jar").classpath },
      resourceDirectory in Compile <<= baseDirectory(_ / "config"), // or unmanagedResourceDirectories?
      scalaSource in Compile <<= baseDirectory(_ / "src"), // or unmanagedSourceDirectories?
      scalaSource in Test <<= baseDirectory(_ / "test"),
      target <<= baseDirectory / "project/build",
      resolvers ++= Seq(
        "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases",
        "Typesafe Snapshots" at "http://repo.typesafe.com/typesafe/snapshots",
        "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases",
        "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
        //"jBCrypt Repository" at "http://repo1.maven.org/maven2/org",
        //"jGit Repository" at "http://download.eclipse.org/jgit/maven",
        //"repository.jboss.org" at "https://repository.jboss.org/nexus/content/repositories/releases/",
        //"spray repo" at "http://repo.spray.cc",
        "Java.net Maven2 Repository" at "http://download.java.net/maven/2",
        "Local Ivy2 Repository" at "file://" + Path.userHome + "/.ivy2/local",
        "Local Maven Repository" at "file://" + Path.userHome + "/.m2/repository"
      ),
      libraryDependencies ++= {
        val akkaVersion = "2.2.0"
        val liftVersion = "2.5"
        val slickVersion = "1.0.0"
        val scalateVersion = "1.6.1"
        val scalatraVersion = "2.2.1"
        Seq(
        //"ch.qos.logback"          %  "logback-classic"              % "1.0.13"            % "runtime",
        //"org.slf4j"               %  "slf4j-nop"                    % "1.7.5",                      // disable logging
        //"org.scalatest"           %% "scalatest"                    % "1.9.1"             % "test", // 2.0 soon
        //"org.mockito"             %  "mockito-all"                  % "1.9.5"             % "test",
        //"org.specs2"              %% "specs2"                       % "2.1.1"             % "test",
        //"org.scalacheck"          %% "scalacheck"                   % "1.10.1"            % "test",
        //"junit"                   %  "junit"                        % "4.11"              % "test",
        //"com.novocode"            %  "junit-interface"              % "0.10"              % "test",
        //"com.typesafe"            %  "config"                       % "1.0.2",
        //"com.typesafe.akka"       %% "akka-actor"                   % akkaVersion,
        //"com.typesafe.akka"       %% "akka-agent"                   % akkaVersion,
        //"com.typesafe.akka"       %% "akka-camel"                   % akkaVersion,
        //"com.typesafe.akka"       %% "akka-cluster"                 % akkaVersion,
        //"com.typesafe.akka"       %% "akka-dataflow"                % akkaVersion,
        //"com.typesafe.akka"       %% "akka-file-mailbox"            % akkaVersion,
        //"com.typesafe.akka"       %% "akka-kernel"                  % akkaVersion,
        //"com.typesafe.akka"       %% "akka-mailboxes-common"        % akkaVersion,
        //"com.typesafe.akka"       %% "akka-osgi"                    % akkaVersion,
        //"com.typesafe.akka"       %% "akka-osgi-aries"              % akkaVersion,
        //"com.typesafe.akka"       %% "akka-remote"                  % akkaVersion,
        //"com.typesafe.akka"       %% "akka-slf4j"                   % akkaVersion,
        //"com.typesafe.akka"       %% "akka-testkit"                 % akkaVersion,
        //"com.typesafe.akka"       %% "akka-transactor"              % akkaVersion,
        //"com.typesafe.akka"       %% "akka-zeromq"                  % akkaVersion,
        //"com.typesafe.akka"       %% "akka-contrib"                 % akkaVersion,
        //"com.ning"                %  "async-http-client"            % "1.7.19",
        //"net.databinder.dispatch" %% "dispatch-core"                % "0.11.0", // scala wrapper for async-http-client
        //"io.netty"                %  "netty-all"                    % "4.0.7.Final",
        //"org.eclipse.jetty"       %  "jetty-webapp"                 % "9.0.5.v20130815",
        //"de.matrixweb.ne"         %  "native-engine"                % "0.4.0", // V8 for java
        //"net.liftweb"             %% "lift-json"                    % liftVersion,
        //"net.liftweb"             %% "lift-json-ext"                % liftVersion,
        //"net.liftweb"             %% "lift-json-scalaz"             % liftVersion,
        //"net.liftweb"             %% "lift-json-scalaz7"            % liftVersion,
        //"net.liftweb"             %% "lift-common"                  % liftVersion,
        //"net.liftweb"             %% "lift-actor"                   % liftVersion,
        //"net.liftweb"             %% "lift-db"                      % liftVersion,
        //"net.liftweb"             %% "lift-jpa"                     % liftVersion,
        //"net.liftweb"             %% "lift-ldap"                    % liftVersion,
        //"net.liftweb"             %% "lift-mapper"                  % liftVersion,
        //"net.liftweb"             %% "lift-mongodb"                 % liftVersion,
        //"net.liftweb"             %% "lift-mongodb-record"          % liftVersion,
        //"net.liftweb"             %% "lift-squeryl-record"          % liftVersion,
        //"net.liftweb"             %% "lift-record"                  % liftVersion,
        //"net.liftweb"             %% "lift-proto"                   % liftVersion,
        //"net.liftweb"             %% "lift-webkit"                  % liftVersion,
        //"net.liftweb"             %% "lift-wizard"                  % liftVersion,
        //"net.liftweb"             %% "lift-util"                    % liftVersion,
        //"net.liftweb"             %% "lift-testkit"                 % liftVersion,
        //"org.mashupbots.socko"    %% "socko-webserver"              % "0.3.0-SNAPSHOT",
        //"org.reactivemongo"       %% "reactivemongo"                % "0.9",
        //"com.foursquare"          %% "rogue-field"                  % "2.2.0" intransitive(),
        //"com.foursquare"          %% "rogue-core"                   % "2.2.0" intransitive(),
        //"com.foursquare"          %% "rogue-lift"                   % "2.2.0" intransitive(),
        //"com.foursquare"          %% "rogue-index"                  % "2.2.0" intransitive(),
        //"postgresql"              %  "postgresql"                   % "9.1-901.jdbc4",
        //"com.h2database"          %  "h2"                           % "1.3.173",
        //"com.typesafe.slick"      %% "slick"                        % slickVersion,
        //"com.typesafe.slick"      %% "slick-testkit"                % slickVersion        % "test",
        //"com.typesafe.slick"      %% "slick-extensions"             % slickVersion,
        //"com.github.nscala-time"  %% "nscala-time"                  % "0.4.2",
        //"org.quartz-scheduler"    %  "quartz"                       % "2.2.0",
        //"org.mindrot"             %  "jbcrypt"                      % "0.3m",
        //"com.lambdaworks"         %  "scrypt"                       % "1.4.0.XOOM",
        //"org.apache.sshd"         %  "sshd-core"                    % "0.8.0",
        //"org.eclipse.jgit"        %  "org.eclipse.jgit"             % "3.0.0.201306101825-r",
        //"com.novell.ldap"         %  "jldap"                        % "2009-10-07",
        //"commons-codec"           %  "commons-codec"                % "1.8",
        //"org.clapper"             %% "classutil"                    % "1.0.3",
        //"javax.mail"              %  "mail"                         % "1.4.7",
        //"org.apache.commons"      %  "commons-compress"             % "1.5",
        //"org.scalatra"            %% "scalatra"                     % scalatraVersion,
        //"org.scalatra"            %% "scalatra-swagger"             % scalatraVersion,
        //"org.scalatra"            %% "scalatra-scalate"             % scalatraVersion,
        //"org.scalatra"            %% "scalatra-json"                % scalatraVersion,
        //"org.scalatra"            %% "scalatra-specs2"              % scalatraVersion     % "test",
        //"org.scalatra"            %% "scalatra-scalatest"           % scalatraVersion     % "test",
        //"org.fusesource.scalate"  %% "scalate-wikitext"             % scalateVersion,
        //"org.fusesource.scalate"  %% "scalate-page"                 % scalateVersion,
        //"org.fusesource.scalate"  %% "scalate-test"                 % scalateVersion,
        //"com.twitter"             %% "finagle-core"                 % "6.5.2",
        //"org.scalaz"              %% "scalaz-core"                  % "7.0.3"

        /* Lift modules: amqp, aws-sns, extras, facebook, fobo-angularjs, fobo-datatables, fobo-font-awesome,
                         fobo-foundation, fobo-google-code-prettify, fobo-jquery-mobile, fobo-jquery,
                         fobo-knockout, fobo-twbs-bootstrap3, fobo-twitter-bootstrap, fobo, google-analytics,
                         google-maps, imaging, imap-idle, jta, lift-couchdb, lift-jquery-module, machine,
                         mapperauth, mongoauth, oauth-mapper, oauth, omniauth, openid, paypal, restrecord,
                         scalate, textile, twittertypeahead, widgets, xmpp
        */
        )
      }
    )
  )
}
