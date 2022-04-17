from pyrogram import filters

from connection import list_bot, BOT_NAME

SCROLL_EMOJI = '\U0001F4DC'


# To get json from the message has sent
@list_bot.on_message(filters.command("json", "/", True))
def get_json_from_message(client, message):
    print(message)


# Everyone can say hello to bot!
@list_bot.on_message(filters.command("hi", "/", True))
def say_hello(client, message):
    list_bot.send_message(chat_id=message["chat"]["id"], text=f"{BOT_NAME} welcomes you!")
