FROM ubuntu

RUN apt update && apt install -y python3-dev python3-pip

WORKDIR /app

COPY . .

RUN pip3 install -r requirements.txt

RUN python3 manage.py migrate

ENV PORT=8000

CMD gunicorn -b 0.0.0.0:$PORT realworld.wsgi
