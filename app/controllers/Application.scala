package controllers

import play.api._
import play.api.mvc._
import models._
 
import play.api.data._
import play.api.data.Forms._

object Application extends Controller {

  def index = Action {
	  Ok("Hello World") 
    }

  import play.api.data._
  import play.api.data.Forms._
  
  def ideas = Action {
	  Ok(views.html.index(Idea.all(), ideaForm))
  }  

  //define actions
  def newIdea = Action { implicit request =>
  	ideaForm.bindFromRequest.fold(
  			errors => BadRequest(views.html.index(Idea.all(), errors)),
  			label => {
  				Idea.create(label)
  				Redirect(routes.Application.ideas)
  			}
  		)
  }
 
 
  def deleteIdea(id: Long) = Action {
	  Idea.delete(id)
	  Redirect(routes.Application.ideas)
  }
  
  
  val ideaForm = Form(
		  	"label" -> nonEmptyText
		  )
		  
		  
// user form
		  		  
  val userForm = Form(
			mapping(
					"name" -> text,
					"age" -> number
					)(User.apply)(User.unapply)
			)

 def manageUsers = Action {
    val filledForm = userForm.fill(User("Bob", 18))
    Ok(views.html.users(filledForm, sys.env("HOME")))
  }
		  
  def updateUser = Action {
    Ok(views.html.users(userForm, "none"))
  }
			  
		  
}