<#setting number_format="computer">
const express = require('express')
const bodyParser = require('body-parser')
const app = express()
const port = 3000;
app.use(bodyParser.json())
 
<#list routeInfosList as routeInfoList>
app.${routeInfoList.method!}('${routeInfoList.pathAndParameter!}', function (req, res) {
  res.send('${routeInfoList.response?js_string!}')
})
</#list>
 
app.listen(port, function () {
  console.log('app listening on port %s',port)
})