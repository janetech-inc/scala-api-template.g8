package controllers

import akka.stream.scaladsl.Source
import akka.util.ByteString
import io.swagger.annotations.{ApiOperation, ApiParam, ApiResponse, ApiResponses}
import io.swagger.util.Json
import javax.inject.Inject
import models.Resource
import play.api.http.HttpEntity
import org.reactivestreams._
import play.api.libs.iteratee.Enumerator
import play.api.libs.iteratee.streams.IterateeStreams
import play.api.mvc._


abstract class BaseApiController[T <: Resource] @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  // ~~ API Actions ~~

  @ApiResponses(Array(
    new ApiResponse(code = 400, message = "Invalid API version supplied")))
  def index(@ApiParam(value = "Api version")version: Double): Action[AnyContent]

  @ApiResponses(Array(
    new ApiResponse(code = 400, message = "Invalid API version supplied"),
    new ApiResponse(code = 405, message = "Invalid collection data supplied")))
  def create(@ApiParam(value = "Api version")version: Double): Action[AnyContent]

  @ApiResponses(Array(
    new ApiResponse(code = 400, message = "Invalid ID supplied"),
    new ApiResponse(code = 404, message = "Resource not found")))
  def show(@ApiParam(value = "Api version")version: Double,  @ApiParam(value = "Resource id")id: Int): Action[AnyContent]

  @ApiResponses(Array(
    new ApiResponse(code = 400, message = "Invalid ID supplied"),
    new ApiResponse(code = 404, message = "Resource not found")))
  def update(@ApiParam(value = "Api version")version: Double,  @ApiParam(value = "Resource id")id: Int): Action[AnyContent]

  @ApiResponses(Array(
    new ApiResponse(code = 400, message = "Invalid ID supplied"),
    new ApiResponse(code = 404, message = "Resource not found")))
  def destroy(@ApiParam(value = "Api version")version: Double,  @ApiParam(value = "Resource id")id: Int): Action[AnyContent]



// ~~ API Response ~~

  def toJsonString(data: Any): String = {
    if (data.getClass.equals(classOf[String])) { data.asInstanceOf[String] }
    else { Json.pretty(data) }
  }

  protected def JsonResponse(data: Object) = {
    val jsonValue: String = toJsonString(data)

    val bodyEnumerator = Enumerator(ByteString.fromArray(jsonValue.getBytes()))
    val bodyPublisher: Publisher[ByteString] = IterateeStreams.enumeratorToPublisher(bodyEnumerator)
    val bodySource: Source[ByteString, _] = Source.fromPublisher(bodyPublisher)
    val entity: HttpEntity = HttpEntity.Streamed(bodySource, null, Some("application/json"))

    new Result(header = ResponseHeader(200), body = entity).as("application/json")
      .withHeaders(
        ("Access-Control-Allow-Origin", "*"),
        ("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT"),
        ("Access-Control-Allow-Headers", "Content-Type, api_key, Authorization"))
  }

  protected def JsonResponse(data: Object, code: Int) = {
    val jsonValue: String = toJsonString(data)
    val bodyEnumerator = Enumerator(ByteString.fromArray(jsonValue.getBytes()))
    val bodyPublisher: Publisher[ByteString] = IterateeStreams.enumeratorToPublisher(bodyEnumerator)
    val bodySource: Source[ByteString, _] = Source.fromPublisher(bodyPublisher)
    val entity: HttpEntity = HttpEntity.Streamed(bodySource, null, Some("application/json"))

    new Result(header = ResponseHeader(code), body = entity).as("application/json")
      .withHeaders(
        ("Access-Control-Allow-Origin", "*"),
        ("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT"),
        ("Access-Control-Allow-Headers", "Content-Type, api_key, Authorization"))
  }

}