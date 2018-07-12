const express = require('express')
const bodyParser = require('body-parser')
const app = express()
const port = 3000;
app.use(bodyParser.json())
 
app.post('ssss/sdsd', function (req, res) {
  res.send('test')
})
app.get('sdsd/sdsd', function (req, res) {
  res.send('{
  "Promotion": [
    {
      "id": 3,
      "name": "ช้อป ซูเปอร์ รับส่วนลด 50% ทดสอบแก้ไข1////",
      "description": "สิทธิพิเศษสำหรับลูกค้าบัตรเครดิตธนาคารออมสิน รับส่วนลด 100 บาท เมื่อช้อปครบ 2,000 บาท/เซลส์สลิป ที่ กูร์เมต์ มาเก็ต & โฮม เฟรช มาร์ท) ทดสอบการแก้ไขโปรโมชั่นเดิม",
      "image_path": "https://mhr-dev.loxleyorbit.com//upload/performance/promotions/eccbc87e4b5ce2fe28308fd9f2a7baf3.jpg",
      "start_date": "06 มิถุนายน 2561",
      "end_date": "31 สิงหาคม 2561"
    },
    {
      "id": 13,
      "name": "dd",
      "description": "dd",
      "image_path": "https://mhr-dev.loxleyorbit.com//upload/performance/promotions/c51ce410c124a10e0db5e4b97fc2af39.png",
      "start_date": "08 มิถุนายน 2561",
      "end_date": "01 ตุลาคม 2561"
    }
  ]
}')
})
 
app.listen(port, function () {
  console.log('app listening on port %s',port)
})