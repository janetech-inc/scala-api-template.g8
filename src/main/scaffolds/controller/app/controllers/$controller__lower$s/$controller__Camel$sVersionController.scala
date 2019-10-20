package controllers.$controller;format="lowercase"$s

import controllers.BaseApiController
import io.swagger.annotations.{Api, ApiOperation}
import javax.inject.Inject
import play.api.mvc.{Action, AnyContent, ControllerComponents}

/**
  * Main ~$controller;format="start-case"$s~ controller with API documentation - Routes to appropriate version controller
  */
@Api(value = "/$controller;format="lowercase"$s", description = "Operations with $controller;format="capitalize"$s")
class $controller;format="capitalize"$sVersionController @Inject()(cc: ControllerComponents, $controller;format="lowercase"$sV1Controller: v1.$controller;format="capitalize"$sController)
  extends BaseApiController[models.$controller;format="capitalize"$](cc) {

  @ApiOperation(
    nickname = "get$controller;format="capitalize"$s",
    value = "List all $controller;format="lowercase"$s",
    notes = "Returns a list of $controller;format="lowercase"$s",
    response = classOf[models.$controller;format="capitalize"$],
    responseContainer = "List",
    httpMethod = "GET",
  )
  def index(version: Double): Action[AnyContent] = {

    version match {
      case 1.0 => $controller;format="lowercase"$sV1Controller.index()
      case _ => Action { BadRequest("Version not found") }
    }

  }

  @ApiOperation(
    nickname = "create$controller;format="capitalize"$",
    value = "Create a new $controller;format="lowercase"$",
    notes = "Returns created $controller;format="lowercase"$",
    response = classOf[models.$controller;format="capitalize"$],
    httpMethod = "POST",
  )
  def create(version: Double): Action[AnyContent] = {

    version match {
      case 1.0 => $controller;format="lowercase"$sV1Controller.create()
      case _ => Action { BadRequest("Version not found") }
    }

  }

  @ApiOperation(
    nickname = "get$controller;format="capitalize"$",
    value = "Get $controller;format="lowercase"$ details",
    notes = "Returns a single $controller;format="lowercase"$",
    response = classOf[models.$controller;format="capitalize"$],
    httpMethod = "GET",
  )
  def show(version: Double, id: Int): Action[AnyContent] = {

    version match {

      case 1.0 => $controller;format="lowercase"$sV1Controller.show(id)
      case _ => Action { BadRequest("Version not found") }
    }

  }

  @ApiOperation(
    nickname = "update$controller;format="capitalize"$",
    value = "Update $controller;format="lowercase"$ details",
    notes = "Returns updated $controller;format="lowercase"$",
    response = classOf[models.$controller;format="capitalize"$],
    httpMethod = "PUT",
  )
  def update(version: Double, id: Int): Action[AnyContent] =  {

    version match {
      case 1.0 => $controller;format="lowercase"$sV1Controller.update(id)
      case _ => Action { BadRequest("Version not found") }
    }

  }

  @ApiOperation(
    nickname = "destroy$controller;format="capitalize"$",
    value = "Delete a $controller;format="lowercase"$s",
    notes = "Returns deleted $controller;format="lowercase"$s",
    response = classOf[models.$controller;format="capitalize"$],
    httpMethod = "DELETE",
  )
  def destroy(version: Double, id: Int): Action[AnyContent] =  {

    version match {
      case 1.0 => $controller;format="lowercase"$sV1Controller.destroy(id)
      case _ => Action { BadRequest("Version not found") }
    }

  }
}