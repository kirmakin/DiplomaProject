FROM node:alpine AS base
WORKDIR /opt/app
COPY . .
RUN npm audit fix && npm install
CMD ["npm", "start"]
EXPOSE 9999