const express = require('express')
const bodyParser = require('body-parser')
const app = express()
const port = 8000;
app.use(bodyParser.json())
 
app.post('sds/dsds/sds:/dsds:', function (req, res) {
  res.send('sss')
})
 
app.listen(port, function () {
  console.log('app listening on port %s',port)
})