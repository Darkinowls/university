import os

from dotenv import load_dotenv
from pyrogram import Client

from bot_methods.general import *
from bot_methods.list import *

load_dotenv()

API_ID = os.getenv('API_ID')
API_HASH = os.getenv('API_HASH')
BOT_TOKEN = os.getenv('BOT_TOKEN')
BOT_NAME = "Abobus"

list_bot = Client(BOT_NAME, api_id=API_ID, api_hash=API_HASH,
                  bot_token=BOT_TOKEN)


