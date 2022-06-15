package io.common.util

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.HttpMethods.{GET, POST}
import akka.http.scaladsl.model._
import io.circe.Encoder

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.util.{Failure, Success, Try}

trait HttpUtil extends JsonUtil {

  private def doRequest(request: HttpRequest, atMost: Duration)(implicit classicActor: ActorSystem): Either[Throwable, String] = {
    Try(Await.result(Http().singleRequest(request), atMost)) match {
      case Success(HttpResponse(StatusCodes.OK, _, entity, _)) =>
        Right("")
      case Failure(e: Throwable) =>
        Left(e)
    }
  }


  def get(url: String, atMost: Duration = 5.second)(implicit classicActor: ActorSystem): Either[Throwable, String] = {
    val uri = Uri(url)
    doRequest(HttpRequest(GET, uri), atMost)
  }

  def post[A: Encoder](url: String, data: A, headers: Seq[HttpHeader] = Nil, atMost: Duration = 5.second)(implicit classicActor: ActorSystem): Either[Throwable, String] = {
    val uri = Uri(url)
    val json = encode0(data)
    val request = HttpRequest(method = POST, uri = uri, entity = HttpEntity(ContentTypes.`application/json`, json), headers = headers)
    doRequest(request, atMost)
  }

}
