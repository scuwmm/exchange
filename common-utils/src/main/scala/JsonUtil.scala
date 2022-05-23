import io.circe.Decoder
import io.circe.parser.decode
import io.circe.generic.auto._


trait JsonUtil {

  def decode0[T](json: String)(implicit decoder: Decoder[T]): Option[T] = {
    decode[T](json) match {
      case Left(e) => None
      case Right(d) => Some(d)
    }
  }


}
