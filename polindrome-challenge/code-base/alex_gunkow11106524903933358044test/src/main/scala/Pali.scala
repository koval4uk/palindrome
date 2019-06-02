import scala.io.Source
import java.io._

object Pali extends App {
  val (in, out) = (args(0), args(1))
  def pali(string: String): Boolean = string == string.reverse
  def write(out: String, str: String): Unit = {
    val pw = new PrintWriter(new File(out ))
    pw.write(str)
    pw.close
  }
  // plain search
  if (args.length == 2) {
    val r: List[String] = Source.fromFile(in).getLines.toArray.flatMap(s => s.split(" ")).
      foldLeft(List[String]())((acc: List[String], str) =>{
        if (pali(str))
          if (acc.isEmpty)
            List(str)
          else if (str.length > acc.last.length)
            List(str)
          else if (str.length == acc.last.length)
            acc :+ str
          else
            acc
        else
          acc
      })
    write(out, r.sorted.mkString(" "))
  }
  // by line search

  def checkSubline(line: String): Option[String] = {
    val isPali = pali(line)
    if (isPali)
      Some(line)
    else if (line.length > 3)
      checkSubline(line.substring(0,line.length-1))
    else
      None
  }
  if (args.length == 3 && args.last == "line"){
    val palindrome = Source.fromFile(in).getLines.toArray.flatMap(line => {
      val rr: IndexedSeq[Option[String]] =
        for (i <- 0 until line.length) yield checkSubline(line.substring(i))
      rr.filter(_.isDefined).map(_.get).foldLeft(List[String]())((acc, p) => {
        if (acc.isEmpty)
          List(p)
        else if (p.length < acc.last.length)
            acc
        else if (p.length == acc.last.length)
          acc :+ p
        else
          List(p)
      })
    }).max

    write(out, palindrome)
  }

}

