const express = require('express')
const bodyParser = require('body-parser')
const app = express()
const port = 3000;
app.use(bodyParser.json())
 
app.get('/api/performance/Promotions/1', function (req, res) {
  res.send('{\"Promotion\":[{\"id\":3,\"name\":\"\\u0e0a\\u0e49\\u0e2d\\u0e1b \\u0e0b\\u0e39\\u0e40\\u0e1b\\u0e2d\\u0e23\\u0e4c \\u0e23\\u0e31\\u0e1a\\u0e2a\\u0e48\\u0e27\\u0e19\\u0e25\\u0e14 50% \\u0e17\\u0e14\\u0e2a\\u0e2d\\u0e1a\\u0e41\\u0e01\\u0e49\\u0e44\\u0e021\\/\\/\\/\\/\",\"description\":\"\\u0e2a\\u0e34\\u0e17\\u0e18\\u0e34\\u0e1e\\u0e34\\u0e40\\u0e28\\u0e29\\u0e2a\\u0e33\\u0e2b\\u0e23\\u0e31\\u0e1a\\u0e25\\u0e39\\u0e01\\u0e04\\u0e49\\u0e32\\u0e1a\\u0e31\\u0e15\\u0e23\\u0e40\\u0e04\\u0e23\\u0e14\\u0e34\\u0e15\\u0e18\\u0e19\\u0e32\\u0e04\\u0e32\\u0e23\\u0e2d\\u0e2d\\u0e21\\u0e2a\\u0e34\\u0e19 \\u0e23\\u0e31\\u0e1a\\u0e2a\\u0e48\\u0e27\\u0e19\\u0e25\\u0e14 100 \\u0e1a\\u0e32\\u0e17 \\u0e40\\u0e21\\u0e37\\u0e48\\u0e2d\\u0e0a\\u0e49\\u0e2d\\u0e1b\\u0e04\\u0e23\\u0e1a 2,000 \\u0e1a\\u0e32\\u0e17\\/\\u0e40\\u0e0b\\u0e25\\u0e2a\\u0e4c\\u0e2a\\u0e25\\u0e34\\u0e1b \\u0e17\\u0e35\\u0e48 \\u0e01\\u0e39\\u0e23\\u0e4c\\u0e40\\u0e21\\u0e15\\u0e4c \\u0e21\\u0e32\\u0e40\\u0e01\\u0e47\\u0e15 & \\u0e42\\u0e2e\\u0e21 \\u0e40\\u0e1f\\u0e23\\u0e0a \\u0e21\\u0e32\\u0e23\\u0e4c\\u0e17) \\u0e17\\u0e14\\u0e2a\\u0e2d\\u0e1a\\u0e01\\u0e32\\u0e23\\u0e41\\u0e01\\u0e49\\u0e44\\u0e02\\u0e42\\u0e1b\\u0e23\\u0e42\\u0e21\\u0e0a\\u0e31\\u0e48\\u0e19\\u0e40\\u0e14\\u0e34\\u0e21\",\"image_path\":\"https:\\/\\/mhr-dev.loxleyorbit.com\\/\\/upload\\/performance\\/promotions\\/eccbc87e4b5ce2fe28308fd9f2a7baf3.jpg\",\"start_date\":\"06 \\u0e21\\u0e34\\u0e16\\u0e38\\u0e19\\u0e32\\u0e22\\u0e19 2561\",\"end_date\":\"31 \\u0e2a\\u0e34\\u0e07\\u0e2b\\u0e32\\u0e04\\u0e21 2561\"},{\"id\":13,\"name\":\"dd\",\"description\":\"dd\",\"image_path\":\"https:\\/\\/mhr-dev.loxleyorbit.com\\/\\/upload\\/performance\\/promotions\\/c51ce410c124a10e0db5e4b97fc2af39.png\",\"start_date\":\"08 \\u0e21\\u0e34\\u0e16\\u0e38\\u0e19\\u0e32\\u0e22\\u0e19 2561\",\"end_date\":\"01 \\u0e15\\u0e38\\u0e25\\u0e32\\u0e04\\u0e21 2561\"}]}')
})
app.get('/api/UserInfo/1', function (req, res) {
  res.send('{\n  \"user_id\": \"1\",\n  \"fullname\": \"abc defg\",\n  \"position\": \"admin\",\n  \"image\": \"https://screenshotlayer.com/images/assets/placeholder.png\",\n  \"line_id\": \"1\",\n  \"line_name\": \"line1\",\n  \"bank_id\": \"1\",\n  \"bank_name\": \"GSB\",\n  \"sector_id\": \"1\",\n  \"sector_name\": \"sector A\",\n  \"areas_id\" : \"1\" ,\n  \"areas_name\" : \"areas A\",\n  \"center_id\": \"1\",\n  \"center_name\": \"center B\",\n  \"level\": \"beginer\",\n  \"point\": \"1000\"\n}')
})
 
app.listen(port, function () {
  console.log('app listening on port %s',port)
})