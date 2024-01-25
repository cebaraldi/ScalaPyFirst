//> using scala 2
//> using dep dev.scalapy::scalapy-core:0.5.3
//> using python

import me.shadaj.scalapy.py
import me.shadaj.scalapy.py.SeqConverters
import py.PyQuote

object ScalaNumPy {

  py.local {
    val np = py.module("numpy")
    val rng = np.random.default_rng()
    val randoms = rng.standard_normal(10).as[Seq[Double]]
    randoms.foreach(println(_))
  }

  def main(args: Array[String]): Unit = {
    val numbers =
      py"[x * 2 for x in ${Iterator.from(3).take(10).toList.toPythonCopy}]"
        .as[Seq[Int]]
    println(numbers)
  }

}
