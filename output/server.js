const express = require('express')
const bodyParser = require('body-parser')
const app = express()
const port = 8000;
app.use(bodyParser.json())
 
app.get('/', function (req, res) {
  res.send('Hello World!')
})

app.post('/error', function (req, res) {
    const json = req.body
    res.send(json)
    
    //return
    //res.send('Hello World!')
  })
 
app.listen(port, function () {
  console.log('app listening on port %s',port)
})