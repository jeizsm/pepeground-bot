package com.pepeground.bot.handlers

import com.pepeground.core.repositories.ChatRepository
import info.mukel.telegrambot4s.models.Message

object SetGabHandler {
  def apply(message: Message): SetGabHandler = {
    new SetGabHandler(message)
  }
}

class SetGabHandler(message: Message) extends GenericHandler(message) {
  def call(level: Int): Option[String] = {
    super.before()

    if(level > 50 || level < 0) return Some("0-50 allowed, Dude!")
    ChatRepository.updateRandomChance(chat.id, level)

    Some(s"Ya wohl, Lord Helmet! Setting gab to ${level}")
  }
}