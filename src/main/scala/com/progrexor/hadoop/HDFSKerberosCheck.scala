package com.progrexor.hadoop

import java.net.URI

import scala.collection.JavaConversions._
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.Path
import org.apache.hadoop.hdfs.DistributedFileSystem
import org.apache.hadoop.security.UserGroupInformation

/**
  * Created by andrey on 14/01/2017.
  */
object HDFSKerberosCheck {

  def main(args: Array[String]): Unit = {

    if (args.length < 5) {
      println("\nUsage:\n\tjava -cp <jars> com.progrexor.hadoop.HDFSKerberosCheck " +
        "<core-site.xml> " +
        "<core-hdfs.xml> " +
        "<principal> " +
        "<keytab> " +
        "<hdfs://nodename>")
      System.exit(0)
    }

    val hdfsCoreSite = args(0)
    val hdfsHdfsSite = args(1)
    val principal = args(2)
    val keytab = args(3)
    val nodename = args(4)

    val conf = new Configuration()
    conf.addResource(new Path(hdfsCoreSite))
    conf.addResource(new Path(hdfsHdfsSite))
    println("\n==> Configuration: ")
    conf.foreach(println)
    UserGroupInformation.setConfiguration(conf)
    println("\n===> Kerberos initialization: ")
    UserGroupInformation.loginUserFromKeytab(principal, keytab)
    println("\n===> List HDFS root folder: ")
    val fs = new DistributedFileSystem
    fs.initialize(new URI(nodename), conf)
    val fsStatus = fs.listStatus(new Path("/"))
    fsStatus.foreach(f => println(f.getPath))
  }
}
