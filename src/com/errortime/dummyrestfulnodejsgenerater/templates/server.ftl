<#setting number_format="computer">
const express = require('express')
const bodyParser = require('body-parser')
const app = express()
const port = ${serverInfo.port};
app.use(bodyParser.json())
 
<#list serverInfo.routeList as routeLists>
app.${routeLists.method}('${routeLists.pathAndParameter}', function (req, res) {
  res.send('${routeLists.response}')
})
</#list>
 
app.listen(port, function () {
  console.log('app listening on port %s',port)
})