{
  "name": "${packageInfo.applicationName!}",
  "version": "${packageInfo.version!}",
  "description": "",
  "main": "server.js",
  "scripts": {
    "start": "node server.js",
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "author": "${packageInfo.author!}",
  "license": "ISC",
  "dependencies": {
    "body-parser": "^1.18.3",
    "express": "^4.16.3"
  }
}
