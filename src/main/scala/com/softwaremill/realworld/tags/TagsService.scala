package com.softwaremill.realworld.tags

import zio.{ZIO, ZLayer}

import java.sql.SQLException

class TagsService(tagsRepository: TagsRepository):
  def getAllTags: ZIO[Any, SQLException, List[TagRow]] = tagsRepository.listTags

object TagsService:
  val live: ZLayer[TagsRepository, Nothing, TagsService] = ZLayer.fromFunction(TagsService(_))
