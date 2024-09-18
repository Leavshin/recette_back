FROM nginx:latest AS git

WORKDIR /usr/share/nginx/html

RUN rm -rf ./*

RUN apt update && apt install -y git

RUN git clone https://github.com/Leavshin/recette_front.git .

RUN git checkout dev

FROM node:latest AS build

WORKDIR /app

COPY --from=git /usr/share/nginx/html/package*.json ./

RUN npm install

RUN npm install -g @angular/cli

COPY --from=git /usr/share/nginx/html/ .

RUN npm run build

FROM nginx:latest

COPY --from=build /app/dist/recette_front/browser /usr/share/nginx/html

EXPOSE 80