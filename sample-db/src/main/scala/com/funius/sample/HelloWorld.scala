package com.funius.sample
import org.slf4j.impl.SimpleLoggerFactory

object HelloWorld extends App{ 

    val echoResult=new EchoService().echo("jerolba")
    new SimpleLoggerFactory().getLogger("echo").info(echoResult)
    
}