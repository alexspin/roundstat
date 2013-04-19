package models

case class Idea(id: Long, idea: String)

object Idea {
  
import anorm._
import anorm.SqlParser._

	val idea = {
		get[Long]("id") ~ 
		get[String]("idea") map {
		case id~idea => Idea(id, idea)
		}
	}
  
	import play.api.db._
	import play.api.Play.current
	
	def create(idea: String) {
		DB.withConnection { implicit c =>
		SQL("insert into ideas (idea) values ({idea})").on(
				'idea -> idea
		).executeUpdate()
		}
	}
	
	def delete(id: Long) {
	  DB.withConnection { implicit c =>
	  SQL("delete from ideas where id = {id}").on(
			  'id -> id
			  ).executeUpdate()
	  }
  }

  	
	def all(): List[Idea] = DB.withConnection { implicit c =>
		SQL("select * from ideas").as(idea *)
	}
  
}