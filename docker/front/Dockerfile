FROM node:alpine

EXPOSE 8080
EXPOSE 8000

WORKDIR /usr/app/front

COPY ./ ./
RUN yarn install

CMD ["yarn", "start"]