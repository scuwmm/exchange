import akka.util.Timeout
import io.circe.syntax._
import io.circe.generic.auto._
import io.circe.parser._
import scala.concurrent.duration._

object Test extends JsonUtil {

  implicit val t: Timeout = Timeout(10.second)

  case class People(id: Long, name:String)
  def main(args: Array[String]): Unit = {
    val p = People(1, "wmm")
    val json = p.asJson.noSpaces
    println(json)
    val p2 = decode0[People](json)
    println(p2)
  }

}
