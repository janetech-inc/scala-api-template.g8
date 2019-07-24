package controllers.$controller;format="lowercase"$

import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents, _}

import scala.concurrent._

// NOTE: Add the following to conf/routes to enable compilation of this class:
/*
GET     /:version/$controller;format="lowercase"$s                   @controllers.$controller;format="lowercase"$s.$controller;format="capitalize"$sVersionController.index(version:Double)
POST    /:version/$controller;format="lowercase"$s                   @controllers.$controller;format="lowercase"$s.$controller;format="capitalize"$sVersionController.create(version:Double)
PUT     /:version/$controller;format="lowercase"$s/:id               @controllers.$controller;format="lowercase"$s.$controller;format="capitalize"$sVersionController.update(version:Double, id:Int)
GET     /:version/$controller;format="lowercase"$s/:id               @controllers.$controller;format="lowercase"$s.$controller;format="capitalize"$sVersionController.show(version:Double, id:Int)
*/


/**
  * Base $controller;format="start-case"$s Controller - Initial version, versions extend from here
  */
@Singleton

abstract class Base$controller;format="start-case"$sController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

    def index(): Action[AnyContent] = Action.async { implicit request =>
    val r: Future[Result] = Future.successful(Ok("hello world"))
    r
  }

  def create(): Action[AnyContent] = Action.async{ implicit request =>
    val r: Future[Result] = Future.successful(Ok("hello world"))
    r

  }

  def show(id: Int): Action[AnyContent] = Action.async { implicit request =>
    val r: Future[Result] = Future.successful(Ok("hello world"))
    r
  }

  def update(id: Int): Action[AnyContent] = Action.async { implicit request =>
    val r: Future[Result] = Future.successful(Ok("hello world"))
    r
  }


  def destroy(id: Int): Action[AnyContent] = Action.async { implicit request =>
    val r: Future[Result] = Future.successful(Ok("hello world"))
    r
  }

}