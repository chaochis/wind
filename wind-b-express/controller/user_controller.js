const express = require('express');
const userService = require("../service/wind_user_service");
const {windUserConvertor} = require("../model/user_convertor");
const apiResult = require("../model/api_result");
const router = express.Router();

router.get('/wxlogin', (req, res, next) => {

})


module.exports = router;
