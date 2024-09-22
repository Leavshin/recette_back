FROM ubuntu:latest AS git

WORKDIR /usr/share/nginx/html

RUN rm -rf ./*

RUN apt update && apt install -y git

RUN git clone https://github.com/Leavshin/recette_front.git .

FROM node:latest AS build

WORKDIR /app

COPY --from=git /usr/share/nginx/html/package*.json ./

RUN npm install

RUN npm install -g @angular/cli

COPY --from=git /usr/share/nginx/html/ .

RUN npm run build

FROM nginx:latest

WORKDIR /usr/share/nginx/html

COPY --from=build /app/dist/recette_front/browser .

COPY --from=build /app/nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80