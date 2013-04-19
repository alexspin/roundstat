package models

import anorm.SQL
import anorm.SqlParser.get
import anorm.sqlToSimple
import anorm.toParameterValue
import play.api.Play.current
import play.api.db.DB

case class Ideas(id: Long, idea: String)

object Ideas {
  
import anorm._
import anorm.SqlParser._

// create idea 
	val idea = {
		get[Long]("id") ~ 
		get[String]("idea") map {
		case id~idea => Ideas(id, idea)
		}
	}
  
	import play.api.db._
	import play.api.Play.current
	
	def create(theidea: String) {
		DB.withConnection { implicit c =>
		SQL("insert into ideas (idea) values ({idea})").on(
				'idea -> theidea
		).executeUpdate()
		}
		
		play.Logger.info("def create: " + theidea)
	}
	
	def delete(id: Long) {
	  DB.withConnection { implicit c =>
	  SQL("delete from ideas where id = {id}").on(
			  'id -> id
			  ).executeUpdate()
	  }
  }

  	
	def all(): List[Ideas] = DB.withConnection { implicit c =>
		SQL("select * from ideas").as(idea *)
	}
  
}