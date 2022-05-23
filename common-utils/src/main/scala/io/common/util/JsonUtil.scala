package io.common.util

import io.circe.parser.decode
import io.circe.syntax._
import io.circe.{Decoder, Encoder}

trait JsonUtil {

  def decode0[T](json: String)(implicit decoder: Decoder[T]): Option[T] = {
    decode[T](json) match {
      case Left(_) => None
      case Right(d) => Some(d)
    }
  }

  def encode0[T](obj: T)(implicit encoder: Encoder[T]): String = obj.asJson.noSpaces


}
