/*
 * Developed by Mona Fawzy on 4/29/19 10:40 AM
 * Last modified 4/29/19 10:40 AM
 * Copyright (c) CXN Fashion 2019. All rights reserved.
 */

package controllers.$controller__lower$

import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents, _}

import scala.concurrent._

// NOTE: Add the following to conf/routes to enable compilation of this class:
/*
GET     /$controller;format="camel"$        controllers.$controller;format="Camel"$Controller.$controller;format="camel"$Get
POST    /$controller;format="camel"$        controllers.$controller;format="Camel"$Controller.$controller;format="camel"$Post
*/


/**
  * Base $controller_Camel$ Controller - Initial version, versions extend from here
  */
@Singleton

abstract class Base$controller__Camel$Controller @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

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