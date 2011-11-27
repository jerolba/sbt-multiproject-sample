import sbt._
import Keys._

object MultiProjectSampleBuild extends Build {

	lazy val buildSettings = Defaults.defaultSettings ++ Seq(
        organization := "com.funius",
        version := "0.1.0-SNAPSHOT",
        scalaVersion := "2.9.1"
    )

    lazy val root = Project(
            id = "multiproject-sample", 
            base = file("."), 
            settings = buildSettings ++ Seq(
            			description := "Example of a multiproject app. Root project"
            		),
    		aggregate =Seq(sample_core, sample_db)
    	 )

    lazy val sample_core = Project(
            id = "sample-core", 
            base = file("sample-core"),
            settings = buildSettings ++ Seq(
            			description := "Example of a multiproject app. Core project"
            		)
         )

    lazy val sample_db = Project(
            id = "sample-db", 
            base = file("sample-db"), 
            settings = buildSettings ++ Seq(
            			description := "Example of a multiproject app. Dependent project"
            		)
         ) dependsOn(sample_core)

         
}